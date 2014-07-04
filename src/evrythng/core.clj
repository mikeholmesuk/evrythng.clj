(ns evrythng.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.string :as str])
  (:import java.net.URLEncoder))

(def ^:dynamic url "https://api.evrythng.com/")

(defn format-url
  "Creates a URL out of end-point and positional. Called URLEncoder/encode on
   the elements of positional and then formats them in."
  [path & params]
  (str url (apply format path (when params (map #(URLEncoder/encode (str %) "UTF-8") params)))))

(defn parse-request-body
  "Parses a request body and returns JSON as a map"
  [request]
  (let [body (:body request)]
    (when body (json/parse-string body))))

;; Execute request
(defn make-request
  "Makes the HTTP request to the target URL"
  [method path params & body]
  (let [req (merge {:url (format-url path params)
                    :method method
                    :content-type :json}
                   {:headers {"Authorization" "<EVRYTHNG_API_TOKEN_GOES_HERE>"}})
        req (if (#{:post :put :delete} method) (assoc req :body (json/generate-string (first body))) req)]
    req))

(defn api-action
  "Makes a call-out to the Evrythng API"
  ([method path] (api-action method path nil nil))
  ([method path params] (api-action method path params nil))
  ([method path params body]
  (parse-request-body (http/request (make-request method path params body)))))

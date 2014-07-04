(ns evrythng.thngs
  (:use [evrythng.core :only [api-action]]))

(defn all-thngs
  [& [options]]
  (api-action :get "thngs" options))

(defn get-thng
  [id & [options]]
  (api-action :get "thngs/%s" id))

(defn create-thng
  [thng & [options]]
  (api-action :post "thngs" nil thng))

(defn update-thng
  [id thng & [options]]
  (api-action :put "thngs/%s" id thng))

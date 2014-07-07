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

(defn delete-thng
  [id & [options]]
  (api-action :delete "thngs/%s" id))

(defn get-thng-properties
  [id & [options]]
  (api-action :get "thngs/%s/properties" id))

(defn get-thng-property
  [id prop-key & [options]]
  (api-action :get "thng/%s/properties/%s" [id prop-key]))

(defn add-thng-property
  [id props & [options]]
  (api-action :put "thngs/%s/properties" id props))

(defn update-thng-property
  [id prop-key value & [options]]
  (api-action :put "thngs/%s/properties/%s" [id prop-key] value))


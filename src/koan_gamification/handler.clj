(ns koan-gamification.handler
  (:use compojure.core koan-gamification.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (PUT "/post" [solution code] (result-view solution code)) 
  (GET "/Koan/" [] (koan-page))
  (GET "/:name/:num" [name num] (str "Challo " name " youre " num))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

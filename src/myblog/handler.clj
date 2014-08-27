(ns myblog.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [myblog.views :as views]))

(defroutes public-routes
  (GET "/" [] (views/main-page))
  (route/resources "/"))

(defroutes protected-routes
  (GET "/admin" [] (views/admin-blog-page)))
  
(defroutes app-routes
  public-routes
  protected-routes
  (route/not-found "Not Found"))
  

(def app
  (handler/site app-routes))

(ns myblog.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [myblog.views :as views]
            [myblog.posts :as posts]
            [ring.util.response :as response]))

(defroutes public-routes
  (GET "/" [] (views/main-page))
  (route/resources "/"))

(defroutes protected-routes
  (GET "/admin" [] (views/admin-blog-page))
  (GET "/admin/add" [] (views/add-post))
  (POST "/admin/create" [& params] 
     (do (posts/create params))
     (response/redirect "/admin")))
  
(defroutes app-routes
  public-routes
  protected-routes
  (route/not-found "Not Found"))
  

(def app
  (handler/site app-routes))


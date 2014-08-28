(ns myblog.views
  (:require [hiccup.core :refer (html)]
  			[myblog.posts :as posts]  
        [hiccup.form :as f]  ))

(defn layout [title & content]
  (html
    [:head [:title title]]
    [:body content]))
    


; Post is a map corresponding to a record from the database
(defn post-summary [post]
  (let [id (:id post)
        title (:title post)
        body (:body post)
        created_at (:created_at post)]
    [:section
      [:h3 title]
      [:h4 created_at]
      [:section body]
      [:section.actions
        [:a {:href (str "/admin/" id "/edit")} "Edit"] " / "
        [:a {:href (str "/admin/" id "/delete")} "Delete"]]]))


(defn main-page []
  (layout "My Blog"
    [:h1 "My Blog"]
    [:p "Welcome to my page"]
    (map #(post-summary %) (posts/all))))
                
(defn admin-blog-page []
  (layout "My Blog - Administer Blog"
    [:h1 "Administer Blog"]
    [:h2 "All my posts"]
    [:a {:href "/admin/add"} "Add"]
    (map #(post-summary %) (posts/all))))  

(defn add-post []
  (layout "My Blog - Add Post"
    (list
      [:h2 "Add Post"]
      (f/form-to [:post "/admin/create"]
        (f/label "title" "Title")
        (f/text-field "title") [:br]
        (f/label "body" "Body") [:br]
        (f/text-area {:rows 20} "body") [:br]
        (f/submit-button "Save")))))
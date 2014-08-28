(ns myblog.posts
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/query "postgresql://localhost:5432/home"
                  ["select * from blogpost"]))

(defn add []  
  (sql/insert! "postgresql://localhost:5432/" :blogpost {:id 34 :title "Hello  
  	PO HOL HOL HOLu TEST!" :body "thmar mar mar"}))

; (sql/db-do-commands "postgresql://localhost:5432/home"
;                            (sql/create-table-ddl :blogpost [:data :text]))

; (sql/insert! "postgresql://localhost:5432/home"
;                     :testing {:data "Hello World"})
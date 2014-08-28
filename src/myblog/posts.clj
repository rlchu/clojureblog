(ns myblog.posts
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as sql]))

(defn all []
  (sql/query "postgresql://localhost:5432/home"
                  ["select * from blogpost"]))

(defn now [] (new java.util.Date))

(defn create [params]  
  (sql/insert! "postgresql://localhost:5432/" :blogpost (merge params {:id 99})))



; (sql/db-do-commands "postgresql://localhost:5432/home"
;                            (sql/create-table-ddl :blogpost [:data :text]))

; (sql/insert! "postgresql://localhost:5432/home"
;                     :testing {:data "Hello World"})
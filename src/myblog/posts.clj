(ns myblog.posts
  (:refer-clojure :exclude [get])
  (:require[clojure.java.jdbc :as sql]))




(defn all []
  (sql/query "postgresql://localhost:5432/home"
                  ["select * from blogpost"]))

; (sql/db-do-commands "postgresql://localhost:5432/home"
;                            (sql/create-table-ddl :testing [:data :text]))
; (sql/insert! "postgresql://localhost:5432/home"
;                     :testing {:data "Hello World"})
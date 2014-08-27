(defproject myblog "0.2"
  :description "writing my own blog"
  :url "http://localhost:3000"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [postgresql "9.1-901.jdbc4"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler myblog.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})



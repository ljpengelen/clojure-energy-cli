(defproject clojure-energy "0.1.0-SNAPSHOT"
  :description "App to filter and sort lists of words"
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot clojure-energy.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

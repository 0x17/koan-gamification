(defproject koan-gamification "0.1.0-SNAPSHOT"
  :description "Prototype for programming language koan website with RPG elements."
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
				 [hiccup "1.0.3"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler koan-gamification.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})

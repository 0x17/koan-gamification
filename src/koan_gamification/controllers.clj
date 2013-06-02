(ns koan-gamification.controllers)

(defn is-correct? [expr]
  (try (-> expr read-string eval) (catch Exception e false)))
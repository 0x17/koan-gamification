(ns koan-gamification.views
  (:use [hiccup core page element form]
  		[koan-gamification controllers]))

(defmacro link [caption url] `[:a {:href ~url} ~caption])

(defn table-around [content]
  [:table [:tr [:td content]]])

(defn index-page []
  (html5
   [:head [:title "Hello World"]]
   [:body
    [:div {:align "center"}
    [:h1 "Hello World Header"]
    (link-to "Koan/" "Koan-View")
    [:h2 "Erste Liste"]
    (table-around (for [x (range 1 4)] [:li (str "Eintrag Nr. " x)]))
    [:h2 "Zweite Liste"]
    (table-around (unordered-list '("Eins" "Zwei" "Drei")))
    [:p "This is some paragraph containing some text!"]
    [:p "Here is a link to my homepage: "
     (link "My Homepage" "http://andre.steinkraft.net") " "
     (link-to "http://andre.steinkraft.net" "Another Link")]]]))

(def code-str "(= (_ 4) 16)")

(defn koan-page []
  (html5
   [:head [:title "Koan View"]]
   [:body
    [:table {:border 1}
     [:tr [:td "Koan Name"] [:td "Another"]]
     [:tr [:td "Some String"] [:td "String"]]]
    code-str
    (form-to [:put "/post"]
             "Fill placeholder with correct text:"
             [:br]
             (hidden-field "code" code-str)
             (text-field "solution" "Solution")
             (submit-button "Submit"))
    (link-to "/" "Back")]))

(defn col-text [msg col]
  [:font {:color col} msg])

(defn show-status [correct]
  (if correct (col-text "Correct" "green") (col-text "Wrong" "red")))

(defn result-view [solution code]
  (let [replaced (clojure.string/replace code #"_" solution)
        correct (is-correct? replaced)]
  (html5
   [:head [:title "Solution view"]]
   [:body
    [:h1 "Solution"]
    (str "Code was " code " and solution " solution ".")
    [:br]
    (show-status correct)
    [:br]
    (link-to "Koan/" "Back")])))
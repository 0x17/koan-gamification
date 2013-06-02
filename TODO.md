# Koan Adventures
**Gamification of Programming Language Koans**

## Overview
* User accounts with score, list of solutions (strings).
* User has customizable character (like RPG).
* Koans for different languages. (first only Clojure)
	* Only languages, that offer some 'eval' capability.
* Character has different skill points.
	* Koans add to specific skill-points.
* Level-Up when certain score count reached. (Animation)
* User accounts and koans stored in NoSQL-Database.
* Backend implemented using *Compojure* in Clojure.
* Frontend using JavaScript libraries and ClojureScript.
* HTML and CSS for skeleton and design. HTML with *hiccup*. CSS with *clj-style* ?.
	* Or using *slice* for everything?
* First prototype design, later more game-like.
* Sandbox for executed code! -> *clojail*

## Use cases
1. User logins in. Sees Character stats. Link to koan practice zone.
2. Koan entry: Uneditable text with placeholder. Textarea to enter placeholder content. Button to check if code in textarea makes testcase pass. Ideally validated in JavaScript.

## First prototype
* Compojure-Webserver with one page that shows koan template code with placeholder. Textarea below to input corresponding code to solve problem. Check-box. Shows error message if input is wrong. Otherwise makes something green.

## Later...
* Add NoSQL database with list of koan objects (code strings with placeholders and expected result). Probably MongoDB and *Monger*.
* Add users {login,email,entryLst,score...}.
(set-env! 
    :dependencies '[[clj-time "0.15.0"]]
)
(ns boot.user
  (:require [clj-time.core :as t])
  (:require [clj-time.coerce :as coerce])
  (:require [clojure.string :as str])
)

(def pattern #"Aa|aA|Bb|bB|Cc|cC|Dd|dD|Ee|eE|Ff|fF|Gg|gG|Hh|hH|Ii|iI|Jj|jJ|Kk|kK|Ll|lL|Mm|mM|Nn|nN|Oo|oO|Pp|pP|Qq|qQ|Rr|rR|Ss|sS|Tt|tT|Uu|uU|Vv|vV|Ww|wW|Xx|xX|Yy|yY|Zz|zZ")

(defn react [str]
  (loop [s str]
    (let [next (clojure.string/replace s pattern "")]
      (if (= s next)
        s
        (recur next)))))

(def input (clojure.string/join "" (slurp "newinput.txt")))

(count (react input))
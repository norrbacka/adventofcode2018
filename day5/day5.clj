(set-env! 
    :dependencies '[[clj-time "0.15.0"]]
)
(ns boot.user
  (:require [clj-time.core :as t])
  (:require [clj-time.coerce :as coerce])
  (:require [clojure.string :as str])
)

(def pattern #"Aa|aA|Bb|bB|Cc|cC|Dd|dD|Ee|eE|Ff|fF|Gg|gG|Hh|hH|Ii|iI|Jj|jJ|Kk|kK|Ll|lL|Mm|mM|Nn|nN|Oo|oO|Pp|pP|Qq|qQ|Rr|rR|Ss|sS|Tt|tT|Uu|uU|Vv|vV|Ww|wW|Xx|xX|Yy|yY|Zz|zZ")

(defn react [str p]
  (loop [s str]
    (let [next (clojure.string/replace s p "")]
      (if (= s next)
        s
        (recur next)))))

(def input (clojure.string/join "" (slurp "newinput.txt")))

(count (react input pattern))

(def patternArray [#"A|a" #"B|b" #"C|c" #"D|d" #"E|e" #"F|f" #"G|g" #"H|h" #"I|i" #"J|j" #"K|k" #"L|l" #"M|m" #"N|n" #"O|o" #"P|p" #"Q|q" #"R|r" #"S|s" #"T|t" #"U|u" #"V|v" #"W|w" #"X|x" #"Y|y" #"Z|z"])

(defn reactSmallest [str]
  (for [p patternArray]
    (apply assoc {} [
        :pattern p
        :count (count (react (react str p) pattern))
    ])    
  )
)

(first (sort-by (fn [v] (-> v :count)) (reactSmallest input)))
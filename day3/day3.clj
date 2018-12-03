(set-env! 
    :dependencies '[[net.mikera/core.matrix "0.62.0"]]
)

(ns boot.user
  (:require [clojure.core.matrix :as matrix])
  (:require [clojure.edn :as edn])
)

(defn indexes [[x y w h]]
    (for [i (range x (+ x w)) j (range y (+ y h))]
      [i j]
    )
)
(def puzzle
    (->>
        (slurp "input.txt")
        (edn/read-string)        
    )
)
(def coordinates
    (->> 
        (map #(indexes %) puzzle)
        (flatten)
        (partition 2)
    )
)
(def frequenced (frequencies coordinates))
(def countOverlaps
    (count(filter (fn [n] (> n 1)) (vals frequenced)))
)

(prn (str "Answer task 1: " countOverlaps))
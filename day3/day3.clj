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
(defn coordinates
    [j]
    (->> 
        (map #(indexes %) j)
        (flatten)
        (partition 2)
    )
)
(def frequenced (frequencies (coordinates puzzle)))
(def countOverlaps
    (count(filter (fn [n] (> n 1)) (vals frequenced)))
)

;;(prn (str "Answer task 1: " countOverlaps))


(defn isLonely?
    [otherFrequencies others]
    (let [fco (frequencies (coordinates others))] fco)
        ;;[let filtered (filter (fn [[xy v]] (> v 1)) fco)]
        ;;(if (> (count(filter (fn [v1] (= v1 value) filtered)) 0)) value nil)
)

;loopa igenom puzzle
;för varje värde räkna fram indexes
;för alla andra värden räkna fram indexes
;kolla att alla index-värden saknas i resten

(defn removeAt
    [puzzle i]
      (concat (subvec puzzle 0 i)
          (subvec puzzle (inc i)))
)

(defn FindLonely
    [p]
    (for [i (range (count p))]
        (let 
            [
                c(nth p i)
                removedPuzzle(removeAt p i)
                c2(coordinates removedPuzzle)
            ]
            (if (every?
                (fn [coordinate] (not(contains? [c2] coordinate)))
                c
            ) i nil)     
        )
    )
)

(FindLonely puzzle)
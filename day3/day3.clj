(ns boot.user
  (:require [clojure.string :as str]))

(defn abs [n] (max n (-' n)))
(defn coord [[x y dx dy]] [x y (+ x dx) (+ y dy)])

(def exampleFabric (vec (replicate 8 (vec (replicate 8 0)))))
(def example1 (coord [1 3 4 4]))
(def example2 (coord [3 1 4 4]))
(def example3 (coord [5 5 4 4]))
(def input(map coord (map read-string (str/split-lines(slurp "input.txt")))))

(def fabric (vec (replicate 1000 (vec (replicate 1000 0)))))


(defn add-vec [& args] 
  "Add two or more vectors together"
  (when (seq args) 
    (apply mapv + args)))

;kudos https://www.geeksforgeeks.org/total-area-two-overlapping-rectangles/
(defn area [[x1 y1 x2 y2]] (*
    (abs (- x1 x2))
    (abs (- y1 y2))
))

(defn intersectingArea [[v1x1 v1y1 v1x2 v1y2] [v2x1 v2y1 v2x2 v2y2]]
    (*
    (-
        (min v1x1 v2x1)
        (max v1x2 v2x2)
    )
    (-
        (min v1y1 v2y1)
        (max v1y2 v2y2)
    )
    )
)

(defn overlappingArea [[v1] [v2]]
    (-
        (+ (area v1) (area v2))
        (intersectingArea v1 v2)
    )
)

;ny idé, blank canvas med 0:or, fyll på med 1:or på positionerna, räkna värden över 2
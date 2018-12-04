(set-env! 
    :dependencies '[[clj-time "0.15.0"]]
)
(ns boot.user
  (:require [clj-time.core :as t])
  (:require [clj-time.coerce :as coerce])
  (:require [clojure.string :as str])
)

(def input (->>
    (slurp "input.txt")
    (str/split-lines)
    (map #(str/trim %)))
)

;regex för allt innanför []-ska bli ett datetime
;finns tre värden
;wakes up
;falls asleep
;Guard #1051 begins shift
;vi borde omvandla det till ett set typ:
;{:date :value där :value är 1051 eller 0 (sleep) eller 1 (awake)}

(defn parseData 
    [data]
    (map 
        (fn [d] into {} [
            [
                :dateTime (->>
                    (clojure.string/replace (str (nth (re-find #"\[(.*?)\]" d) 1)) #"\ " "T")
                    (coerce/from-string)
                )
                :guard (nth (re-find  #"\#(\d{0,6})" d) 1)
                :wake (if (empty? (re-find  #"wake" d)) false true)
                :sleep (if (empty? (re-find  #"sleep" d)) false true)
            ]
        ])
        data
    )
)
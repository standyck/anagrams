(ns anagrams.core
  (:gen-class))

(defn anagram-key [^String word]
  (if word (apply str (-> word .toLowerCase sort))))

(defn anagrams [word-list]
  (filter #(> (count (set (second %))) 1)
          (reduce #(let [k          (anagram-key %2)
                         v          %2
                         existing-v (get %1 k)]
                     (conj %1 [k (conj existing-v v)]))
                  {}
                  (seq word-list))))

(defn longer-anagram [[k1 _ :as a1] [k2 _ :as a2]]
  (if (= (count k1) (max (count k1) (count k2))) a1 a2))

(defn longest-anagram [word-list]
  (reduce  longer-anagram nil (anagrams word-list)))

(defn more-anagrams [[_ v1 :as a1] [_ v2 :as a2]]
  (if (= (count v1) (max (count v1) (count v2)) ) a1 a2))

(defn most-anagrams [word-list]
  (reduce more-anagrams nil (anagrams word-list)))

(defn -main
  "Locates the longest anagram and the largest number of anagrams from the input file"
  [& args]
  (let [word-list (line-seq (clojure.java.io/reader (first args)))
        longest (second (longest-anagram word-list))
        most (second (most-anagrams word-list))]
    (println "Checking words from " (first args))
    (println "The longest anagram is" longest)
    (println "The largest number of anagrams is" (count most) most)))

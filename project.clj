(defproject anagrams "0.1.0-SNAPSHOT"
  :description "Implementation of the anagrams kata."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot anagrams.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

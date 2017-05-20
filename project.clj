(defproject timbre-ns-pattern-level "0.1.2"
  :description "Timbre middleware configuring log levels per namespace pattern"
  :url "https://github.com/yonatane/timbre-ns-pattern-level"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.taoensso/encore "2.90.1"]
                 [com.taoensso/timbre "4.8.0"]]
  :pedantic? :abort
  :global-vars {*warn-on-reflection* true}
  :target-path "target/%s/")

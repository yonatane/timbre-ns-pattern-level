(ns timbre-ns-pattern-level
  (:require [taoensso.encore]
            [taoensso.timbre :as timbre]))

(defn ns-filter [fltr] (-> fltr taoensso.encore/compile-ns-filter taoensso.encore/memoize_))

(defn middleware
  [ns-patterns]
  (fn log-by-ns-pattern [{:keys [?ns-str config level] :as opts}]
    (let [namesp (or (some->> ns-patterns
                              keys
                              (filter #(and (string? %)
                                            ((ns-filter %) ?ns-str)))
                              not-empty
                              (apply max-key count))
                     :all)
          loglevel (get ns-patterns namesp (get config :level))]
      (when (and (taoensso.timbre/may-log? loglevel namesp)
                 (taoensso.timbre/level>= level loglevel))
        opts))))

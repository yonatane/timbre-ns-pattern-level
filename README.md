# timbre-ns-pattern-level

Timbre middleware configuring log levels per namespace pattern.

## Usage

In project.clj:
```clj
[timbre-ns-pattern-level "0.1.2"]
```

require:
```clj
[taoensso.timbre :as timbre]
[timbre-ns-pattern-level]
```

Configure timbre with the middleware:
```clj
(timbre/merge-config!
  {:middleware [(timbre-ns-pattern-level/middleware {"datomic.process-monitor" :warn
                                                     "com.mchange.v2.c3p0.*" :warn
                                                     "ring.logger.timbre" :debug ;; to log request body
                                                     :all :info})]})
```

## Acknowledgement

Copied with minor changes from a [timbre issue comment](https://github.com/ptaoussanis/timbre/issues/208#issuecomment-269008644) by [vandr0iy](https://github.com/vandr0iy).

## License

Copyright © 2017 Yonatan Elhanan

Distributed under the MIT License.

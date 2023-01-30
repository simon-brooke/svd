(ns svd.core
  (:require [hiccups.runtime :as hiccupsrt]
            [svd.desktop :refer [render]])
  (:require-macros [hiccups.core :refer [html]]))

(enable-console-print!)

(println "This text is printed from src/svd/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}
                         :desktop (render)))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  (swap! app-state update-in [:__figwheel_counter] inc)
  (-> js/document
      (.getElementById "app")
      (.-innerHTML)
      (set! (html (render)))))

(-> js/document
    (.getElementById "app")
    (.-innerHTML)
    (set! (html (render))))
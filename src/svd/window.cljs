(ns svd.window
  (:require [devtools.defaults :as defaults]))

(def defaults
  {:title-height 20})

(defn rect-window
  [& {:keys [x y corner-radius width height render-fn title title-fn]
      :or {x (rand (/ (.-innerWidth js/window) 2))
           y (rand (/ (.-innerHeight js/window) 2))
           width 100
           height 100
           corner-radius 10
           title "Untitled Window"}}]
  (let [id (gensym)
        th (:title-height defaults)]
    [:rect {:id (str "window" id)
            :class "window"
            :x x
            :y y
            :width width
            :height (+ height th)
            :rx corner-radius}
     [:rect {:id (str "title" id)
             :class "title"
             :x 0 :y 0 :width width :height th}
      title]
     [:rect {:id (str "workspace" id)
             :class "workspace"
             :x 0
             :y th
             :width width
             :height height}
      "There's nothing here"]]))
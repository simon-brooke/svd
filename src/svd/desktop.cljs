(ns svd.desktop
  (:require [svd.window :refer [rect-window]]))

(declare desktop)

(defn ^:export render
  "With no args, render the current state of the desktop."
  ([]
   (render (deref desktop)))
  ([w]
   (let [f (:render-fn w)]
     (if f (apply (:render-fn w) (list w))
         f))))

(def desktop
  (atom {:attributes {:id "desktop"
                      :class "desktop"
                      :viewBox (str "0 0 " 
                                    (.-innerWidth js/window) 
                                    " " 
                                    (.-innerHeight js/window))}
         :windows (list (rect-window :title "Window One")
                        (rect-window :title "Window Two"))
         :render-fn (fn [dt]
                      (apply
                       vector
                       (concat (list :svg (:attributes dt))
                               (map
                                render
                                (:windows dt)))))}))


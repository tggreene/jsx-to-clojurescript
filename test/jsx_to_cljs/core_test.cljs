(ns jsx-to-cljs.core-test
  (:require [jsx-to-cljs.core :as core]
            [jsx-to-cljs.test-cases :as cases]
            [cljs.test :refer [deftest testing is]]))

(def opts
  {:ns "u"
   :dom-ns "d"
   :kebab-tags true
   :kebab-attrs true
   :camel-styles true
   :remove-attr-vals false
   :omit-empty-attrs true
   :lib-ns "lib"
   :styles-as-vector true})

(deftest can-compile-jsx-to-reagent

  (testing "t0"
    (is (= '[:a {:x styles} [:b {} "here"]]
           (core/jsx->reagent cases/t0))))

  (testing "t1"
    (is (= '[View {:style (:container styles)}
             [TouchableWithoutFeedback {:onPressIn on-press-in,
                                        :onPressOut on-press-out}
              [Image {:source {:uri image-uri}, :style image-style}]]]
           (core/jsx->reagent cases/t1))))

  (testing "t2"
    (is (= '[Table {}
             [TableHeader {}
              [TableRow {}
               [TableHeaderColumn {:value (:first-slider state)} "ID"]
               [TableHeaderColumn {} "Name"]
               [TableHeaderColumn {} "Status"]]]
             [TableBody {}
              [TableRow {}
               [TableRowColumn {} "1"]
               [TableRowColumn {} "John Smith"]
               [TableRowColumn {} "Employed"]]
              [TableRow {}
               [TableRowColumn {} "2"]
               [TableRowColumn {} "Randal White"]
               [TableRowColumn {} "Unemployed"]]
              [TableRow {} [TableRowColumn {} "3"]
               [TableRowColumn {} "Stephanie Sanders"]
               [TableRowColumn {} "Employed " [:b {} "Google Inc."]]]
              [TableRow {}
               [TableRowColumn {} "4"]
               [TableRowColumn {} "Steve Brown"]
               [TableRowColumn {} "Employed"]]]]
           (core/jsx->reagent cases/t2))))

  (testing "t3"
    (is (= '[:div {:style style}
             [Slider {:defaultValue 0.5,
                      :value (:first-slider state),
                      :onChange (partial handle-first-slider this)}]
             [:p {}
              [:span {} "The value of this slider is: "]
              [:span {} (:first-slider state)]
              [:span {} " from a range of 0 to 1 inclusive"]]
             [Slider {:min 0,
                      :max 100,
                      :step 1,
                      :defaultValue 50,
                      :value (:second-slider state),
                      :onChange (partial handle-second-slider this)}]
             [:p {} [:span {} "The value of this slider is: "]
              [:span {} (:second-slider state)]
              [:span {} " from a range of 0 to 100 inclusive"]]]
           (core/jsx->reagent cases/t3))))

  (testing "t3 with opts"
    (is (= '[:div {:style style}
            [u/slider {:default-value 0.5,
                       :value (:first-slider state),
                       :on-change (partial handle-first-slider this)}]
            [:p
             [:span "The value of this slider is: "]
             [:span (:first-slider state)]
             [:span " from a range of 0 to 1 inclusive"]]
            [u/slider {:min 0,
                       :max 100,
                       :step 1,
                       :default-value 50,
                       :value (:second-slider state),
                       :on-change (partial handle-second-slider this)}]
            [:p
             [:span "The value of this slider is: "]
             [:span (:second-slider state)]
             [:span " from a range of 0 to 100 inclusive"]]]
           (core/jsx->reagent cases/t3 opts))))

  (testing "t4"
    (is (= '[:div {:style style}
             [Slider {:defaultValue 0.5,
                      :value (:first-slider state),
                      :onChange (partial handle-first-slider this)}]
             [:p {}
              [:span {} "The value of this slider is: "]
              [:span {} (:first-slider state)]
              [:span {} " from a range of 0 to 1 inclusive"]]
             [Slider {:min 0,
                      :max 100,
                      :step 1,
                      :defaultValue 50,
                      :value (:second-slider state),
                      :onChange (partial handle-second-slider this)}]
             [:p {} [:span {} "The value of this slider is: "]
              [:span {} (:second-slider state)]
              [:span {} " from a range of 0 to 100 inclusive"]]]
           (core/jsx->reagent cases/t3)))))

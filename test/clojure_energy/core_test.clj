(ns clojure-energy.core-test
  (:require [clojure.test :refer :all]
            [clojure-energy.core :refer :all]))

(deftest filters-empty-vector
    (is (= (human-filter nil []) {:keep [] :discard []})))

(deftest filters-non-empty-vector
  (is (= (human-filter even? [1 2 3 4 5 6 7 8]) {:keep [2 4 6 8] :discard [1 3 5 7]})))

(deftest sorts-singleton-list
  (is (= (human-sort nil [1]) [1])))

(deftest sorts-list
  (is (= (human-sort #(< %1 %2) [3 1 2]) [1 2 3])))

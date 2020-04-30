(ns cljwlove.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
(foo "")

(defn factor  [x]
   (loop[cnt x acc 1]
    (if(zero? cnt)
      (* acc 1000000)
      (recur(dec cnt)(* acc cnt)))))

(factor 5);; => 120000000

;;Run only in REPL Window!
(doc doc); description
(apropos "+") ; paths
(find-doc "trim") ; description
(dir clojure.repl) ;list of commands
(source dir) ;; about dir
;;


(+ 1 2)
(def var1 (- (factor 5) 1))
;; => #'cljwlove.core/var1
var1;; => 119999999
(println "var1 + 1 is equals:" (+ var1 1))
;; => nil (120000000)
(prn "one\n\two");; => nil

(+ 7654 1234)
;; => 8888

(->(*  3 4)(+ 7 5)(/ 10))
;;
(->>(+ 1 3)(+ 5 15))
(->>(+ (+ 5 15) 1 3))
(->(+ 5 15)(+ 1 3))
(+ (+ 5 15) 1 3)
;; => 24
;; => 24
;; => 24
(->>(+ -1 -3)(+ 5 15))
(->>(- (+ 5 15)1 3))
(->(+ 5 15)(- 1 3))
(- (+ 5 15) 1 3)
;; => 16
;; => 16
;; => 16
;; => 16


(/ (+ 7 5 (* 3 4)) 10)
(* 3 4)

(find-doc "rem")

;Functions
(defn greet [name]
    (str "Hello, " name))

(greet "Admin")

;Multi-arity functions
(defn messenger
  ([] (messenger "Hello World!"))
  ([msg] (println "Hello" msg "!")))

(messenger)
(messenger "Admin")

;Variadic functions
(defn hello [greeting & who]
  (println greeting who))
(hello "Hello" "world" "class")

((fn [message] (println message)) "Hello world")

(defn messenger [msg]
  (let [a 7 b 5 c (clojure.string/capitalize msg)]
    (println a b c)
    ))

(messenger "hi")

;The fn special form creates a "closure". It "closes over" the surrounding lexical scope (like msg, a, b, or c above) and captures their values beyond the lexical scope.
(defn messenger-builder
  ([greeting symbols] (fn [who & symbolsfn] (println greeting who symbols symbolsfn)))
  ([greeting] (fn [who] (println greeting who))))
;; => #'cljwlove.core/messenger-builder

(def msg-builder (messenger-builder "Hi"))
;; => #'cljwlove.core/msg-builder
(msg-builder "Friend")
;; => nil ... Hi Friend
(def m2 (messenger-builder "Hi" "!!!"))
(m2 "symbols after greeting" "123")
;; => nil ... Hi symbols after greeting !!! (123)
(m2 "symbols after greeting")
;; => nil ... Hi symbols after greeting !!! nil
                                        ; =>
;Define a function greet
(defn greet [] (println "Hello"))
(greet)
;Redefine greet using def
(def greet
  (fn [] (println "Hello")))
(greet)
;Redefine greet using #()
(def greet
  #(println "Hello"))
(greet)

;;
(defn do-nothing [x] identity x)
(do-nothing 5)
;; => 5

(source identity)
;; => nil

;5
(defn at [a b & c]
 println 100)
(at 1 2 3 4 5)
;; => 100

                                        ;6
(source constantly)
(defn mt [x] (fn [& args] x))

(let [n 5;(rand-int Integer/MAX_VALUE)
      f (mt n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range 100)))))

(= 2 (apply mt  123 (range 100)))
(source apply)
(mt 2) (mt)

(apply 2 1 2 '(3 4))
;Spacemacs Docs: https://simpletutorials.com/c/3036/Spacemacs+%28Vim+mode%29+Cheatsheet

;Num 7
(defn triplicate [f]
  (dotimes [n 3] (println f)))
(triplicate factor)
;; => nil
;;; #function[cljwlove.core/factor]
;;It works !!!!!!!!!!!!!!!!!!!!!!! Just check paragraph 'Loop in 'Macros

(def test (fn [check] (+ check 1)))
(test 1)
;; => 2

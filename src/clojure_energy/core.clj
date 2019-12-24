(ns clojure-energy.core
  (:gen-class))

(def words
  [
   "Liefde"
   "Groei"
   "Orde en netheid"
   "Rechtvaardigheid"
   "Vrijheid"
   "Macht"
   "Passie"
   "Discipline"
   "Integriteit"
   "Seks"
   "Empathie"
   "Tolerantie"
   "Eerlijkheid"
   "Contributie"
   "Zekerheid"
   "Mededogen"
   "Blijheid"
   "Onafhankelijkheid"
   "Harmonie"
   "Waarheid"
   "Devotie"
   "Teamspirit"
   "Reputatie"
   "Vertrouwen"
   "Plezier"
   "Avontuur"
   "Uitdaging"
   "Deskundigheid"
   "Creativiteit"
   "Respect"
   "Comfort"
   "Vrede"
   "Extase"
   "Kwaliteit"
   "Commitment"
   "Humor"
   "Intelligentie"
   "Warmte"
   "Vitaliteit"
   "Schoonheid"
   "Delen"
   "Authenticiteit"
   "Meelevendheid"
   "Originaliteit"
   "Professionaliteit"
   "Competentie"
   "Openheid"
   "Behulpzaamheid"
   "Ondersteuning"
   "Intimiteit"
   "Invloed"
   "Rust"
   "Gezondheid"
   "Succes"
   "Veiligheid"
   "Verbetering"
   "Lol"
   "Risico"
   "Winnen"
   "Bescheidenheid"
   "Duurzaamheid"
   "Speelsheid"
   "Spontaniteit"
   "Losheid"
   "Flexibiliteit"
   "Controle"
   "Erkenning"
   "Waardering"
   "Status"])

(defn human-test [word]
  (let [response (read-line)]
    (= response "y")))

(defn human-filter
  ([test in] (human-filter test in [] []))
  ([test in keep discard]
   (if (empty? in)
     {:keep keep :discard discard}
     (let [[first & rest] in]
       (println first)
       (if (test first)
         (do
           (println (str "Keeping \"" first "\""))
           (recur test rest (conj keep first) discard))
         (do
           (println (str "Discarding \"" first "\""))
           (recur test rest keep (conj discard first))))))))

(defn human-at-most [x y]
  (println (str "Which do prefer, a) " x " or b) " y "?"))
  (let [response (read-line)]
    (= response "a")))

(defn human-merge
  [[l & *left :as left] [r & *right :as right] acc]
  (if (and (not-empty left) (not-empty right))
    (if (human-at-most l r)
      (do (println (str "Preferring \"" l "\""))(recur *left right (conj acc l)))
      (do (println (str "Preferring \"" r "\""))(recur left *right (conj acc r))))
    (concat acc left right)))

(defn human-sort [in]
  (if (> (count in) 1)
    (let [[left right] (split-at (/ (count in) 2) in)]
      (human-merge (human-sort left) (human-sort right) []))
    in))

(defn println-dash
  [in] (println (str " - " in)))

(defn -main
  [& args]
  (println (str "You'll be presented with " (count words) " words."))
  (println "Press \"y\" to to keep a word and \"n\" to discard it.")
  (let [{ keep :keep discard :discard } (human-filter human-test (shuffle words))]
    (println "Keeping:")
    (run! println-dash keep)
    (println "Discarding:")
    (run! println-dash discard)
    (let [sorted-words (human-sort keep)]
      (println "Words in order:")
      (doseq [[i word] (map-indexed vector sorted-words)]
        (println (str " " (inc i) ": " word))))))

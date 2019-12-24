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
  (println word)
  (let [response (read-line)]
    (if (= response "y")
      (do
        (println (str "Keeping \"" word "\""))
        true)
      (do
        (println (str "Discarding \"" word "\""))
        false))))

(defn human-at-most [x y]
  (println (str "Which do prefer, a) " x " or b) " y "?"))
  (let [response (read-line)]
    (if (= response "a")
      (do
        (println (str "Preferring \"" x "\""))
        true)
      (do (println (str "Preferring \"" y "\""))
        false))))

(defn println-dash [in] (println "-" in))

(defn -main
  [& args]
  (println "You'll be presented with" (count words) "words.")
  (println "Press \"y\" to to keep a word and \"n\" to discard it.")
  (let [{keep true discard false} (group-by human-test (shuffle words))]
    (println "Keeping:")
    (run! println-dash keep)
    (println "Discarding:")
    (run! println-dash discard)
    (let [sorted-words (sort human-at-most keep)]
      (println "Words in order:")
      (doseq [[i word] (map-indexed vector sorted-words)]
        (println (str " " (inc i) ": " word))))))

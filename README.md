# acces-a-distance

### ETUDIANT
* RANDRIANARIVELO Stephan
* ETU 1867

### CONTENU
* coté serveur:
  * ReceiveScreen: lit et dessine les captures d'écrans du client
  * SendEvent: prépare le printwriter pour l'envoi des commandes au client
  * CreateFrame: cré une fenetre et appel les classes ReceiveScreen et SendEvent

* coté client:
  * SendScreen: envoie les captures d'écrans
  * ReceiveEvent: recoi les évenements depuis le serveur
  * Connecton: initialise la connection et fait appel aux classes SendScreen et ReceiveEvent

### LANGUAGE
* JAVA

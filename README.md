# JustMeet

JustMeet è un sistema creato per facilitare la creazione di eventi ( es. Sportivi , videoludici , didattici ...) tra persone.
Le funzionalità sono :
- Poter registrarsi 
- Visualizzare il proprio account
- Modificare o eliminare il proprio account
- Visualizzare gli eventi a cui ti sei unito
- Gestire gli eventi che hai creato
- Creare o partecipare ad eventi
- Visualizzare gli eventi disponibili
- Stringire amicizia con altri utenti
- Visualizzare o rimuovere i propri amici
- Sistema di notifiche integrato

![Alt text](src/main/webapp/resources/images/Screen.png?raw=true "Titolo")

## Getting Started

Le istruzioni seguenti ti permetteranno di eseguire il sistema sulla tua macchina e simulare l'uso su un web server.

### Prerequisites

Di seguito troverai tutto quello che ti occorre per preparare il tuo ambiente per eseguire JustMeet :
- JDK 1.8 (versione minima)
- Maven
- Il tuo IDE preferito ( si consiglia Eclipse )

### Installing

Ora ti illustreremo una serie di passi per eseguire il sistema , ma prima se vuoi configurare le coordinate del tuo Database MySQL
vai in src/main/resources nella cartella del progetto e cerca il file " application.properties " .

Usa maven per compilare il sistema
```
mvn install
```
Questo eseguirà JustMeet sulla porta 8080 del tuo computer
```
Run with your IDE
```
Ora vedrai che verrà avviato Spring Boot , creata una connessione con un Database online.

Alla fine dovrai aprire il browser che preferisci e cercare " localhost:8080 " e se tutto

sarà andato a buon fine potrai vedere correttamente la pagina index.

## Running the tests

Per eseguire dei semplici test

```
mvn test
```

## Deployment
Se vuoi simulare il sistema su un web server gratuitamente , scarica e configura ngrok.

Per maggiori informazioni : https://www.antonioscatoloni.it/blog/2016/05/04/introduzione-a-ngrok

Una volta configurato :

* Eseguire JustMeet sulla tua macchina
* Eseguire sulla tua macchina il comando : ./ngrok http 8080 

Se tutto sarà andato a buon fine ngrok ti indicherà i link per visitare il sito. 

## Built With

* Spring Boot
* JSP Page
* Bootstrap
* MySQL online

## Javascript Libraries

* jQuery
* SweetAlert2

## Analytics

* Google Analytics
* Google Tag Manager

## Map

* Google Maps
* Google Chart Diagrams

## Font Script
* Font Awesome
* Google Font Api

## Diagrams

* Google Chart Diagrams
* Please refer to this link if you want to change the diagrams : https://developers.google.com/chart/interactive/docs/gallery?hl=it

## Authors

* **Matteo Molteni** 
* **Mattia Romagnoli**


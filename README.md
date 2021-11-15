# Usługa transportu zbiorowego - REST Api
## Lokalne uruchomienie aplikacji
### Wymagania systemowe
* Java 11
* wolny port 8080
####Instrukcja uruchomienie i weryfikacja działania
Wykonywalny plk transport-app.jar znajduje się w ścieżce `/src/main/resources/releases/`
Aplikacja uruchamiana jest poprzez wykonanie z lini komend w podanej ścieżce polecenia ```$ java -jar transport-app.jar```. W aplikacji dostępny jest publiczny endpoint testowy 
pod adresem `http://localhost:8080/transport-app/api/v1/test`. Jeżeli aplikacja została uruchomiona poprawnie, w oknie przeglądarki powinien być widoczny tekst `Hello from transport-api`
## Skrypt bazodanowy
Skrypt inicjalizujący struktury bazodanowe _init.sql_ znajduje się w ścieżce `/src/main/resources/scripts/`.
## Diagram bazy danych
Diagram modelu danych w uml znajduje się w pliku _public.uml_ w ścieżce `/src/main/resources/scripts/`.
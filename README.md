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
## Testowa - generyczna baza danych
Do projektu została dodana generyczna baza danych h2 przechowywana w pamięci jvm. Baza tworzona jest każdorazowo podczass startu aplikacji z pliku data.sql. Połączenie do konsoli bazy danych pod adresem `http://localhost:8080/transport-app/h2-console/`. Dane logowania:
1. Driver class `org.h2.Driver`
2. Database Url `jdbc:h2:mem:testdb`
3. Username `jdbc:h2:mem:testdb`
4. Password `password`

Po skuteczntm podłączeniu do bazy można wykonywać na niej testowe skrypty z poziomu konsoli dostępnej w przeglądarce
## OpenApi SwaggerUi
Adresy:
1. `http://localhost:8080/transport-app/v3/api-docs` - kolekcja requestów w formacie json
2. `http://localhost:8080/transport-app/swagger-ui/index.html?configUrl=/transport-app/v3/api-docs/swagger-config#/` - interfejs swaggerUI 

## Docker z bazą danych
`docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=dupa -d postgres`
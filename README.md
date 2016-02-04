# mongodb 

O MongoDB

Przydatne materiały:

    Działamy na MongoDB, spring-data-mongodb
    Najistotniejsze na teraz: mongo.repositories.html
    Pełna dokumentacja
    Konkretnie o zapytaniach związanych z wyszukiwaniem: http://docs.mongodb.org/manual/tutorial/query-documents/
    Przykład - BARDZO UBOGI - od wykładowcy https://github.com/KubaNeumann/springnosqldemo - przykład z samochodami i właścicielami 

Jak sprawić aby ten przykład w ogóle się uruchomił...

Otóż trzeba odpalić MongoDB:

mongod --dbpath {tu wpisz ścieżkę do bazy} --port 27017

Uwaga - akurat przykład od dr Neumanna działa na porcie 27017. Oczywiście jeśli wolisz mieć inny port, to nie ma problemu - wystarczy zmienić to w src/main/resources/beans.xml
Uwaga

Mongodb udostępnia konsolę, w której możesz wykonywać zapytania do bazy. Uruchamia się ją tak (można pominąć host i port, jeśli łączymy się lokalnie do bazy na domyślnym porcie):

mongo --port XXX --host XXX

Te zapytania można później wykorzystać na przykład przy adnotacji @Query, albo do stworzenia jakichś testowych rekordów.
Zadanie z Mongo:

Tradycyjnie CRUD według Twojego tematu. Wiadomo o co chodzi :)

Ponad to:

    Wyszukiwanie wszystkich dokumentów (odpowiednik rekordu) po jednym z pól nie będących ID
    Wyszukiwanie po wyrażeniu regularnym. Podpowiem że wersja mongodb w przykładzie springnosqldemo jest lekko leciwa. Należy wybrać jakąś bardziej aktualną. 

W bazie nosql niektóre z tych punktów będą banalnie łatwe :)

    Dwie klasy dokumentów w bazie, nazwijmy je roboczo X oraz Y, powiedzmy że jest jedno X do wielu Y, albo wiele X do wiele Y (aczkolwiek druga opcja wymaga pewnej sztuczki).
    Test CRUD co najmniej jednej z nich
    możliwość wyszukania Y należących do X
    możliwość skasowania Y spełniających jakieś kryterium i należących do X 

Taka uwaga - odrzuć myślenie relacyjne :)
Zadanie na 2pkt

Przygotować działającą stronę w JEE (może być za pomocą jakichś frameworków lub technologii typu Vaadin, GWT, JSP) w Twoim temacie. Dodatkowo oczywiście testy. Baza powinna być co najmniej taka jak w zadaniu poprzednim. 

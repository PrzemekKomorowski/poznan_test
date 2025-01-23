Witam, repozytorium służy oddaniu zadania które otrzymałem na okres od 16.01.2025 do do dnia 23.01.2025 r. do godz. 23:59.  w Regionalnym Ośrodku Polityki Społecznej.

Zadanie polegało na poprawieniu błędów, które zostały oznaczone odpowiednimi komentarzami.



Na obecną chwilę zostało poprawione:

Klasa Task
-
- Poprawiłem metodę gdzie `setStatus`, aby poprawnie przypisywała wartość
- Zdjąłem komentarz z `Settera Description`
- Poprawiłem implementację `hashCode` aby nie zwracał 0 tylko unikalną wartość. Aby w przypadku porównywania nie "wrzucał wszystkich Tasków to jednego worka"

- Końcowo usunąłem gettery i settery, żeby uprościc kod i użyłem lomboka.

Klasa Project
- 
- Uprościłem metodę `getName` kasując `String.valueOf`, gdyż jest tam niepotrzebnie wywołany
- Zmieniłem listę `tasks` z `List.of` na `ArrayList`

Dodatkowa notatka:

Rozbudowałem kilka funkcjonalności jak możliwość wyszukiwania tasków po Statusie Taska, Dacie, Opisie czy ID.

Niestety ze względów prywatnych nie jestem wstanie wykonać testów ani sam nie sprawdziłem w pełni aplikacji, dlatego zostaje ona w obecnym stadium.



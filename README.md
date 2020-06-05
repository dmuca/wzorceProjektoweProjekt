**Obliczanie pola powierzchni podłóg oraz ścian w domu/mieszkaniu na podstawie danych pliku txt.**  
W pliku wypisane są pomieszczenia, ich szerokość, długość oraz wysokość.  
Program oblicza pole powierzchni poszczególnych pomieszczeń oraz całkowity metraż domu.  
Dla uproszczenia zakładam, że wszystkie pomieszczenia mają kształt prostopadłościanu.

Format pliku txt (wyrażone w metrach):
```
Nazwa pomieszczenia;szerokość;długość;wysokość;
```
Przykładowy format pliku txt:  
```
Kuchnia;4;3;2.5;
Salon;5;5;2.5;
Łazienka;2;3;2.5;
Salon;6;6;2.5;
```

Przykładowy wynik działania programu:  
```
Kuchnia (4m x 3m x 2.5m) 
    Powierzchnia podłogi: 12m^2
     Powierzchnia sufitu: 12m^2
      Powierzchnia ścian: 35m^2
  Objętość pomieszczenia: 30m^3

Salon (5m x 5m x 2.5m)
    Powierzchnia podłogi: 25m^2
     Powierzchnia sufitu: 25m^2
      Powierzchnia ścian: 50m^2
  Objętość pomieszczenia: 62,5m^3

Łazienka (2m x 3m x 2.5m)
    ...

Salon (6m x 6m 2.5m)
    ...

Dom/mieszkanie
    Powierzchnia podłogi: 25m^2
     Powierzchnia sufitu: 25m^2
      Powierzchnia ścian: 50m^2
                Objętość: 500,5m^3
```

**Budowanie oraz uruchomienie aplikacji**
```bash
mvn clean package
java -jar target/ApartmentCalculator-1.0-Release.jar
```

**Uruchomienie testów**
```bash
mvn test
```

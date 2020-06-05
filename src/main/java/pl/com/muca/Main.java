package pl.com.muca;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.class.path").replace(':','\n'));

    if (args.length == 0) {
      System.out.println("Musisz podać ścieżkę do pliku który chcesz wczytać.");
    } else {
      for (String filePath : args) {
        File file = new File(filePath);
        try {
          Apartment.from(file);
          Apartment apartment = Apartment.from(file);
          ApartmentCalculator apartmentCalculator = ApartmentCalculator.from(apartment);
          System.out.printf("Informacje dla %s. %n%s %n", file.getName(), apartmentCalculator);
        } catch (FileNotFoundException e) {
          System.out.printf("Nie mogłem znaleźć pliku \"%s\".%n", filePath);
          e.printStackTrace();
        } catch (ParseException e) {
          System.out.printf("Plik \"%s\" jest nieprawidłowo sformatowany.%n", filePath);
          e.printStackTrace();
        }
      }
    }
  }
}

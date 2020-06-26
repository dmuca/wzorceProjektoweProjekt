package pl.com.muca;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Arrays;
import pl.com.muca.apartment.Apartment;

/**
 * Program wykorzystuje:
 * 1. Wzorzec adapter (klasa RoomGeometricShapeAdapter).
 * 2. Wzorzec projektowy budowniczy (klasa Room).
 * 3. Wzorzec projektowy Singleton (klasa ApartmentPrinter).
 */
public class Main {
  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("Musisz podać ścieżkę do pliku który chcesz wczytać.");
    } else {
      Arrays.stream(args)
          .map(File::new)
          .map(file -> new Thread(tryToPrintApartment(file)))
          .forEach(Thread::start);
    }
  }

  private static Runnable tryToPrintApartment(File file) {
    return () -> {
      try {
        ApartmentPrinter.getInstance().print(Apartment.from(file));
      } catch (FileNotFoundException e) {
        System.out.printf("Nie mogłem znaleźć pliku \"%s\".%n", file);
        e.printStackTrace();
      } catch (ParseException e) {
        System.out.printf("Plik \"%s\" jest nieprawidłowo sformatowany.%n", file);
        e.printStackTrace();
      }
    };
  }
}

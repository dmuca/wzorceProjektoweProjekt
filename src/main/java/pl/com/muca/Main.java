package pl.com.muca;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import pl.com.muca.apartment.Apartment;

/** Program wykorzystuje:
 *  1. Wzorzec adapter (klasy ApartmentCalculatorAdapterImpl, RoomGeometricShapeAdapter).
 *  2. Wzorzec projektowy budowniczy (klasa Room).
 *  3. Wzorzec projektowy Singleton (klasa ApartmentPrinter).
 * */
public class Main {
  public static void main(String[] args) {
    ApartmentPrinter apartmentPrinter = ApartmentPrinter.getInstance();

    if (args.length == 0) {
      System.out.println("Musisz podać ścieżkę do pliku który chcesz wczytać.");
    } else {
      for (String filePath : args) {
        File file = new File(filePath);
        try {
          apartmentPrinter.print(Apartment.from(file));
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

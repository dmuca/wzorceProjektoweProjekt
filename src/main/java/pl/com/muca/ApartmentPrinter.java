package pl.com.muca;

import static java.util.stream.Collectors.joining;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import pl.com.muca.apartment.Apartment;
import pl.com.muca.apartment.Room;
import pl.com.muca.calculator.ApartmentCalculator;
import pl.com.muca.calculator.ApartmentCalculatorImpl;

public class ApartmentPrinter {
  private static ApartmentPrinter instance;
  private final PrintWriter printWriter;

  private ApartmentPrinter(PrintWriter printWriter) {
    this.printWriter = printWriter;
  }

  public static synchronized ApartmentPrinter getInstance() {
    if (ApartmentPrinter.instance == null){
      try {
        PrintWriter writer = new PrintWriter("wynik.txt");
        ApartmentPrinter.instance = new ApartmentPrinter(writer);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return ApartmentPrinter.instance;
  }

  synchronized void print(Apartment apartment) {
    printWriter.printf("##### Apartament %s ##### %n", apartment.getName().split("\\.")[0]);
    printWriter.printf("%s %n", getApartamentInfo(apartment));
    printWriter.printf("%s %n", getRoomsInfo(apartment));
    printWriter.flush();
  }

  private static String getApartamentInfo(Apartment apartment) {
    ApartmentCalculator calc = ApartmentCalculatorImpl.from(apartment);
    return new StringBuilder()
        .append(String.format("\tPowierzchnia podłóg: %-9s%n", calc.calculateFloorArea()+" m^2"))
        .append(String.format("\tPowierzchnia ścian:  %-9s %n", calc.calculateWallSurfaceArea()+" m^2"))
        .toString();
  }

  private String getRoomsInfo(Apartment apartment) {
    return apartment.getRoomList().stream().map(ApartmentPrinter::getRoomInfo).collect(joining());
  }

  private static String getRoomInfo(Room room) {
    return new StringBuilder()
        .append(String.format("%s %n", room.getName()))
        .append(String.format("\tSzerokość: %-7s %n", room.getWidth()+" m^2"))
        .append(String.format("\tDługość:   %-7s %n", room.getLength()+" m^2"))
        .append(String.format("\tWysokość:  %-7s %n", room.getHeight()+" m^2"))
        .toString();
  }
}

package pl.com.muca;

import static java.util.stream.Collectors.joining;

import java.io.PrintStream;
import pl.com.muca.apartment.Apartment;
import pl.com.muca.apartment.Room;
import pl.com.muca.calculator.ApartmentCalculator;
import pl.com.muca.calculator.ApartmentCalculatorImpl;

public class ApartmentPrinter {
  private static ApartmentPrinter instance;
  private final PrintStream printStream;

  private ApartmentPrinter(PrintStream printStream) {
    this.printStream = printStream;
  }

  public static ApartmentPrinter getInstance() {
    if (ApartmentPrinter.instance == null){
      ApartmentPrinter.instance = new ApartmentPrinter(System.out);
    }
    return ApartmentPrinter.instance;
  }

  synchronized void print(Apartment apartment) {
    String apartmentName = String.format("##### Apartament %s ##### %n", apartment.getName().split("\\.")[0]);
    String apartmentInfo = String.format("%s %n", getApartamentInfo(apartment));
    String apartmentRoomsInfo = String.format("%s %n", getRoomsInfo(apartment));
    printStream.printf("%s %s %s", apartmentName, apartmentInfo, apartmentRoomsInfo);
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

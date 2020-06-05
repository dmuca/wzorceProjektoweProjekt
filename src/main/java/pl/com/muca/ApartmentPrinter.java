package pl.com.muca;

import static java.util.stream.Collectors.joining;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class ApartmentPrinter {
  private PrintStream printStream;

  ApartmentPrinter(PrintStream printStream) {
    this.printStream = printStream;
  }

  void print(Apartment apartment) {
    printStream.printf("##### Apartament %s ##### %n", apartment.getName().split("\\.")[0]);
    printStream.printf("%s %n", getApartamentInfo(apartment));
    printStream.printf("%s %n", getRoomsInfo(apartment));
  }

  private static String getApartamentInfo(Apartment apartment) {
    ApartmentCalculator calc = ApartmentCalculator.from(apartment);
    return new StringBuilder()
        .append(String.format("\tPowierzchnia podłóg: %5s m^2%n", calc.calculateFloorArea()))
        .append(String.format("\tPowierzchnia ścian:  %5s %n", calc.calculateWallSurfaceArea()))
        .toString();
  }

  private String getRoomsInfo(Apartment apartment) {
    return apartment.getRoomList().stream().map(ApartmentPrinter::getRoomInfo).collect(joining());
  }

  private static String getRoomInfo(Room room) {
    return new StringBuilder()
        .append(String.format("%s %n", room.getName()))
        .append(String.format("\tSzerokość: %4sm^2 %n", room.getWidth()))
        .append(String.format("\tDługość:   %4sm^2 %n", room.getLength()))
        .append(String.format("\tWysokość:  %4sm^2 %n", room.getHeight()))
        .toString();
  }
}

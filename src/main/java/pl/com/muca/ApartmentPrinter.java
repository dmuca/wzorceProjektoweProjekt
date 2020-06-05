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
    printStream.printf("### Apartament \"%s\" %n", apartment.getName().split("\\.")[0]);
    String roomsInfo =
        apartment.getRoomList().stream()
            .map(ApartmentPrinter::getRoomInfo)
            .collect(joining());
    printStream.printf("%s %n", roomsInfo);
  }

  private static String getRoomInfo(Room room) {
    return new StringBuilder()
        .append(String.format("%s %n", room.getName()))
        .append(String.format("\tSzerokość: %4s %n", room.getWidth()))
        .append(String.format("\t  Długość: %4s %n", room.getLength()))
        .append(String.format("\t Wysokość: %4s %n", room.getHeight()))
        .toString();
  }
}

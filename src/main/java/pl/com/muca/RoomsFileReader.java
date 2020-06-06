package pl.com.muca;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import pl.com.muca.apartment.Room;

public class RoomsFileReader {

  public static ImmutableList<Room> read(File file)
      throws FileNotFoundException, ParseException {
    Builder<Room> rooms = ImmutableList.builder();
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
      rooms.add(parseToRoom(sc.nextLine()));
    }
    return rooms.build();
  }

  private static Room parseToRoom(String line) throws ParseException {
    String[] roomLineValues = line.split(";");

    Room.Builder roomBuilder = Room.builder();
    try {
      roomBuilder.setName(roomLineValues[0])
          .setWidth(Double.parseDouble(roomLineValues[2]))
          .setLength(Double.parseDouble(roomLineValues[1]))
          .setHeight(Double.parseDouble(roomLineValues[3]));
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new ParseException("Wrong file format.", 0);
    }
    return roomBuilder.build();
  }
}


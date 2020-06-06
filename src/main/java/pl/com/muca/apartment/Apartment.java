package pl.com.muca.apartment;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import pl.com.muca.calculator.RoomsFileReader;

public class Apartment {

  private final String name;

  private final ImmutableList<Room> roomList;
  private Apartment(String name, ImmutableList<Room> roomList) {
    this.name = name;
    this.roomList = roomList;
  }

  public static Apartment from(File file)
      throws FileNotFoundException, ParseException {
    ImmutableList<Room> roomList = RoomsFileReader.read(file);
    return new Apartment(file.getName(), roomList);
  }

  public String getName() {
    return name;
  }

  public ImmutableList<Room> getRoomList() {
    return roomList;
  }
}

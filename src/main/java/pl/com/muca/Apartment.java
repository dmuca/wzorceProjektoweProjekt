package pl.com.muca;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Apartment {
  private final ImmutableList<Room> roomList;

  private Apartment(ImmutableList<Room> roomList) {
    this.roomList = roomList;
  }

  public static Apartment from(File file)
      throws FileNotFoundException, ParseException {
    ImmutableList<Room> roomList = RoomsFileReader.read(file);
    return new Apartment(roomList);
  }

  public ImmutableList<Room> getRoomList() {
    return roomList;
  }
}

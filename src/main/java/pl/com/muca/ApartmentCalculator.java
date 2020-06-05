package pl.com.muca;

public class ApartmentCalculator {

  private final Apartment apartment;

  ApartmentCalculator(Apartment apartment) {
    this.apartment = apartment;
  }

  public static ApartmentCalculator from(Apartment apartment) {
    return new ApartmentCalculator(apartment);
  }

  public double calculateFloorArea() {
    return apartment.getRoomList().stream()
        .map(this::calculateFloorSurface)
        .mapToDouble(Double::doubleValue)
        .sum();
  }

  private double calculateFloorSurface(Room room) {
    return room.getLength() * room.getWidth();
  }

  public double calculateWallSurfaceArea() {
    return apartment.getRoomList().stream()
        .map(this::calculateWallSurface)
        .mapToDouble(Double::doubleValue)
        .sum();
  }

  private double calculateWallSurface(Room room) {
    double wallByLength = room.getLength() * room.getHeight();
    double wallByWidth = room.getWidth() * room.getHeight();
    return wallByLength * 2 + wallByWidth * 2;
  }
}

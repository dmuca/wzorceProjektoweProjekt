package pl.com.muca.calculator;

import pl.com.muca.apartment.Apartment;
import pl.com.muca.apartment.Room;

public class ApartmentCalculatorImpl implements ApartmentCalculator{

  private final Apartment apartment;

  ApartmentCalculatorImpl(Apartment apartment) {
    this.apartment = apartment;
  }

  public static ApartmentCalculatorImpl from(Apartment apartment) {
    return new ApartmentCalculatorImpl(apartment);
  }

  @Override
  public double calculateFloorArea() {
    return apartment.getRoomList().stream()
        .map(this::calculateFloorSurface)
        .mapToDouble(Double::doubleValue)
        .sum();
  }

  private double calculateFloorSurface(Room room) {
    return room.getLength() * room.getWidth();
  }

  @Override
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

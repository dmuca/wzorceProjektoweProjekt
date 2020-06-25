package pl.com.muca.calculator;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import org.locationtech.jts.geom.Polygon;
import pl.com.muca.apartment.Apartment;

public class ApartmentCalculatorImpl implements ApartmentCalculator {
  private final ImmutableList<RoomGeometricShapeAdapter> roomsGeometrics;

  private ApartmentCalculatorImpl(Apartment apartment) {
    this.roomsGeometrics =
        apartment.getRoomList().stream()
            .map(RoomGeometricShapeAdapter::from)
            .collect(ImmutableList.toImmutableList());
  }

  public static ApartmentCalculatorImpl from(Apartment apartment){
    return new ApartmentCalculatorImpl(apartment);
  }

  @Override
  public double calculateFloorArea() {
    return roomsGeometrics.stream()
        .map(RoomGeometricShapeAdapter::getFloorArea)
        .mapToDouble(Double::doubleValue)
        .sum();
  }

  @Override
  public double calculateWallSurfaceArea() {
    return roomsGeometrics.stream()
        .map(RoomGeometricShapeAdapter::getWallsArea)
        .mapToDouble(Double::doubleValue)
        .sum();
  }
}

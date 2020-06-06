package pl.com.muca.calculator;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import org.locationtech.jts.geom.Polygon;
import pl.com.muca.apartment.Apartment;

public class ApartmentCalculatorAdapterImpl implements ApartmentCalculator {
  private final ImmutableList<RoomGeometricShapeAdapter> roomsGeometrics;

  private ApartmentCalculatorAdapterImpl(Apartment apartment) {
    this.roomsGeometrics =
        apartment.getRoomList().stream()
            .map(RoomGeometricShapeAdapter::from)
            .collect(ImmutableList.toImmutableList());
  }

  public static ApartmentCalculatorAdapterImpl from(Apartment apartment){
    return new ApartmentCalculatorAdapterImpl(apartment);
  }

  @Override
  public double calculateFloorArea() {
    return roomsGeometrics.stream()
        .map(RoomGeometricShapeAdapter::getFloor)
        .map(Polygon::getArea)
        .mapToDouble(Double::doubleValue)
        .sum();
  }

  @Override
  public double calculateWallSurfaceArea() {
    return roomsGeometrics.stream()
        .map(RoomGeometricShapeAdapter::getWalls)
        .flatMap(Collection::stream)
        .map(Polygon::getArea)
        .mapToDouble(Double::doubleValue)
        .sum();
  }
}

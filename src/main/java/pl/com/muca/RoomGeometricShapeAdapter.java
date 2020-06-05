package pl.com.muca;

import com.google.common.collect.ImmutableList;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.util.GeometricShapeFactory;

public class RoomGeometricShapeAdapter {

  private final Polygon floor;
  private final Polygon ceil;
  private final ImmutableList<Polygon> walls;

  private RoomGeometricShapeAdapter(Room room) {
    double length = room.getLength();
    double width = room.getWidth();
    double height = room.getHeight();
    this.floor = shapeFrom(width, length).createRectangle();
    this.ceil = shapeFrom(width, length).createRectangle();
    this.walls =
        ImmutableList.of(
            shapeFrom(width, height).createRectangle(),
            shapeFrom(width, height).createRectangle(),
            shapeFrom(length, height).createRectangle(),
            shapeFrom(length, height).createRectangle());
  }

  public static RoomGeometricShapeAdapter from(Room room) {
    return new RoomGeometricShapeAdapter(room);
  }

  private GeometricShapeFactory shapeFrom(double x, double y) {
    GeometricShapeFactory geometricShapeFactory = new GeometricShapeFactory();
    geometricShapeFactory.setWidth(x);
    geometricShapeFactory.setHeight(y);
    return geometricShapeFactory;
  }

  public Polygon getFloor() {
    return floor;
  }

  public Polygon getCeil() {
    return ceil;
  }

  public ImmutableList<Polygon> getWalls() {
    return walls;
  }
}

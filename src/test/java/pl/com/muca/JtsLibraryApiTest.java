

package pl.com.muca;

import static org.testng.Assert.assertEquals;

import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.util.GeometricShapeFactory;
import org.testng.annotations.Test;

/**
 * Tests for checking the correctness of external library API.
 */
public class JtsLibraryApiTest {
  @Test
  public void getArea_forSquare_shouldReturnProperValue() {
    GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
    shapeFactory.setSize(40);
    Polygon rectangle = shapeFactory.createRectangle();
    double area = rectangle.getArea();
    assertEquals(area, 1600, 0.000001);
  }

  @Test
  public void getArea_forRectangle_shouldReturnProperValue() {
    GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
    shapeFactory.setWidth(2.5);
    shapeFactory.setHeight(50);
    Polygon rectangle = shapeFactory.createRectangle();
    double area = rectangle.getArea();
    assertEquals(area, 125, 0.000001);
  }
}

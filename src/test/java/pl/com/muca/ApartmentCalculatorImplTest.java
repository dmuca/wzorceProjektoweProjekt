package pl.com.muca;

import static org.testng.Assert.assertEquals;

import com.google.common.base.Function;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.stream.Stream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApartmentCalculatorImplTest {
  private Function<Apartment, ApartmentCalculator> calculator;

  @BeforeClass
  public void setUp(){
    calculator = ApartmentCalculatorImpl::from;
//    calculator = ApartmentCalculatorAdapterImpl::from;
  }

  @Test
  public void calculateFloorArea_firstHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_1.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = calculator.apply(apartment);

    double apartmentFloorArea = apartmentCalculator.calculateFloorArea();

    assertEquals(apartmentFloorArea, 79, 10E-5);
  }

  @Test
  public void calculateFloorArea_secondHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_2.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = calculator.apply(apartment);

    double apartmentFloorArea = apartmentCalculator.calculateFloorArea();

    assertEquals(apartmentFloorArea, 137, 10E-5);
  }

  @Test(expectedExceptions = FileNotFoundException.class)
  public void createApartment_fromNonExistingFile_shouldThrowException()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("non_existing_file");

    Apartment.from(houseFile);
  }

  @Test
  public void calculateWallSurfaceArea_firstHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_1.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = calculator.apply(apartment);

    double wallSurfaceArea = apartmentCalculator.calculateWallSurfaceArea();

    assertEquals(wallSurfaceArea, 170, 10E-5);
  }

  @Test
  public void calculateWallSurfaceArea_secondHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_2.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = calculator.apply(apartment);

    double wallSurfaceArea = apartmentCalculator.calculateWallSurfaceArea();

    assertEquals(wallSurfaceArea, 275);
  }

  @Test(expectedExceptions = ParseException.class)
  public void createApartment_fromBrokenFormatFile_shouldThrowException()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/file_broken_format.txt");
    Apartment apartment = Apartment.from(houseFile);
  }
}

package pl.com.muca;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import org.testng.annotations.Test;

public class ApartmentCalculatorTest {

  @Test
  public void calculateFloorArea_firstHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_1.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = ApartmentCalculator
        .from(apartment);

    double apartmentFloorArea = apartmentCalculator.calculateFloorArea();

    assertEquals(apartmentFloorArea, 79, 10E-5);
  }

  @Test
  public void calculateFloorArea_secondHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_2.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = ApartmentCalculator
        .from(apartment);

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
    ApartmentCalculator apartmentCalculator = ApartmentCalculator
        .from(apartment);

    double wallSurfaceArea = apartmentCalculator.calculateWallSurfaceArea();

    assertEquals(wallSurfaceArea, 170, 10E-5);
  }

  @Test
  public void calculateWallSurfaceArea_secondHouse_shouldReturnCorrectArea()
      throws FileNotFoundException, ParseException {
    File houseFile = new File("src/test/resources/house_2.txt");
    Apartment apartment = Apartment.from(houseFile);
    ApartmentCalculator apartmentCalculator = ApartmentCalculator
        .from(apartment);

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

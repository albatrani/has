import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;

    @Before
    public void setUp() throws Exception {
        house = TestingUtilities.getSampleHouse();
    }

    @Test
    public void testGetHouseSectionValid() {
        // Act
        String expected = "Master Bedroom";
        HouseSection actual = house.getHouseSection(expected);

        // Assert
        assertNotNull(actual);
        assertEquals(actual.getName(), expected);
    }

    @Test
    public void testGetHouseSectionInValid() {
        // Act
        String expected = "Garden";
        HouseSection actual = house.getHouseSection(expected);

        // Assert
        assertNull(actual);
    }

    @Test
    public void testAddHouseSectionValid() {
        // Act
        HouseSection newSection = new HouseSection("Swimming Pool", false);
        boolean actual = house.addHouseSection(newSection);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void testAddHouseSectionDuplicatesNotAllowed() {
        // Act
        HouseSection existingSection = new HouseSection("Master Bedroom", true);
        boolean actual = house.addHouseSection(existingSection);

        // Assert
        assertFalse(actual);
    }

}

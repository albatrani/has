import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControlLightingHandlerTests {

    private ControlLightingHandler handler;
    private static House house;

    @BeforeClass
    public static void setUpBeforeClass() {
        house = TestingUtilities.getSampleHouse();
    }

    @Before
    public void setUp() throws Exception {
        handler = house.makeNewControlLighting();
    }

    @Test
    public void testControlLightingHandler() {
        assertNotNull(handler.getHouse());
        assertNotNull(handler.getLct());
    }

    @Test
    public void testSelectHousesectionValidName() {
        // Act
        String expected = "Master Bedroom";
        HouseSection actual = handler.selectHousesection(expected);

        // Assert
        assertNotNull(actual);
        assertEquals(actual.getName(), expected);
    }

    @Test
    public void testSelectHousesectionInValidName() {
        // Act
        String expected = "Swimming Pool"; // does not exist
        HouseSection actual = handler.selectHousesection(expected);

        // Assert
        assertNull(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectHousesectionThrowsException() {
        // Act
        handler.selectHousesection(null);
    }

    @Test
    public void testTurnOnOffLightingSuccessfulAddition() {
        // Act
        HouseSection masterBedroom = house.getHouseSection("Master Bedroom");
        handler.turnOnOffLighting(masterBedroom, LightStatus.ON);

        // Assert
        assertEquals(1, handler.getLct().getLcas().size());
    }

    @Test
    public void testTurnOnOffLightingDuplicatesNotAllowed() {
        // Act
        HouseSection masterBedroom = house.getHouseSection("Master Bedroom");
        boolean first = handler.turnOnOffLighting(masterBedroom, LightStatus.ON);
        boolean second = handler.turnOnOffLighting(masterBedroom, LightStatus.OFF);

        // Assert
        assertTrue(first);
        assertFalse(second);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTurnOnOffLightingNullHouseSectionNotAllowed()
            throws IllegalArgumentException {
        // Act
        handler.turnOnOffLighting(null, LightStatus.ON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTurnOnOffLightingNullActionNotAllowed() {
        // Act
        handler.turnOnOffLighting(house.getHouseSection("Master Bedroom"), null);
    }

    @Test
    public void testEndControlLighting() {
        // Act
        int noOfTransactionLogBefore = house.getTrasactions().size();
        TestingUtilities.addUserLightControlSelections(handler);
        TransactionStatus status = handler.endControlLighting();
        int noOfTransactionLogAfter = house.getTrasactions().size();

        // Assert
        assertEquals(TransactionStatus.SUCCESSFUL, status);
        assertEquals(0, noOfTransactionLogBefore);
        assertEquals(1, noOfTransactionLogAfter);
    }

}

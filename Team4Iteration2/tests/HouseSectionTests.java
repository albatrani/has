import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HouseSectionTests {

    private static final String MASTER_BEDROOM_NAME = "Master Bedroom";
    private static final String BACK_YARD_NAME = "Back Yard";

    @Test
    public void testHouseSection() {
        // Arrange
        HouseSection masterBedRoom = new HouseSection(MASTER_BEDROOM_NAME, true);

        // Asserts by checking that the object is initialized properly
        assertEquals("HouseSection names are not equal", MASTER_BEDROOM_NAME,
                masterBedRoom.getName());
        assertTrue("HouseSection should be in side house", masterBedRoom.isInHouse());
        assertNotNull("HouseSection's light adapter was not defined",
                masterBedRoom.getLightAdapter());
    }

    @Test
    public void testSetLightingStatusAndGetLightingStatus() {
        // Arrange
        HouseSection masterBedRoom = new HouseSection(MASTER_BEDROOM_NAME, true);
        HouseSection backYard = new HouseSection(BACK_YARD_NAME, false);

        // Act - switch on the lights and then switch them off
        masterBedRoom.setLightingStatus(LightStatus.ON);
        backYard.setLightingStatus(LightStatus.ON);
        masterBedRoom.setLightingStatus(LightStatus.OFF);

        // Assert
        assertEquals("HouseSection setLightingStatus function failed", LightStatus.OFF,
                masterBedRoom.getLightingStatus());
        assertEquals("HouseSection setLightingStatus function failed", LightStatus.ON,
                backYard.getLightingStatus());
    }
}

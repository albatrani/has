import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LightingControlTransactionTests {

    private HouseSection hs;
    private LightStatus action;
    private LightingControlTransaction lct;

    @Before
    public void setUp() throws Exception {
        // Arrange
        hs = new HouseSection("Kitchen", true);
        action = LightStatus.ON;
        lct = new LightingControlTransaction();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddLightControlActionUniqueEntries() {
        // Act
        lct.addLightControlAction(hs, action);
        lct.addLightControlAction(new HouseSection("Bedroom", true), LightStatus.OFF);

        // Assert
        assertEquals(2, lct.getLcas().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddLightControlActionDuplicatesNotAllowed() {
        // Act
        lct.addLightControlAction(hs, action);
        lct.addLightControlAction(hs, action); // throws exception duplicate
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddLightControlActionDuplicatesNotAllowed2() {
        // Act
        lct.addLightControlAction(hs, action);
        lct.addLightControlAction(new HouseSection("Kitchen", true), LightStatus.OFF); // throws
                                                                                       // exception
                                                                                       // duplicate
    }

    @Test
    public void testComplete() {
        // Act
        for (int i = 0; i < TestingUtilities.SECTIONS_NAMES.length; i++) {
            HouseSection hs =
                    new HouseSection(TestingUtilities.SECTIONS_NAMES[i],
                            TestingUtilities.SECTIONS_IN_HOUSE_FLAGS[i]);
            LightStatus action = LightStatus.ON;
            lct.addLightControlAction(hs, action);
        }
        TransactionStatus actual = lct.complete();
        TransactionStatus expected = TransactionStatus.SUCCESSFUL;

        // Assert
        assertEquals(expected, actual);
        assertNotEquals(TransactionStatus.FAILED, actual);
    }

    @Test
    public void testSetType() {
        // Act
        lct.setType(LightingControlTransactionType.SWITCH_ALL_LIGHTS_OFF);

        // Assert
        assertEquals(LightingControlTransactionType.SWITCH_ALL_LIGHTS_OFF, lct.getType());
    }

}

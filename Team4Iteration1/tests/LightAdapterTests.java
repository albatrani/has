import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LightAdapterTests {

    @Test
    public void testLightAdapter() {
        // Arrange
        LightAdapter lightAdapter = new LightAdapter();

        // check that object is initialized to off
        assertEquals(lightAdapter.getLightStatus(), LightStatus.OFF);
    }

    @Test
    public void testOn() {
        // Arrange
        LightAdapter lightAdapter = new LightAdapter();

        // Act
        lightAdapter.on();

        // Assert status to be on
        assertEquals(lightAdapter.getLightStatus(), LightStatus.ON);
    }

    @Test
    public void testOff() {
        // Arrange
        LightAdapter lightAdapter = new LightAdapter();

        // Act
        lightAdapter.off();

        // assert status to be off
        assertEquals(lightAdapter.getLightStatus(), LightStatus.OFF);
    }
}

/*
 * Test driver program for control lighting feature
 */
public class SampleControlLightingRun {

    public static void main(String[] args) {
        // create a sample house
        House house = TestingUtilities.getSampleHouse();

        // test 1: switch on all lights for every house section
        switchAllLightsOnScenario(house);

        System.out.println();

        // test 2: switch off 6 random lights
        switchRandowmLightsOffScenario(house, 6);

    }

    private static void switchAllLightsOnScenario(House house) {
        // get ControlLightingHandler
        ControlLightingHandler handler = house.makeNewControlLighting();

        System.out
                .println("--------------------------------------------------------------");
        System.out.println("      Test 1: Switch On all lights for the house");
        System.out
                .println("--------------------------------------------------------------");

        TestingUtilities.addUserLightControlSelections(house, handler, LightStatus.ON);
        System.out.printf("%s%nCreating %s%n", house.toString(), handler.getLct()
                .toString());

        // execute the transaction
        System.out.printf("Executing the Lighting Control Transaction now...%n");
        handler.endControlLighting();
        System.out.printf("%nHouse details after the transaction...%n%s",
                house.toString());
        System.out
                .println("--------------------------------------------------------------");
        System.out.println("                   End of Test 1");
        System.out
                .println("--------------------------------------------------------------");
    }

    private static void switchRandowmLightsOffScenario(House house, int count) {
        // get ControlLightingHandler
        ControlLightingHandler handler = house.makeNewControlLighting();

        System.out
                .println("--------------------------------------------------------------");
        System.out.printf("      Test 2: Switch Off %d random lights from the house%n",
                count);
        System.out
                .println("--------------------------------------------------------------");

        TestingUtilities.addRandomUserLightControlSelections(house, handler,
                LightStatus.OFF, count);
        System.out.printf("%s%nCreating %s%n", house.toString(), handler.getLct()
                .toString());

        // execute the transaction
        System.out.printf("Executing the Lighting Control Transaction now...%n");
        handler.endControlLighting();
        System.out.printf("%nHouse details after the transaction...%n%s",
                house.toString());
        System.out
                .println("--------------------------------------------------------------");
        System.out.println("                   End of Test 2");
        System.out
                .println("--------------------------------------------------------------");
    }
}

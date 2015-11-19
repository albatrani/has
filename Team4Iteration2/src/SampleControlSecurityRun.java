public class SampleControlSecurityRun {

    public static void main(String[] args) {
        // create a sample house
        House house = TestingUtilities.getSampleHouse();

        // test 1: switch on all lights for every house section
        secureForNightScenario(house);

        System.out.println();

        // test 2: switch off 6 random lights
        goodMorningScenario(house);

    }

    private static void secureForNightScenario(House house) {
        ControlSecurityHandler handler = house.makeNewControlSecurity();

        System.out
                .println("--------------------------------------------------------------");
        System.out.println(" Test 1: Secure For Night (Enable all Window/Door sensors");
        System.out.println("         and lock all external doors)");
        System.out
                .println("--------------------------------------------------------------");

        handler.secureForNight();
        System.out.printf("%s%nCreating %s%n", house.getHouseSecurityStatusDescription(),
                handler.getSecurityControlTransaction().toString());

        // execute the transaction
        System.out.printf(
                "Executing the Security Control Transaction (type: %s) now...%n", handler
                        .getSecurityControlTransaction().getType());
        handler.endControlSecurity();
        System.out.printf("%nHouse security details after the transaction...%n%s",
                house.getHouseSecurityStatusDescription());
        System.out
                .println("--------------------------------------------------------------");
        System.out.println("                   End of Test 1");
        System.out
                .println("--------------------------------------------------------------");
    }

    private static void goodMorningScenario(House house) {
        ControlSecurityHandler handler = house.makeNewControlSecurity();

        System.out
                .println("--------------------------------------------------------------");
        System.out.println(" Test 2: Good Morning (disables all Window/Door sensors)");
        System.out
                .println("--------------------------------------------------------------");

        handler.goodMorning();
        System.out.printf("%s%nCreating %s%n", house.getHouseSecurityStatusDescription(),
                handler.getSecurityControlTransaction().toString());

        // execute the transaction
        System.out.printf(
                "Executing the Security Control Transaction (type: %s) now...%n", handler
                        .getSecurityControlTransaction().getType());
        handler.endControlSecurity();
        System.out.printf("%nHouse security details after the transaction...%n%s",
                house.getHouseSecurityStatusDescription());
        System.out
                .println("--------------------------------------------------------------");
        System.out.println("                   End of Test 2");
        System.out
                .println("--------------------------------------------------------------");
    }

}

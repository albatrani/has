import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestingUtilities {

    private final static String[] SECTIONS_NAMES = {
            "Front Door", "Living Room", "Master Bedroom", "Master Bedroom Bath",
            "Master Bedroom Closet", "Kitchen", "Stairway", "Upstair Looby",
            "Kids Bedroom", "Guest Bedroom", "Guest Bathroom"
    };
    private final static boolean[] SECTIONS_IN_HOUSE_FLAGS = {
            false, true, true, true, true, true, true, true, true, true, true,
    };

    public static House getSampleHouse() {
        House house =
                new House(new Resident("Team 4", "password"), "Cypress Spring Apartments");
        List<HouseSection> sections = getHouseSections();
        for (HouseSection hs : sections) {
            house.addHouseSection(hs);
        }
        return house;
    }

    public static List<HouseSection> getHouseSections() {
        List<HouseSection> list = new ArrayList<>();
        for (int i = 0; i < TestingUtilities.SECTIONS_NAMES.length; i++) {
            HouseSection hs =
                    new HouseSection(TestingUtilities.SECTIONS_NAMES[i],
                            TestingUtilities.SECTIONS_IN_HOUSE_FLAGS[i]);
            list.add(hs);
        }
        return list;
    }

    public static void addUserLightControlSelections(ControlLightingHandler handler) {
        List<HouseSection> sections = getHouseSections();
        for (HouseSection hs : sections) {
            handler.turnOnOffLighting(hs, LightStatus.ON);
        }

    }

    public static void addRandomUserLightControlSelections(
            ControlLightingHandler handler, int needToSelect) {
        List<HouseSection> sections = getHouseSections();
        int noOfAvailableSections = sections.size();

        // if user want more than the available sections then select them all
        if (needToSelect >= noOfAvailableSections) {
            addUserLightControlSelections(handler);
        } else {
            // randomly select HouseSections equal to needToSelect parameter
            Random rnd = new Random();
            for (int i = 0; i < needToSelect; i++) {
                int index = rnd.nextInt(noOfAvailableSections);
            }
        }
        for (HouseSection hs : sections) {
            handler.turnOnOffLighting(hs, LightStatus.ON);
        }

    }
}

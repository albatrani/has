import java.util.ArrayList;
import java.util.List;

public class TestingUtilities {

    public final static String[] SECTIONS_NAMES = {
            "Front Door", "Living Room", "Master Bedroom", "Master Bedroom Bath",
            "Master Bedroom Closet", "Kitchen", "Stairway", "Upstair Looby",
            "Kids Bedroom", "Guest Bedroom", "Guest Bathroom"
    };
    public final static boolean[] SECTIONS_IN_HOUSE_FLAGS = {
            false, true, true, true, true, true, true, true, true, true, true,
    };

    public static House getSampleHouse() {
        House house = new House(new Resident("Said", "abc"), "My Address");
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
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    private final static String[] WINDOW_SENSORS_NAMES = {
            "Living Room Window", "Master Bedroom Window", "Kids Bedroom Window",
            "Guest Bedroom Window"
    };

    private final static String[] EXTERNAL_DOOR_NAMES = {
            "Main Front Door", "House Back Door"
    };

    public static House getSampleHouse() {
        House house =
                new House(new Resident("Team 4", "password"),
                        "115 Turpial Way, Melbourne, FL 32901");

        List<HouseSection> sections = getHouseSections();
        for (HouseSection houseSection : sections) {
            house.addHouseSection(houseSection);
        }

        List<WindowSensor> windowSensors = getWindowSensors();
        for (WindowSensor windowSensor : windowSensors) {
            house.addWindowSensor(windowSensor);
        }

        List<DoorSensor> doorSensors = getDoorSensors();
        for (DoorSensor doorSensor : doorSensors) {
            house.addDoorSensor(doorSensor);
        }

        List<DoorLock> doorLocks = getDoorLocks();
        for (DoorLock doorLock : doorLocks) {
            house.addDoorLock(doorLock);
        }

        return house;
    }

    public static List<HouseSection> getHouseSections() {
        List<HouseSection> list = new ArrayList<>();
        for (int i = 0; i < SECTIONS_NAMES.length; i++) {
            HouseSection hs =
                    new HouseSection(SECTIONS_NAMES[i], SECTIONS_IN_HOUSE_FLAGS[i]);
            list.add(hs);
        }
        return list;
    }

    public static List<WindowSensor> getWindowSensors() {
        List<WindowSensor> list = new ArrayList<>();
        for (int i = 0; i < WINDOW_SENSORS_NAMES.length; i++) {
            WindowSensor sensor =
                    new WindowSensor(TestingUtilities.WINDOW_SENSORS_NAMES[i]);
            list.add(sensor);
        }
        return list;
    }

    public static List<DoorSensor> getDoorSensors() {
        List<DoorSensor> list = new ArrayList<>();
        for (int i = 0; i < EXTERNAL_DOOR_NAMES.length; i++) {
            DoorSensor sensor = new DoorSensor(EXTERNAL_DOOR_NAMES[i]);
            list.add(sensor);
        }
        return list;
    }

    public static List<DoorLock> getDoorLocks() {
        List<DoorLock> list = new ArrayList<>();
        for (int i = 0; i < EXTERNAL_DOOR_NAMES.length; i++) {
            DoorLock doorLock = new DoorLock(EXTERNAL_DOOR_NAMES[i]);
            list.add(doorLock);
        }
        return list;
    }

    public static void addUserLightControlSelections(House house,
            ControlLightingHandler handler, LightStatus action) {
        Map<String, HouseSection> sections = house.getSections();
        for (String key : sections.keySet()) {
            handler.turnOnOffLighting(sections.get(key), action);
        }
    }

    public static void addRandomUserLightControlSelections(House house,
            ControlLightingHandler handler, LightStatus action, int needToSelect) {
        HouseSection[] sections =
                house.getSections().values().toArray(new HouseSection[0]);
        int noOfAvailableSections = sections.length;

        // if user want more than the available sections then select them all
        if (needToSelect >= noOfAvailableSections) {
            addUserLightControlSelections(house, handler, action);
        } else {
            // randomly select HouseSections equal to needToSelect parameter
            Random rnd = new Random();
            for (int i = 0; i < needToSelect; i++) {
                int index = rnd.nextInt(noOfAvailableSections);
                while (!handler.turnOnOffLighting(sections[index], action)) {
                    index = rnd.nextInt(noOfAvailableSections);
                }
            }
        }
    }
}

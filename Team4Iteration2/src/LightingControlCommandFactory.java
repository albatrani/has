/*
 * Factory methods to create light control commands 
 */
public class LightingControlCommandFactory {

    public static LightingControlCommand create(HouseSection hs, LightStatus action) {
        switch (action) {
        case OFF:
            return new SwitchOffLightCommand(hs);
        case ON:
            return new SwitchOnLightCommand(hs);
        default:
            return null;
        }
    }

}

/*
 * The Controller class which will be coordinating the User Interface (UI) actions 
 * with the domain classes to perform control lighting transactions. 
 */
public class ControlLightingHandler {

    House house;
    LightingControlTransaction lct;

    /*
     * Constructs the object with referencing to the house object
     */
    public ControlLightingHandler(House house) {
        this.house = house;
        lct = new LightingControlTransaction();
    }

    /*
     * Searches for a house section by name
     */
    public HouseSection selectHousesection(String name) {
        // 1st validate user input
        if (name == null) {
            throw new IllegalArgumentException("The name supplied is undefined!");
        }
        return house.getHouseSection(name);
    }

    /*
     * Passes the user’s light control action to the transaction object
     */
    public boolean turnOnOffLighting(HouseSection hs, LightStatus action) {
        // 1st validate all user inputs
        if (hs == null) {
            throw new IllegalArgumentException("The HouseSection supplied is undefined!");
        }
        if (action == null) {
            throw new IllegalArgumentException("The light action supplied is undefined!");
        }

        // try to add the user's selection where duplicate house section is not allowed
        try {
            lct.addLightControlAction(hs, action);
        } catch (Exception e) {
            return false; // duplicates found
        }
        return true;
    }

    /*
     * Indicates that user has ended house sections picking and ready to apply the
     * transaction.
     */
    public TransactionStatus endControlLighting() {
        TransactionStatus status = lct.process();
        house.logTransaction(lct, TransactionType.CONTROL_LIGHTING, status);
        return status;
    }

    public House getHouse() {
        return this.house;
    }

    public LightingControlTransaction getLightingControlTransaction() {
        return this.lct;
    }
}

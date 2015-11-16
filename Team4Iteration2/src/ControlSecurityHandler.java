/*
 * The Controller class which will be coordinating the User Interface (UI) actions 
 * with the domain classes to perform control security transactions. 
 */
public class ControlSecurityHandler {

    House house;
    SecurityControlTransaction sct;

    /*
     * Constructs the object with referencing to the house object
     */
    public ControlSecurityHandler(House house) {
        this.house = house;
        sct = new SecurityControlTransaction();
    }

  public Sensor selectSensor(SensorType type, String name){
	  if (type == SensorType.WINDOW)
	  {
		  Window window = house.getWindow(name);
		  return window.getWindowSensor();
		  
	  }
	  else
	  {
		  Door door = house.getDoor(name);
		  return door.getDoorSensor();
		  
	  }
	  
  }

    /*
     * Passes the user�s security control action to the transaction object
     */
    public boolean enableDisableSensor(Sensor sensor, SensorStatus action) {
        // 1st validate all user inputs
        if (sensor == null) {
            throw new IllegalArgumentException("The sensor supplied is undefined!");
        }
        if (action == null) {
            throw new IllegalArgumentException("The security action supplied is undefined!");
        }

        // try to add the user's selection where duplicate house section is not allowed
        try {
            sct.addSecurityControlAction(sensor, action);
        } catch (Exception e) {
            return false; // duplicates found
        }
        return true;
    }

    
    public TransactionStatus endControlSecurity() {
        TransactionStatus status = sct.complete();
        house.logTransaction(sct, status);
        return status;
    }

    public SecurityControlTransaction getsct() {
        return this.sct;
    }
}

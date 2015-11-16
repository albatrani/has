
public class SecurityControlTransaction implements ITransaction {

	@Override
	public TransactionStatus process() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addSecurityControlAction(Sensor sensor, SensorStatus action) {
		SecurityControlSensorCommand sca = SecurityControlSensorCommandFactory .create(sensor, action);

	        // check that the house section to be added is unique (no duplicates allowed)
	        if (lcas.contains(lca)) {
	            throw new IllegalArgumentException(
	                    "The HouseSection supplied is already selected!");
	        } else {
	            // otherwise it's safe to added it
	            lcas.add(lca);
	        }
	}

	public TransactionStatus complete() {
		// TODO Auto-generated method stub
		return null;
	}

}

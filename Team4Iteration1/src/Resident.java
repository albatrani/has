
public class Resident {
// get and set
	private String name;
	private String password;
	public Resident(String name, String password) {
		this.name = name;
		this.password = password;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

/*
 * Basic Customer information who will be given access to the system. 
 */
public class Resident {

    private String name;
    private String password;

    public Resident(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

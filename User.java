import java.io.Serializable;

abstract class User implements Serializable{
	
// this user class has basic traits such as username, password, first and last name. Admin and student inherits from this class and uses these members through getters and setters.
    /**
	 * 
	 */
// all username, password, and names are private members
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
// below are constructors for User class
	
	public User() {
	    }

    public User(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}

    public User(String username, String password, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.first_name = last_name;
        this.last_name = last_name;
    }

   

// below contains setters and getters for each member of the User class
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	

}

package Task1;

public class Name {
	private String firstname;
	private String middlename;
	private String lastname;
	public Name(String firstname,String middlename,String lastname) {
		this.firstname=firstname;
		//Check if middlename is null or empty after removing leading and trailing whitespaces
		this.middlename = middlename != null && !middlename.trim().isEmpty() ? middlename : null;
		this.lastname=lastname;
	}
	public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    public String getMiddleName() {
    	return middlename;
    }
    
    public void setMiddleName(String middleName) {
    	this.middlename = middleName;
    }
    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    public String getInitials() {
        String initials = Character.toString(firstname.charAt(0)) + Character.toString(lastname.charAt(0));
        if (middlename != null && !middlename.isEmpty()) {
            initials =Character.toString(firstname.charAt(0)) + Character.toString(middlename.charAt(0))+Character.toString(lastname.charAt(0));
        }
        return initials;
    }

    @Override
    public String toString() {
        if (middlename != null && !middlename.isEmpty()) {
            return firstname + " " + middlename + " " + lastname;
        } else {
            return firstname + " " + lastname;
        }
    }
}

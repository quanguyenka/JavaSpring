package itsol.object;

public class GiaoVien {
	private String acount, firstName,lastName,email;
	
	public GiaoVien() {
    }

    public GiaoVien(String acount, String firstName, String lastName, String email) {
        this.acount = acount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "GiaoVien{" + "acount=" + acount + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }
    
}

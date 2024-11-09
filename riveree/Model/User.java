package riveree.Model;

public class User {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String name, String address, String phoneNumber, String email, String password) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String text) {
    }

    public void setEmail(String text) {
    }

    public void setPhoneNumber(String text) {
    }

    public void setPassword(String text) {
    }
}

package euronics.model;

import org.apache.commons.lang3.RandomStringUtils;

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Client(boolean isRandom) {
        if (isRandom) {
            firstName = RandomStringUtils.randomAlphabetic(10);
            lastName = RandomStringUtils.randomAlphabetic(10);
            email = RandomStringUtils.randomAlphabetic(4) + "@gmail.com";
            phone = "2" + RandomStringUtils.randomNumeric(7);
        }
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

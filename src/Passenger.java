import java.util.ArrayList;
import java.util.List;

public class Passenger {
    public static List<Passenger> passengerList = new ArrayList<>(List.of(
            new Passenger("John Smith", 30, "Male", "john.smith@example.com", "+1 123-456-7890"),
            new Passenger("Jane Doe", 25, "Female", "jane.doe@example.com", "+44 9876543210"),
            new Passenger("Michael Johnson", 45, "Male", "michael.johnson@example.com", "+81 876543210")));

    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String contactNumber;

    public Passenger() {
    }

    public Passenger(String name, Integer age, String gender, String email, String contactNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

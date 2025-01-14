package Data_Faker;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
    Locale localeEn = new Locale("en");
    Faker faker = new Faker(localeEn);

    public static DataHelper getData() {
        return new DataHelper();
    }

    public String getFirstName() {
        // Generating the first name
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        // Generating last name
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCompany() {
        return faker.company().name();
    }

    public String getEmail() {
        // Generating email Id
        String emailId = faker.internet().emailAddress();
        return emailId;
    }

    public String getPassword() {
        // Generating password
        String pwd = faker.internet().password();
        return pwd;
    }

    public String getCountry() {
        // Generating password
        return faker.country().name();
    }

    public String getCity() {
        return faker.address().city();
    }
}

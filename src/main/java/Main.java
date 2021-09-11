import helpers.PhoneBook;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook("src/phonebook.csv");
        try {
            phoneBook.init(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

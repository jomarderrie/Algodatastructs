import helpers.Address;
import helpers.Person;
import helpers.PhoneBook;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

    }

    public void runSearch(){
        PhoneBook phoneBook = new PhoneBook("src/phonebook.csv");
        try {
            phoneBook.init(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phoneBook.addPersonAtIndex(new Person("Nathan", "Ganesh", new Address("3564xs", "bangesdreef", "24", "Utrecht", "utrecht", "123987127389")), 50);


//        phoneBook.linearSearch("Nathan");
//        phoneBook.findPersonWithBinarySearch("Nathan");
        phoneBook.findPersonWithHousePriceBinarySearch("123987127389");
    }

    public void runSorting(){
        PhoneBook phoneBook = new PhoneBook("src/phonebook.csv");
        try {
            phoneBook.init(100);
        } catch (IOException e) {
            e.printStackTrace();
        }

        phoneBook.addPersonAtIndex(new Person("Nathan", "Ganesh", new Address("3564xs", "bangesdreef", "24", "Utrecht", "utrecht", "123987127389")), 50);


        phoneBook.selectionSort();
    }
}

import helpers.*;

import java.io.IOException;

import static helpers.SortingTypes.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        new Main().runSearch();
        main.runSorting();
    }

    public void runSearch() {
        PhoneBook phoneBook = new PhoneBook("src/phonebook.csv");
        try {
            phoneBook.init(1000000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phoneBook.addPersonAtIndex(new Person("Nathan", "Ganesh", new Address("3564xs", "bangesdreef", "24", "Utrecht", "utrecht", "123987127389")), 2000);

        for (SearchTypes value : SearchTypes.values()) {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                search(value, phoneBook, "Nathan");
            }
            long duration = (System.currentTimeMillis() - startTime) / 10;
            System.out.println(value + " took " + duration);
        }
    }

    public void runSorting() {
        PhoneBook phoneBook = new PhoneBook("src/phonebook.csv");
        try {
            phoneBook.init(100);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        phoneBook.addPersonAtIndex(new Person("Nathan", "Ganesh", new Address("3564xs", "bangesdreef", "24", "Utrecht", "utrecht", "123987127389")), 50);
//        phoneBook.isSorted();
//        phoneBook.selectionSort();
//        phoneBook.insertionSort();


//        for (SortingTypes value : values()) {
//            long startTime = System.currentTimeMillis();
//            for (int i1 = 0; i1 < 10; i1++) {
//                sort(value, phoneBook);
//                assert (phoneBook.isSorted()) : "List is not sorted!";
//            }
//            long duration = (System.currentTimeMillis() - startTime) / 10;
//            System.out.println(value + " took " + duration);
//        }
    }

    private void sort(SortingTypes sortingMethod, PhoneBook phoneBook) {
        // Change this to change the method of sorting
        // You can add more sorting algorithms here
        switch (sortingMethod) {
            case SELECTION_SORT:
                phoneBook.selectionSort();
                break;
            case INSERTION_SORT:
                phoneBook.insertionSort();
                break;
            case MERGE_SORT:
                phoneBook.mergeSort();
                break;
            case QUICK_SORT:
                phoneBook.quickSort();
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    private void search(SearchTypes searchTypes, PhoneBook phoneBook, String nameToSearch) {
        switch (searchTypes) {
            case BINARY_SEARCH:
                phoneBook.findPersonWithBinarySearch(nameToSearch);
                break;
            case LINEAR_SEARCH:
                phoneBook.linearSearch(nameToSearch);
                break;
            case RECURSIVE_BINARY_SEARCH:
                phoneBook.findPersonWithBinarySearchRecursive(nameToSearch);
                break;
            default:
                System.out.println("Error");
                break;
        }

    }
}

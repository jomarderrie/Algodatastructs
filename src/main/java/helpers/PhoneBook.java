package helpers;

import java.io.*;
import java.util.*;

public class PhoneBook extends AbstractPhoneBook {

    public PhoneBook(String phonebookLocationFile) {
        super(phonebookLocationFile);
    }

    @Override
    public Person linearSearch(String name) {
        for (int i = 0; i < super.persons.size(); i++) {
            if (super.persons.get(i).getVoornaam().equals(name)) {
                return persons.get(i);
            }
        }
        return null;
    }

    @Override
    public Person findPersonWithBinarySearch(String name) {
        //binair zoeken verwacht gesorteerde lijst
        Collections.sort(super.persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getVoornaam().compareTo(o2.getVoornaam());
            }
        });

        int mid = persons.size() % 2 == 0 ? persons.size() : persons.size() - 1;
//        int mid = 0;
        int links = 0;
        int rechts = persons.size() - 1;

        while ((!persons.get(mid).getVoornaam().equals(name)) && links < rechts) {
            if (persons.get(mid).getVoornaam().compareTo(name) < 0) {
                links = mid + 1;
            } else if (persons.get(mid).getVoornaam().compareTo(name) > 0) {
                rechts = mid - 1;
            } else {
                break;
            }
            mid = (links + rechts) / 2;
        }
        if (persons.get(mid).getVoornaam().equals(name)) {
            return persons.get(mid);
        } else {
            return null;
        }
    }

    @Override
    public Person findPersonWithHousePriceBinarySearch(String housePrice) {
        int links = 0;
        int rechts = persons.size() - 1;
        int mid = persons.size() % 2 == 0 ? persons.size() / 2 : persons.size() / 2 - 1;

        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Long.compare(Long.parseLong(o1.getAddress().getHuisPrijs()), Long.parseLong(o2.getAddress().getHuisPrijs()));
            }
        });
        while ((!persons.get(mid).getAddress().getHuisPrijs().equals((housePrice))) && links < rechts) {
            if (Long.parseLong(persons.get(mid).getAddress().getHuisPrijs()) > Long.parseLong(housePrice)) {
                rechts = mid - 1;
            } else if (Long.parseLong(persons.get(mid).getAddress().getHuisPrijs()) < Long.parseLong(housePrice)) {
                links = mid + 1;
            }
            mid = (rechts + links) / 2;
        }
        if (persons.get(mid).getAddress().getHuisPrijs().equals(housePrice)) {
            return persons.get(mid);
        } else {
            return null;
        }
    }

    @Override
    public Person findPersonWithBinarySearchRecursive(String name) {
        System.out.println("Still needs to implemented");
        return null;
    }

    @Override
    public void selectionSort() {
//        Collections.sort(super.persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getVoornaam().compareTo(o2.getVoornaam());
//            }
//        });
//        for (int i = 1; i < persons.size(); i++) {
//            int j = i;
//            while (j != 0) {
//                if (persons.get(i).getVoornaam().compareTo(persons.get(j-1).getVoornaam()) < 0) {
//                    Person temp = persons.get(j);
//                    persons.set(j, persons.get(i));
//                    persons.set(i, temp);
//                }
//                j--;
//            }
//        }
        int index = 1;
        while (index<persons.size()){
            for (int i = index; i >0; i--) {
                if (persons.get(i).getVoornaam().compareTo(persons.get(i-1).getVoornaam()) < 0){
                    Person temp = persons.get(i-1);
                    persons.set(i-1, persons.get(i));
                    persons.set(i, temp);
                }
            }
            index++;
        }
        System.out.println(persons);
    }

    @Override
    public void insertionSort() {

    }

    @Override
    public void mergeSort() {

    }

    @Override
    public void quickSort() {

    }

    @Override
    public boolean isSorted() {
        for (int i = 1; i < persons.size(); i++) {
            if (persons.get(i).getVoornaam().compareTo(persons.get(i - 1).getVoornaam()) < 0) {
                return false;
            }
        }
        return true;
    }


}

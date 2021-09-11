package helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@NoArgsConstructor
public abstract class AbstractPhoneBook {
    protected List<Person> persons;
    private String phonebookLocationFile;

    public AbstractPhoneBook(String phonebookLocationFile) {
        this.phonebookLocationFile = phonebookLocationFile;
    }

    public void init(int amountOfPeople) throws IOException {
        persons= new ArrayList<>(amountOfPeople);
        try {
            File file = new File(getPhonebookLocationFile());
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            int count = 1;
            while ((line = br.readLine())!= null && count < amountOfPeople) {
                tempArr = line.split(";");
                Address address = new Address(tempArr[2], tempArr[3], tempArr[4], tempArr[5], tempArr[6], tempArr[7]);
                Person person = new Person(tempArr[0], tempArr[1], address);
                count++;
                persons.add(person);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void addPersonAtIndex(Person person,int index){
        persons.add(index, person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public abstract Person linearSearch(String name);

    public abstract Person findPersonWithBinarySearch(String name);

    public abstract Person findPersonWithHousePriceBinarySearch(String housePrice);

    public abstract Person findPersonWithBinarySearchRecursive(String name);

    public abstract void selectionSort();

    public abstract void insertionSort();

    public abstract void mergeSort();

    public abstract void quickSort();



}

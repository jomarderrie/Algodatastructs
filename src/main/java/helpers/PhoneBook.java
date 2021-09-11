package helpers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneBook {
    private String phonebookLocationFile;

    public PhoneBook(String phonebookLocationFile) {
        this.phonebookLocationFile = phonebookLocationFile;
    }

    public void init(int amountOfPeople) throws IOException {
        try {
            File file = new File(getPhonebookLocationFile());
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            int count = 0;
            while ((line = br.readLine())!= null && count < amountOfPeople) {
                tempArr = line.split(";");

                count++;
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public String getPhonebookLocationFile() {
        return phonebookLocationFile;
    }
}

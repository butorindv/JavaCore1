import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, List<String>> mapPhoneBook = new HashMap<>();
    private List<String> phoneNumbers;

    public HashMap<String, List<String>> getMapPhoneBook() {
        return mapPhoneBook;
    }

    public List<String> get(String lastName) {
        return mapPhoneBook.get(lastName);
    }

    public void add(String lastName, String phoneNumber) {
        if (!mapPhoneBook.containsKey(lastName)) {
            phoneNumbers = new ArrayList<>();
        } else {
            phoneNumbers = mapPhoneBook.get(lastName);
        }
        phoneNumbers.add(phoneNumber);
        mapPhoneBook.put(lastName, phoneNumbers);
    }


}

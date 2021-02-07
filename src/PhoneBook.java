import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> mapPhoneBook = new HashMap<>();
    private List<String> phoneNumbers;

    public HashMap<String, List<String>> get() {
        return mapPhoneBook;
    }

    public HashMap<String, List<String>> get(String lastName) {
        HashMap<String, List<String>> temp = new HashMap<>();
        for (Map.Entry<String, List<String>> listEntry : mapPhoneBook.entrySet()) {
            if(listEntry.getKey().equals(lastName)) {
                temp.put(listEntry.getKey(),listEntry.getValue());
            }
        }
        return temp;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> pbMap = new HashMap<>();

    void add(String name, String phoneNumber) {
        if (pbMap.containsKey(name)) {
            pbMap.get(name).add(phoneNumber);

        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            pbMap.put(name, phoneList);
        }
    }

    void showPhoneNumbers(String name) {
        if (pbMap.containsKey(name)) {
            System.out.printf("%s: %s%n", name, pbMap.get(name).toString());
        }
    }
    void showAll(){
        for (Map.Entry<String,List<String>> entry : pbMap.entrySet()) {
            System.out.println(entry);
        }
    }
}

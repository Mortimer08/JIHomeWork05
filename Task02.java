import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Пусть дан список сотрудников:
Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
*/
public class Task02 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> namesList = new ArrayList<String>();

        namesList = getNamesList();

        TreeMap<Integer, List<String>> namesTree = new TreeMap<>(Collections.reverseOrder());
        namesToTree(namesTree, namesList);
        System.out.println(namesTree);

    }

    public static ArrayList<String> getNamesList() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        FileReader fr = new FileReader("names.txt");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        br.close();
        String[] fullNames = s.split(",");
        for (String fullName : fullNames) {
            list.add(fullName.strip().split(" ")[0].strip());
        }
        return list;

    }

    public static void namesToTree(TreeMap<Integer, List<String>> treeMap, ArrayList<String> namesList) {
        Map<String, Integer> namesCount = new HashMap<String, Integer>();

        for (String name : namesList) {
            if (namesCount.containsKey(name)) {
                namesCount.put(name, namesCount.get(name) + 1);
            } else {
                namesCount.put(name, 1);
            }

        }
        for (Map.Entry<String, Integer> entry : namesCount.entrySet()) {
            if (treeMap.containsKey(entry.getValue())) {
                treeMap.get(entry.getValue()).add(entry.getKey());
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(entry.getKey());
                treeMap.put(entry.getValue(), tempList);
            }
        }

    }
}

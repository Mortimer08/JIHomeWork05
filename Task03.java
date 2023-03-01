import java.util.ArrayList;
import java.util.Random;

/*
 * *Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */
public class Task03 {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        arrayListRndFill(myArrayList, 30);
        MyHeapSorter mhs = new MyHeapSorter();
        System.out.println("Исходный массив:");
        System.out.println(myArrayList.toString());
        mhs.MyHeapSort(myArrayList);
        System.out.println("Отсортированный массив:");
        System.out.println(myArrayList.toString());
    }
    public static void arrayListRndFill(ArrayList<Integer> myList, int size) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            myList.add(rnd.nextInt(50));
        }
    }
}

import java.util.ArrayList;

public class MyHeapSorter {
    void MyHeapSort(ArrayList<Integer> array) {
        Integer lowEnd = array.size();  // нижняя граница, до которой проводятся действия по выстраиванию кучи
        fullHeapBuild(lowEnd-1, array); // формирование кучи из массива
        while (lowEnd > 2) {            // сортировка кучей
            Integer temp = array.get(lowEnd - 1);   //  - перестановка корневого (максимального) элемента в конец массива
            array.set(lowEnd - 1, array.get(0));    //  перестановка последнего элемента неотсортированной части массива в корень
            array.set(0, temp);
            fullHeapBuild(--lowEnd, array);         // формирование кучи - извлечение максимального элемента в корень
        }
        Integer temp = array.get(lowEnd - 1);       // последние два элемента просто меняются местами
        array.set(lowEnd - 1, array.get(0));
        array.set(0, temp);
    }

    void fullHeapBuild(Integer lowEnd, ArrayList<Integer> array) {
        Integer index = lowEnd / 2 - 1; // последний родительский элемент элемент кучи
        while (index >= 0) {
            heapBuild(index--, lowEnd, array);  // постройка кучи выше index (для формирования полной кучи нужно пройти от последнего родителя до корня)
        }
    }

    private void heapBuild(Integer index, Integer lowEnd, ArrayList<Integer> array) { // постройка "элементарной" кучи из трёх элементов
        Integer maxParentIndex = lowEnd / 2 - 1;
        if (array.get(index) < array.get(getLeftChildIndex(index, array))) {   // смена местами родителя и левого потомка
            Integer temp = array.get(index);
            array.set(index, array.get(getLeftChildIndex(index, array)));
            array.set(getLeftChildIndex(index, array), temp);
            if (getLeftChildIndex(index, array) <= maxParentIndex) {            // если смена произошла, нужно рекурсивно перестроить кучу вниз
                heapBuild(getLeftChildIndex(index, array), lowEnd, array);
            }
        }
        if (lowEnd > getRightChildIndex(index, array)) {                            // правого потомка может не быть
            if (array.get(index) < array.get(getRightChildIndex(index, array))) { // смена местами родителя и правого потомка
                Integer temp = array.get(index);
                array.set(index, array.get(getRightChildIndex(index, array)));
                array.set(getRightChildIndex(index, array), temp);
                if (getRightChildIndex(index, array) <= maxParentIndex) {       // если смена произошла, нужно рекурсивно перестроить кучу вниз
                    heapBuild(getRightChildIndex(index, array), lowEnd, array);
                }
            }
        }

    }

    private Integer getLeftChildIndex(Integer parentIndex, ArrayList<Integer> array) {
        Integer result = null;
        if (array.size() > parentIndex * 2 + 1) {
            result = parentIndex * 2 + 1;
        }
        return result;
    }

    private Integer getRightChildIndex(Integer parentIndex, ArrayList<Integer> array) {
        Integer result = null;
        if (array.size() > parentIndex * 2 + 2) {
            result = parentIndex * 2 + 2;
        }
        return result;
    }
}
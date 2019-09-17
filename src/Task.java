import java.util.Arrays;

/**
 *Finding the minimum element in an array
 */

//public class Task{
//    public static void main(String[] args) {
//        int[] arr = new int[] {64, 42, 73, 41, 31, 53, 16, 24, 57, 42, 74, 55, 36};
//
//        int minValue = arr[0];
//        int minIndex = 0;
//
//        for (int i = 1; i < arr.length; i++){
//            if(arr[i] < minValue){
//                minValue = arr[i];
//                minIndex = i;
//            }
//        }
//
//        System.out.println("min value: " + minValue);
//        System.out.println("min index: " + minIndex);
//    }
//}

/**
 * Linear Search ищет элемент в заданном массиве, пока не достигнет конца массива. При нахождении элемента возвращается
 * его позиция в массиве. Если элемент не найден, возвращаем -1. Время работы очень сильно зависит от размера массива.
 * На установление отсутствия элемента в массиве необходимо пройти N итераций (кол-во эл-тов массива). Не следует исп-ть
 * на больших массивах. Сложность O(n).
 */

//public class Task {
//
//    public static void main(String[] args) {
//        int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
//        System.out.println(Arrays.toString(array));
//
//        System.out.println(searchLinear(array, 10));
//    }
//
//    public static int searchLinear(int[] array, int elementToFind) {
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("searhing at index: " + i + ", value: " + array[i]);
//            if (array[i] == elementToFind) {
//                System.out.println("found at index: " + i + ", value: " + array[i]);
//                return i;
//            }
//        }
//        System.out.println("not found: " + elementToFind);
//        return -1;
//    }
//}

/**
 * Binary Searching ОБЯЗАТЕЛЬНОЕ УСЛОВИЕ: массив предварительно должен быть отсортирован. Берем средний эл-т отсорт-го
 * массива и сравниваем его с искомым. Если тот больше среднего эл-та, то дальше рассматриваем только правую половину
 * массива, меньше - только левую половину. Повторям алгоримт до результата. Максимальное кол-во шагов это log2(N), так
 * при 1024 элементах массива отсутствие эл-та будет найдено за 10 шагов. Сложность O(log2 n).
 */

public class Task {

    public static void main(String[] args) {
        int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(searchBinary(array, 36));
//        System.out.println(searchBinaryRecursive(array, 0,array.length - 1, 42));
    }

    public static int searchBinary(int[] array, int elementToFind) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = startIndex + (endIndex - startIndex) / 2;
            System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex + ", middleIndex: " + middleIndex);

            if (array[middleIndex] == elementToFind) {
                System.out.println("found " + elementToFind + " at " + middleIndex);
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }

//    public static int searchBinaryRecursive(int array[], int startIndex, int endIndex, int elementToFind) {
//        if (endIndex >= startIndex) {
//            int middleIndex = startIndex + (endIndex - startIndex) / 2;
//
//            if (array[middleIndex] == elementToFind) {
//                return middleIndex;
//            }
//
//            if (array[middleIndex] > elementToFind) {
//                return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
//            } else {
//                return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
//            }
//        }
//        return -1;
//    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
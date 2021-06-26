// Author: Bruno Waldvogel
// Java - Aula 3 - Exercício 2 -> Exercício 1

package Aula1TM;

import java.util.Arrays;

public class Exercicio6 {
    private static int makePartition(Integer[] array, int begin, int end, boolean decreasing) {
        int pivot = array[end];
        int i = begin - 1;
        
        if (decreasing) {
            for (int j = begin; j < end; j++) {
                if (array[j] >= pivot) {
                    i++;
                    int number = array[i];
                    array[i] = array[j];
                    array[j] = number;
                }
            }
        } else {
            for (int j = begin; j < end; j++) {
                if (array[j] <= pivot) {
                    i++;
                    int number = array[i];
                    array[i] = array[j];
                    array[j] = number;
                }
            }
        }
        
    
        int number = array[i + 1];
        array[i + 1] = array[end];
        array[end] = number;
    
        return i + 1;
    }

    private static void quickSort(Integer[] array, int begin, int end, boolean decreasing) {
        if (begin < end) {
            int partitionIndex = makePartition(array, begin, end, decreasing);
    
            quickSort(array, begin, partitionIndex-1, decreasing);
            quickSort(array, partitionIndex+1, end, decreasing);
        }
    }

    public static void main(String[] args) {
        Integer[] array = { 52, 10, 85, 1324, 01, 13, 62, 30, 12, 127 };

        // Exercise 1a
        quickSort(array, 0, array.length - 1, false);

        // Exercise 1b
        // quickSort(array, 0, array.length - 1, true);

        System.out.println(Arrays.toString(array));
    }
}

package utils;

import org.junit.jupiter.api.Assertions;

public class ArrayUtil {

    public static void assertAllEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length;i++) {
            Assertions.assertTrue(arr1[i] == arr2[i]);
        }
    }
}

package utils;

import org.junit.jupiter.api.Assertions;

public class ArrayAssertions {

    public static void assertEqual(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length;i++) {
            for (int j = 0; j < arr1[i].length;j++) {
                Assertions.assertEquals(arr1[i][j], arr2[i][j]);
            }
        }
    }
}

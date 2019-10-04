package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandom {

    /**
     * map for fast lookup
     * array for fast random access
     */
    private static class RandomizedSet {

        Map<Integer, Integer> map;
        int[] idxs;
        Random r;

        public RandomizedSet() {
            map = new HashMap<>();
            idxs = new int[20];
            r = new Random();
        }


        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            } else {
                int inIdx = map.size();
                idxs[inIdx] = val;
                map.put(val, inIdx);

                if (inIdx == idxs.length - 1) {
                    idxs = Arrays.copyOf(idxs, idxs.length * 2);
                }

                return true;
            }
        }

        /**
         * The element being removed should be swapped with the last element in the array
         * to keep elements contiguous
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int outIdx = map.get(val);
                int lastIdx = map.size() - 1;

                map.put(idxs[lastIdx], outIdx);
                idxs[outIdx] = idxs[lastIdx];

                map.remove(val);

                return true;
            } else {
                return false;
            }
        }

        /**
         * Assuming that r.next() is O(1)
         */
        public int getRandom() {
            return idxs[r.nextInt(map.size())];
        }
    }
}

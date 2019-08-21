package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/subdomain-visit-count/
public class SubdomainVisitCount {

    public static void main(String... args) {
        List<String> list = subdomainVisits(new String[]{"9001 discuss.leetcode.com"});

        System.out.println(list);
    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : cpdomains) {
            int idx = str.indexOf(" ");
            int count = Integer.parseInt(str.substring(0, idx));
            String domain = str.substring(idx + 1);

            put(map, domain, count);

            while((idx = domain.indexOf(".")) != -1) {
                domain = domain.substring(idx + 1);
                put(map, domain, count);
            }
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }

        return list;
    }

    private static void put(Map<String, Integer> map, String key, Integer val) {
        map.put(key, map.getOrDefault(key, 0) + val);
    }
}

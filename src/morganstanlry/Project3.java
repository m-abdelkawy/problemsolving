package morganstanlry;

import java.util.HashMap;
import java.util.Map;

public class Project3 {
    public static void main(String[] args) {
        String str = "bcabc";
        String str1 = "aaaaaa";
        String str2 = "";
        //"abc"

        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicates(str1));
        System.out.println(removeDuplicates(str2));
    }

    public static String removeDuplicates(String str){
        Map<Character, Integer> frequencyMap = new HashMap<>();

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry: frequencyMap.entrySet()) {
            sb.append(entry.getKey());
        }

        return sb.toString();
    }
}

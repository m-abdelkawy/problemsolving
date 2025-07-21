package com.problemsolving.citi;

import java.util.Hashtable;
import java.util.Map;

public class Solution {
    public static String reveresInWords(String str){

        String [] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static Map<String, Integer> countWords(String str){
        Map<String, Integer> map = new Hashtable<>();
        String [] arr = str.split(" ");
        for (int i = arr.length-1; i >= 0; i--) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        String str = "This This is is a a String";

        Map<String, Integer> count = countWords(str);

        for (Map.Entry<String, Integer> entry: count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

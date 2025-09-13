package com.problemsolving.w3global;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RegexTest {

    //Example: for the following input
    //Some items in the order cannot be shipped. ELEC-TV-239754, SA-Toas-65289 and m-Fil-25420.
    //the output should be ELEC-TV-239754; SA-Toas-65289; m-Fil-25420


    public static void main(String[] args) {
        String regex_pattern = "[a-zA-Z]+-[a-zA-Z]+-[0-9]+";
        Pattern p = Pattern.compile(regex_pattern);
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        List<String> tags = new ArrayList<>();
        Matcher m = p.matcher(inputStr);
        while(m.find()){
            String part1 = m.group();
            tags.add(part1.trim());
        }

        String output = tags.stream().collect(Collectors.joining("; "));
        System.out.println(output);

    }
}

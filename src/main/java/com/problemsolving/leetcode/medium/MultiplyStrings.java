package com.problemsolving.leetcode.medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // reverse numbers to multiply from right to left
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] arr = new int[n1.length() + n2.length()];

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                arr[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        // result in string builder
        StringBuilder sb = new StringBuilder();

        // consider all numbers in the array as units
        // so the unit part of each number will be in its correct position
        // carry the remaining part to the next position
        for (int i = 0; i < arr.length; i++) {
            int mod = arr[i] % 10; // the unit part- keep in place
            int carry = arr[i] /10; // carry the tens part to the next position
            if(i+1 < arr.length){
                arr[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        // remove zeros from the left
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);

        // Reverse both the numbers.
        firstNumber.reverse();
        secondNumber.reverse();

        // To store the multiplication result of each digit of secondNumber with firstNumber.
        int N = firstNumber.length() + secondNumber.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            answer.append(0);
        }

        for (int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';

            // For each digit in secondNumber multiply the digit by all digits in firstNumber.
            for (int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';

                // The number of zeros from multiplying to digits depends on the
                // place of digit2 in secondNumber and the place of the digit1 in firstNumber.
                int currentPos = place1 + place2;

                // The digit currently at position currentPos in the answer string
                // is carried over and summed with the current result.
                int carry = answer.charAt(currentPos) - '0';
                int multiplication = digit1 * digit2 + carry;

                // Set the ones place of the multiplication result.
                answer.setCharAt(currentPos, (char)(multiplication % 10 + '0'));

                // Carry the tens place of the multiplication result by
                // adding it to the next position in the answer array.
                int value = (answer.charAt(currentPos + 1) - '0') + multiplication / 10;
                answer.setCharAt(currentPos + 1, (char)(value + '0'));
            }
        }

        // Pop excess 0 from the rear of answer.
        if (answer.charAt(answer.length() - 1) == '0') {
            answer.deleteCharAt(answer.length() - 1);
        }

        answer.reverse();
        return answer.toString();
    }

    public String multiplyKaratsuba(String num1, String num2){
        // to do
        throw  new UnsupportedOperationException();
    }

    public String multiply3(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                res[i + j + 1] += digit1 * digit2;
            }
        }
        int carry = 0;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] += carry;
            int mod = res[i] % 10;
            carry = res[i] / 10;
            res[i] = mod;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            sb.append(res[i]);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "207";
        String num2 = "30";

        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}

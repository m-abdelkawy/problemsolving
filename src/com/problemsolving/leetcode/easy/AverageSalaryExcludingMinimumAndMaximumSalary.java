package com.problemsolving.leetcode.easy;

import java.util.Arrays;

/**
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 * Link: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 *
 * @author Mohammed Abdelkawy
 * @version 1.0.0
 * @since 18.05.2023
 */
public class AverageSalaryExcludingMinimumAndMaximumSalary {
    public double average1(int[] salary) {
        Arrays.sort(salary);
        int n = salary.length - 2;
        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / n;
    }

    public double average2(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;

        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        return (sum - min - max)/(salary.length - 2);
    }
}

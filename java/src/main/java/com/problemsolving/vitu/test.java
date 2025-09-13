package com.problemsolving.vitu;

import java.time.LocalDate;
import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;


class Subscription {
    public Subscription() {
    }

    public Subscription(int id, int customerId, int monthlyPriceInDollars) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    public int id;
    public int customerId;
    public int monthlyPriceInDollars;
}

class User {
    public User() {
    }

    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    public int customerId;
}

class Challenge {
    public static double billFor(String month, Subscription activeSubscription, User[] users) {
        // your code here!
        String[] monthYear = month.split("-");
        int firstday = firstDayOfMonth(LocalDate.of(Integer.parseInt(monthYear[0]),
                Integer.parseInt(monthYear[1]), 1)).getDayOfMonth();
        int lastday = lastDayOfMonth(LocalDate.of(Integer.parseInt(monthYear[0]),
                Integer.parseInt(monthYear[1]), 1)).getDayOfMonth();

        int numberOfDays = lastday - firstday + 1;
        double dailyRate = activeSubscription != null ?
                (double) activeSubscription.monthlyPriceInDollars / numberOfDays : 0;

        double res = 0;
        for (int i = firstday; i <= lastday; i++) {
            int countActiveUsers = 0;
            for (int j = 0; j < users.length; j++) {

                LocalDate today = LocalDate.of(Integer.parseInt(monthYear[0]),
                        Integer.parseInt(monthYear[1]), i);


                if ((today.isEqual(users[j].activatedOn) || today.isAfter(users[j].activatedOn))) {
                    if (users[j].deactivatedOn == null || today.isBefore(users[j].deactivatedOn))
                        countActiveUsers++;
                }
            }
            res += (dailyRate * countActiveUsers);
        }

        return Math.round(res * 100.0) / 100.0;
    }

    /*******************
     * Helper functions *
     *******************/

    /**
     * Takes a LocalDate object and returns a LocalDate which is the first day
     * of that month. For example:
     * <p>
     * firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
     **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the last day
     * of that month. For example:
     * <p>
     * lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
     **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * Takes a LocalDate object and returns a LocalDate which is the next day.
     * For example:
     * <p>
     * nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
     * nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
     **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }

    public static void main(String[] args) {
        User[] userSignedUp = {
                new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
                new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1),
                new User(3, "Employee #3", LocalDate.of(2019, 01, 10), null, 1),
        };
        Subscription newPlan = new Subscription(1, 1, 4);

        System.out.println(Challenge.billFor("2019-01", newPlan, userSignedUp));
    }
}


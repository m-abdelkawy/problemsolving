package com.problemsolving.imc;

public class DoesAPathExist {
    public static String canReach(int c, int x1, int y1, int x2, int y2) {
        return canReachRecursive(c, x1, y1, x2, y2)? "Yes": "No";
    }

    public static boolean canReachRecursive(int c, int x1, int y1, int x2, int y2) {
        if(isPerfectSquare(x1 + y1))
            return false;

        if(x1 > x2 || y1 > y2)
            return false;

        if(x1 == x2 && y1 == y2)
            return true;

        return canReachRecursive(c, x1 + y1, y1, x2, y2)
                || canReachRecursive(c, x1, x1 + y1, x2, y2)
                || canReachRecursive(c, x1 + c, y1 + c, x2, y2);
    }

    private static boolean isPerfectSquare(double num){
        double sq = Math.sqrt(num);

        return (sq - Math.floor(sq)) == 0.0;
    }
}

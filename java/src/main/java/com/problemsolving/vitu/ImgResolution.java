package com.problemsolving.vitu;

public class ImgResolution {
    public static double[][] solution(int[][] img) {
        // i-1, j-1
        // i-1, j
        // i-1, j+1
        // i, j-1
        // i, j+1
        // i+1, j-1
        // i+1, j
        // i+1, j+1
        int row = img.length;
        int col = img[0].length;
        double[][] res = new double[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                int[] sumCount = sumCountNeighbours(img, i, j);

                res[i][j] = (double)sumCount[0]/(double)sumCount[1];
            }
        }
        return res;
    }

    public static int[] sumCountNeighbours(int[][] arr, int row, int col){
        int count = 0;
        int sum = 0;
        int[] sumCount = new int[2];

        int r = arr.length;
        int c = arr[0].length;

        for(int i = row - 1; i <= row+1; i++){
            for(int j = col - 1; j <= col + 1; j++){
                if((i >= 0 && i <= r-1) && j >= 0 && j <= c-1 && !(i==row && j==col)){
                    count++;
                    sum+=arr[i][j];
                }
            }
        }

        sumCount[0] = sum;
        sumCount[1]=count;
        return sumCount;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {7,6},
                {5,4}
        };

        System.out.println(solution(arr));
    }

}

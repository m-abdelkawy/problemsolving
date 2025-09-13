package com.problemsolving.leetcode.hard;

/**
 * 72. Edit Distance
 * Link: https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int row = word1.length()+1;
        int col = word2.length()+1;
        int[][] distance = new int[row][col];
        for(int i = 0; i < row; i++){
            distance[i][0] = i;
        }
        for(int j = 0; j < col; j++){
            distance[0][j] = j;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                int insertion = distance[i][j-1]+1;
                int deletion = distance[i-1][j]+1;
                int replacement = distance[i-1][j-1]+1;
                int match = distance[i-1][j-1];

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    distance[i][j] = match;
                }else{
                    distance[i][j]=Math.min(Math.min(insertion, deletion), replacement);
                }
            }
        }
        return distance[row-1][col-1];
    }
}

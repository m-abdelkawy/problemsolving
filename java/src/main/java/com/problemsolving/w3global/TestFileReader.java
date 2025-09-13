package com.problemsolving.w3global;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader("D:\\sample.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
    }
}


package com.problemsolving;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int getNumberOfMovies(String substr) throws IOException, InterruptedException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HttpClient httpClient  = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        List<String> lst = new ArrayList<>();
        return 1;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        //getNumberOfMovies("maze");

        double d = 10.0 / -0.0;
        if(d == Double.POSITIVE_INFINITY){
            System.out.println("Positive Infinity");
        }else{
            System.out.println("Negative Infinity");
        }
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String myurl="https://api.chucknorris.io/jokes/random";
        int responceCode=0;
        HttpURLConnection connection=null;
        URL url=null;
        try {
            url=new URL(myurl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


            try {
                connection= (HttpURLConnection) url.openConnection();
                responceCode = connection.getResponseCode();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        if(responceCode == 200){
            try {
                BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder apidata=new StringBuilder();
                String readLine=null;
                while((readLine=in.readLine())!=null){
                    apidata.append(readLine);
                }

                try {
                    in.close();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
                System.out.println(apidata.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("api call failed");
        }
    }
}
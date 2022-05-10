package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

class Task_5 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the first three digits of you bank acc. no.: ");
        String accountNumber = BR.readLine();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())))
        {

            String line;
            System.out.println("Reads data from a file");

            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\t+");

                String bankNumber = words[0].trim();
                String bankName = words[1].trim();
                if (bankNumber.equals(accountNumber)) {
                    System.out.println("Bank number:" + bankNumber + "Your bank name is:" + bankName);
                    break;
                }
            }

        }
        catch (IOException e)
        {
            System.out.println("Error in Data");
        }
    }
}
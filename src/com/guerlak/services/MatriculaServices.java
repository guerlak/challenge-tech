package com.guerlak.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaServices {

    private static String generateDigit(String mat) {
        int length = mat.length();
        int numArr[] = new int[length];

        for (int i = 0; i < length; i++) {
            //numArr[i] = Integer.parseInt(Integer.toString(mat).substring(i, i + 1));
            numArr[i] = Integer.parseInt(mat.substring(i, i + 1));
        }

        int sum = 0;
        int c = 5;

        for (int i = 0; i < length; i++) {
            int d = c - i;
            numArr[i] = numArr[i] * (d);
        }

        for (int i = 0; i < length; i++) {
            sum = sum + numArr[i];
        }

        int rest = sum % 16;
        return mat + "-" + Integer.toHexString(rest).toUpperCase();
    }

    private static List<String> generateListFromFile(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    path));
            String line = reader.readLine();
            while (line != null) {

                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void generateListComDVToFile(String pathIn, String pathOut){

        List<String> list = generateListFromFile(pathIn);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))){
            for (String el : list) {
                bw.write(generateDigit(el));
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void generateVerifiedListToFile(String pathIn, String pathOut){

        List<String> list = generateListFromFile(pathIn);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))){

            for (String el : list) {
                int length = el.length();
                String digitOld = el.substring(length -1 ,length);
                String digitNew = generateDigit(el.substring(0,length -2)).substring(length - 1,length);
                String word = "falso";
                if(digitOld.equals(digitNew)){
                    word = "verdadeiro";
                }
                //System.out.println(el + " " + word);
                word = el + " " + word;
                bw.write(word);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



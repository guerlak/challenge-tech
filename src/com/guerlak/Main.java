package com.guerlak;

import com.guerlak.services.MatriculaServices;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("----- 1 -----");

        MatriculaServices.generateListComDVToFile(
                "C:\\Workspace\\java\\TechGraph\\MatriculasSemDV.txt",
                "C:\\Workspace\\java\\TechGraph\\MatriculasComDV.txt");


        System.out.println("----- 2 -----");

        MatriculaServices.generateVerifiedListToFile(
                "C:\\Workspace\\java\\TechGraph\\MatriculasParaVerificar.txt",
                "C:\\Workspace\\java\\TechGraph\\MatriculasVerificadas.txt");

    }
}




package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        Simulator simulator = new Simulator();
        simulator.run();
    }

}

//        String writeFilePath = "test/membership/customers1.txt";
//        try (FileWriter fl = new FileWriter("logFile.txt", true);) {
//            fl.write(writeFilePath);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//
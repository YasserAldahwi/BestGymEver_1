package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Simulator {
    private final static String FILE = "C:\\Users\\yassi\\OneDrive\\Skrivbord\\customers.txt";

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your personal number, for exist enter 0 or q");
            String personalNumber = sc.next();
            if (personalNumber.equals("0") || personalNumber.equalsIgnoreCase("q")) {
                System.out.println("Good bye");
                System.exit(0);
            }
            if (personalNumber.length() == 10) {
                List<String> lines = Files.lines(Path.of(FILE)).collect(Collectors.toList());
                ClubMember member = getMemberIfExist(personalNumber, lines);
                if (member != null) {
                    logToFile(member);
                }

            } else {
                System.out.println("Wrong personal number format ");
            }
        }
    }


    private static void logToFile(ClubMember member) throws IOException {
//        FileWriter fl = new FileWriter("logFile.txt",true);
//        fl.write(input +" "+ LocalDate.now() + "\n");
//        fl.flush();
//        fl.close();

        try (FileWriter fl = new FileWriter("logFile.txt", true);) {
            fl.write(member.getPersonalNumber() + " " + member.getName() + " " + member.getSubscriptionDate() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can not write to fil");
        }
    }

    public static ClubMember getMemberIfExist(String personNumber, List<String> lines) throws IOException {
        for (int i = 0; i < lines.size(); i++) {
            boolean exist = lines.get(i).startsWith(personNumber);

            if (exist) {
                LocalDate date = LocalDate.parse(lines.get(i + 1));
                // String[] dateArray = lines.get(i + 1).split("-");
                //LocalDate date = LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
                System.out.println(date);
                boolean after = date.plusYears(1).isAfter(LocalDate.now());

                if (after) {
                    System.out.println("Welcome to the club!");

                    String[] pNrName = lines.get(i).split(",");
                    ClubMember member = new ClubMember(personNumber, pNrName[1].trim(), date);
                    return member;
                } else {
                    System.out.println("You membership is expired");
                }
                return null;
            }
        }
        System.out.println("You are not a member in the club");
        return null;
    }


}

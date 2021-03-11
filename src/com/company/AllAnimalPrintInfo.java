package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllAnimalPrintInfo {


    //χρηση του padRight για ομοιομορφη εκτυπωση
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    void getAnimalInfo(String s){
        try (
            BufferedReader bufferedReaderAnimalInfo = new BufferedReader(new FileReader("animalDataFile.txt"))) {
            String line ;
            String[] data;
            System.out.println("|    ID     |   Όνομα    | Ομοταξία  | Βάρος (kg) | Ηλικία (έτη)|"+"\n");
            while ((line = bufferedReaderAnimalInfo.readLine()) != null) {
                data=line.split(",");
                if(!data[0].isEmpty()){
                    //data αντισοιχηση καθε στηλης data[0] με animalid κ.ο.
                    String animalId = data[0]; String animalName= data[1]; String omotaxia = data[2];
                    String animalWeight = data[3]; String animalAge = data[4];
                    System.out.println(
                            "| "+padRight(animalId,10)+ //"n:10" με λιγα λογια ο χωρος που θα αφήσει για κενό
                            "| "+padRight(animalName,11)+
                            "| "+padRight(omotaxia,10)+
                            "| "+padRight(animalWeight,11)+
                            "| "+padRight(animalAge,12) + "|");
                }
            }
            System.out.print("\n");
        }catch (IOException e) {

            System.out.println("Error : file corrupted");
        }
    }
}

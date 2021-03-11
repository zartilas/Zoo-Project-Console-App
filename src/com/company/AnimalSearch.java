package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnimalSearch extends AllAnimalPrintInfo {

    //ελεγχος αν υπάρχει το  id του ζωου
    //παιρνει σαν ορισμα το animalid που δίνει ο χρήστης (βλεπε main) Και το ονομα του αρχειου
   boolean searchForCheckAnimalID(int animalId, String filename){
        try (BufferedReader animalFileBr = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] animalInfo;
            //ελεγχος για κενη γραμμη
            while ((line = animalFileBr.readLine()) != null) {
                animalInfo = line.split(",");
                //ψαχνουμε γραμμη γραμμη αν υπαρχει και το τυπωνουμε
                if (Integer.parseInt(animalInfo[0])==animalId) {
                    //επιστρεφει true αν υπάρχει
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }


    //αναζητηση βαση id
    //παιρνει σαν ορισμα το animalid που δίνει ο χρήστης (βλεπε main) Και το ονομα του αρχειου
    boolean searchForIDForPrintOfUser(String findId,String filename){
        try {
            boolean foundAnimalId =false;
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReaderAnimalInfo = new BufferedReader(fileReader);
            String line;
            String[] data = new String[0];
            while ((line = bufferedReaderAnimalInfo.readLine()) != null) {
                //χωριζουμε το "," για να μπορει να γινει η αναζητηση
                data = line.split(",");
                //αναζητηση data[0] πεδιου , οπου αντιστοιχει στο animalId
                if (data[0].equals(findId)) {
                    foundAnimalId = true;
                    break;
                }
            }
            fileReader.close();
            bufferedReaderAnimalInfo.close();
            //εκτυπωση αποτελεσμάτων στον χρηστη
            if (foundAnimalId){
                System.out.println("|    ID     |   Όνομα    | Ομοταξία  | Βάρος (kg) | Ηλικία (έτη)|"+"\n");
                System.out.println(
                        "| "+padRight(data[0],10)+
                        "| "+padRight(data[1],11)+
                        "| "+padRight(data[2],10)+
                        "| "+padRight(data[3],11)+
                        "| "+padRight(data[4],12)+" |"+"\n");
            }
            else {
                System.out.println("Λυπούμαστε δεν υπάρχει τέτοια εγγραφή."+"\n");
            }
        } catch (IOException e) {
            System.out.println("Error : file corrupted");
        }
        return false;
   }

   //αναζητηση βαση ονοματος
   //παιρνει σαν ορισμα το animalname που δίνει ο χρήστης (βλεπε main) Και το ονομα του αρχειου
    boolean searchForNameForPrintOfUser(String findIdName,String filename){
        try {
            boolean foundAnimalName =false;
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReaderAnimalInfo = new BufferedReader(fileReader);
            String line;
            String[] data = new String[0];
            while ((line = bufferedReaderAnimalInfo.readLine()) != null) {
                data = line.split(",");
                if (data[1].equals(findIdName)) {
                    foundAnimalName = true;
                    break;
                }
            }
            fileReader.close();
            bufferedReaderAnimalInfo.close();
            if (foundAnimalName){
                System.out.println("|    ID     |   Όνομα    | Ομοταξία  | Βάρος (kg) | Ηλικία (έτη)|"+"\n");
                System.out.println(
                        "| "+padRight(data[0],10)+
                                "| "+padRight(data[1],11)+
                                "| "+padRight(data[2],10)+
                                "| "+padRight(data[3],11)+
                                "| "+padRight(data[4],12)+" |"+"\n");
            }
            else {
                System.out.println("Λυπούμαστε δεν υπάρχει τέτοια εγγραφή."+"\n");
            }
        } catch (IOException e) {
            System.out.println("Error : file corrupted");
        }
        return false;
    }




}

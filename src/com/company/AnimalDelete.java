package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AnimalDelete {

    void deleteAnimalInfo(String setIdForDeleteAnimal,String filename) {
        try {
            //Δημιουργουμε ενα temporary αρχείο για να μπορέσουμε να βαλουμε μεσα τα στοιχεια που θα μείνουν
            FileReader fileAnimalReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileAnimalReader);
            FileWriter fileAnimalWriter = new FileWriter("TemporaryAnimalFile.tmp");
            BufferedWriter bufferedWriter = new BufferedWriter(fileAnimalWriter);
            String line;
            String[] data;
            //ελεγχος Id αν υπαρχει
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                if (!data[0].equals(setIdForDeleteAnimal)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            //κλεισιμο αρχειων
            bufferedReader.close();
            fileAnimalReader.close();
            bufferedWriter.close();
            fileAnimalWriter.close();
            Path to = Paths.get(filename);
            //μεταφορα στοιχειων στο παλιο αρχειο
            Path from = Paths.get("TemporaryAnimalFile.tmp");
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            File temporaryAnimalFile = new File("TemporaryAnimalFile.tmp");
            //διαγραφει temporary
            temporaryAnimalFile.delete();


        }
        catch (IOException e) {
            System.out.println("Error : file corrupted");
        }
    }
}

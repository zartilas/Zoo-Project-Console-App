package com.company;
import java.io.*;

public class AnimalSaveClass
{
//μεταφορα των μεραβλητων απο την main για αποθηκευση στο αρχειο animalDataFile
   public void saveAnimal(String MainAnimalID,String MainAnimalName,String MainOmotaxia,String MainAnimalWeight,String MainAnimalAge){
       //τοποθετηση ολων των στοιχειων σε ενα string
            String animalInfoSave = MainAnimalID+","+MainAnimalName+","+MainOmotaxia+","+MainAnimalWeight+","+MainAnimalAge+"\n";
            try {
                try {

                    FileWriter fileWriter = new FileWriter("animalDataFile.txt",true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    //"γραφουμε" το string στο txt αρχειο μας!
                    bufferedWriter.write(animalInfoSave);
                    bufferedWriter.close();
                    fileWriter.close();
                    System.out.println("Animal Save");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    System.out.println("Error : file corrupted");
                }
            } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Error : file corrupted");
            }
   }

}



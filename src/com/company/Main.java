package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
        //System.out.println("hi");
        Boolean repeat = true;
        AllAnimalPrintInfo printAll = new AllAnimalPrintInfo();
        AnimalSearch printInfo = new AnimalSearch();
        AnimalClass callClass = new AnimalClass();
    while (repeat)
        try {
            System.out.println("1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n2. Προσθήκη νέου ζώου\n3. Αναζήτηση ζώου βάσει ονόματος\n4. Αναζήτηση ζώου βάσει κωδικού\n5. Επεξεργασία ζώου βάσει κωδικού\n6. Διαγραφή ζώου βάσει κωδικού\n7. Έξοδος από την εφαρμογή");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:

                    printAll.getAnimalInfo("animalDataFile.txt");
                    break;
                case 2:
                    String MainAnimalID = callClass.UserSetAnimalID();
                    String MainAnimalName = callClass.UserSetAnimalName();
                    String MainOmotaxia = callClass.UserSetOmotaxia();
                    String MainAnimalWeight = callClass.UserSetAnimalWeight();
                    String MainAnimalAge = callClass.UserSetAnimalAge();
                    callClass.SaveAnimalInfo(MainAnimalID, MainAnimalName, MainOmotaxia, MainAnimalWeight, MainAnimalAge);
                    break;
                case 3:
                    System.out.println("Δώστε το Όναμα του ζώου για αναζήτηση:");
                    Scanner scName = new Scanner(System.in);
                    String findName = scName.nextLine();
                    printInfo.searchForNameForPrintOfUser(findName,"animalDataFile.txt");
                    break;
                case 4:
                    System.out.println("Δώστε το ID του ζώου για αναζήτηση:");
                    Scanner scId = new Scanner(System.in);
                    String findId = scId.nextLine();
                    printInfo.searchForIDForPrintOfUser(findId,"animalDataFile.txt");
                    break;
                case 5:
                   /* editAnimalInfo edit = new editAnimalInfo();
                    edit.editAnimal();*/
                    System.out.println("Συγγνώμη αλλά αυτή η λειτουργία δεν είναι διαθέσιμη ακόμα!"+"\n");
                    break;
                case 6:
                    AnimalDelete deleteAnimal = new AnimalDelete();
                    System.out.println("Δώστε το ID του ζώου που θέλετε να διαγραφεί:");

                    Scanner scIdDelete= new Scanner(System.in);
                    String IdDelete = scIdDelete.nextLine();
                    printInfo.searchForIDForPrintOfUser(IdDelete,"animalDataFile.txt");
                    deleteAnimal.deleteAnimalInfo(IdDelete,"animalDataFile.txt");
                    System.out.println("Tα διαθέσιμα ζώα τώρα είναι:"+"\n");
                    printAll.getAnimalInfo("animalDataFile.txt");

                    break;
                case 7:
                    System.out.println("Έξοδος από το πρόγραμμα! Καλή συνέχεια!");
                    System.exit(0);
                default:
                    System.out.println("Παρακαλώ επιλέξτε από τις επιλογές που σας δίνονται!");
            }
        } catch (Exception e) {
            System.out.println("Προσοχή! Επιλέξτε μόνο τους αριθμόυς αριθμούς 1 ή 2 ή 3 ή 4 ή 5 ή 6 ή 7!");
            System.out.println();

        }
    }
}

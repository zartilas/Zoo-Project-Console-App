package com.company;
import java.util.Scanner;

public class AnimalClass extends AnimalSaveClass
{

    //Εισαγωγή id του ζώου
    public String UserSetAnimalID()
    {
     int animalID=0;

        Scanner scanner = new Scanner(System.in);
        while (animalID <= 999 || animalID >= 10000)
        {
            try {
                System.out.println("Παρακαλώ δώστε μοναδικό κωδικό(id) του ζώου: (από 1000 μέχρι 9999)");
                String stringAnimalID = scanner.nextLine();
                animalID = Integer.parseInt(stringAnimalID.trim());
                //Ελεγχος αν ειναι το id που πρεπει
                if (animalID > 999 && animalID < 10000 )
                {
                    //ελεγχος αν υπάρχει ήδη το id
                    AnimalSearch sameId = new AnimalSearch();
                    boolean checkSameId = sameId.searchForCheckAnimalID(animalID,"animalDataFile.txt");
                    if (!checkSameId){
                        System.out.println("Ο κωδικός του ζώου είναι: "+animalID);
                    }else{
                        System.out.print("Tο ID που έχετε δώσει υπάρχει ήδη.Δώστε άλλο:"+"\n");
                        UserSetAnimalID();
                    }
                }else {

                    System.out.println("Προσοχή! Δεν δώσατε αριθμό ή ο αριθμός που δώσατε δεν είναι έγκυρος! "+"\n");

                }
            } catch (NumberFormatException e) {
                System.out.println("Προσοχή! Δεν δώσατε αριθμό ή ο αριθμός που δώσατε δεν είναι έγκυρος! "+"\n");
            }

        }

        return String.valueOf(animalID);
    }

    //εισοδος ονοματος ζωου
    public String UserSetAnimalName()
    {
        String animalName = null;

        System.out.println();
        System.out.println("Παρακαλώ δώστε το όνομα του ζώου:");
        System.out.println("Επιτρέπονται μόνο μίκρη λατινική χαρακτήρες");
        System.out.println("Ορθά Παραδείγματα: tiger,dog,skulos");
        System.out.println("Λάθος Παραδείγματα: 1tiger,Tiger,tiger1,τίγρης1");
        boolean repeat=true;
        Scanner scanner = new Scanner(System.in);
        animalName = scanner.nextLine().trim();
        while (repeat==true){
            //ελεγχος αν είναι όλα μικρά λατινικά γράμματα
            if (!animalName.matches("[a-z]+"))
            {
                System.out.println();
                System.out.println("Προσοχή! Το όνομα δεν μπορεί να περιέχει Αριθμούς ή Σύμβολα ή Ελληνικούς Χαρακτήρες ή Κεφαλαία Γράμματα!");
                System.out.println("Επιτρέπονται μόνο μίκρη λατινική χαρακτήρες");
                animalName = scanner.nextLine();
            }
            else {
                System.out.println("Το όνομα του ζώου είναι "+animalName);
                repeat = false;
            }
        }
        return animalName;
    }


    //εισοδος ομοταξιας ζώου!
    public String UserSetOmotaxia() {
        Boolean repeat = true;
        String omotaxia = null;
        //while μέχρι να δώσει ο χρηστης από 1-5 για απαντηση.
        while (repeat)
            try {
                System.out.println();
                System.out.println("Παρακαλώ επιλέξτε ομοταξία για το ζώο:");
                System.out.println("-Για Θηλαστικό πατήστε 1\n-Για Αμφίβιο πατήστε 2\n-Για Πτηνό πατήστε 3\n-Για Ερπετό πατήστε 4\n-Αν δεν είναι κανένα από τα πιο πάνω πατήστε 5");
                System.out.print("Επιλογή αριθμού: ");
                Scanner scanner = new Scanner(System.in);

                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Το ζώο είναι Θηλαστικό.");
                        omotaxia = "Θηλαστικό";
                        repeat = false;
                        break;
                    case 2:
                        System.out.println("Το ζώο είναι Αμφίβιο.");
                        omotaxia = "Αμφίβιο";
                        repeat = false;
                        break;
                    case 3:
                        System.out.println("Το ζώο είναι Πτηνό.");
                        omotaxia = "Πτηνό";
                        repeat = false;
                        break;
                    case 4:
                        System.out.println("Το ζώο είναι Ερπετό.");
                        omotaxia = "Ερπετό";
                        repeat = false;
                        break;
                    case 5:
                        System.out.println("Άγνωστη κατηγορία Ομοταξίας.");
                        omotaxia = "Άγνωστο";
                        repeat = false;
                        break;
                    default:
                        System.out.println("\n"+"Επιλέξτε μόνο τους αριθμόυς αριθμούς 1 ή 2 ή 3 ή 4 ή 5");

                }

            } catch (Exception e) {
                System.out.println("Προσοχή! Επιλέξτε μόνο τους αριθμόυς αριθμούς 1 ή 2 ή 3 ή 4 ή 5 !"+"\n");
            }
        return omotaxia;
    }


    //εισοδος βάρους
    public String UserSetAnimalWeight()
    {
         int animalWeight=0;
       Scanner scanner = new Scanner(System.in);
       //ελεγχος αν ειναι σωστό το βάρος
        while (animalWeight <= 0 || animalWeight >= 200001)
        {
           try {
               System.out.println("\n"+"Παρακαλώ δώστε το μέσο βάρος του ζώου σε κιλά(kg):");
               System.out.println("Παράδειγμα: Αν το ζώο ζυγίζει 2.5kg δώστε αριθμό κιλών 3! ");
                String stringAnimalWeight = scanner.nextLine();
               animalWeight = Integer.parseInt(stringAnimalWeight.trim());
                if (animalWeight > 0 && animalWeight < 200001)
                {
                    System.out.println("Το ζώο έιναι "+animalWeight+" Kg");

                } else {
                    System.out.println("Προσοχή! Tο ζώο δεν μπορεί να έχει βάρος μικρότερο 0 kg και το πιο βαρύ ζώο ζυγίζει 200 000 kg όπου είναι η μπλέ φάλαινα, δώστε ξανά τον αριθμό! "+"\n");
                }
           } catch (Exception e) {
                System.out.println("Προσοχή! Δεν δώσατε αριθμό ή ο αριθμός που δώσατε δεν είναι έγκυρος!"+"\n");
           }
        }
        return String.valueOf(animalWeight);
    }


    //εισοδος ηλικίας ζώου
    public String UserSetAnimalAge()
    {
        int animalAge = 0 ;
        Scanner scanner = new Scanner(System.in);
        //ελεγχος αν εδωσε σωστό αριθμό
        while (animalAge <= 0 || animalAge >= 101)
        {
            try
            {
                System.out.println("\n"+"Παρακαλώ δώστε τη μέση ηλικία του ζώου σε χρόνια:");
                String stringAnimalAge = scanner.nextLine();
                animalAge = Integer.parseInt(stringAnimalAge.trim());
                if (animalAge > 0 && animalAge < 101)
                {
                    System.out.println("Η μέση ηλικία του ζώου είναι "+animalAge +" χρόνια");


                }else{
                    System.out.println("Προσοχή! Το ζώο δεν μπορεί να έχει μέση ηλικία 0 ετών και ο Ζωολογικός κήπος δέχεται μόνο ζώα μέσης ηλικίας μέχρι 100 ετών"+"\n");
                }

            } catch (Exception e) {
                System.out.println("Προσοχή! Προσοχή! Δεν δώσατε αριθμό ή ο αριθμός που δώσατε δεν είναι έγκυρος!"+"\n");
            }
        }
        return String.valueOf(animalAge);
    }


    //μεθόδος ελεγχου στοιχειων και επιλογή του χρήστη τι θέλει να κάνει
    public void SaveAnimalInfo(String FinalAnimalID, String FinalAnimalName,String FinalOmotaxia,String FinalAnimalWeight,String FinalAnimalAge)
    {
        System.out.println("\n"+"\n"+"   Τα στοιχεία του ζώου είναι:");
        System.out.println("     Ο Κωδικός(id) του ζώου είναι: "+FinalAnimalID);
        System.out.println("     Το όνομα του ζώου είναι: "+FinalAnimalName);
        System.out.println("     Η ομοταξία του ζώου είναι: " + FinalOmotaxia);
        System.out.println("     Το βάρος του ζώου είναι: " + FinalAnimalWeight+" Kg");
        System.out.println("     Η μέση ηλικία του ζώου είναι: " + FinalAnimalAge+" χρόνια");
        System.out.println();

        System.out.println("     Είναι σωστά τα πιο πάνω στοιχεία;");
        System.out.println("      -Αν είναι σωστά  πληκτρολογήστε yes για αποθήκευση.");
        System.out.println("      -Αν είναι λάθος  πληκτρολογήστε no για να ξαναβάλετε τα στοιχεία.");
        System.out.println("      -Αν θέλετε να πάτε στο κεντρικό μενού πληκτρολογήστε out.");


        //ελεγχος αν ο χρηστης εδωσε yes ή no ή out
        //γινεται η αντιστοιχη ενέργεια κάθε φορα
        while(true) {

            String userAnswer;
            Scanner scanner = new Scanner(System.in);
            userAnswer = scanner.nextLine().trim().toLowerCase();
            if (userAnswer.equals("yes")) {
           AnimalSaveClass saveAnimalInfo = new AnimalSaveClass();
                saveAnimalInfo.saveAnimal(FinalAnimalID,FinalAnimalName, FinalOmotaxia, FinalAnimalWeight, FinalAnimalAge);
                break;
            } else if (userAnswer.equals("no")) {
                 AnimalClass againCallClass = new AnimalClass();
                 String AgainAnimalID = UserSetAnimalID();
                 String AgainAnimalName = UserSetAnimalName();
                 String AgainOmotaxia   = UserSetOmotaxia();
                 String AgainAnimalWeight  = UserSetAnimalWeight();
                 String AgainAnimalAge     = UserSetAnimalAge();
                 againCallClass.SaveAnimalInfo(AgainAnimalID,AgainAnimalName,AgainOmotaxia,AgainAnimalWeight,AgainAnimalAge);
                 break;
            } else if (userAnswer.equals("out")){
                System.out.println("Βγηκες εξω");
                break;

            }else {
                System.out.println("     Συγγνώμη! Πρέπει να πατήσετε yes/no/out");
                System.out.println("     -yes για αποθήκευση");
                System.out.println("     -no για να ξανά-προσπαθήσετε");
                System.out.println("     -οut για πάτε στο κεντρικό μενού");
            }
        }
    }

}

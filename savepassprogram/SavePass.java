import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SavePass {
/*
 * Function Name: generateDatabase
 * Function Prototype: public static
 * Description: returns hashmap of entries 
 * Parameters: file in which all accounts are stored 
 * Side Effects: TODO
 * Error Conditions: TODO
 * Return Value: hashmap of entries
 */
  public static HashMap<String,List<String>> generateDatabase (){
    
    //create a hash of entries
    HashMap<String,List<String>> entryHash = new HashMap<>();
    
    //create one entry
    List<String> facebookAccount = new ArrayList<>();
    facebookAccount.add("kimpham107@gmail.com");
    facebookAccount.add("Facebook96");
    entryHash.put("facebook",facebookAccount);

    //create another entry
    List<String> googleAccount = new ArrayList<>();
    googleAccount.add("kimpham107@gmail.com");
    googleAccount.add("Google96");
    entryHash.put("google",googleAccount);

    return entryHash;

  }

/*
 * Function Name: saveEntry
 * Function Prototype: public static void saveEntry()
 * Description: function inquires the user for an entry they intend to save.
 * If the entry has already been saved previously, function will ask if user
 * would like to update that entry
 * Parameters: TODO
 * Side Effects: TODO
 * Error Conditions: TODO
 * Return Value: TODO
 */
  public static void saveEntry (){
    HashMap<String,List<String>> database = generateDatabase();

    System.out.print("Enter the website/application you intend for: ");
    Scanner scan = new Scanner (System.in);
    String app = scan.nextLine();
    app = app.toLowerCase();
    
    char ans; //used to hold yes/no answer
    //check if no entry was ever written
    if (!database.isEmpty()){
      //check if entry was already in system
      if (database.containsKey(app)){
        System.out.println("A set of username/password was already registered "+
        "for " + app);
        System.out.println("Would you like to update old entry? [y/n]");
        ans = scan.next().charAt(0);
        if (ans == 'y'){
          //delete old entry
          database.remove(app);
        }
        else {
          return;
        }
      }
    }


    List<String> value = new ArrayList<>();
    Scanner infoScan = new Scanner (System.in);
    System.out.print("Enter your username: ");
    String usr = infoScan.nextLine();
    value.add(usr);

    System.out.print("Enter your password: ");
    String pas = infoScan.nextLine();
    value.add(pas);

    System.out.println("Would you like to add additional information? [y/n]");
    ans = scan.next().charAt(0);
    String addInfo;
    while (ans == 'y'){
      //input additional information
      System.out.println("Enter additional information: ");
      addInfo = infoScan.nextLine();
      value.add(addInfo);
      
      System.out.println("Would you like to add additional information? [y/n]");
      ans = scan.next().charAt(0);
    }
    
    //input info into database
    database.put(app, value);
    //TODO write to file
    System.out.println("Successfully added entry for " + app + ": ");
    System.out.println(value);
  }

/*
 * Function Name: main
 * Function Prototype: public static  void main (String args[])
 * Description: main driver for SavePass program
 * Parameters: TODO
 * Side Effects: TODO
 * Error Conditions: TODO
 * Return Value: TODO
 */
  public static void main (String args[]){

    String displayOption = "Choose an option: \n" + 
                           "1/ Save an entry. \n" + 
                           "2/ Request to display an entry. \n" +
                           "3/ Request to display all entries. \n" +
                           "4/ Exit. \n";

    //Display options Save/Request
    System.out.print(displayOption);
    Scanner scan = new Scanner (System.in);
    int ans = scan.nextInt();
    while (ans != 4){
      switch (ans){
        case 1: //save an entry
          saveEntry();
          break;
        case 2: //request to display an entry
          //TODO displayEntry();
          break;
        case 3:
          //TODO displayAllEntry();
          break;
        case 4: //exit program
          System.exit(0);
          return;
        default:  //invalid option
          System.err.println ("Invalid option");
          break;
      }
      System.out.println();
      System.out.print(displayOption);
      ans = scan.nextInt();
    }

  }
}

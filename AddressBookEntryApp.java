import java.util.Scanner;              //import statements to import Scanner, IOException and AddressBookEntryApp classes
import java.io.IOException;
public class AddressBookEntryApp
{ 
  public static void main(String args[]) throws IOException //main method
  {
  String name = ""; //Declaring and initialising the string type variables for name, email, phone fields
  String email = "";
  String phone = "";
  System.out.print("Welcome to the Address Book Application\n"); //displaying the list
  System.out.printf("\n1 - List Entries\n");
  System.out.printf("2 - Add Entry\n");
  System.out.printf("3 - Exit\n");
  Scanner s;          //declaring scanner type variable
  int selection;      //declaring integer type varibale for input selection
  do                              
  {
    System.out.printf("\nPlease enter your choice from (1-3) :"); //statement asking user to enter input
    s = new Scanner(System.in);                       // scanner type object is created
    selection = s.nextInt();                          // stores value into scanner type variable
    selection = Validator.checkChoice(selection);     //Validates the user entered input by calling the validator class method
    if( selection == 0)                               //if validated right, the result is returned and checked 
    System.out.printf("\nPlease enter a number for choice from 1-3"); //if not validated, error message printed
    switch(selection)           //switches to cases as per the selection entered
    {
     case 1:                    //prints the string by printing the result from calling the getEntriesString method 
     System.out.printf(AddressBookIO.getEntriesString());
     break;
     case 2:                   //case 2 for choice 2 entered
     int check;                //temporary variable declared to store the user entered value before validation
     do                        //loops untill the user enters correct format input
     {
     System.out.print("Enter Name :"); //statement asking user to enter input
     String name1 = s.next(); //statement asking user to enter input
     s.nextLine(); //using nextLine method so that the next method for email doesn't take space entered in name field as input
     check = Validator.checkName(name1); //Validates the user entered input by calling the validator class method
     if(check==0)
     {
       System.out.println("\nInvalid name, please enter the name which has all characters\n"); //if not validated, error message printed
     }
     else
     {
       name = name1;  //if validated right, the temporary value is stored into variable name 
     }
        }
     while(check!= 1);
     int check1;      //temporary variable declared to store the user entered value before validation       
     do
     {                //loops untill the user enters correct format input
     System.out.print("\nEnter email address :"); //statement asking user to enter input
     String email1 = s.next(); //value stored in temp variable
     s.nextLine();
     check1 = Validator.checkEmail(email1); //Validates the user entered input by calling the validator class method
     if(check1==0)
       {
       System.out.println("\nInvalid email, please enter a email which has '.com' domain"); //if not validated, error message printed
       }
     else
       {
       email = email1; //if validated right, the temporary value is stored into variable email 
       }
     }
     while(check1!= 1);
     
     int check2;     //temporary variable declared to store the user entered value before validation
     do                  //loops untill the user enters correct format input
     {
     System.out.print("\nEnter Phone Number :"); //statement asking user to enter input
     String phone1 = s.next(); // stores value into temp variable
     s.nextLine();
     check2 = Validator.checkPhone(phone1); //Validates the user entered input by calling the validator class method
     if(check2==0)
       {
       System.out.println("\nInvalid phone number, please enter a 10-digit number"); //if not validated, error message printed
       }
     else
       {
       phone = phone1; //if validated right, the temporary value is stored into variable phone 
       }
     }
     while(check2!= 1);
     
     AddressBookEntry a = new AddressBookEntry(name,email,phone); //After validation, the stored values from user are instantiated to reference variables in AddressEntry class
     if(AddressBookIO.saveEntry(a)==true)   //save entry method called to check if the entries have been added
       {
       System.out.println("\nThis entry has been successfully saved"); //prints if entry saved
       }
    else 
       System.out.println("This entry could not be saved"); //if not saved
      break;
    case 3:
      System.out.print("Goodbye."); //printed when user selects choice 3
      break;
  }
  }
  while(selection != 3);
  s.close();
  } 
}

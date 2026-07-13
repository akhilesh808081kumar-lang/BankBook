import java.util.ArrayList;
import java.util.Scanner;

// ==============================================================
// BankBook Simple Bank Account Simulater
// Concepts used: Scanner, switch-case, while loop,
//  ArrayList(transection history), method
// ==============================================================

public class BankBook{
  // ----------Globle Variablees-----------
  static double balance=0.0;
  static String Accountholder="";
  static ArrayList<String>transection=new ArrayList<>();
  static Scanner scanner= new Scanner (System.in);
  // =====================MAIN===================
  public static void main(String[] args) {
    System.out.println("=================================");
    System.out.println("      Welcom to BankBook         ");
    System.out.println("=================================");
    
    // Account setup
    System.out.print("Enter your name: ");
    Accountholder=scanner.nextLine();
    System.out.print("Enter your opning balance (Rs): ");
    balance=scanner.nextDouble();
    transection.add("Open Account "+"Opning balance : Rs " + balance);
    System.out.print("\nNamaste,"+Accountholder +"! Start Account.");

    // Main menu loop jab tak user Exit na kare
    boolean running =true;
    while (running){
      showmenu();
      int choice=scanner.nextInt();
      switch(choice){
        case 1: deposit();
        break;
        case 2: withdraw();
        break; 
        case 3: checkBalance();
        break;
        case 4: checkhistory();
        break;
        case 5: running=false;
        System.out.println("\nShukriya! BankBook band ho raha hai. Alvida,"+ Accountholder +"!");
        break;
        default:
        System.out.println("galat choice! 1 se 5 ke beech number dalo.");  
      }
    }
    scanner.close();
  }
         
  //  =============================== MENU ==============================
  static void showmenu(){
    System.out.println("\n-------------------------------------");
    System.out.println("        BankBook Main Manu          ");
    System.out.println("-------------------------------------");
    System.out.println("1. Deposit (Paise jama karo)");
    System.out.println("2. Withdraw(Paise nikalo)");
    System.out.println("3. Balance Chek Karo");
    System.out.println("4. Transection History dekho");
    System.out.println("5. Exit");                       
    System.out.println("------------------------------------");
    System.out.print("Apna choice enter karo (1-5): ");
    
  }

  // ============================ DEPOSIT ========================
  static void deposit(){
    System.out.print("\n kitna paisa jama karna hai (Rs): ");
    double amount=scanner.nextDouble();
    if (amount<=0){
      System.out.print("Amount zero ya negative nho ho sakta !");
      return;
    }  
    balance += amount; 
    String entry= "Deposit  : + Rs" + amount+" | Balance: Rs "+ balance;
    transection.add(entry); 
    System.out.println("Rs" + amount +" jama ho gaya !");
    System.out.println("Nay a Balance :Rs "+ balance);
  }

  // =============================== WITHDRAW =============================
  static void withdraw(){
    System.out.print("\n kitna paisa nikalna hai (Rs): ");
    double amount =scanner.nextDouble();
    if(amount<=0){
      System.out.print("Amount zero ya negative nhi ho sakta! ");
      return;
    }
    if(amount>balance){
      System.out.println("Insufficent balance ! Apke paas sirf Rs "+ balance +"hai.");
      return;
    }
    balance -= amount;
    String entry="Withdrawal: -Rs "+ amount +" | Balance: Rs" + balance;
    transection.add(entry);
    System.out.println("Rs"+ amount + "nikal liya gaya!");
    System.out.println("Bacha hua balance: Rs " + balance);
  }

  // ============================= CHECK BALANCE ============================
  static void checkBalance(){
    System.out.println("\n-----Balance Statement ----");
    System.out.println("Account holder : "+ Accountholder);
    System.out.println("Current Balance: Rs "+ balance);
    System.out.println("--------------------------------------");
  }

 //  ============================= TRANSECTION HISTORY ============================
  static void checkhistory(){
    System.out.println("\n----Transection History ----");
    if(transection.isEmpty()){
     System.out.println("koi transection nhi hua hai abhi tak");
    }else{
      for(int i=0;i<transection.size();i++){
        System.out.println((i+1)+"."+transection.get(i));
      }
    }
    System.out.println("-------------------------------------");
  }
}
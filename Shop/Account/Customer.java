package Shop.Account;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Customer {

    private static Customer customer = new Customer();
    public static Customer get() { return customer; }

    public static void main(String[] args) {
        System.out.println("Client");
        System.out.println("Hello World");
        new Customer();
        addCustomer();
    }
    static String firstName;
    static String lastName;
    static String address;
    static int age,wage;

    static boolean fileExist(File castomersDataFile){
        if (!castomersDataFile.exists()){
            try {
                castomersDataFile.createNewFile();
                System.out.println("Plik was create");
                return false;
            }catch (Exception e){
                System.out.println(e.getMessage());
                return  true;
            }
        }
        return true;
    }


    static void addCustomer(){
        File f  = new File("ShopData/Customer/customersData.txt");

        if(fileExist(f)) {
            if (f.canWrite()) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    FileWriter fw = new FileWriter(f,true);
//                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Gson gson = new Gson();
                    JsonObject objJ = new JsonObject();
                    System.out.println("Enter first name:");
                    firstName = scanner.nextLine();
                    fw.write(firstName+"\n");
                    gson.toJson(firstName);

                    System.out.println("Enter last name:");
                    lastName = scanner.nextLine();
                    fw.write(lastName+"\n");
                    gson.toJson(lastName);


                    System.out.println("Enter address:");
                    address = scanner.nextLine();
                    fw.write(address+"\n");
                    gson.toJson(address);

                    System.out.println("Enter age:");
                    age = scanner.nextInt();
                    fw.write(age+"\n");
                    gson.toJson(age);

                    System.out.println("Enter wage:");
                    wage = scanner.nextInt();
                    fw.write(wage+"\n");
                    wage = wage.toString();
                    gson.toJson(wage);

                    String json = gson.toString();
                    fw.write(json);
                    fw.write("---------\n");
                    System.out.println("Cilent data: "+firstName+" "+lastName+" "+address+" "+age+" "+wage
                    );

                    fw.close();
                    scanner.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }


}


package AppPack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
    static ArrayList<Course> courses = new ArrayList<Course>();

    static Scanner scanner = new Scanner(System.in);

    static FileOutputStream fos;

    public static void main(String[] args) throws InterruptedException, IOException {

        boolean driverStatus = true;
        fileConnector();
        while (driverStatus){
            System.out.print("Who are you? \n" +
                    "1. Admin;\n" +
                    "2. Student;\n" +
                    "3. Logout.\n" +
                    "--> ");
            int act = scanner.nextInt();
            scanner.nextLine();
            switch (act){
                case 1:
                    Admin admin = new Admin();
                    admin.start();
                    admin.join();
                    break;
                case 2:
                    Collections.sort(courses);
                    System.out.println(courses);
                    break;
                case 3:
                    driverStatus = false;
                    break;
            }
        }
        closeFileConnector();

    }

    static void fileConnector(){
        try{
            fos = new FileOutputStream("src/AppPack/admin.txt", true);
        }catch (IOException ioe){
            throw new RuntimeException(ioe);
        }
    }

    static void closeFileConnector() throws IOException{
        fos.close();
        System.out.println("q");
    }

}

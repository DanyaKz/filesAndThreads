package AppPack;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Admin extends Thread {

    private static String username = "admin";
    private static String password = "qq";

    private static Scanner scanner = new Scanner(System.in);

    private Instructor currentInstructor;
    private Textbook currentTextBook;

    @Override
    public void run() {
        login();
        System.out.println("Choose an action:\n" +
                "1. Add new course;\n" +
                "2. Logout.");

        int action = askAdmin();
        login();
        switch (action) {
            case 1:
                addNewInstructor();
                break;
            case 2:
                Thread.currentThread().interrupt();
                break;
        }


    }

    private int askAdmin() {
        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("\t--> ");
            return Integer.parseInt(bufferRead.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Hentai ! It's not a number !!!");
        }
    }


    private static void login() {
        try (FileInputStream fis = new FileInputStream("src/AppPack/admin.txt");
             FileOutputStream fos = new FileOutputStream("src/AppPack/admin.txt", true)) {
            if (fis.readAllBytes().length == 0) {
                String adminData = String.format("Username: %s%nPassword: %s%n", username, password.hashCode());
                fos.write(adminData.getBytes());
            }

            String loginData = LocalDate.now() + " admin logged in to a system\n";

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

    }

    private void addNewCourse() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fos = new FileOutputStream("src/AppPack/admin.txt", true)) {

            System.out.println("Text course title: ");
            String title = bufferedReader.readLine();

            Driver.courses.add(new Course(title, this.currentTextBook, this.currentInstructor));

            String message = LocalDate.now() + " admin added new course " + "\"" + title + "\"\n";
            fos.write(message.getBytes());

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private void addNewTextBook() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fos = new FileOutputStream("src/AppPack/admin.txt", true)) {

            System.out.println("Text course isbn, title separated by a space and authors separated by commas: ");
            String[] textbookData = bufferedReader.readLine().split("( )");
            ArrayList<String> authors = new ArrayList<String>(Arrays.asList(textbookData[2].split(",")));

            currentTextBook = new Textbook(Integer.parseInt(textbookData[0]), textbookData[1],
                    authors);


            String message = LocalDate.now() + " admin added new course " + "\"" + textbookData[1] + "\"\n";
            fos.write(message.getBytes());

            addNewCourse();

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private void addNewInstructor() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fos = new FileOutputStream("src/AppPack/admin.txt", true)) {

            System.out.println("Text instructor data (firstName, lastName, department, email): ");
            String[] instrData = bufferedReader.readLine().split("( )");

            currentInstructor = new Instructor(instrData[0], instrData[1], instrData[2], instrData[3]);

            String message = LocalDate.now() + " admin added new instructor " + instrData[1] + "\n";
            fos.write(message.getBytes());

            addNewTextBook();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}

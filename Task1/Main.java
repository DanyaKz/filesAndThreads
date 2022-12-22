package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Student> allStudents = new ArrayList<Student>();

    public static void main(String[] args) {

        inputData();
        output();
        printObjects(readObjectInp());
    }

    static void inputData() {
        try (FileInputStream fis = new FileInputStream("src/Task1/scores.txt");
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            StringBuilder data = new StringBuilder();
            byte[] dataArr = bis.readAllBytes();
            for (int i = 0; i < dataArr.length; i++) {
                data.append((char) dataArr[i]);

                if ((char) dataArr[i] == '\r'  || i == dataArr.length - 1) {
                    String[] addedData = data.toString().split("( )");
                    allStudents.add(new Student(addedData[0].strip(), Integer.parseInt(addedData[1].strip())));
                    data = new StringBuilder();
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void output() {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("src/Task1/grades.txt"))) {
            Collections.sort(allStudents);
            ois.writeObject(allStudents);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    static ArrayList<Student> readObjectInp() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Task1/grades.txt"))) {

            return (ArrayList<Student>) ois.readObject();

        } catch (IOException | ClassNotFoundException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    static void printObjects(ArrayList<Student> students){
        int avg = 0;
        int max = students.get(0).getPoints();
        int min = students.get(0).getPoints();
        for (Student student: students){
            int points = student.getPoints();
            System.out.println(student.getFullName() + " " + student.getLetter() + " " + student.getPoints());
            avg += points;
            if (points > max) max = points;
            if (points < min) min = points;
        }
        System.out.printf("Average – %d\n" +
                "Maximum – %d\n" +
                "Minimum – %d\n", (avg / students.size()), max, min);
    }
}

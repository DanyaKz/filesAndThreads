package Task1;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    public static final long serialVersionUID = 1L;

    String fullName;
    private int points;
    private String letter;

    public Student(String fullName, int points) {
        this.fullName = fullName;
        this.points = points;
        setLetter();
    }

    public String getFullName() {
        return fullName;
    }

    public int getPoints() {
        return points;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter() {
        if (points >= 90) letter = "A";
        else if (points >= 80) {
            letter = "B";
        }else if (points >= 70) {
            letter = "C";
        }else if (points >= 60) {
            letter = "D";
        }else letter = "F";

    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(s.getPoints(), points);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", points=" + points +
                ", letter='" + letter + '\'' +
                '}';
    }

}


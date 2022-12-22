package AppPack;


public class Course implements Comparable<Course> {
    private String courseTitle;
    private Textbook textbook;
    private Instructor instructor;

    public Course(String courseTitle, Textbook textbook, Instructor instructor) {
        this.courseTitle = courseTitle;
        this.textbook = textbook;
        this.instructor = instructor;
    }

    public Course() {
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    @Override
    public int compareTo(Course c) {
        return courseTitle.compareTo(c.getCourseTitle());
    }
}

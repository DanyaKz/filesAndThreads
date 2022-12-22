package AppPack;

import java.util.ArrayList;

public class Textbook {
    private int isbn;
    private String title;
    private ArrayList<String> authors = new ArrayList<String>();

    public Textbook(int isbn, String title, ArrayList<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    public Textbook() {
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void appendAuthor(String authors) {
        this.authors.add(authors);
    }

}

/**
 * @author Alexis Salgado
 * @since 2025.09.20
 * Abstract: This is the Book.java File
 *
 *
 *
 */
import java.time.LocalDate;
import java.util.Objects;

public class Book {

    // Constant fields these are used for CSV indexing.
    public static final int ISBN_ = 0;
    public static final int TITLE_ = 1;
    public static final int SUBJECT_ = 2;
    public static final int PAGE_COUNT_ = 3;
    public static final int AUTHOR_ = 4;
    public static final int DUE_DATE_ = 5;

    // Instance Fields.
    private String author;
    private LocalDate dueDate;
    private String isbn;
    private int pageCount;
    private String subject;
    private String title;

    // Constructor (full-args, matches UML)
    public Book(String isbn, String title, String subject, int pageCount, String author, LocalDate dueDate){
        this.isbn = isbn;
        this.title = title;
        this.subject = subject;
        this.pageCount = pageCount;
        this.author = author;
        this.dueDate = dueDate;
    }

    public Book(String token, String token1, String token2, String token3, String token4, int i) {
    }

    // Getters and Setters.
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    // equals() -> Everything except dueDate
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Book book)) return false;
        return  pageCount == book.pageCount &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(subject, book.subject) &&
                Objects.equals(author, book.author);
        // dueDate is intentionally not included.
    }
    //hashCode() -> everything except dueDate
    @Override
    public int hashCode(){
        return Objects.hash(isbn, title, subject, pageCount, author);
    }
    // toString() -> "[Title] by [Author] ISBN: [isbn]
    @Override
    public String toString(){
        return title + " by " + author + " ISBN: " + isbn;
    }
}

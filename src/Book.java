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


}

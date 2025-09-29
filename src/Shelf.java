import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class Shelf {
    //Constant Fields
    public static final int SHELF_NUMBER_ = 0;
    public static final int SUBJECT_ = 1;

    // Creates Instance fields.
    private HashMap<Book, Integer> books = new HashMap<>();
    private int shelfNumber;
    private String subject;

    // Constructors
    @Deprecated
    public Shelf(){
        // Deprecated no arg constructor.
    }
    public Shelf(int shelfNumber, String subject){
        this.shelfNumber = shelfNumber;
        this.subject = subject;
    }

    //getters and setters.
    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexis Salgado
 * @since 2025.09.21
 * Abstract: This is the Reader.java File
 *
 *
 *
 */
public class Reader {
    // Constant fields used for CSV indices
    public static final int CARD_NUMBER_ = 0;
    public static final int NAME_ = 1;
    public static final int PHONE_ = 2;
    public static final int BOOK_COUNT_ = 3;
    public static final int BOOK_START_ = 4;

    // Instance fields
    private int cardNumber;
    private String name;
    private String phone;
    private List<Book> books;

    // Constructor
    public Reader(int cardNumber, String name, String phone){
        this.cardNumber = cardNumber;
        this.name = name;
        this.phone = phone;
        this.books = new ArrayList<>();
    }

}

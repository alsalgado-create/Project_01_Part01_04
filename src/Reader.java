import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import Utilities.Code;
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
    // Methods

    public Code addBook(Book book){
        if (books.contains(book)){
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }
        books.add(book);
        return Code.SUCCESS;
    }
    public Code removeBook(Book book){
        if(!books.contains(book)){
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }
        if (books.remove(book)){
            return Code.SUCCESS;
        }
        return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
    }
    public  boolean hasBook(Book book){
        return books.contains(book);
    }
    public int getBookCount(){
        return books.size();
    }

    // Generated Getters and Setters
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        if (books == null){
            this.books = new ArrayList<>();
        }else{
            this.books = books;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // equals and hashCode (also ignores booklist)
    @Override
    public  boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Reader)) return false;
        Reader reader = (Reader) o;
        return cardNumber == reader.cardNumber &&
                Objects.equals(name, reader.name) &&
                Objects.equals(name, reader.phone);
    }
    @Override
    public int hashCode(){
        return Objects.hash(cardNumber, name, phone);
    }
    // toString
    @Override
    public  String toString(){
        return name + " (#" + cardNumber + ") has checked out " + books;
    }
}

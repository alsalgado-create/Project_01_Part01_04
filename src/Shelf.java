import Utilities.Code;

import java.lang.annotation.Native;
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
    // equals and hashcode will be (shelfNumber + subject only)
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Shelf)) return false;
        Shelf shelf = (Shelf) o;
        return shelfNumber == shelf.shelfNumber &&
                Objects.equals(subject, shelf.subject);
    }
    @Override
    public int hashCode(){
        return Objects.hash(shelfNumber, subject);
    }
    //toString
    @Override
    public String toString(){
        return shelfNumber + " : " + subject;
    }

    // Methods
    public int getBookCount(Book book){
        return books.getOrDefault(books, -1);
    }
    public Code addBook(Book book){
        if (!book.getSubject().equalsIgnoreCase(this.subject)){
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }
        int count = books.getOrDefault(book, 0);
        books.put(book, count + 1);

        System.out.println(book.toString() + " added to shelf " + this.toString());
        return Code.SUCCESS;
    }
    public Code removeBook(Book book){
        if (!books.containsKey(book)){
            System.out.println(book.getTitle() + " is not on shelf " + subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        int count = books.get(book);
        if(count <= 0){
            System.out.println("No copies of " + book.getTitle() + " remain on shelf " + subject);
            return Code.SUCCESS;
        }
        books.put(book,count - 1);
        System.out.println("No copies of " + book.getTitle() + " remain on shelf " + subject);
        return Code.SUCCESS;
    }
    public String listBooks(){
        StringBuilder sb = new StringBuilder();
        int total = books.values().stream().mapToInt(Integer::intValue).sum();

        sb.append(total)
                .append(total == 1 ? " book on shelf: ": " books on shelf: ")
                .append(this.toString())
                .append("\n");

        for(Map.Entry<Book, Integer> entry : books.entrySet()){
            sb.append(entry.getKey().toString())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString().trim();
    }
}

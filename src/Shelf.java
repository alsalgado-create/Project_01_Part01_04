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

}

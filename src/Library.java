/**
 * @author Alexis Salgado
 * @since 2025.10.12
 * Abstract: This is the Library.java File
 *Project 01 Part 04/04: Library.java
 *
 *
 */

import Utilities.Code;
import java.util.*;
import java.time.LocalDate;
public class Library {
    /**
     * Constant fields
     */
    public static final int NAME_ = 0;
    public static final int ADDRESS_ = 1;
    public static final int PHONE_ = 2;
    /**
     * Instance fields
     */
    private String name;
    private String address;
    private String phone;
    private HashMap<Integer, Reader> readers = new HashMap<>();
    private HashMap<Integer, Shelf> shelves = new HashMap<>();
}

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
    /**
     * Constructors
     */
    public Library(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<Integer, Reader> getReaders() {
        return readers;
    }

    public void setReaders(HashMap<Integer, Reader> readers) {
        this.readers = readers;
    }

    public HashMap<Integer, Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(HashMap<Integer, Shelf> shelves) {
        this.shelves = shelves;
    }
}

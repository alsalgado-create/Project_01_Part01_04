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
    /**
     * Equals and hashCode
     */
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name)
                && Objects.equals(address, library.address)
                && Objects.equals(phone, library.phone);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, address, phone);
    }
    /**
     * toString
     */
    @Override
    public String toString(){
        return name + " (" + address + ")";
    }
    /**
     * Methods
     */
    public Code addShelf(Shelf shelf){
        if (shelves.containsKey(shelf.getShelfNumber())){
            return Code.SHELF_EXISTS_ERROR;
        }
        shelves.put(shelf.getShelfNumber(), shelf);
        System.out.println("Shelf " + shelf.getShelfNumber() + " added to library " + name);
        return Code.SUCCESS;
    }
    public Code addReader(Reader reader){
        if(readers.containsKey(reader.getCardNumber())){
            return Code.READER_ALREADY_EXISTS_ERROR;
        }
        readers.put(reader.getCardNumber(), reader);
        System.out.println("Reader " + reader.getName() + " added to library " + name);
        return Code.SUCCESS;
    }
    public Code addBook(Book book, int shelfNumber){
        Shelf shelf = shelves.get(shelfNumber);
        if (shelf == null){
            System.out.println("Shelf #" + shelfNumber + " Does not exist. ");
            return Code.SHELF_NUMBER_PARSE_ERROR;
        }
        return shelf.addBook(book);
    }

    public Code removeBook(Book book, int shelfNumber){
        Shelf shelf = shelves.get(shelfNumber);
        if(shelf == null){
            System.out.println("Shelf #" + shelfNumber + " Does not exist ");
            return Code.SHELF_NUMBER_PARSE_ERROR;
        }
        return shelf.removeBook(book);
    }
    public Code checkoutBook(Reader reader, Book book){
        Shelf locatedShelf = null;
        for (Shelf shelf : shelves.values()){
            if (shelf.getBookCount(book) > 0){
                locatedShelf = shelf;
                break;
            }
        }
        if (locatedShelf == null){
            System.out.println("Book not available in library: " + book.getTitle());
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }
        Code shelfResult = locatedShelf.removeBook(book);
        if (shelfResult != Code.SUCCESS) return shelfResult;

        Code readerResult = reader.addBook(book);
        if (readerResult != Code.SUCCESS) return readerResult;

        System.out.println(reader.getName() + " Checked out " + book.getTitle());
        return Code.SUCCESS;
    }
    public Code returnBook(Reader reader, Book book, int shelfNumber){
        if(!readers.containsKey(reader.getCardNumber())){
            return Code.READER_NOT_IN_LIBRARY_ERROR;
        }
        if (!reader.hasBook(book)){
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }
        Shelf shelf = shelves.get(shelfNumber);
        if(shelf == null){
            return Code.SHELF_NUMBER_PARSE_ERROR;
        }
        reader.removeBook(book);
        shelf.addBook(book);
        System.out.println(reader.getName() + " returned " + book.getTitle() + " to shelf " + shelf.getSubject());
        return Code.SUCCESS;
    }
    public String listShelves(){
        StringBuilder sb = new StringBuilder();
        for (Shelf shelf : shelves.values()){
            sb.append(shelf.listBooks()).append("\n\n");
        }
        return sb.toString().trim();
    }
    public String listReaders(){
        StringBuilder sb = new StringBuilder();
        for (Reader reader : readers.values()){
            sb.append(reader.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}

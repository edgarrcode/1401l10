public class BooksLL {

    // Attributes ARE GIVEN TO YOU...
    private Book myBook;
    private BooksLL next;
    
    // NOW COMPLETE THE FOLLOWING SECTIONS WITH RELEVANT METHODS
    // Constructors
    public BooksLL () {
    }

    public BooksLL (Book theMyBook, BooksLL theNext) {
        myBook = theMyBook;
        next = theNext;
    }
    
    // Accessors
    public Book getMyBook() {
        return myBook;
    }

    public BooksLL getNext() {
        return next;
    }
    
    // Mutators
    public void setMyBook (Book theMyBook) {
        myBook = theMyBook;
    }
    public void setNext (BookLL theNext) {
        next = theNext;
    }
    
    /*******************************************************************
     * Other methods
     *******************************************************************/
    
    // A (non static) method, printLL, that prints a linked list
    public void printLL() {
        // add your code here
    }
    
    // A (non static) method, sizeLL, that returns the number of items in 
    // the list
    public int sizeLL() {
        // add your code here
    }
    
    // A (non static) recursive method, sizeLLR, that returns the number 
    // of items in the list
    public int sizeLLR() {
        // add your code here
    }

    // A (non static) method, addTail, that takes a new book B and modifies 
    // the original list where B has been added as the last node in the list.
    public void addTail(BooksLL B) {
        // add your code here
    }        
    
    // Bonus 1: A (non static) method, removeHead, that modifies the original list by cropping out its first node
    
    // Bonus 2: A (non static) method, addNth, that takes a new book B and 
    // an integer n, and modifies the original list where B has been added 
    // as the nth node in the list (or at the end of the list if n is larger 
    // than the size of the list + 1).
        
    
}
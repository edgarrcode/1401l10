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

    public BooksLL (Book theMyBook) {
        myBook = theMyBook;
        next = null;
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
    public void setNext (BooksLL theNext) {
        next = theNext;
    }

    /*******************************************************************
     * Other methods
     *******************************************************************/

    // A (non static) method, printLL, that prints a linked list
    public void printLL() {
        // add your code here
        if (myBook != null) {
            myBook.Print();
            System.out.println("\n");
        }
        if(next != null) {
            next.printLL();
        }
    }

    // A (non static) method, sizeLL, that returns the number of items in 
    // the list
    public int sizeLL() {
        //add your code here
        BooksLL temp = this;
        int counter = 0;

        while (temp != null) {
            temp = temp.next;
            counter++;
        }

        return counter;

    }
    
    // A (non static) recursive method, sizeLLR, that returns the number 
    // of items in the list
    public int sizeLLR() {
        // add your code here
        BooksLL temp = this;
        int counter = 0;

        if (temp.next == null) {
            return counter + 1;
        }

        counter++;
        return counter + next.sizeLLR();
    }

    // A (non static) method, addTail, that takes a new book B and modifies 
    // the original list where B has been added as the last node in the list.
    public void addTail(BooksLL B) {
        // add your code here
        BooksLL temp = this;

        while (temp.getNext() != null) {
            temp = temp.next;
        }

        temp.next = B;

        return;
    }
    
    // Bonus 1: A (non static) method, removeHead, that modifies the original list by cropping out its first node
    public void removeHead () {
        this.setMyBook(getNext().getMyBook());
        this.setNext(getNext().getNext());
    }
    
    // Bonus 2: A (non static) method, addNth, that takes a new book B and 
    // an integer n, and modifies the original list where B has been added 
    // as the nth node in the list (or at the end of the list if n is larger 
    // than the size of the list + 1).
    public void addNth (Book B, int n) {
        BooksLL newBookForNth = new BooksLL(B, null);
        int sizeOfThisList = this.sizeLLR();
        BooksLL temp = this;
        //System.out.println("this:");
        //this.printLL();

        if (n > sizeOfThisList) {
            addTail(newBookForNth);
        }
        else if (n == 0) {
            //add in 2nd
            newBookForNth.setNext(temp.next);
            temp.setNext(newBookForNth);

            //swap 1st and 2nd Book
            BooksLL tempB = new BooksLL();
            tempB.setMyBook(temp.getMyBook());
            temp.setMyBook(newBookForNth.getMyBook());
            newBookForNth.setMyBook(tempB.getMyBook());

            //swap 1st and 2nd Book


        }
        else {
            //iterate
            for (int i = 1; i < n; i++) {
                temp = temp.next;
            }
            //insert
            newBookForNth.setNext(temp.next);
            temp.setNext(newBookForNth);
        }
    }
}
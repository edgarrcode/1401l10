import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ManageBooks {

    /*********************************************************************
     * A method, readFromFile, that takes a file name as a string – this 
     * file contains book information, and returns an array of items of 
     * type Book. This method should handle file-reading errors via 
     * exception handling.
     *********************************************************************/
    public static Book[] readFromFile(String filename) throws IOException {
        // add your code here
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
        textReader.mark(1000);

        int numOfLines = 0;
        while (textReader.readLine()!=null) {
            numOfLines++;
        }

        textReader.reset();
        Book[] myBooks = new Book[numOfLines];
        String title = "";
        String authorsTemp = "";
        int pages = 0;
        int pubDate = 0;
        double price = 0.0;
        boolean enjoyed = true;

        for (int i = 0; i < numOfLines; i++) {
            String[] line = textReader.readLine().split(";");
            title = line[0];
            authorsTemp = line[1];
            String[] authors = authorsTemp.split(", ");
            pages = Integer.parseInt(line[2]);
            pubDate = Integer.parseInt(line[3]);
            price = Double.parseDouble(line[4]);
            enjoyed = Boolean.parseBoolean(line[5]);

            myBooks[i] = new Book (title, authors, pages, pubDate, price, enjoyed);

        }

        textReader.close();

        return myBooks;

    }
    
    /*********************************************************************
     * A method, sortByPublicationDate, that takes an array of items of 
     * type Book, and sorts them by publication date, from oldest to newest. 
     *********************************************************************/
    public static void sortByPublicationDate(Book[] myBooks) {
        // add your code here
        int i = 0;
        int j = 0;
        int leastRecent = 0;
        int indexLeastRecent = 0;
        int tempIndex = 0;
        
        Book tempBook = new Book();

        // get most recent and swap
        for (i = 0; i < myBooks.length; i++) {
            leastRecent = myBooks[i].getPubDate();
            indexLeastRecent = i;
            for (j = i; j < myBooks.length; j++) {
                if (myBooks[j].getPubDate() < leastRecent) {
                    leastRecent = myBooks[j].getPubDate();
                    indexLeastRecent = j;
                }
            }

            //swap title
            tempBook.setTitle(myBooks[i].getTitle());
            myBooks[i].setTitle(myBooks[indexLeastRecent].getTitle());
            myBooks[indexLeastRecent].setTitle(tempBook.getTitle());

            //swap authors
            tempBook.setAuthors(myBooks[i].getAuthors());
            myBooks[i].setAuthors(myBooks[indexLeastRecent].getAuthors());
            myBooks[indexLeastRecent].setAuthors(tempBook.getAuthors());

            //swap pages
            tempBook.setPages(myBooks[i].getPages());
            myBooks[i].setPages(myBooks[indexLeastRecent].getPages());
            myBooks[indexLeastRecent].setPages(tempBook.getPages());

            //swap pubDate
            tempBook.setPubDate(myBooks[i].getPubDate());
            myBooks[i].setPubDate(myBooks[indexLeastRecent].getPubDate());
            myBooks[indexLeastRecent].setPubDate(tempBook.getPubDate());

            //swap price
            tempBook.setPrice(myBooks[i].getPrice());
            myBooks[i].setPrice(myBooks[indexLeastRecent].getPrice());
            myBooks[indexLeastRecent].setPrice(tempBook.getPrice());

            //swap enjoyed
            tempBook.setEnjoyed(myBooks[i].getEnjoyed());
            myBooks[i].setEnjoyed(myBooks[indexLeastRecent].getEnjoyed());
            myBooks[indexLeastRecent].setEnjoyed(tempBook.getEnjoyed());

            myBooks[i].Print();
            System.out.println("\n");//test

        }

    }
    
    /*********************************************************************
     * A method, cheapest, that takes an array of items of type Book, 
     * and returns the cheapest book in the array.
     *********************************************************************/
    public static Book cheapest(Book[] myBooks) {
        // add your code here
        int i = 0;
        int j = 0;
        double cheapest = myBooks[0].getPrice();
        int indexCheapest = 0;
        
        // get most recent and swap
        for (i = 1; i < myBooks.length; i++) {
            if (myBooks[i].getPrice() < cheapest) {
                cheapest = myBooks[i].getPrice();
                indexCheapest = i;
            }
        }

        return myBooks[indexCheapest];

    }
    
    /*********************************************************************
     * A method, enjoyed, that takes an array of items of type Book, and 
     * returns the number of books in the array that you enjoyed.
     *********************************************************************/
    public static int enjoyed(Book[] myBooks) {
        // add your code here
        int counter = 0;
        for (int i = 0; i < myBooks.length; i++) {
            if (myBooks[i].getEnjoyed()) {
                counter++;
            }
        }

        return counter;
    }
    
    /*********************************************************************
     * A recursive method, recEnjoyed, that takes an array of items of 
     * type Book and an integer n, and returns the number of books in the 
     * array that you enjoyed, starting at index n in the array.
     *********************************************************************/
    public static int recEnjoyed(Book[] myBooks, int n) {
        // add your code here
        int counter = 0;
        if (myBooks.length == 0) {
            return 0;
        }

        if ( myBooks[n].getEnjoyed() ) {
            counter++;
        }

        return counter + recEnjoyed(myBooks, (n + 1));

    }
    
    /*********************************************************************
     * A method buildLL that takes an array of items of type Book, and 
     * returns a linked list of all the Book items in the array
     *********************************************************************/
    public static BooksLL buildLL(Book[] myBooks) {
        // add your code here
        BooksLL firstBookOfList = new BooksLL(myBooks[0],null);

        BooksLL currentBookOfList = firstBookOfList;

        for (int i = 1; i < myBooks.length; i++) {
            BooksLL newBookOfList = new BooksLL(myBooks[i], null);
            currentBookOfList.setNext(newBookOfList);
            currentBookOfList = newBookOfList;
        }

        return firstBookOfList;

    }

    /*********************************************************************
     * A method chronoLLinsert that takes:
     *  a.	an array A of books; and 
     *  b.	an extra book B, 
     * and returns a linked-list of all of the items in A in chronological 
     * order of their publication date (from oldest to newest) as well as 
     * book B inserted at the right chronological position to ensure that 
     * the resulting list is sorting in ascending chronological order.
     *********************************************************************/
    /*public static void chronoLLinsert(BooksLL myBooks, Book B) {
           // add your code here    
    }*/
    
     /*********************************************************************
     * A main method that allows you to test all above methods.
     *********************************************************************/
    public static void main(String[] args) throws IOException {
        // add your code here
        Scanner scnr = new Scanner(System.in);
        String filename = "";
        int i = 0;

        System.out.println("Enter File Name:");
        filename = scnr.nextLine();

        Book[] myBooks = readFromFile(filename);

        System.out.println("Printing books...\n");
        for (i = 0; i < myBooks.length; i++) {
            myBooks[i].Print();
            System.out.println("\n");
        }

        System.out.println("_____________________");
        System.out.println("Sorting books from oldest to newest...\n");
        sortByPublicationDate(myBooks);

        System.out.println("_____________________");
        System.out.println("Printing cheapest book:\n");
        cheapest(myBooks).Print();

        System.out.println("_____________________");
        System.out.println("Number of enjoyed books: " + enjoyed(myBooks));

        System.out.println("_____________________");
        System.out.println("Number of enjoyed books (recursive): " + enjoyed(myBooks));

        System.out.println("_____________________");
        System.out.println("Building and printing linked list:\n");
        BooksLL myListOfBooks = buildLL(myBooks);
        myListOfBooks.printLL();

        System.out.println("\n_____________________");
        System.out.println("Counting size of linked list:");
        System.out.println(myListOfBooks.sizeLL());

        System.out.println("\n_____________________");
        System.out.println("Counting size of linked list Recursively:");
        System.out.println(myListOfBooks.sizeLLR());

        System.out.println("\n_____________________");
        System.out.println("Adding Tail to myListOfBooks and printing it:");
        BooksLL newFirstListItem = new BooksLL(myBooks[0],null);
        myListOfBooks.addTail(newFirstListItem);
        myListOfBooks.printLL();

        System.out.println("\n_____________________");
        System.out.println("Removing Head to myListOfBooks and printing it:");
        myListOfBooks.removeHead();
        myListOfBooks.printLL();

        //bonus2
        System.out.println("\n_____________________");
        System.out.println("Creating newBookForNth:");
        BooksLL newBookForNth = new BooksLL(myBooks[0],null);
        System.out.println("newBookForNth:\n");
        newBookForNth.printLL();

        System.out.println("Enter nth");
        int nth = scnr.nextInt();
        myListOfBooks.addNth(newBookForNth, nth);
        System.out.println(myListOfBooks.sizeLLR());
        myListOfBooks.printLL();


    }
} 
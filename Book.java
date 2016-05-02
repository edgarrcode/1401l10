public class Book {

    // Attributes... ARE PROVIDED TO YOU:
    private String title;
    private String[] authors;
    private int pages;
    private int pubDate;
    private double price;
    private boolean enjoyed;

    // NOW COMPLETE THE FOLLOWING SECTIONS WITH RELEVANT METHODS
    // Constructors
    public Book () {
    }

    public Book (String theTitle, String[] theAuthors, int thePages, int thePubDate, double thePrice, boolean theEnjoyed) {
        title = theTitle;
        authors = theAuthors;
        pages = thePages;
        pubDate = thePubDate;
        price = thePrice;
        enjoyed = theEnjoyed;
    }

    // Accessors
    public String getTitle() {
        return title;
    }
    public String[] getAuthors() {
        return authors;
    }
    public int getPages() {
        return pages;
    }
    public int getPubDate() {
        return pubDate;
    }
    public double getPrice() {
        return price;
    }
    public boolean getEnjoyed() {
        return enjoyed;
    }

    // Mutators
    public void setTitle(String theTitle) {
        title = theTitle;
    }
    public void setAuthors(String[] theAuthors) {
        authors = theAuthors;
    }
    public void setPages(int thePages) {
        pages = thePages;
    }
    public void setPubDate(int thePubDate) {
        pubDate = thePubDate;
    }
    public void setPrice(double thePrice) {
        price = thePrice;
    }
    public void setEnjoyed(boolean theEnjoyed) {
        enjoyed = theEnjoyed;
    }

    // Print method
    public void Print() {
        String stringPubDate = Integer.toString(pubDate);
        String formattedPubDate = stringPubDate.substring(4,6) + "/" + stringPubDate.substring(6) + "/" + stringPubDate.substring(0,4);

        System.out.println("Book: " + title + ", of " + pages + " pages");
        System.out.println("First published on " + formattedPubDate);
        System.out.println("Price: " + price);
        if (enjoyed) {
            System.out.println("I enjoyed it very much!");
        }
        if (!enjoyed) {
            System.out.println("This book was not so great...");
        }
    }
}
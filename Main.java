package BookStoreLab;

public class Main {

    public static void main(String[] args) {
        Bookstore bookStore = new Bookstore();

        System.out.println("Welcome to " + bookStore.getName());
        // System.out.println(bookStore.getAddressSqft());
        bookStore.address();
        bookStore.getOpenTimes();
        // System.out.println("We have " + bookStore.totalBooks() + " books.");
        bookStore.getBookType();
        bookStore.userTitles();
        // System.out.println(bookStore.getTitles());
    }

}
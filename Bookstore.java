package BookStoreLab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Bookstore {

    /*
     * Name: World Beyond Books Address: 1414 S. Tryon St. Charlotte, NC 28208
     * Square Feet: 975 Has used books?: Yes Open?: Yes Open on Weekends?: No Open
     * on Sundays?: No Daily Opening time/Daily Closing time: 11am-8pm
     */
    private String name = "World Beyond Books";
    private String address = "1414 S. Tryon St. Charlotte, NC 28208";
    private int squareFt = 975;
    private Boolean hasUsedBooks;
    private String daysOpen;
    private String timesOpen;
    private ArrayList<String> titles;

    private Scanner userInput = new Scanner(System.in);

    /*
     * public static void main(String[] args) { storeInfo(); address(); areWeOpen();
     * bookType();
     * 
     * }
     */

    public Bookstore() {
    }

    public Bookstore(String name, String address) {
        this.name = name;
        this.address = address;

        // all other members set here

        // init the array and then load it.
        titles = new ArrayList<String>();
        loadTitles();
    }

    public Bookstore(String name, String address, Boolean hasUsedBooks) {
        this.name = name;
        this.address = address;
        this.hasUsedBooks = hasUsedBooks;
        loadTitles();
    }

    public Bookstore(String name, String address, int squareFt, Boolean hasUsedBooks, String daysOpen, String timesOpen,
            ArrayList<String> titles) {
        this.name = name;
        this.address = address;
        this.squareFt = squareFt;
        this.hasUsedBooks = hasUsedBooks;
        this.daysOpen = daysOpen;
        this.timesOpen = timesOpen;
        this.titles = titles;
        titles = new ArrayList<String>();
        loadTitles();
    }

    public String getName() {
        return name;
    }

    public String getAddressSqft() {
        return address();
    }

    public String getOpenTimes() {
        return areWeOpen();
    }

    public String getBookType() {
        return bookType();
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public int totalBooks() {
        return this.titles.size();
    }

    public String userTitles() {
        return bookTitles();
    }

    public void loadTitles() {
        try {
            Utils.loadStringsToArray(this.titles);
        } catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();

        }
    }

    public String bookTitles() {
        System.out.println("What book are you looking for?");
        String userBook = userInput.next();

        if (titles.contains(userBook.toLowerCase())) {
            System.out.println("A book that we found is: " + titles);
        } else {
            System.out.println("Sorry we don't have that book, want to try another one?");
        }

        return address;
    }

    public String address() {
        System.out.print("Our address is " + address);
        System.out.printf("\nThe store is " + squareFt + " square feet\n");
        return address;
    }

    public String bookType() {
        System.out.println("What type of book are you looking for? 'New' or 'Used'?");
        String userBookType = userInput.next();

        if (userBookType.equalsIgnoreCase("New")) {
            System.out.println("We do have new books!");
        } else if (userBookType.equalsIgnoreCase("Used")) {
            System.out.println("We do have used books!");
        } else {
            System.out.println("Sorry, that's an invalid book type");
        }
        return userBookType;
    }

    public String areWeOpen() {
        System.out.println("Which day do you plan to visit?");
        String openCheck = userInput.next();

        LinkedList<String> openDays = new LinkedList<String>();
        openDays.add("Monday");
        openDays.add("Tuesday");
        openDays.add("Wednesday");
        openDays.add("Thursday");
        openDays.add("Friday");

        String mon = openDays.get(0);
        String tues = openDays.get(1);
        String wed = openDays.get(2);
        String thur = openDays.get(3);
        String fri = openDays.get(4);

        if (openCheck.equalsIgnoreCase(mon) || openCheck.equalsIgnoreCase(tues) || openCheck.equalsIgnoreCase(wed)
                || openCheck.equalsIgnoreCase(thur) || openCheck.equalsIgnoreCase(fri)) {
            System.out.println("Yes, We are open 11am-6pm!");
        } else {
            System.out.println("Sorry, We are closed until Monday at 11am!");
        }
        // System.out.println(openCheck);
        return openCheck;
    }
}
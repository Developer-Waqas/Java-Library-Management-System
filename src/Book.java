import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


// Book Class
public class Book {
    private String bookID;
    private String bookTitle;
    private String bookAuthor;
    private boolean isIssued;
    private LocalDate dueDate; 

    public Book(String bookId, String title, String author) {
        this.bookID = bookId;
        this.bookTitle = title;
        this.bookAuthor = author;
        this.isIssued = false;
        this.dueDate = null;
    }

    public String getBookId() {
        return bookID;
    }

    public String getTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return bookAuthor;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            dueDate = LocalDate.now().plusDays(14); // 14-day due period
            System.out.println("✅ " + bookTitle + " has been issued.");
        } else {
            System.out.println("✅ " + bookTitle + " is already issued.\nDue Date: \" + dueDate");
        }
    }

    public void returnBook() {
        if (isIssued) {
            LocalDate today = LocalDate.now();
            if (today.isAfter(dueDate)) {
                long daysLate = ChronoUnit.DAYS.between(dueDate, today);
                double fine = daysLate * 2.0; // $2 per day late fee
                System.out.println(
                        "😥 Book returned late! You were " + daysLate + " days late. Fine: $" + fine + " 💵");
            } else {
                System.out.println("✅ Book returned on time.");
            }
            isIssued = false;
            dueDate = null;
        } else {
            System.out.println("❌ This book was not issued.");
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookID + "\n, Title: " + bookTitle + "\n, Author: " + bookAuthor +
                "\n, Issued: " + (isIssued ? "Yes" : "No") +
                (isIssued ? ", Due Date: " + dueDate : ""));
    }
}

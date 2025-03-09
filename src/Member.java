import java.util.ArrayList;
import java.util.List;

// Member class
public class Member {
    private String memberID;
    private String memberName;
    private List<Book> issuedBooks;

    public Member(String memberId, String name) {
        this.memberID = memberId;
        this.memberName = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getMemberId() { return memberID; }

    public String getName() {
        return memberName;
    }

    // Method for issuing books 
     void issueBook(Book book) {
        if (!book.isIssued()) {
            book.issueBook();
            issuedBooks.add(book);
        } else {
            System.out.println("✅ This book is already issued.");
        }
    }

    // Method for Returning a Book
    public void returnBook(Book book) {

        // this condition check whether member has this book
        if (issuedBooks.contains(book)) {
            book.returnBook();
            issuedBooks.remove(book);
            System.out.println("✅ Book returned successfully.");
        } else {
            System.out.println("✅ This member did not borrow this book.");
        }
    }
    

    // Method for displaying member details
    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberID + "\n, Name: " + memberName);
        System.out.print("✨ Issued Books: ");

        // This condition for to check whether this member has any issued book or not
        if (issuedBooks.isEmpty()) {
            System.out.println("❌ None");
        } else {
            for (Book book : issuedBooks) {
                System.out.print(book.getTitle() + " (Due: " + book.getDueDate() + ") | ");
            }
            System.out.println();
        }
    }
}

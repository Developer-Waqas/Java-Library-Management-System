import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("❌ Book added: " + book.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("❌ Member added: " + member.getName());
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("\n❌ No books available. ");
            return;
        }
        System.out.println("\n✨ Library Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("\n❌ No members registered.");
            return;
        }
        System.out.println("\n✨ Library Members: ✨");
        for (Member member : members) {
            member.displayMemberInfo();
        }
    }

    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}

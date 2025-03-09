import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n✨ Library Management System ✨");
            System.out.println("1. Display Books");
            System.out.println("2. Display Members");
            System.out.println("3. Add Member");
            System.out.println("4. Add Book");
            System.out.println("5. Issue a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Exit");
            System.out.print("🎲 Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                library.displayAllBooks();
            } else if (choice == 2) {
                library.displayAllMembers();
            } else if (choice == 3) {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine();
                System.out.print("Enter Member Name: ");
                String memberName = scanner.nextLine();
                library.addMember(new Member(memberId, memberName));
                System.out.println("✅ New member added successfully!");
            } else if (choice == 4) {
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine();
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(bookId, title, author));
            } else if (choice == 5) {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine();
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine();
                Member member = library.findMemberById(memberId);
                Book book = library.findBookById(bookId);
                if (member != null && book != null) {
                    member.issueBook(book);
                } else {
                    System.out.println("❌ Invalid Member ID or Book ID.");
                }
            } else if (choice == 6) {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine();
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine();

                Member member = library.findMemberById(memberId);
                Book book = library.findBookById(bookId);

                if (member != null && book != null) {
                    member.returnBook(book); // 
                } else {
                    System.out.println("❌ Invalid Member ID or Book ID.");
                }
            }

            else if (choice == 7) {
                System.out.println("Good Bye! 🙋‍♂️");
                break;
            } else {
                System.out.println("❌ Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}

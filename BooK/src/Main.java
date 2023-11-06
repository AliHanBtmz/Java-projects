import java.util.*;

public class Main {
    public static void main(String[] args) {

        Book book1=new Book("Tel ali",120,"ali",2000);
        Book book2=new Book("Cingöz recai",210,"berkay",2015);
        Book book3=new Book("Alice Harikkalarda",320,"furkan",2020);
        Book book4=new Book("Yenilmezler",100,"efe",2010);
        Book book5=new Book("Zaferdeki utanç",550,"hasan",2003);

        Set<Book> listSet=new TreeSet<>();

        listSet.add(book1);
        listSet.add(book2);
        listSet.add(book3);
        listSet.add(book4);
        listSet.add(book5);


        Set <Book> finalStatment=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                return Integer.compare(o1.getPageNum(),o2.getPageNum());
            }
        });


        finalStatment.addAll(listSet);

        System.out.println("\nBooks are sorted by name:");
        for (Book book : listSet) {
            System.out.println(book.getName());
        }

        System.out.println("\n------------------------------------------");
        // Print page count order
        System.out.println("\nBooks are sorted by page number:");
        for (Book book : finalStatment) {
            System.out.println(book.getName() + " - Page number: " + book.getPageNum());
        }
    }
}
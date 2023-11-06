public class Book implements Comparable<Book> {
     private String name;
     private int pageNum;
     private String writer;
     private int date;

    public String getName() {
        return name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public String getWriter() {
        return writer;
    }

    public int getDate() {
        return date;
    }

    public Book(String name, int pageNum, String writer, int date) {
        this.name = name;
        this.pageNum = pageNum;
        this.writer = writer;
        this.date = date;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }
}

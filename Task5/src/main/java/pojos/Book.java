package pojos;

public class Book extends Magazine {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    @Override
    public String toString() {
        return super.toString() + "Book author=" + author;
    }
}



public class P2for2022 {
    public static void main(String[] args){
        Textbook bio2015 = new Textbook("Biology", 49.95, 2);
        Textbook bio2019 = new Textbook("Biology", 39.95, 3);
        bio2015.getBookInfo();
        bio2019.getBookInfo();
        bio2015.canSubstituteFor(bio2019);

    }
}

class Book{
    private String title;
    private double price;

    public Book(String title, double price){
        this.title = title;
        this.price = price;
    }

    public String getTitle(){
        return title;
    }

    public String getBookInfo(){
        return title + "--" + price;
    }

}
class Textbook extends Book {
    private int edition;

    public Textbook(String title, double price, int edition) {
        super(title, price);
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public String getBookInfo() {
        System.out.println(super.getBookInfo() + "--" + edition);
        return super.getBookInfo() + "--" + edition;
    }

    public boolean canSubstituteFor(Textbook otherTextbook) {
        System.out.print(getTitle().equals(otherTextbook.getTitle()) && getEdition() >= otherTextbook.getEdition());
        return getTitle().equals(otherTextbook.getTitle()) && getEdition() >= otherTextbook.getEdition();
    }

}
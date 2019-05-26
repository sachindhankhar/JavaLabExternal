package q2_bookDb;

public class Book implements Comparable<Book>{
	String title,author,publisher;
	double price;
	Book(String title,String author,String publisher,Double price){
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
	}
	@Override
	public int compareTo(Book bk) {
		return (this.price>bk.price ? 1:((this.price==bk.price) ? 0:-1));
	}
	@Override
	public String toString() {
		return ("title->"+this.title+"\tAuthor->"+this.author+"\tpublisher->"+this.publisher+"\tprice->"+this.price);
	}
}

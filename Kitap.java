package KitapciOtomasyon;

public class Kitap {
	String bookName;
	int id = 1000;
	String autorName;
	int price;
	
	public Kitap(int id,String bookName, String autorName, int price) {
		this.id = id;
		this.bookName = bookName;
		this.autorName = autorName;
		this.price = price;
	}
}

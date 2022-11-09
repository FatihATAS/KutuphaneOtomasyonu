package KitapciOtomasyon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kitapci {
	Scanner scan = new Scanner(System.in);
	ArrayList<Kitap> bookList = new ArrayList<>();
	static int sayac = 0;
	public void kitapEkle() {
		System.out.print("Kitap adını giriniz : ");
		String kitapName = scan.next();
		System.out.print("Yazar bilgisini giriniz : ");
		String yazar=scan.next();
		System.out.print("Kitap fiyatını giriniz : ");
		int fiyat = scan.nextInt();
		Kitap kt1 = new Kitap((sayac+1000),kitapName, yazar, fiyat);
		bookList.add(kt1);
		sayac++;
	}
	public void tumKitaplariListele() {
		System.out.println("***\tKitap Listemiz\t***\nK.No\tKitap Adı\t\tYazar Adı\tKitap Fiyatı");
		for(int i = 0; i<bookList.size();i++) {
			System.out.printf("%-6d\t%-20S\t%-15S\t%7dTL\n",bookList.get(i).id,bookList.get(i).bookName,bookList.get(i).autorName,bookList.get(i).price);
		}
	}
	public void kitapSil() {
		System.out.println("Silinecek kitap numarasını giriniz : ");
		int kitapNo = scan.nextInt();
		while(kitapNo-1000<0 || kitapNo-1000>bookList.size()) {
			System.out.println("Yanlış numara girdiniz, Tekrar deneyiniz");
			kitapSil();
		}
		bookList.remove(kitapNo-1000);
	}
	public Kitap numaraIleKitapGoruntule(int kitapId) {
		int kitapIndex = -1;
		for(int i = 0;i<bookList.size();i++) {
			if(bookList.get(i).id==kitapId) {
				kitapIndex = i;
			}
		}
		if(kitapIndex==-1) {
			System.out.println("Yanlış işlem yaptınız tekrar kitap numarasını girerek deneyiniz : ");
			kitapIndex = scan.nextInt();
			numaraIleKitapGoruntule(kitapIndex);
		}
		return bookList.get(kitapIndex);
	}
	public Kitap bilgiIleKitapGoruntule(String kitapAdi) {
		int kitapIndex = -1;
		for(int i = 0;i<bookList.size();i++) {
			if(kitapAdi.equalsIgnoreCase(bookList.get(i).autorName) || kitapAdi.equalsIgnoreCase(bookList.get(i).bookName)) {
				kitapIndex = i;
			}
		}
		if(kitapIndex==-1) {
			System.out.println("Yanlış işlem yaptınız tekrar kitap bilgisi girerek deneyiniz : ");
			String str = scan.next();
			bilgiIleKitapGoruntule(str);
		}
		return bookList.get(kitapIndex);
	}
	public void menuYazdir() {
		System.out.print("=== Kitapçı Dükkanımıza Hoş Geldiniz ===\nLütfen Seçiminizi yapınız\n[1] - Kitap ekle\n[2] - Numara ile kitap al\n[3] - Bilgi ile Kitap al\n[4] - Numara ile kitap sil\n[5] - Tüm kitapları göster\n[6] - Çıkış yap\nSeçiminiz =  ");
	}
	public void kitapSat(Kitap kitap) {
		System.out.println("Almak istediğiniz kitabın ücreti " + kitap.price + " TL dir\nLütfen tutar giriniz : ");
		int alinanPara = scan.nextInt();
		while(alinanPara<kitap.price) {
			System.out.println("Tutar yetersiz, Lütfen tutar ilave yapınız : ");
			int ilavePara = scan.nextInt();
			alinanPara+=ilavePara;
		}
		System.out.println("Hayırlı olsun, biraz zorla sattık gibi ama okumaktan zarar gelmez efendim :D,\nPara üstünü TİPBOX a attım, bilginiz olsun :D ");
		bookList.remove(kitap);
	}
}

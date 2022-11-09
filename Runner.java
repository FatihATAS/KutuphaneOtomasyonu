package KitapciOtomasyon;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Kitapci kitapci = new Kitapci();
		char devam = 'E';
		do {
			kitapci.menuYazdir();
			int karar = scan.nextInt();
			switch(karar) {
			case 1 : kitapci.kitapEkle(); break;
			case 2 : 
				System.out.println("Almak istediğiniz kitaba ait kitap numarası giriniz : ");
				int kitapNo=scan.nextInt();
				kitapci.kitapSat(kitapci.numaraIleKitapGoruntule(kitapNo));
				break;
			case 3 : 
				System.out.println("Almak istediğiniz kitaba ait yazar veya Kitap adı giriniz : ");
				String kitapBilgi = scan.next();
				kitapci.kitapSat(kitapci.bilgiIleKitapGoruntule(kitapBilgi));
				break;
			case 4 : 
				kitapci.kitapSil();
				break;
			case 5 :
				kitapci.tumKitaplariListele();
				break;
			case 6 : System.out.println("iyi günler dileriz !");
			break;
			default : 
				System.out.println("Yanlış seçim yaptınız, tekrar deneyiniz!");
				karar = scan.nextInt();
			}
			System.out.print("İşleme devam etmek ister misiniz ? <E / H>");
			devam = scan.next().toUpperCase().charAt(0);
		}while(devam=='E');
		System.out.println("İyi günler dileriz efendim :D ");
	}
}

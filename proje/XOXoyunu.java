import java.util.Scanner;
import java.util.Random;

public class XOXoyunu {


	public static void main(String[] args) {

		Scanner istenen = new Scanner(System.in);

		char[][] yuzey = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		tahtaYuzeyi(yuzey);

		while (true) {
			kullaniciHareketi(yuzey, istenen);
			if (oyunBittimi(yuzey)) {
				break;
			}
			tahtaYuzeyi(yuzey);

			bilgisayarSirasi(yuzey);
			if (oyunBittimi(yuzey)) {
				break;
			}
			tahtaYuzeyi(yuzey);
		}
		istenen.close();

	}

	private static boolean oyunBittimi(char[][] yuzey) {
		if (yarismaciKazandi(yuzey, 'X')) {
			tahtaYuzeyi(yuzey);
			System.out.println("Yarışmacı Kazandı.");
			return true;
		}

		if (yarismaciKazandi(yuzey, 'O')) {
			tahtaYuzeyi(yuzey);
			System.out.println("Bilgisayar kazandı.");
			return true;
		}

		for (int i = 0; i < yuzey.length; i++) {
			for (int j = 0; j < yuzey[i].length; j++) {
				if (yuzey[i][j] == ' ') {
					return false;
				}
			}
		}
		tahtaYuzeyi(yuzey);
		System.out.println("Maç berabere bitti.");
		return true;
	}

	private static boolean yarismaciKazandi(char[][] yuzey, char sembol) {
		if ((yuzey[0][0] == sembol && yuzey[0][1] == sembol && yuzey[0][2] == sembol) ||
		    (yuzey[1][0] == sembol && yuzey[1][1] == sembol && yuzey[1][2] == sembol) ||
	   	    (yuzey[2][0] == sembol && yuzey[2][1] == sembol && yuzey[2][2] == sembol) ||

		    (yuzey[0][0] == sembol && yuzey[1][0] == sembol && yuzey[2][0] == sembol) ||
		    (yuzey[0][1] == sembol && yuzey[1][1] == sembol && yuzey[2][1] == sembol) ||
			(yuzey[0][2] == sembol && yuzey[1][2] == sembol && yuzey[2][2] == sembol) ||

			(yuzey[0][0] == sembol && yuzey[1][1] == sembol && yuzey[2][2] == sembol) ||
			(yuzey[0][2] == sembol && yuzey[1][1] == sembol && yuzey[2][0] == sembol)) {
			return true;
		}
		return false;
	}

	private static void bilgisayarSirasi(char[][] yuzey) {
		Random rastgele = new Random();
		int bilgisayarHareketi;
		while (true) {
			bilgisayarHareketi = rastgele.nextInt(9) + 1;
			if (kutuMusaitmi(yuzey, Integer.toString(bilgisayarHareketi))) {
				break;
			}
		}
		System.out.println("Bilgisayar Hareketi " + bilgisayarHareketi);
		yerHareketi(yuzey, Integer.toString(bilgisayarHareketi), 'O');
	}

	private static boolean kutuMusaitmi(char[][] yuzey, String kutu) {
		switch (kutu) {
		case "1":
			return (yuzey[0][0] == ' ');

		case "2":
			return (yuzey[0][1] == ' ');

		case "3":
			return (yuzey[0][2] == ' ');

		case "4":
			return (yuzey[1][0] == ' ');

		case "5":
			return (yuzey[1][1] == ' ');

		case "6":
			return (yuzey[1][2] == ' ');

		case "7":
			return (yuzey[2][0] == ' ');

		case "8":
			return (yuzey[2][1] == ' ');

		case "9":
			return (yuzey[2][2] == ' ');

		default:
			return false;
		}
	}

	private static void kullaniciHareketi(char[][] yuzey, Scanner istenen) {
		String kullaniciGiris;
		while (true) {
			System.out.println("Hangi numaraya oynamak istediğinizi giriniz. (1-9)");
			kullaniciGiris = istenen.nextLine();
			if (kutuMusaitmi(yuzey, kullaniciGiris)) {
				break;
			}

			else {
				System.out.println(kullaniciGiris + "Geçerli bir hareket hamlesi değil.");
			}
		}
		yerHareketi(yuzey, kullaniciGiris, 'X');
	}

	private static void yerHareketi(char[][] yuzey, String kutu, char sembol) {
		switch (kutu) {
		case "1":
			yuzey[0][0] = sembol;
			break;

		case "2":
			yuzey[0][1] = sembol;
			break;

		case "3":
			yuzey[0][2] = sembol;
			break;

		case "4":
			yuzey[1][0] = sembol;
			break;

		case "5":
			yuzey[1][1] = sembol;
			break;

		case "6":
			yuzey[1][2] = sembol;
			break;

		case "7":
			yuzey[2][0] = sembol;
			break;

		case "8":
			yuzey[2][1] = sembol;
			break;

		case "9":
			yuzey[2][2] = sembol;
			break;

		default:
			System.out.println("Lütfen belirtilen numara aralığında seçtiğinizden emin olunuz.");
		}
	}

	private static void tahtaYuzeyi(char[][] yuzey) {
		System.out.println(yuzey[0][0] + "|" + yuzey[0][1] + "|" + yuzey[0][2]);
		System.out.println("-+-+-");
		System.out.println(yuzey[1][0] + "|" + yuzey[1][1] + "|" + yuzey[1][2]);
		System.out.println("-+-+-");
		System.out.println(yuzey[2][0] + "|" + yuzey[2][1] + "|" + yuzey[2][2]);
	}
}
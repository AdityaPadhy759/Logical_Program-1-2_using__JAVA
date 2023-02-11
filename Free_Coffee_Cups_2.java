//FREE COFFEE CUPS
package Program_100;
import java.util.Scanner;
public class Free_Coffee_Cups_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Coffee: ");
		int no_cfe = sc.nextInt();
		int tot_cfe = (no_cfe / 6) + no_cfe;
		System.out.println("Number of Coffee you get: "+tot_cfe);
	}

}

import java.time.LocalDate;

public class LocalDateDemo {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getMonth());
		System.out.println(now.getYear());
	}
}

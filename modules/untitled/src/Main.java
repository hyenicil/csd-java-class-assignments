import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CountStringTest.run();
    }
}


class CountStringTest {

    public static void run() {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("Birinci yazıyı giriniz:");
            String s1 = kb.nextLine();

            if ("elma".equals(s1))
                break;

            System.out.print("İkinci yazıyı giriniz:");
            String s2 = kb.nextLine();

            System.out.printf("Count:%d%n", CountStringUtil.countString(s1, s2));
            System.out.printf("Count:%d%n", CountStringUtil.countStringIgnoreCase(s1, s2));
        }
    }
}

class CountStringUtil {
    public static int countString(String s1, String s2)
    {
        int count = 0;
        /*for(int i = 0; i < s1.length(); i++){
            if(s1.indexOf(s2, i) > -1 ) {
                count++;
            }}*/
        int index = -1;
        while ((index = s1.indexOf(s2, index + 1)) != -1)
            count++;

        return count;
    }


    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }
}
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradePointAverageTest.run();
    }
}
class GradePointAverageTest{

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Şube sayı giriniz: ");
            int grande = Integer.parseInt(scanner.nextLine());
            System.out.print("Öğrenci sayısı giriniz: ");
            int studentCount = Integer.parseInt(scanner.nextLine());
            Grandes[] grandesList = GradePointUtil.createGrande(grande, studentCount);
            for(Grandes grandes : grandesList) {
                GrandeUtil.averageScore(grandes);
                GrandeUtil.maxScore(grandes);
                GrandeUtil.minScore(grandes);
                GrandeUtil.print(grandes);
            }
            return;
         }
    }
}

class Grandes {
    int[] studentAndNotes;
    int max;
    int min;
    int average;

    public Grandes(int[] studentNotes) {
        studentAndNotes = studentNotes;
    }
}

class GradePointUtil {
    public static Grandes[] createGrande(int grande, int count ) {
        Random rand = new Random();
        Grandes[] grandes = new Grandes[count];
        for(int i = 0; i < count; i++) {
            grandes[i] = new Grandes(new int[count]);
            for (int j = 0; j < grandes[i].studentAndNotes.length; j++)
                grandes[i].studentAndNotes[j] = rand.nextInt(0, 100);
        }
        return grandes;
    }
}

class GrandeUtil {
    public static void maxScore(Grandes grandes) {
        int maxScore = 0;
            for(int score:grandes.studentAndNotes)
                if(score > maxScore)
                    maxScore = score;
        grandes.max = maxScore;
    }

    public static void minScore(Grandes grandes) {
        int minScore = grandes.studentAndNotes[0];
        for(int score: grandes.studentAndNotes)
                if(score < minScore)
                    minScore = score;
        grandes.min = minScore;
    }

    public static void averageScore(Grandes grandes) {
        int count = grandes.studentAndNotes.length;
        int totalScore = 0;
        for(int score: grandes.studentAndNotes)
                totalScore += score;
        grandes.average = totalScore / count;
    }

    public static void print (Grandes grandes) {
        System.out.println("En yüksek Öğrenci Puanı: " + grandes.max);
        System.out.println("En düşük Öğrenci Puanı: " + grandes.min);
        System.out.println("Ortalama Öğrenci Puanı: " + grandes.average);
        System.out.println("=============================");
    }
}
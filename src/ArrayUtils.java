import java.awt.desktop.AboutEvent;

public class ArrayUtils {
    public static double avg_ar(int[] array) {
        double sum = 0, count = 0;
        for (int num : array) {
            if (num > 150) {
                sum += num;
                count++;
            }
        }
        return sum / count;
    }

    public static double avg_geo(int[] array) {
        double multiply = 1, count = 0;
        for (int num : array) {
            if (num % 2 == 1) {
                multiply *= num;
                count++;
            }
        }
        return Math.pow(multiply, (1.0 / count));
    }
}

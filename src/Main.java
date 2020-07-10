import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] inputValue = input();
        int[] evenValues = filterEvenValues(inputValue);
        int[] oddValues = filterOddValues(inputValue);
        showResult(evenValues, oddValues);
    }

    private static int[] input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input your value: ");
        char[] charArray = in.next().toUpperCase().toCharArray();
        int[] result = new int[charArray.length];
        Arrays.setAll(result, i -> (int)charArray[i]);
        return result;
    }

    private static int[] filterEvenValues(int[] inputValue) {
        return Arrays.stream(inputValue)
                .distinct()
                .filter(n -> n % 2 == 0)
                .filter(n -> n <= 127)
                .toArray();
    }

    private static int[] filterOddValues(int[] inputValue) {
        return Arrays.stream(inputValue)
                .distinct()
                .filter(n -> n % 2 != 0)
                .filter(n -> n <= 127)
                .toArray();
    }

    private static void showResult(int[] evenValues, int[] oddValues) {
        System.out.println("Even values: ");
        showValues(evenValues);
        System.out.println("* * * * * * *");
        System.out.println("Odd values: ");
        showValues(oddValues);
        System.out.println("* * * * * * *");
        System.out.println("Difference: " + findDifference(evenValues, oddValues));
    }

    private static void showValues(int[] values) {
        for (int v : values) {
            System.out.println((char)v + " -> ASCII " + v);
        }
    }

    private static int findDifference(int[] evenValues, int[] oddValues) {
        int sumEvenValues = Arrays.stream(evenValues).sum();
        int sumOddValues = Arrays.stream(oddValues).sum();
        return Math.abs(sumEvenValues - sumOddValues);
    }
}

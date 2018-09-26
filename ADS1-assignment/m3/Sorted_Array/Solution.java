/**
 * @author Praveen
 */
/**
 * { Importing Package }.
 */
import java.util.Scanner;
/**
 * { Importing package }.
 */
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { Main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int[] ar1 = new int[n1];
        int[] ar2 = new int[n2];
        String[] s1 = scan.nextLine().split(",");
        System.out.println(Arrays.toString(s1));
        String[] s2 = scan.nextLine().split(",");
        System.out.println(Arrays.toString(s2));
        for (int i = 0; i < n1; i++) {
            ar1[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < n2; i++) {
            ar2[i] = Integer.parseInt(s2[i]);
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] fin = new int[n1 + n2];
        while (k < n1 + n2) {
            if ((i < n1) && (j < n2)) {
                if ((ar1[i] < ar2[j])) {
                    fin[k] = ar1[i];
                    i++;
                    k++;
                } else if ((ar1[i] > ar2[j])) {
                    fin[k] = ar2[j];
                    j++;
                    k++;
                } else {
                    fin[k] = ar2[i];
                    i++;
                    k++;
                    fin[k] = ar2[j];
                    j++;
                    k++;
                }
            } else {
                break;
            }
        }
        if (i < n1) {
            while (i < n1) {
                fin[k] = ar1[i];
                i++;
                k++;
            }
        }
        if (j < n2) {
            while (j < n2) {
                fin[k] = ar2[j];
                j++;
                k++;
            }
        }
        for (int l = 0; l < fin.length - 1; l++) {
            System.out.print(fin[l] + ",");
        }
        System.out.print(fin[fin.length - 1]);
    }
}
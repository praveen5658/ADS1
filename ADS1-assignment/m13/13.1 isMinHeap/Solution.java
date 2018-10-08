
/**
 * { Importing Scanner class }.
 */
import java.util.Scanner;
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
     * { Main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        // String[] input = scan.nextLine().split(" ");
        String type = scan.nextLine();
        String[] input;
        int testcases = Integer.parseInt(scan.nextLine());
        int k = 0;
        switch (type) {
        case "String":
            while (testcases > 0) {
                k = 0;
                input = scan.nextLine().split(",");
                if (input[0].equals("")) {
                    System.out.println("false");
                } else {
                    MinHeap<String> mh = new MinHeap<>(input.length);
                    for (int i = 0; i < input.length; i++) {
                        if (!(mh.insert(input[i]))) {
                            System.out.println("false");
                            k++;
                            break;
                        }
                    }
                    if (k == 0) {
                        System.out.println("true");
                    }
                }
                testcases--;
            }
            break;
        case "Integer":
            while (testcases > 0) {
                k = 0;
                input = scan.nextLine().split(",");
                if (input[0].equals("")) {
                    System.out.println("false");
                } else {
                    MinHeap<Integer> mh = new MinHeap<>(input.length);
                    for (int i = 0; i < input.length; i++) {
                        if (!(mh.insert(Integer.parseInt(input[i])))) {
                            System.out.println("false");
                            k++;
                            break;
                        }
                    }
                    if (k == 0) {
                        System.out.println("true");
                    }
                }
                testcases--;
            }
            break;
        case "Double":
            while (testcases > 0) {
                k = 0;
                input = scan.nextLine().split(",");
                if (input[0].equals("")) {
                    System.out.println("false");
                } else {
                    MinHeap<Double> mh = new MinHeap<>(input.length);
                    for (int i = 0; i < input.length; i++) {
                        if (!(mh.insert(Double.parseDouble(input[i])))) {
                            System.out.println("false");
                            k++;
                            break;
                        }
                    }
                    if (k == 0) {
                        System.out.println("true");
                    }
                }
                testcases--;

            }
            break;
        case "Float":
            while (testcases > 0) {
                k = 0;
                input = scan.nextLine().split(",");
                if (input[0].equals("")) {
                    System.out.println("false");
                } else {
                    MinHeap<Float> mh = new MinHeap<>(input.length);
                    for (int i = 0; i < input.length; i++) {
                        if (!(mh.insert(Float.parseFloat(input[i])))) {
                            System.out.println("false");
                            k++;
                            break;
                        }
                    }
                    if (k == 0) {
                        System.out.println("true");
                    }
                }
                testcases--;
            }
            break;
        default:
            break;
        }
    }
}

/**
 * { Scanner }.
 */
import java.util.Scanner;
/**
 * { Arrays }.
 */
class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    protected AddLargeNumbers() {

    }
    /**
     * { Numbers to Digits }.
     *
     * @param      number  The number
     *
     * @return     { LinkedList }.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList l = new LinkedList();
        char[] ar = number.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            l.addNumber(Character.getNumericValue(ar[i]));
        }
        return l;
    }
    /**
     * { Digits to Numners to List }.
     *
     * @param      list  The list
     *
     * @return     {String}.
     */
    public static String digitsToNumberList(final LinkedList list) {
        String s = "";
        while (!(list.isEmpty())) {
            s = Integer.toString(list.popNumber()) + s;
        }
        return s;
    }
    /**
     * { digits to number }.
     *
     * @param      list  The list
     *
     * @return     { String }.
     */
    public static String digitsToNumber(final LinkedList list) {
        String s = "";
        while (!(list.isEmpty())) {
            s += Integer.toString(list.popNumber());
        }
        return s;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { List }.
     */
    public static LinkedList addLargeNumbers(
        final LinkedList list1, final LinkedList list2) {
        int n1, n2, sum;
        final int ten = 10;
        final int nine = 9;
        LinkedList result = new LinkedList();
        if (list1.size() == list2.size()) {
            while ((!(list1.isEmpty())) && (!(list2.isEmpty()))) {
                sum = 0;
                n1 = list1.popNumber();
                n2 = list2.popNumber();
                sum = n1 + n2;
                if ((sum > nine) && (list1.size() > 0)) {
                    list1.head.data += 1;
                    result.addNumber(sum % ten);
                } else if ((sum > nine) && (list1.size() == 0)) {
                    result.addNumber(sum);
                } else {
                    result.addNumber(sum);
                }
            }
        } else if (list1.size() > list2.size()) {
            while ((!(list2.isEmpty()))) {
                sum = 0;
                n1 = list1.popNumber();
                n2 = list2.popNumber();
                sum = n1 + n2;
                if ((sum > nine) && (list1.size() > 0)) {
                    list1.head.data += 1;
                    result.addNumber(sum % ten);
                } else if ((sum > nine) && (list2.size() == 0)) {
                    result.addNumber(sum % ten);
                    list1.head.data += 1;
                } else {
                    result.addNumber(sum);
                }
            }
            while ((!(list1.isEmpty()))) {
                n1 = list1.popNumber();
                result.addNumber(n1);
            }
        } else {
            while ((!(list1.isEmpty()))) {
                sum = 0;
                n1 = list1.popNumber();
                n2 = list2.popNumber();
                sum = n1 + n2;
                if ((sum > nine) && (list1.size() > 0)) {
                    list1.head.data += 1;
                    result.addNumber(sum % ten);
                } else if ((sum > nine) && (list1.size() == 0)) {
                    result.addNumber(sum % ten);
                    list2.head.data += 1;
                } else {
                    result.addNumber(sum);
                }
            }
            while ((!(list2.isEmpty()))) {
                n1 = list2.popNumber();
                result.addNumber(n1);
            }
        }
        return result;

    }
}
/**
 * Class for solution.
 */
final public class Solution {
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
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumberList(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumberList(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(
                                    pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default :
            break;
        }
    }
}


import java.util.Scanner;
import java.util.Arrays;
class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList l = new LinkedList();
		char[] ar = number.toCharArray();
		for (int i = 0; i < ar.length; i++) {
			l.addNumber(Character.getNumericValue(ar[i]));
		}
		return l;
	}

	public static String digitsToNumberList(LinkedList list) {
		String s = "";
		while (!(list.isEmpty())) {
			s = Integer.toString(list.popNumber()) + s;
		}
		return s;
	}
	public static String digitsToNumber(LinkedList list) {
		String s = "";
		while (!(list.isEmpty())) {
			s += Integer.toString(list.popNumber());
		}
		return s;
	}

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		int n1, n2, sum;
		LinkedList result = new LinkedList();
		if (list1.size() == list2.size()) {
			while ((!(list1.isEmpty())) && (!(list2.isEmpty()))) {
				sum = 0;
				n1 = list1.popNumber();
				n2 = list2.popNumber();
				sum = n1 + n2;
				if ((sum > 9) && (list1.size() > 0)) {
					list1.head.data += 1;
					result.addNumber(sum % 10);
				} else if ((sum > 9) && (list1.size() == 0)) {
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
				if ((sum > 9) && (list1.size() > 0)) {
					list1.head.data += 1;
					result.addNumber(sum % 10);
				} else if ((sum > 9) && (list2.size() == 0)) {
					result.addNumber(sum % 10);
					list1.head.data += 1;
				} else {
					result.addNumber(sum);
				}
			}
			while((!(list1.isEmpty()))) {
				n1 = list1.popNumber();
				result.addNumber(n1);
			}
		} else {
			while ((!(list1.isEmpty()))) {
				sum = 0;
				n1 = list1.popNumber();
				n2 = list2.popNumber();
				sum = n1 + n2;
				if ((sum > 9) && (list1.size() > 0)) {
					list1.head.data += 1;
					result.addNumber(sum % 10);
				} else if ((sum > 9) && (list1.size() == 0)) {
					result.addNumber(sum % 10);
					list2.head.data += 1;
				} else {
					result.addNumber(sum);
				}
			}
			while((!(list2.isEmpty()))) {
				n1 = list2.popNumber();
				result.addNumber(n1);
			}
		}
		return result;

	}
}

public class Solution {
	public static void main(String[] args) {
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
			LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			System.out.println(AddLargeNumbers.digitsToNumber(result));
			break;
		}
	}

}
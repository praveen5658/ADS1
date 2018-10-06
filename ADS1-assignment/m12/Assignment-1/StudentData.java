import java.util.Scanner;
class StudentData {
	private String name;
	private String dob;
	private int subject1marks;
	private int subject2marks;
	private int subject3marks;
	private int totalmarks;
	private String category;
	private String[] input;
	protected StudentData(final Scanner scan) {
		input = scan.nextLine().split(",");
		final int two = 2;
		final int three = 3;
		final int four = 4;
		final int five = 5;
		final int six = 6;
		name = input[0];
		dob = input[1];
		subject1marks = Integer.parseInt(input[two]);
		subject2marks = Integer.parseInt(input[three]);
		subject3marks = Integer.parseInt(input[four]);
		totalmarks = Integer.parseInt(input[five]);
		category = input[six];
	}
	public String getname() {
		return name;
	}
	public String getdob() {
		return dob;
	}
	public int getsubject1marks() {
		return subject1marks;
	}
	public int getsubject2marks() {
		return subject2marks;
	}
	public int getsubject3marks() {
		return subject3marks;
	}
	public int gettotalmarks() {
		return totalmarks;
	}
	public String getcategory() {
		return category;
	}
	public String toString() {
		String s = name + "," + Integer.toString(totalmarks) + "," + category;
		return s;
	}
}
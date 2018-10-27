import java.util.Scanner;
public class Solution{
	public static void main(final String[] args){
		Scanner scan = new Scanner(System.in);
		int insertoperations = Integer.parseInt(scan.nextLine());
		RedBlackBst rbst = new RedBlackBst();
		String[] input;
		for(int i = 0; i< insertoperations; i++){
			input = scan.nextLine().split(",");
			rbst.put(new Student(Integer.parseInt(input[0]), input[1], Double.parseDouble(input[2])), i);
		}
		int queries = Integer.parseInt(scan.nextLine());
		for(int i = 0; i< queries; i++){
			input = scan.nextLine().split(" ");
			Student s = rbst.get(Integer.parseInt(input[1]));
			System.out.println(s.getname());
		}
	}
}
class Student implements Comparable<Student>{
	private String name;
	private int rollno;
	private double marks;
	protected Student(final int r, final String na, final double m){
		name = na;
		rollno = r;
		marks = m;
	}
	public String getname(){
		return name;
	}
	public int getrollno(){
		return rollno;
	}
	public double getmarks(){
		return marks;
	}
	public int compareTo(final Student other){
		return this.rollno - other.rollno;
	}
	public int com(final int ro){
		return ro - this.rollno;
	}
	public String toString(){
		return Integer.toString(rollno) + ","+name + ","+Double.toString(marks);
	}
}
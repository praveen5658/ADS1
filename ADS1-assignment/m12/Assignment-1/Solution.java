import java.util.Scanner;
final class Solution{
	private Solution(){

	}
	public static void main(final String[] args){
		Scanner scan = new Scanner(System.in);
		int studentsnumber = Integer.parseInt(scan.nextLine());
		int totalvaccancies = Integer.parseInt(scan.nextLine());
		int unreservedvaccancies= Integer.parseInt(scan.nextLine());
		int bcvaccancies = Integer.parseInt(scan.nextLine());
		int scvaccancies = Integer.parseInt(scan.nextLine());
		int stvaccancies = Integer.parseInt(scan.nextLine());
		int i = 0;
		StudentData[] studentdata = new StudentData[studentsnumber];
		while(studentsnumber > 0){
			studentdata[i] = new StudentData(scan);
			// System.out.println(studentdata[i]);
			i++;
			studentsnumber--;
		}
		MeritOrderSort meritordersort = new MeritOrderSort();
		studentdata = meritordersort.sort(studentdata);
		for (int k = 0; k < studentdata.length;k++){
			System.out.println(studentdata[k]);
		} 
	}
}
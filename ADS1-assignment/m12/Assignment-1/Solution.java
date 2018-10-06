import java.util.Scanner;
final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int studentsnumber = Integer.parseInt(scan.nextLine());
		int totalvaccancies = Integer.parseInt(scan.nextLine());
		int unreservedvaccancies = Integer.parseInt(scan.nextLine());
		int bcvaccancies = Integer.parseInt(scan.nextLine());
		int scvaccancies = Integer.parseInt(scan.nextLine());
		int stvaccancies = Integer.parseInt(scan.nextLine());
		int i = 0;
		StudentData[] studentdata = new StudentData[studentsnumber];
		while (studentsnumber > 0) {
			studentdata[i] = new StudentData(scan);
			// System.out.println(studentdata[i]);
			i++;
			studentsnumber--;
		}
		MeritOrderSort meritordersort = new MeritOrderSort();
		studentdata = meritordersort.sort(studentdata);
		for (int k = 0; k < studentdata.length; k++) {
			System.out.println(studentdata[k]);
		}
		System.out.println();
		String cat;
		int h = 0;
		StudentData[] finaldata = new StudentData[totalvaccancies];
		for (int k = 0; k < studentdata.length; k++) {
			cat = studentdata[k].getcategory();
			// if (cat.compareTo("ST") == 0){
			// 	if (stvaccancies > 0){
			// 		// System.out.println(studentdata[k]);
			// 		finaldata[h] = studentdata[k];
			// 		stvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	} else if (unreservedvaccancies > 0){
			// 		finaldata[h] = studentdata[k];
			// 		unreservedvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	}
			// } else if (cat.compareTo("SC") == 0){
			// 	if (scvaccancies > 0){
			// 		finaldata[h] = studentdata[k];
			// 		scvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	}
			// 	else if (unreservedvaccancies > 0){
			// 		finaldata[h] = studentdata[k];
			// 		unreservedvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	}
			// } else if (cat.compareTo("BC") == 0){
			// 	if (bcvaccancies > 0){
			// 		finaldata[h] = studentdata[k];
			// 		bcvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	}
			// 	else if (unreservedvaccancies > 0){
			// 		finaldata[h] = studentdata[k];
			// 		unreservedvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	}
			// } else {
			// 	if (unreservedvaccancies > 0){
			// 		finaldata[h] = studentdata[k];
			// 		unreservedvaccancies--;
			// 		totalvaccancies--;
			// 		h++;
			// 	}
			// }
			if (unreservedvaccancies > 0) {
				finaldata[h] = studentdata[k];
				unreservedvaccancies--;
				totalvaccancies--;
				h++;
			} else if (cat.compareTo("SC") == 0){
				if (scvaccancies > 0){
					finaldata[h] = studentdata[k];
					scvaccancies--;
					totalvaccancies--;
					h++;
				}
			}else if (cat.compareTo("BC") == 0){
				if (bcvaccancies > 0){
					finaldata[h] = studentdata[k];
					bcvaccancies--;
					totalvaccancies--;
					h++;
				}
			} else if (cat.compareTo("ST") == 0){
				if (stvaccancies > 0){
					// System.out.println(studentdata[k]);
					finaldata[h] = studentdata[k];
					stvaccancies--;
					totalvaccancies--;
					h++;
				}
			}// } else {
			// 	if (totalvaccancies > (bcvaccancies+scvaccancies+stvaccancies)){
			// 		finaldata[h] = studentdata[k];
			// 		h++;
			// 		totalvaccancies--;
			// 	}
			// }
		}
		if(totalvaccancies>0){
			int b = 0;
			int d = 0;
			for (int e = 0;e< studentdata.length;e++){
				b = 0;
				for (d = 0;d< finaldata.length;d++){
					if(studentdata[e].getname().compareTo(finaldata[d].getname())==0){
						b++;
						break;
					} else {
						break;
					}
				}
				if (b == 0 && (totalvaccancies>0)){
					finaldata[d] = studentdata[e];
					totalvaccancies--;
				}
			}
		}
		for (int d = 0; d < finaldata.length; d++) {
			System.out.println(finaldata[d]);
		}
	}
}
import java.util.Scanner;
/**
 * { Class }.
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
        int sc = 0;
        int st = 0;
        int bc = 0;
        for (int v = 0; v < studentdata.length;v++){
            if (studentdata[v].getcategory().compareTo("SC")==0){
                sc++;
            }
            else if(studentdata[v].getcategory().compareTo("ST")==0){
                st++;
            }
            else if(studentdata[v].getcategory().compareTo("BC")==0){
                bc++;
            }
        }
        System.out.print(sc+" sc\n");
        System.out.print(bc+" bc\n");
        System.out.print(st+" st\n");
        for (int k = 0; k < studentdata.length; k++) {
            cat = studentdata[k].getcategory();
            if (unreservedvaccancies > 0) {
                finaldata[h] = studentdata[k];
                unreservedvaccancies--;
                totalvaccancies--;
                h++;
            } else if (cat.compareTo("SC") == 0) {
                if (scvaccancies > 0) {
                    finaldata[h] = studentdata[k];
                    scvaccancies--;
                    sc--;
                    totalvaccancies--;
                    h++;
                }
            } else if (cat.compareTo("BC") == 0) {
                if (bcvaccancies > 0) {
                    finaldata[h] = studentdata[k];
                    bcvaccancies--;
                    bc--;
                    totalvaccancies--;
                    h++;
                }
            } else if (cat.compareTo("ST") == 0) {
                if (stvaccancies > 0) {
                    // System.out.println(studentdata[k]);
                    finaldata[h] = studentdata[k];
                    stvaccancies--;
                    st--;
                    totalvaccancies--;
                    h++;
                }
                else {
                    if (totalvaccancies > 0 ){
                        if (st<stvaccancies){
                            finaldata[h] = studentdata[k];
                            h++;
                            st--;
                            totalvaccancies--;
                        }
                        else if (sc<scvaccancies){
                            finaldata[h] = studentdata[k];
                            h++;
                            sc--;
                            totalvaccancies--;
                        }
                        else if (bc<bcvaccancies){
                            finaldata[h] = studentdata[k];
                            h++;
                            bc--;
                            totalvaccancies--;
                        }
                    }
                }
            }// } else {
            //  if (totalvaccancies > (bcvaccancies+scvaccancies+stvaccancies)){
            //      finaldata[h] = studentdata[k];
            //      h++;
            //      totalvaccancies--;
            //  }
            // }
        }
        // System.out.println(totalvaccancies);
        // if (totalvaccancies > 0) {
        //  int b = 0;
        //  int d = 0;
        //  for (int e = 0; e < studentdata.length; e++) {
        //      b = 0;
        //      if (studentdata[e].getname().compareTo(finaldata[e].getname()) == 0) {
        //      } else {
        //          b++;
        //      }
        //      if (b != 0 && (totalvaccancies > 0)) {
        //          // System.out.println("entered");
        //          // finaldata[d] = studentdata[e];
        //          // totalvaccancies--;
        //          System.out.println(finaldata[e]);
        //          if (totalvaccancies == 0) {
        //              break;
        //          }
        //      }
        //  }
        // }
        for (int d = 0; d < finaldata.length; d++) {
            System.out.println(finaldata[d]);
        }
    }
}
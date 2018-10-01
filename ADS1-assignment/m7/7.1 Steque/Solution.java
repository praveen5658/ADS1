import java.util.Scanner;
class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        String[] input;
        String line = "";
        LinkedList l;
        while (testcases > 0) {
            l = new LinkedList();
            while (scan.hasNext()) {
                line = scan.nextLine();
                if(line.isEmpty()) {
                    break;
                }
                input = line.split(" ");
                switch (input[0]) {
                case "push":
                    l.push(Integer.parseInt(input[1]));
                    System.out.println(l.print());
                    break;
                case "enqueue":
                    l.enqueue(Integer.parseInt(input[1]));
                    System.out.println(l.print());
                    break;
                case "pop":
                    if (!(l.isEmpty())) {
                        l.pop();
                    }
                    System.out.println(l.print());
                    break;
                default :
                    break;
                }
            }
            testcases--;
            System.out.println();
        }
    }
}
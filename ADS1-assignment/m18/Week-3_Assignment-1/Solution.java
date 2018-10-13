import java.util.Scanner;
/**
 * { Solution class }.
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
        int noofstocksperhour = Integer.parseInt(scan.nextLine());
        final int five = 5;
        final int six = 6;
        int n = six;
        String[] input;
        String[] keys;
        float[] values;
        String key;
        float value;
        MinPQ minpq;
        MaxPQ maxpq;
        float f;
        int s = 0;
        BinarySearchST bstmin = new BinarySearchST();
        BinarySearchST bstmax = new BinarySearchST();
        while (n > 0) {
            minpq = new MinPQ(five);
            maxpq = new MaxPQ(five);
            keys = new String[noofstocksperhour];
            values = new float[noofstocksperhour];
            for (int i = 0; i < noofstocksperhour; i++) {
                input = scan.nextLine().split(",");
                key = input[0];
                keys[i] = input[0];
                value = Float.parseFloat(input[1]);
                values[i] = value;
                minpq.insert(value);
                maxpq.insert(value);
            }
            for (int m = 0; m < five; m++) {
                f = (float)maxpq.delMax();
                // System.out.print(f +"   Deleted element from maxpq\n");
                for (s = 0; s < noofstocksperhour - 1; s++) {
                    if ((values[s] == f) &&  ((float)maxpq.max() == f)) {
                        // s++;
                        int h = 0;
                        for (h = s + 1; h < noofstocksperhour; h++) {
                            if (values[h] == f) {
                                break;
                            }
                        }
                        if (keys[s].compareTo(keys[h]) > 0) {
                            int temp = s;
                            s = h;
                            h = temp;
                        }
                        key = keys[h];
                        value = f;
                        if (bstmax.contains(key)) {
                            // System.out.print(bstmax.get(key)+" bstmax.getkey\n");
                            bstmax.put(key, (int)bstmax.get(key) + 1);
                        } else {
                            bstmax.put(key, 1);
                        }
                        System.out.print(key + " " + Float.toString(value) + "\n");
                        // s--;
                        m++;
                        f = (float)maxpq.delMax();
                        break;
                    } else if (values[s] == f) {
                        break;
                    }
                }
                key = keys[s];
                value = f;
                if (bstmax.contains(key)) {
                    // System.out.print(bstmax.get(key)+" bstmax.getkey\n");
                    bstmax.put(key, (int)bstmax.get(key) + 1);
                } else {
                    bstmax.put(key, 1);
                }
                System.out.print(key + " " + Float.toString(value) + "\n");
            }
            System.out.println();
            for (int m = 0; m < five; m++) {
                f = (float)minpq.delMin();
                for (s = 0; s < noofstocksperhour - 1; s++) {
                    if ((values[s] == f) &&  ((float)minpq.min() == f)) {
                        // s++;
                        int h = 0;
                        for (h = s + 1; h < noofstocksperhour; h++) {
                            if (values[h] == f) {
                                break;
                            }
                        }
                        if (keys[s].compareTo(keys[h]) < 0) {
                            int temp = s;
                            s = h;
                            h = temp;
                        }
                        key = keys[h];
                        value = f;
                        if (bstmin.contains(key)) {
                            // System.out.print(bstmin.get(key)+" bstmin.getkey\n");
                            bstmin.put(key, (int)bstmin.get(key) + 1);
                        } else {
                            bstmin.put(key, 1);
                        }
                        System.out.print(key + " " + Float.toString(value) + "\n");
                        // s--;
                        m++;
                        f = (float)minpq.delMin();
                        break;
                    } else if (values[s] == f) {
                        break;
                    }
                }
                key = keys[s];
                value = f;
                if (bstmin.contains(key)) {
                    // System.out.print(bstmin.get(key)+" bstmin.getkey\n");
                    bstmin.put(key, (int)bstmin.get(key) + 1);
                } else {
                    bstmin.put(key, 1);
                }
                System.out.print(key + " " + Float.toString(value) + "\n");
            }
            System.out.println();
            n--;
        }
        int number = Integer.parseInt(scan.nextLine());
        while (number > 0) {
            input = scan.nextLine().split(",");
            switch (input[0]) {
            case "get":
                if (input[1].equals("maxST")) {
                    if (bstmax.contains(input[2])) {
                        System.out.println(bstmax.get(input[2]));
                    } else {
                        System.out.println(0);
                    }
                    break;
                } else {
                    if (bstmin.contains(input[2])) {
                        System.out.println(bstmin.get(input[2]));
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
            }
            number--;
        }
    }
}
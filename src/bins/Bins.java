package bins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Runs a number of algorithms that try to fit files onto disks.
 */
public class Bins {
    public static final String DATA_FILE = "example.txt";
    public static final String WORST_FIT = "worst-fit";
    public static final String WORST_FIT_DECREASING = "worst-fit decreasing";

    /**
     * Reads list of integer data from the given input.
     *
     * @param input tied to an input source that contains space separated numbers
     * @return list of the numbers in the order they were read
     */
    public List<Integer> readData(Scanner input) {
        List<Integer> results = new ArrayList<>();
        while (input.hasNext()) {
            results.add(input.nextInt());
        }
        return results;
    }

    /**
     * Returns sum of all values in given list.
     */
    public int getTotalSize(List<Integer> data) {
        int total = 0;
        for (Integer size : data) {
            total += size;
        }
        return total;
    }

    // add files to the collection of Disks
    private Collection<Disk> calculateDisksNeeded(List<Integer> data) {
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        pq.add(new Disk());
        for (Integer size : data) {
            Disk d = pq.peek();
            if (d.freeSpace() >= size) {
                pq.poll();
                d.add(size);
                pq.add(d);
            } else {
                Disk d2 = new Disk();
                d2.add(size);
                pq.add(d2);
            }
        }
        return pq;
    }

    // print contents of given pq and a header, description
    private void printDisksUsed(Collection<Disk> pq, String description) {
        System.out.println();
        System.out.println(description);
        System.out.println("number of disks used: " + pq.size());
        for (Disk d : pq) {
            System.out.println(d);
        }
        System.out.println();
    }

    // add contents of given data to pq and print results
    private void fitDisksAndPrint(List<Integer> data, String description) {
        List<Integer> copy = new ArrayList<>(data);
        if (description.equals(WORST_FIT_DECREASING)) {
            Collections.sort(copy, Collections.reverseOrder());
        }
        Collection<Disk> pq = calculateDisksNeeded(copy);
        printDisksUsed(pq, description);
    }

    /**
     * The main program.
     */
    public static void main(String args[]) {
        Bins b = new Bins();
        Scanner input = new Scanner(Bins.class.getClassLoader().getResourceAsStream(DATA_FILE));
        List<Integer> data = b.readData(input);
        int total = b.getTotalSize(data);

        System.out.println("total size = " + (double) total / Disk.GIGABYTE + "GB");
        b.fitDisksAndPrint(data, WORST_FIT);
        b.fitDisksAndPrint(data, WORST_FIT_DECREASING);
    }
}

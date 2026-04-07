import java.util.Arrays;

public class Problem5 {

    public static int linearSearch(String[] arr, String target) {
        int comps = 0;
        for (int i = 0; i < arr.length; i++) {
            comps++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Found at index " + i + " comparisons=" + comps);
                return i;
            }
        }
        System.out.println("Linear Not Found comparisons=" + comps);
        return -1;
    }

    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comps = 0;

        while (low <= high) {
            comps++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Found at index " + mid + " comparisons=" + comps);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Not Found comparisons=" + comps);
        return -1;
    }

    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        int linearIndex = linearSearch(logs, "accB");

        Arrays.sort(logs);

        int binaryIndex = binarySearch(logs, "accB");

        int count = countOccurrences(logs, "accB");

        System.out.println("Count = " + count);
    }
}
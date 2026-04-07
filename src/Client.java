import java.util.Arrays;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore;
    }
}

class Problem2 {

    // ✅ Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimization
        }

        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(arr));
        System.out.println("Total Swaps: " + swaps);
    }

    // ✅ Insertion Sort (Descending by riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (Descending): " + Arrays.toString(arr));
    }

    // ✅ Top K highest risk clients
    public static void topRisk(Client[] arr, int k) {
        System.out.println("Top " + k + " High-Risk Clients:");

        for (int i = 0; i < k && i < arr.length; i++) {
            System.out.println(arr[i].name + " (Risk: " + arr[i].riskScore + ")");
        }
    }
}

public class problem6{
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 10000),
                new Client("clientA", 20, 5000),
                new Client("clientB", 50, 7000)
        };

        // Step 1: Bubble Sort (Ascending)
        Problem2.bubbleSort(clients);

        System.out.println();

        // Step 2: Insertion Sort (Descending)
        Problem2.insertionSort(clients);

        System.out.println();

        // Step 3: Top 3 highest risk clients
        Problem2.topRisk(clients, 3);
    }
}
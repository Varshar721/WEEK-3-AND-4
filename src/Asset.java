import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double r, double v) {
        this.name = name;
        this.returnRate = r;
        this.volatility = v;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class Main {
    public static void mergeSort(List<Asset> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        List<Asset> left = new ArrayList<>(list.subList(0, mid));
        List<Asset> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        list.clear();
        merge(list, left, right);
    }

    public static void merge(List<Asset> list, List<Asset> l, List<Asset> r) {
        int i = 0, j = 0;

        while (i < l.size() && j < r.size()) {
            if (l.get(i).returnRate <= r.get(j).returnRate)
                list.add(l.get(i++));
            else
                list.add(r.get(j++));
        }

        while (i < l.size()) list.add(l.get(i++));
        while (j < r.size()) list.add(r.get(j++));
    }

    public static void quickSort(List<Asset> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    public static int partition(List<Asset> list, int low, int high) {
        Asset pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).returnRate > pivot.returnRate) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();
        assets.add(new Asset("AAPL", 12, 5));
        assets.add(new Asset("TSLA", 8, 7));
        assets.add(new Asset("GOOG", 15, 4));

        mergeSort(assets);
        System.out.println("Merge Sort: " + assets);

        quickSort(assets, 0, assets.size() - 1);
        System.out.println("Quick Sort DESC: " + assets);
    }
}
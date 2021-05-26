package exercise.chapter2;

public class Heap extends SortUtil {

    private static boolean siftDown(Comparable[] arr, int lo, int hi)
    {
        int k = lo;
        while(true)
        {
            int child = k * 2 + 1; // left child
            if (child >= hi || child < 0) {
                break;
            }
            int right = child + 1; // right child
            if (right < hi && less(arr, child, right)) {
                child = right;
            }
            exch(arr, k, child);
            k = child;
        }
        return k > lo;
    }

    private static void siftUp(Comparable[] arr, int lo, int k)
    {
        while (k > lo) {
            int parent = (k - lo -1) / 2;
            if (!less(arr, k, parent)) {
                break;
            }
            exch(arr, k, parent);
            k = parent;
        }
    }

    private static void sink(Comparable[] arr, int k, int N)
    {
        while(2*k <= N)
        {
            int j = 2*k; // left child
            if (j < N && less(arr, j, j+1)) {
                j++; // right child
            }
            if (!less(arr, k, j))
                break;
            exch(arr, k, j);
            k = j;
        }
    }

    public static void sort(Comparable[] arr)
    {
        int N = arr.length;
        for (int k = N/2; k >= 1; k--) {
            sink(arr, k, N);
        }
        while(N > 1)
        {
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
    }


    public static void sort1(Comparable[] arr)
    {
        int lo = 0;
        int hi = arr.length;

        // build heap with greatest element at top
        for (int i = (hi-1)/2; i >= 0; i--)
        {
            siftDown(arr, i, hi);
        }

        // pop elements, largest first, into end of data
        for (int i = hi - 1; i >= 0; i--) {
            exch(arr, 0, i);
            siftDown(arr, lo, i);
        }
    }
}

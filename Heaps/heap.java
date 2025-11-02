import java.util.ArrayList;

public class heap {

    // heap is a complete binary tree which follows heap property
    // max heap - parent node is greater than child nodes
    // min heap - parent node is less than child nodes
    // heap is not implemented as a class it implemented as an array / arraylist
    // for heap parent index = i, left child = 2*i + 1, right child = 2*i + 2 using this we can implement tree in array form 
    // if child idx = i, then parent idx = (i-1)/2

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int x = arr.size() - 1; // child idx
            int par = (x - 1)/2; // parent idx
            while (arr.get(x) < arr.get(par)) { //O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public int remove() {
            int data = arr.get(0);
            // step 1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            // step 2 - remove last
            arr.remove(arr.size()-1);
            // step 3 - heapify
            heapify(0);
            return data;
        }

        public void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i; 

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            } 

            if(minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // heap sort
    public static void heapSort(int arr[]) {
        // build max heap
        int n = arr.length;
        for (int i = n/2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // push largest at end
        for(int i=n-1; i>0; i--) {
            // swap largset first with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void heapify(int arr[], int i, int size) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i; 

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }
    

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(2);
        while (!h.isEmpty()) {  
            System.out.println(h.peek());
            h.remove();
        }

        // heap sort O(nlogn)
        int[] arr = {1,5,2,4,3};
        heapSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

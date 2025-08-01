public class basicSorting {
    public static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length-1; turn++) {
            for (int j = 0; j < arr.length-1-turn; j++) {
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length-1; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort (int arr[]) {
        for (int i = 1; i < arr.length-1; i++) {
            int curr = arr[i];
            int prev = i-1;
            // find out the correct position to insert
            while (prev >=0 && curr < arr[prev]) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insert
            arr[prev+1] = curr;
        }
    }

    public static void countSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < count.length; i++) {
            count[arr[i]]++;
        }
        // sorting and put elements in original array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1,0};
        System.out.println("Original Array: ");
        printArray(arr);
        System.out.print("Bubble Sort: ");
        bubbleSort(arr);
        printArray(arr);
        System.out.print("Selection Sort: ");
        selectionSort(arr);
        printArray(arr);
        System.out.print("Insertion Sort: ");
        insertionSort(arr);
        printArray(arr);
        System.out.print("Count Sort: ");
        countSort(arr);
        printArray(arr);
    }
}

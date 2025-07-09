public class divideConqure{

    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (si - ei)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[si - ei + 1];
        // idx for 1st sorted part
        int i=si;
        // idx for 2nd sorted part
        int j=mid+1;
        // idx for temp
        int k=0;

        while (i <= mid && j <= ei){
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for leftover elements of 1st sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for leftover elements of 2nd sorted part
        while (i <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original array
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        // last element
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx-1);
        quickSort(arr, pidx, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; // index of smaller element

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

     public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main (String args[]){
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        System.out.print("By Merge sort: ");
        printArr(arr);
        
        quickSort(arr, 0, arr.length-1);
        System.out.print("By Quick sort: ");
        printArr(arr);
    }
}

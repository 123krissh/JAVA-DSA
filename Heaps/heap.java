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
    }
}

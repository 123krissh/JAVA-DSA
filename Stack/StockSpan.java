import java.util.*;
public class StockSpan {
    
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s =new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 0; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >= stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }


// leetcode --->
// class StockSpanner {
//     private Stack<int[]> stack;
//     public StockSpanner() {
//         stack = new Stack<>();
//     }    
//     public int next(int price) {
//         int span = 1;
//         while(!stack.isEmpty() && stack.peek()[0] <= price){
//             span += stack.pop()[1];
//         }
//         stack.push(new int[]{price, span});
//         return span;
//     }
// }


    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60,  85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}

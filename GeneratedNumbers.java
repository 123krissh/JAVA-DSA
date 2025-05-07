import java.util.*;
// import java.util.Scanner;

public class GeneratedNumbers {

    public static int uniqueMarbleCounts(int N, int A, int B) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        visited.add(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Try subtracting A
            int nextA = current - A;
            if (nextA > 0 && visited.add(nextA)) {
                queue.offer(nextA);
            }

            // Try subtracting B
            int nextB = current - B;
            if (nextB > 0 && visited.add(nextB)) {
                queue.offer(nextB);
            }
        }

        return visited.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // initial number of marbles
        int A = sc.nextInt(); // value A
        int B = sc.nextInt(); // value B

        int result = uniqueMarbleCounts(N, A, B);
        System.out.println("Output: " + result);
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {
    // comparable interface for custom object sorting it is overriding compareTo method
    static class Student implements Comparable<Student>{ 
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; // min rank
        }
    }
    public static void main(String[] args) {
        // by default pq peek min value first
        // for peek max value first we need to pass comparator object Comparator.reverseOrder().
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3); //O(logn)
        pq.add(4);
        pq.add(2);
        pq.add(7);
        pq.add(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // O(logn)
        }

        PriorityQueue<Student> pqs = new PriorityQueue<>();
        pqs.add(new Student("Alice", 3));
        pqs.add(new Student("Bob", 4));
        pqs.add(new Student("Charlie", 2));
        pqs.add(new Student("David", 7));
        pqs.add(new Student("Eve", 1));
        while (!pqs.isEmpty()) {
            System.out.println(pqs.peek().name + " -> " + pqs.peek().rank); 
            pqs.remove();
        }
    }
}

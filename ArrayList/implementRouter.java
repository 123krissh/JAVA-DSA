import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class implementRouter {
    private class Packet{
        int source, destination, timestamp;

        Packet(int source, int destination, int timestamp){
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }

    private int memoryLimit = 0;
    private ArrayList<Packet> packets = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    private String getKey(int source, int destination, int timestamp){
        return source + "_" + destination + "_" + timestamp;
    }
    
    // 1,12,4 -> 1124 -> 1_12_4
    // 11,2,4 -> 1124 -> 11_2_4
    public boolean addPacket(int source, int destination, int timestamp) {
        String value = getKey(source, destination, timestamp);

        if(set.contains(value)){
            return false;
        }

        if(packets.size() == memoryLimit) {
            Packet packet = packets.remove(0);
            String key = getKey(packet.source, packet.destination, packet.timestamp);
            set.remove(key);

            List<Integer> timestamps = map.getOrDefault(packet.destination, new ArrayList<>());
            if(!timestamps.isEmpty()) {
                timestamps.remove(0);
                map.put(packet.destination, timestamps);
            }
        }

        set.add(value);
        packets.add(new Packet(source, destination, timestamp));
        map.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(packets.size() == 0) {
            return new int[0];
        }

        Packet packet = packets.remove(0);
        String key = getKey(packet.source, packet.destination, packet.timestamp);
        set.remove(key);

        List<Integer> timestamps = map.getOrDefault(packet.destination, new ArrayList<>());
        if(!timestamps.isEmpty()) {
            timestamps.remove(0);
            map.put(packet.destination, timestamps);
        }

        return new int[] {packet.source, packet.destination, packet.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> arr = map.getOrDefault(destination, new ArrayList<>());
        int upper = upperBound(arr, endTime); 
        int lower = lowerBound(arr, startTime);
        return upper - lower;
    }

    private int lowerBound(List<Integer> arr, int target){
        int low = 0, high = arr.size();

        while(low < high) {
            int mid = (low + high)/2;
            if(arr.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int upperBound(List<Integer> arr, int target){
        int low = 0, high = arr.size();

        while(low < high) {
            int mid = (low + high)/2;
            if(arr.get(mid) <= target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

// <---------------OR----------------->
class Router {
    Deque<int[]>que;
    HashMap<Integer,List<int[]>>map;
    int size;
    public Router(int memoryLimit) {
        que=new LinkedList<>();
        map=new HashMap<>();
        this.size=memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        
        if(!map.containsKey(destination)){
            map.put(destination,new ArrayList<>());
        }
        List<int[]>list=map.get(destination);
        int left=small(list,timestamp);
        
        if(list.size()!=0){
            // System.out.println(left);
            // for(int []a:list)System.out.println(Arrays.toString(a));
            for(int i=left;i<list.size() && list.get(i)[1]==timestamp;i++){
                // System.out.println(left);
                if(list.get(i)[0]==source)return false;
            }
        }
        map.get(destination).add(new int[]{source,timestamp});
        que.addLast(new int[]{source,destination,timestamp});
        if(que.size()>size){
            forwardPacket();
        }
        
        return true;
        
    }
    
    public int[] forwardPacket() {
        if(que.size()==0)return new int[0];
        int[]arr=que.pollFirst();
        // System.out.println(Arrays.toString(arr));
        map.get(arr[1]).remove(0);
        return arr;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!map.containsKey(destination)){
            return 0;
        }
        List<int[]>list=map.get(destination);
        int left=small(list,startTime);
        int right=big(list,endTime);
        if(left>right)return 0;
        return right-left+1;
    }
    public int small(List<int[]>list,int start){
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)[1]>=start){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public int big(List<int[]>list,int end){
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)[1]>end){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }
}

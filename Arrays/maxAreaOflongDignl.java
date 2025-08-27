public class maxAreaOflongDignl {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDignl = Integer.MIN_VALUE;
        int maxArea = Integer.MIN_VALUE;
        int length, width, area;
        for(int i=0; i<dimensions.length; i++){
            length = dimensions[i][0];
            width = dimensions[i][1];
            double dignlLength = Math.sqrt(length*length + width*width);
            area = length * width;
            if(dignlLength > maxDignl){
                maxDignl = dignlLength;
                maxArea = area;
            } else if(dignlLength == maxDignl){
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

     public static void main(String[] args) {
        int[][] dimensions = { { 6, 5 }, { 8, 6 }, { 2, 10 }, { 8, 1 }, { 9, 2 }, { 3, 5 }, { 3, 5 } };
        System.out.println(areaOfMaxDiagonal(dimensions));
    }
}

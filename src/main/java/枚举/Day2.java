package 枚举;

public class Day2 {
    public static void main(String[] args) {
        Day2 day2 = new Day2();
        double ans = day2.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}});
        System.out.println(ans);
    }

    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double ans = 0;
        for (int i = 0; i < len-2; ++i){
            for (int j = i+1; j < len -1; ++j){
                for (int k = j+1; k < len; ++k){
                    ans = Math.max(ans,are(points[i],points[j],points[k]));
                }
            }
        }
        return ans;
    }

    public double are(int[] first, int[] second, int[] third){
        int x1 = first[0];
        int y1 = first[1];
        int x2 = second[0];
        int y2 = second[1];
        int x3 = third[0];
        int y3 = third[1];
        return Math.abs(0.5*(x1*y2+x2*y3+x3*y1-x1*y3-x2*y1-x3*y2));
    }
}

class Solution {
    public int minTimeToVisitAllPoints(int[][] point) {
        int minTime=0;
        int n=point.length;
        for(int i=0;i<n-1;i++){
            int x1=point[i][0];
            int y1=point[i][1];
            int x2=point[i+1][0];
            int y2=point[i+1][1];
            int dx=Math.abs(x2-x1);
            int dy=Math.abs(y2-y1);
            minTime+=Math.min(dx,dy);  
            minTime+=Math.abs(dx-dy);
        }
        return minTime;
    }
}
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[]sqrs=new int[n];
        int pi=0,k=0;
        for(int i=0;i<n;i++) 
            if(Math.abs(nums[i])<Math.abs(nums[pi])) pi=i;
        sqrs[k++]=nums[pi]*nums[pi];
        int l=pi-1;
        int r=pi+1;
        while(l>=0 && r<n){
            if(Math.abs(nums[l])<Math.abs(nums[r]))
                sqrs[k++]=nums[l]*nums[l--];
            else
                sqrs[k++]=nums[r]*nums[r++];
        }
        while(l>=0) sqrs[k++]=nums[l]*nums[l--];
        while(r<n) sqrs[k++]=nums[r]*nums[r++];
        return sqrs;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     Arrays.sort(nums);  
     int n=nums.length;
     List<List<Integer>> ml=new ArrayList<>();
     for(int i=0;i<n;i++){
        if (i != 0 && nums[i] == nums[i - 1]) continue;
        int j=i+1,k=n-1;
        while(j<k){
            int sum=nums[i]+nums[j]+nums[k];
            if(sum>0)
                k-=1;
            else if(sum<0)
                j++;
            else{
                List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                ml.add(l);
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;

            }
        }
     }
     return ml;
    }
}
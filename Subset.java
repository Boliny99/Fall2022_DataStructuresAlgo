public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(nums,0,path,res);
        return res;



    }

    public void backTrack(int[] nums,int index,List<Integer> path,List<List<Integer>> res){
        if (index == nums.length){
            return;
        }

        path.add(nums[index]);
        res.add(path);
        index++;
        backTrack(nums, index, path,res);
    }
}


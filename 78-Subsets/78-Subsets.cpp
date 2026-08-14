// Last updated: 8/14/2026, 10:09:29 AM
class Solution {
public:

    void getAllSubsets(vector<int> &arr, vector<int> &ans,int i, vector<vector<int>> &allSubsets){

        //base case 
        if(i== arr.size()){
            //store subset 
            allSubsets.push_back({ans});
            return;
        }

        //include
        ans.push_back(arr[i]);
        getAllSubsets(arr,ans,i+1,allSubsets);

        ans.pop_back(); //backtrack

        //exclude
        getAllSubsets(arr,ans,i+1,allSubsets);

    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> allSubsets;
        vector<int> ans;
        int index = 0;

        getAllSubsets(nums,ans,index,allSubsets);

        return allSubsets;
    }
};
#include <bits/stdc++.h>
#include <chrono>
#include <unordered_map>
#include <vector>

using namespace std;
using namespace std::chrono;

class Solution
{
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int>output;
        unordered_map<int, int> Map;
        vector<vector<int>>bucket((int)nums.size()+1);
        for (int i=0; i<nums.size(); ++i) {
            if (Map.find(nums[i])== Map.end()){
                Map[nums[i]]=0;
            }
            ++Map[nums[i]];
        }
        for (const auto& [key, v] : Map) {
            bucket[v].push_back(key);
        }
        int c{(int)nums.size()};
        while (k>0) {
            while(! bucket[c].empty()){
                output.push_back(bucket[c].back());
                bucket[c].pop_back();
                --k;
            }
            --c;
        
        }
        return output;
    }
};

int main()
{
    auto start = high_resolution_clock::now();

    Solution solution;
    vector<int> input = {1,2,1,2,1,3};
    

    for (const auto& item :solution.topKFrequent(input, 2) ) {
        cout<< item << " ";

    }
    cout<< endl;


    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}

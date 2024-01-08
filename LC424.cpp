#include <bits/stdc++.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution {
public:
    static int mapMax(const unordered_map <char, int> &map){
        int m=0;
        for(const auto &[k,v]:map){
            v > m ? m=v: 0;
        }
        return m;
    }

    int characterReplacement(string s, int k) {
        int l, r, window, output, mostFrequent;
        unordered_map<char, int> map;
        l=r=output=mostFrequent=0;
        while(r<s.size()){

            if(map.find(s[r])==map.end()){
                map[s[r]]=1;
            }
            else{
                map[s[r]]+=1;
            }
            mostFrequent=max(mostFrequent, map[s[r]]);

            window= r-l+1;
            if (window - mostFrequent > k){
                map.count(s[l])==0? 0: map[s[l]]-=1;
                l++;
                window= r-l+1;
            }
            output=max(window, output);
            r++;

        }
        return output;
    }
};

int main() {
    auto start = high_resolution_clock::now();

    // Your code here
    Solution solution;

    // Example test cases
    std::string str1 = "ABAB";
    int k1 = 2;

    std::string str2 = "AABABBA";
    int k2 = 1;

    std::string str3 = "AAAA";
    int k3 = 0;

    int result1 = solution.characterReplacement(str1, k1);
    int result2 = solution.characterReplacement(str2, k2);
    int result3 = solution.characterReplacement(str3, k3);

    std::cout << "Result for str1: " << result1 << std::endl;
    std::cout << "Result for str2: " << result2 << std::endl;
    std::cout << "Result for str3: " << result3 << std::endl;

    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}
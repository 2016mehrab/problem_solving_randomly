#include <bits/stdc++.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> visited;
        int l, r, output;
        output=l=r=0;
        
        while(r<s.size()){
            // if it doesn't exist
            if(visited.find(s[r]) == visited.end()){
                visited.insert(s[r]);
                output=max(r-l+1, output);
                r++;
            }
            else{
                visited.erase(s[l]);
                l++;
            }
        }
        return output;
        
    }
};

int main() {
    auto start = high_resolution_clock::now();

std::string str1 = "abcabcbb";
    std::string str2 = "bbbbb";
    std::string str3 = "pwwkew";
    std::string str4 = "aab";
    std::string str5 = "dvdf";

    Solution solution;

    int maxLen1 = solution.lengthOfLongestSubstring(str1);
    int maxLen2 = solution.lengthOfLongestSubstring(str2);
    int maxLen3 = solution.lengthOfLongestSubstring(str3);
    int maxLen4 = solution.lengthOfLongestSubstring(str4);
    int maxLen5 = solution.lengthOfLongestSubstring(str5);

    std::cout << "Longest substring length for str1: " << maxLen1 << std::endl;
    std::cout << "Longest substring length for str2: " << maxLen2 << std::endl;
    std::cout << "Longest substring length for str3: " << maxLen3 << std::endl;
    std::cout << "Longest substring length for str4: " << maxLen4 << std::endl;
    std::cout << "Longest substring length for str5: " << maxLen5 << std::endl;

    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}
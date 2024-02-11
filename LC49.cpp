#include <bits/stdc++.h>
#include <chrono>
#include <sstream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;
using namespace std::chrono;

class Solution
{
public:
    static string getSignature(const string& str){
        vector<int>count(26,0);
        for (const auto& c  : str) {
            ++count[c-'a'];
        }

        stringstream ss;
        for (int i=0; i<26; ++i) {
            if(count[i]!=0){
                //(char) ('a'+i) = converts relative index to char
                ss<<(char)('a'+i)<<count[i];
            }
        }
        return ss.str();
    }
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>>output;
        unordered_map<string, vector<string>>HashMap;
        for (const auto& word : strs) {
            string tmp=word;
            sort(tmp.begin(),tmp.end());
            //doesnot exist
            if(HashMap.find(tmp)==HashMap.end()){
                HashMap[tmp]={};
            }
            HashMap[tmp].push_back(word);
        }
        for (const auto& [k,v] : HashMap) {
            output.push_back(v);
        }
        return output;

    }
    vector<vector<string>> groupAnagrams_optimal(vector<string>& strs) {
        vector<vector<string>>output;
        unordered_map<string, vector<string>>HashMap;
        for (const auto& word : strs) {
            string key = getSignature(word);
            if(HashMap.find(key)==HashMap.end()){
                HashMap[key]={};
            }
            HashMap[key].push_back(word);
        }
        for (const auto& [k,v] : HashMap) {
            output.push_back(v);
        }
        return output;

    }
};

int main()
{
    auto start = high_resolution_clock::now();

    Solution solution;
    vector<string> input = {"eat","ate","tan","nat", "bat"};
    for (const auto& list : solution.groupAnagrams(input)) {
        for (const auto& word : list) {
            cout<< word << " ";
        }
        cout<< endl;
    
    }


    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}

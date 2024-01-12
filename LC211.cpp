#include <bits/stdc++.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Node {

	public:
    unordered_map<char, Node*> hashmap;
		bool terminal;
  ~Node(){
    for (auto &it:hashmap){
      delete it.second;
    }
   
  }

};
class WordDictionary {
public:
 Node* root; 
    WordDictionary() {
      root = new Node();

    }

    void addWord(string word) {
      Node* curr = root;
      for(const char& c: word){
        // doesn't exists
        if (curr->hashmap.find(c) == curr->hashmap.end()){
          curr->hashmap[c] = new Node();
        }
        curr= curr->hashmap[c];
      }
      curr->terminal = true;

    }
    bool dfs(Node* root, string word){
      Node* curr = root;
      int s = word.size();
      for (int i=0; i<s; i++){
        if (word[i]=='.') {
          for(const auto& pair: curr->hashmap){
            if (dfs( pair.second, word.substr(i+1, s-1))){
              return true;
            }
            
          }
          return false;

        }
        // doesn't exists
        if (curr->hashmap.find(word[i]) == curr->hashmap.end()){
          return false;
        }
        curr= curr->hashmap[word[i]];

      }
      return curr->terminal;
    }

    bool search(string word) {
      return dfs(root,word);

    }
};


int main()
{
    auto start = high_resolution_clock::now();


     WordDictionary obj;
    obj.addWord("a");
    obj.addWord("a");
    obj.search("a");
    obj.search("aa");
    obj.search("a");
    obj.search(".a");
    obj.search("a.");
    cout << "Search result for 'a': " << (obj.search("a") ? "true" : "false") << endl;
    cout << "Search result for 'a': " << (obj.search("a") ? "true" : "false") << endl;
    cout << "Search result for '.a': " << (obj.search(".a") ? "true" : "false") << endl;
    cout << "Search result for 'a.': " << (obj.search("a.") ? "true" : "false") << endl;


    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}


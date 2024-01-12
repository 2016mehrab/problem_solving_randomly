#include <bits/stdc++.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

class TrieNode{
	public:
    unordered_map<char, TrieNode*> hashmap;
		bool terminal;
  ~TrieNode(){
    for (auto &it:hashmap){
      delete it.second;
    }
   
  }
};

class Trie {
public:
	TrieNode* root;
    Trie() {
	   root = new TrieNode(); 
        
    }
    ~Trie(){
      delete root;
    }
    
    void insert(string word) {
	    TrieNode* curr = root;
	    for (const char& c : word){
		    if(curr->hashmap.find(c)==curr->hashmap.end()){
			   curr->hashmap[c] = new TrieNode();
			    }
		    curr =curr->hashmap[c]; 
	    }
	    curr->terminal = true;
        
    }
    
    bool search(string word) {
	    TrieNode* curr = root;
	    for (const char& c : word){
		    if(curr->hashmap.find(c)==curr->hashmap.end()){
			    return false;
		    }
		    curr =curr->hashmap[c]; 
	    }
	    return curr->terminal;
    }
    
    bool startsWith(string prefix) {
	    TrieNode* curr = root;
	    for (const char& c : prefix){
		    if(curr->hashmap.find(c)==curr->hashmap.end()){
			    return false;
		    }
		    curr =curr->hashmap[c]; 
	    }
	    return true;
    }
};

int main()
{
    auto start = high_resolution_clock::now();

	Trie t;
	t.insert("apple");
	t.insert("apply");
	t.insert("ape");
	t.insert("api");
	cout<<"Does ape exists? "<< t.search("ape")<<endl;
	cout<<"Does ai prefix exists? "<< t.startsWith("ai")<<endl;
    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}


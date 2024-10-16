function     lengthOfLongestSubstring(s) {
    let tempSet = new Set();
    let result=0;
    let finish=0;

    while(finish<s.length){
        if(!tempSet.has(s[finish])){
            tempSet.add(s[finish]);
            console.log(tempSet);
            
        }
        else{
            tempSet.clear();
            tempSet.add(s[finish]);
        }
        result = result < tempSet.size ? tempSet.size : result;
        ++finish;

    }
    return result;
}
lengthOfLongestSubstring("dvdf");
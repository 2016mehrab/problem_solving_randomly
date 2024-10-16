 // INCOMPLETE
 function characterReplacement(s, k) {
    let i=0;
    let f=i+1;
    let dupK=k;
    let longest=0;
    let mark=-1;
    while(i<s.length){
        if (s[i]!==s[f]){
            mark = f;
            --dupK;
        }
        ++f;
        if(dupK<0){
            dupK=k;
            longest = Math.max(longest, f-i);
            i=mark;
            f=i+1;
        }

    }
 }
    function checkInclusion(s1, s2) {
        let size_s1= s1.length;
        let hashmap = new Map();
        for(let c of s1){
            if(!hashmap.has(c)){
                hashmap.set(c,1);
            }
            hashmap.set(hashmap.get(c)+1);
        }

        let s=0;
        let f=0;
        while(true){
            let tempHashmap = new Map();
            if(!tempHashmap.has(s2[f])){
                tempHashmap.set(s2[f],0);
            }
            tempHashmap.set(tempHashmap.get(s2[f])+1);
            if(hashmap.get(s2[f])!==tempHashmap.get(s2[f])){
                ++s;
            }
            ++f;
        
            


        }
    }
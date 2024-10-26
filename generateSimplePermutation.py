def gen(stringList, length):
    if length == 0:
        print(''.join(stringList))
        return

    for i in stringList:
        stringList.append(str(i)+'')
        gen(stringList,length-1)
        stringList.pop()
    
gen(['a','b','c'],3)
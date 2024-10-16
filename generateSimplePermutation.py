def gen(stringList, length):
    if length == 0:
        print(''.join(stringList))
        return

    for i in [1,2,3]:
        stringList.append(str(i)+'')
        gen(stringList,length-1)
        stringList.pop()
    
gen([],3)
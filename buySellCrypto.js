function maxProfit(prices) {
    let buy=0;
    let sell=  buy+1;
    let maxProfit=0;

    while(sell < prices.length){
        if(prices[buy] > prices[sell]) buy=sell;
        maxProfit= maxProfit < prices[sell]-prices[buy] ? prices[sell]-prices[buy] : maxProfit; 
        ++sell;

    }
    return maxProfit;
}

console.log(maxProfit([10,1,5,6,7,1]));


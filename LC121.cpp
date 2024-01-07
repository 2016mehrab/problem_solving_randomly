#include <bits/stdc++.h>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int buy, sell, profit, tmp;
        buy = 0;
        profit = 0;
        sell = buy + 1;
        while (buy < sell && sell < prices.size())
        {
            tmp = prices[sell] - prices[buy];
            if (tmp > 0)
            {
                profit=max(tmp, profit);
                // if (tmp> profit){
                //     profit= tmp;
                // }

            }
            else
            {
                buy=sell;
            }
            sell++;
        }
        return profit;
    }
};

int main()
{
    auto start = high_resolution_clock::now();

    // Your code here

    std::vector<int> prices1 = {7, 1, 5, 3, 6, 4};
    std::vector<int> prices2 = {4, 2, 2, 2, 4};
    std::vector<int> prices3 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
    std::vector<int> prices4 = {1,2,4,2,5,7,2,4,9,0,9};

    Solution solution;

    int maxProfit1 = solution.maxProfit(prices1);
    int maxProfit2 = solution.maxProfit(prices2);
    int maxProfit3 = solution.maxProfit(prices3);
    int maxProfit4 = solution.maxProfit(prices4);

    std::cout << "Maximum profit for prices1: " << maxProfit1 << std::endl;
    std::cout << "Maximum profit for prices2: " << maxProfit2 << std::endl;
    std::cout << "Maximum profit for prices3: " << maxProfit3 << std::endl;
    std::cout << "Maximum profit for prices4: " << maxProfit4 << std::endl;

    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);

    cout << "Time taken by function: "
         << duration.count() << " microseconds" << endl;

    return 0;
}
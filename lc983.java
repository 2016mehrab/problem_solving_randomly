/*
 * integer array = [ days of year]
 * day is from 1 to 365
 *  - day is strictly increasing
 *  - length of array is small 
 *  - cost is small size 
 * tickets sold in 3 ways 1 -day pass, 7-day pass, 30-day pass
 * 30-day pass costs lower for 30 day travel compared to 7-day pass 
 * 7-day pass costs lower for 7 day travel compared to 1-day pass
 * Therefore, can not proceed greedily with the 1-day pass.
 * return MINIMUM NUMBER OF DOLLARS YOU NEED TO TRAVEL THE GIVEN DAYS
 */

/*
 * Order doesn't matter in terms of choosing a PASS
 * should stop buying PASS when no days to travel
 *
 */

//days=days costs = costs
//starting cost=0
//Decision:
//minimum cost to travel the days using costs
//
//
//starting with i-th day what are my actions
//
//buy i-th-day pass from (1, 7, 30)
//    - cost= add starting_cost + i-th-day cost 
//    - next day to buy pass i-th day + i-th-day pass - 1  
//
//take the minimum cost
//next i'll have to start from the i-th day
//
//for travelling days[i] -> 
//    using pass[j]-> totalCostSofar+ costs[pass[j]] actions: find the min cost and try for the  i+pass[j] day

import java.util.HashMap;
import java.util.Map;

class LC983 {
    private int minimumTicketCost_forCurrDay(int[]days, int[] costs,  int i, int daysCoveredByPass, Map<String, Integer>dp){
        if(i  >= days.length) return 0;
        String key = i+"-"+daysCoveredByPass;
        if(dp.containsKey(key)) return dp.get(key);
        if(days[i] <= daysCoveredByPass) {
            return minimumTicketCost_forCurrDay(days, costs, i+1 ,daysCoveredByPass,dp);
        }

        int one_day_pass=costs[0]+ minimumTicketCost_forCurrDay(days, costs, i+1 ,days[i]+1-1 , dp);
        int seven_day_pass=costs[1] +minimumTicketCost_forCurrDay(days, costs, i+1 ,days[i]+7-1 ,dp);
        int thirty_day_pass=costs[2] +minimumTicketCost_forCurrDay(days, costs,i+1  ,days[i]+30-1 ,dp);

        int tmp = Math.min(one_day_pass, seven_day_pass);
        dp.put(key,Math.min(tmp, thirty_day_pass)) ;
        return dp.get(key);
    }

    public int mincostTickets(int[] days, int[] costs) {
        Map<String, Integer> dp = new HashMap<>();
        int r =minimumTicketCost_forCurrDay ( days, costs, 0,0 , dp);
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        LC983 solution = new LC983();
        
    }
}

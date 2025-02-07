class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        r=[]
        ball_color={}
        color_count={}
        for i in range(len(queries)):
            ball ,color = queries[i]
            if ball in ball_color:
                prev_color=ball_color[ball]
                color_count[prev_color]-=1
                if color_count[prev_color]==0:
                    del color_count[prev_color]
            ball_color[ball]=color
            color_count[color]=color_count.get(color,0)+1
            r.append(len(color_count))
        return r
        

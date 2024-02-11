#include <bits/stdc++.h>
#include <chrono>
#include <queue>
#include <utility>
#include <vector>

using namespace std;
using namespace std::chrono;

class Solution {
public:
  int ROWS, COLS{0};
  void bfs(vector<vector<char>> &grid, int r, int c,
           vector<vector<bool>> &visited) {
    queue<pair<int, int>> Q;
    Q.push({r, c});
    visited[r][c] = true;
    while (!Q.empty()) {
      int cr = Q.front().first;
      int cc = Q.front().second;
      Q.pop();
      int directions[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      int nr{0}, nc{0};
      for (int i = 0; i < 4; ++i) {
        nr = cr + directions[i][0];
        nc = cc + directions[i][1];

        if (min(nr, nc) >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == '1' &&
            visited[nr][nc] == false) {
          Q.push({nr, nc});
          visited[nr][nc] = true;
        }
      }
    }
  }
  int numIslands(vector<vector<char>> &grid) {
    vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size()));
    ROWS = (int)grid.size(), COLS = (int)grid[0].size();
    int output{0};
    for (int r = 0; r < grid.size(); ++r) {
      for (int c = 0; c < grid[0].size(); ++c) {
        if (grid[r][c] == '0' || visited[r][c] == true)
          continue;
        bfs(grid, r, c, visited);
        ++output;
      }
    }
    return output;
  }
};

int main() {
  auto start = high_resolution_clock::now();

  Solution solution;
  vector<vector<char>> grid = {{'1', '1', '0', '0', '0'},
                               {'1', '1', '0', '0', '0'},
                               {'0', '0', '1', '0', '0'},
                               {'0', '0', '0', '1', '1'}};
  cout << "Number of Islands-> " << solution.numIslands(grid) << endl;
  vector<vector<char>> grid1 = {
      {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'},
      {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
      {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1',
       '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
      {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1',
       '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
      {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1',
       '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
      {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
       '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};

  cout << "Number of Islands-> " << solution.numIslands(grid1) << endl;
  /* cout << "ROWS-> " << grid1.size() << endl; */
  /* cout << "COLS-> " << grid1[0].size() << endl; */
  cout << endl;

  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);

  cout << "Time taken by function: " << duration.count() << " microseconds"
       << endl;

  return 0;
}

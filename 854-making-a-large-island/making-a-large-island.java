class Solution {
    int n;
    int[] islands;
    int[][] grid;
    int[][] visited;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        int count = 0, max = 0, tmp;
        int[] closeIslandIds = new int[4];
        islands = new int[n * n];
        visited = new int[n][n];
        this.grid = grid;

        // 0. 초기에 존재하는 섬들의 크기를 저장한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j] > 0) continue ;
                // 섬에 진입하면 해당 섬을 전체 탐색한다.
                exploreIsland(i, j, ++count);
                if (max < islands[count - 1]) max = islands[count - 1];
            }
        }

        // 1. 모든 0의 cell에서 상하좌우 섬의 크기의 합이 max인 값아 1을 더한 값이 답이다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue ;
                tmp = 1;
                closeIslandIds[0] = i > 0 ? visited[i - 1][j] : 0; // 상
                closeIslandIds[1] = i < n - 1 ? visited[i + 1][j] : 0; // 하
                closeIslandIds[2] = j > 0 ? visited[i][j - 1] : 0; // 좌
                closeIslandIds[3] = j < n - 1 ? visited[i][j + 1] : 0; // 우
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < k; l++) {
                        if (closeIslandIds[k] == closeIslandIds[l]) {
                            closeIslandIds[k] = 0;
                            break ;
                        }
                    }
                    tmp += closeIslandIds[k] > 0 ? islands[closeIslandIds[k] - 1] : 0;
                }
                if (max < tmp) max = tmp;
            }
        }
        return max;
    }

    private void exploreIsland(int row, int col, int id) {
        if (row < 0 || row >= n || col < 0 || col >= n) return ;
        if (grid[row][col] == 0) return ;
        if (visited[row][col] != 0) return ; // 서로 다른 섬을 침범할 일은 없다.
        visited[row][col] = id;
        islands[id - 1]++;
        exploreIsland(row + 1, col, id);
        exploreIsland(row, col + 1, id);
        exploreIsland(row - 1, col, id);
        exploreIsland(row, col - 1, id);
    }

    // void printMap(int count) {
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             System.out.print(visited[i][j] + " ");
    //         }
    //         System.out.print("\n");
    //     }
    //     System.out.println("--------");
    //     for (int i = 0; i < count; i++) System.out.print(islands[i] + " ");
    //     System.out.println("--------");
    // }
}
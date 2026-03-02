class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // nums 배열로 직사각형을 만든다했을 때, 시작점이 (row, col)인 대각선의 요소들은 모두 diag[row + col]에 저장된다.
        // 해당 요소들의 행과 열의 합은 언제나 row + col로 같다.
        // 저장이 되는 순서는 (row++, 0) 후에 (rowMax, col++)이다 -> row 0에서 rowMax까지 저장 후, rowMax부터 순차적으로 저장한다.

        List<List<Integer>> diags = new ArrayList<>();
        int rowMax = nums.size();
        int len = 0, i = -1, j;

        while (++i < rowMax) {
            diags.add(new ArrayList<Integer>(List.of(nums.get(i).get(0))));
            len++;
        }
        while (--i >= 0) {
            j = 0;
            List<Integer> row = nums.get(i);
            while (++j < nums.get(i).size()) {
                if (diags.size() <= i + j) diags.add(new ArrayList<Integer>());
                diags.get(i + j).add(row.get(j));
                len++;
            }
        }
        
        int[] result = new int[len];
        int idx = 0;
        for (List diag : diags) {
            for (i = 0; i < diag.size(); i++) result[idx++] = (Integer) diag.get(i);
        }
        return result;
    }
}
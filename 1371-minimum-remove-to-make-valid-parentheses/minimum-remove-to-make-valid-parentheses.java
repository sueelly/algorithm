class Solution {
    public String minRemoveToMakeValid(String s) {
        List<Integer> idxs = new ArrayList<>();
        char[] str = s.toCharArray();
        int i, len = str.length, j;
        StringBuffer sb = new StringBuffer();

        for (i = 0; i < len; i++) {
            if (str[i] == '(') {
                idxs.add(i);
            } else if (str[i] == ')') {
                if (idxs.isEmpty() || str[idxs.get(idxs.size() - 1)] == ')') {
                    idxs.add(i);
                } else {
                    idxs.remove(idxs.size() - 1);
                }
            }
        }
        if (idxs.isEmpty()) return s;
        j = 0;
        for (i = 0; i < len; i++) {
            if (j < idxs.size() && i == idxs.get(j)) {
                j++;
            } else {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}
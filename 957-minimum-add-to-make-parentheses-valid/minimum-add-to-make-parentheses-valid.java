class Solution {
    public int minAddToMakeValid(String s) {
        int total = 0, bracket = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (bracket < 0) {
                    total -= bracket;
                    bracket = 0;
                }
                bracket++;
            } else bracket--; 
        }
        return total + (bracket >= 0 ? bracket: -bracket);
    }
}
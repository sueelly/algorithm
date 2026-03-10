class Solution {
    public int divide(int dividend, int divisor) {
        int q = 0;
        boolean isPositive = true;

        if (divisor < 0) {
            isPositive = !isPositive;
            divisor = -divisor;
        }
        if (dividend < 0) {
            isPositive = !isPositive;
            if (dividend == Integer.MIN_VALUE) { // MIN_VALUE만이 int 범위를 벗어남
                if (divisor == 1) return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE; // 이 케이스만이 주어진 수의 범위를 벗어날 수 있음
                q += isPositive ? 1 : -1;
                dividend += divisor;
            }
            dividend = -dividend;
        }
        // if (divisor == 1) return isPositive ? dividend : -dividend;
        if (dividend < divisor) return q;
        if (dividend == divisor) return q + (isPositive ? 1 : -1);

        // 남은 값은 dividend가 INT_MINVALUE보다 작거나 같음
        int tmp_q = 1;
        while (divisor << 1 > 0 && divisor << 1 <= dividend) {
            divisor <<= 1;
            tmp_q <<= 1;
        }

        while (divisor > 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                q += isPositive ? tmp_q : -tmp_q;
            }
            divisor >>= 1;
            tmp_q >>= 1;
        }
        return q;
    }
}
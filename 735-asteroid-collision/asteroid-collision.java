class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length, currLen = 0, i = 0, currVal;
        int[] state = new int[length];

        // 첫 -까지는 충돌 없이 저장된다
        while (i < length && asteroids[i] < 0) state[currLen++] = asteroids[i++];
        // + 다음 -인 경우에만 충돌
        while (i < length) {
            currVal = asteroids[i];
            if (currVal > 0) state[currLen++] = currVal;
            else {
                while (currLen > 0 && state[currLen - 1] > 0 && state[currLen - 1] + currVal < 0) currLen--;
                if (currLen > 0 && state[currLen - 1] + currVal == 0) currLen--;
                else if (currLen == 0 || (currLen > 0 && state[currLen - 1] < 0)) state[currLen++] = currVal;
            }
            i++;
        }

        return Arrays.copyOf(state, currLen);
    }
}
class Solution
{
    public int solution(int n, int a, int b)
    {
        int res = 0;
        while (a != b) {
            if (a % 2 != 0) a++;
            if (b % 2 != 0) b++;
            a /= 2;
            b /= 2;
            res++;
        }
        return res;
    }
}
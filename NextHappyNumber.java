public class NextHappyNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.print(nextHappy(n));
    }

    static int nextHappy(int N) {
        while (true) {
            N++; // Move to the next number
            int slow = N;
            int fast = N;

            do {
                slow = findSquare(slow);
                fast = findSquare(findSquare(fast));
            } while (slow != fast && slow != 1);

            if (slow == 1) {
                return N; // N is a happy number
            }
        }
    }

    static int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int remainder = n % 10;
            ans += remainder * remainder;
            n /= 10;
        }
        return ans;
    }
}

class Solution {
public:
    int addDigits2(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }
        if (sum < 10) {
            return sum;
        } 
        return addDigits(sum);
    }
    
    int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int remain = num%9;
        return (remain == 0 ? 9 : remain);
    }
};

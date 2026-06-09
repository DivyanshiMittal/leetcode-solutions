//time complexity: O(n) 
//space complexity: O(1)



class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));

            if (i < s.length() - 1) {
                int next = getValue(s.charAt(i + 1));

                if (curr < next) {
                    result -= curr;
                } else {
                    result += curr;
                }
            } else {
                result += curr;
            }
        }

        return result;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
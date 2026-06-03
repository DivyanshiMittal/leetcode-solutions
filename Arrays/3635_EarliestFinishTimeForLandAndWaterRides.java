
//Time Complexity: O(n log n + m log m)
//Space Complexity: O(m)

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                   int[] waterStartTime, int[] waterDuration) {

        long ans = Math.min(
                solve(landStartTime, landDuration,waterStartTime,waterDuration),
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration)
        );

        return (int)ans;
    }

    private long solve(int[] firstStart, int[] firstDuration,
                       int[] secondStart, int[] secondDuration) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        java.util.Arrays.sort(rides,
                (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];

            if (i == 0) {
                prefixMinDur[i] = rides[i][1];
            } else {
                prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            long value = (long) rides[i][0] + rides[i][1];

            if (i == m - 1) {
                suffixMinStartPlusDur[i] = value;
            } else {
                suffixMinStartPlusDur[i] =
                        Math.min(suffixMinStartPlusDur[i + 1], value);
            }
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishTime =
                    (long) firstStart[i] + firstDuration[i];

            int idx = upperBound(starts, (int) finishTime);

            long best = Long.MAX_VALUE;

            if (idx > 0) {
                best = Math.min(
                        best,
                        finishTime + prefixMinDur[idx - 1]
                );
            }

            if (idx < m) {
                best = Math.min(
                        best,
                        suffixMinStartPlusDur[idx]
                );
            }

            result = Math.min(result, best);
        }

        return result;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
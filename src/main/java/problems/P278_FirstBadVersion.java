package problems;

import myUtils.VersionControl;

/**
 * 问题链接：https://leetcode.com/problems/first-bad-version/
 * <p>
 * <p>
 * 问题描述：
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class P278_FirstBadVersion extends VersionControl {
    public int firstBadVersion1(int n) {
        int low = 0;
        int hi = n;
        while (low < hi) {
            int middle = low + (hi - low) / 2;
            if (isBadVersion(middle)) {
                if (middle == 0 || !isBadVersion(middle - 1)) {
                    return middle;
                }
                hi = middle - 1;
            } else {
                if (middle + 1 <= n && isBadVersion(middle + 1)) {
                    return middle + 1;
                }
                low = middle + 1;
            }
        }

        return -1;
    }

    public int firstBadVersion2(int n) {
        int low = 0;
        int hi = n;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

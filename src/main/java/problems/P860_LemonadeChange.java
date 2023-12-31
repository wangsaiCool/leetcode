package problems;

/**
 * Created by WangSai on 2019-05-19 22:54
 *
 * 题目链接：https://leetcode.com/problems/lemonade-change/
 *
 * 题目描述：
 * At a lemonade stand, each lemonade costs $5.
 *
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 *
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Return true if and only if you can provide every customer with correct change.
 *
 *
 *
 * Example 1:
 *
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * Example 2:
 *
 * Input: [5,5,10]
 * Output: true
 * Example 3:
 *
 * Input: [10,10]
 * Output: false
 * Example 4:
 *
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can't give change of $15 back because we only have two $10 bills.
 * Since not every customer received correct change, the answer is false.
 *
 *
 * Note:
 *
 * 0 <= bills.length <= 10000
 * bills[i] will be either 5, 10, or 20.
 */


public class P860_LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int payment : bills) {
            if (payment == 5) {
                five++;
                continue;
            } else if (payment == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 ) {
                return false;
            }

        }
        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int record5 = 0, record10 = 0;
        int sum = 0;

        for (int i = 0; i < bills.length; i++) {
            int payment = bills[i];
            if (payment == 5) {
                record5 += 1;
                sum+=5;
                continue;
            }

            if (payment == 10) {
                record10 += 1;
            }

            sum += 5;
            int payBack = payment - 5;
            if (sum < payBack) {
                return false;
            }

            if (record5 == 0) {
                return false;
            }


            if (payBack == 15) {
                if (record10 > 0) {
                    record10--;
                    record5--;
                    continue;
                } else {
                    if (record5 >= 3) {
                        record5 -= 3;
                        continue;
                    } else {
                        return false;
                    }
                }

            } else {
                if (record5 > 0) {
                    record5--;
                } else {
                    return false;
                }
            }

        }
        return true;

    }

    public static void main(String[] args) {
        P860_LemonadeChange p = new P860_LemonadeChange();
        p.lemonadeChange(new int[]{5, 5, 5, 10, 20});
    }
}
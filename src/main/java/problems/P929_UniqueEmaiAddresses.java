package Problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by WangSai on 2/19/19
 */
public class P929_UniqueEmaiAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<String>();
        for (String email : emails) {
            String[] nameAndDomain = email.split("@");
            String name = nameAndDomain[0];
            String domain = nameAndDomain[1];
            name = name.replaceAll("\\.", "");
            name = name.split("\\+")[0];
            unique.add(name + domain);
        }
        return unique.size();

    }

    public static void main(String[] args) {
        String[] emails = new String[] {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new P929_UniqueEmaiAddresses().numUniqueEmails(emails));
    }
}

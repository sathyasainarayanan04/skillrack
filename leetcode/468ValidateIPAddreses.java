import java.util.regex.*;
class Solution {
    public String validIPAddress(String queryIP) {
        String IPV4Pattern = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}"+
                             "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String IPV6Pattern = "((([0-9a-fA-F]){1,4})\\:){7}"+"(([0-9a-fA-F]){1,4})";
        Pattern ipv4regex = Pattern.compile(IPV4Pattern);
        Pattern ipv6regex = Pattern.compile(IPV6Pattern);
        if(ipv4regex.matcher(queryIP).matches())return "IPv4";
        if(ipv6regex.matcher(queryIP).matches())return "IPv6";
        return "Neither";
    }
}

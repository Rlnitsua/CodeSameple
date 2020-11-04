package rlnitsua.array;

import java.util.regex.Pattern;

public class ValidateIPAddress {
    private static final int IPV4_LEN = 4;
    private static final int IPV6_LEN = 8;
    private static final String ERROR = "Neither";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";


    public String validIPAddress(String IP) {
        if (IP.isEmpty()) {
            return ERROR;
        }

        boolean isContainPoint = IP.contains(".");
        boolean isContainColon = IP.contains(":");
        if (isContainPoint && isContainColon) {
            return ERROR;
        } else if (isContainPoint) {
            return isIPv4(IP);
        } else if (isContainColon) {
            return isIPv6(IP);
        } else {
            return ERROR;
        }
    }

    private String isIPv4(String IP) {
        String[] parts = IP.split("\\.");
        if (parts.length == IPV4_LEN) {
            for (String part : parts) {
                if (IP.endsWith(".")) {
                    return ERROR;
                }
                if (!isIPv4Part(part)) {
                    return ERROR;
                }
            }
            return IPV4;
        } else {
            return ERROR;
        }
    }

    private boolean isIPv4Part(String part) {
        if (part.isEmpty()) {
            return false;
        }

        int num;
        try {
            num = Integer.parseInt(part);
        } catch (Exception e) {
            return false;
        }

        if (num < 0 || num > 255) {
            return false;
        }

        return part.length() == 1 || part.toCharArray()[0] != '0';
    }

    private String isIPv6(String IP) {
        String[] parts = IP.split(":");
        String regex = "^(\\d|[a-f]|[A-F]){1,4}$";
        if (parts.length == IPV6_LEN) {
            if (IP.endsWith(":")) {
                return ERROR;
            }
            for (String part : parts) {
                if (!Pattern.matches(regex, part)) {
                    return ERROR;
                }
            }
            return IPV6;
        } else {
            return ERROR;
        }
    }

}

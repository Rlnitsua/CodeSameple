package rlnitsua.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidateIPAddressTest {
    private final String IP;
    private final String res;

    public ValidateIPAddressTest(String IP, String res) {
        this.IP = IP;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"192.168.1.1", "IPv4"},
                {"192.168.1.0", "IPv4"},
                {"192.168.01.1", "Neither"},
                {"192.168.1.00", "Neither"},
                {"192.168@1.1", "Neither"},
                {"2001:0db8:85a3:0000:0000:8a2e:0370:7334", "IPv6"},
                {"2001:db8:85a3:0:0:8A2E:0370:7334", "IPv6"},
                {"2001:0db8:85a3::8A2E:037j:7334", "Neither"},
                {"02001:0db8:85a3:0000:0000:8a2e:0370:7334", "Neither"},
                {"2001:0db8:85a3:0000:0000:8a2e:0370:7334:", "Neither"},
        });
    }

    @Test
    public void test() {
        ValidateIPAddress demo = new ValidateIPAddress();
        assertEquals(res, demo.validIPAddress(IP));
    }

}
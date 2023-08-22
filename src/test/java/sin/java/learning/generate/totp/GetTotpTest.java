package sin.java.learning.generate.totp;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetTotpTest {

    @Test
    public void getTOTP() {
        GetTotp topt = new GetTotp();
        System.out.println(topt.getTOTP());
    }
}
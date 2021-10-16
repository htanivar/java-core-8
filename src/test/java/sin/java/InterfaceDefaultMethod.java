package sin.java;

import org.junit.Test;
import sin.java.interfaces.MovementInt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InterfaceDefaultMethod implements MovementInt {
    @Test
    public void defaultInterfaceMethod() {
        assertThat(how()).isEqualTo("I am moving without Implementation Class - New Style");
    }
}

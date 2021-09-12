package sin.java.interfaces;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MovementImplOldStyleTest {

    @Test
    public void test_howOldStyle() {
        MovementImplOldStyle movementImplOldStyle = new MovementImplOldStyle();
        assertThat(movementImplOldStyle.howOldStyle()).isEqualTo("I am moving from Implementation Class - Old Style");
    }

    @Test
    public void test_howDefaultNewStyle() {
        MovementImplOldStyle movementImplOldStyle = new MovementImplOldStyle();
        assertThat(movementImplOldStyle.how()).isEqualTo("I am implemented in Interface with default - New Style");
    }
}
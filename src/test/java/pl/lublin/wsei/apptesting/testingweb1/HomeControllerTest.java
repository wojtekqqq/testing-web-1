package pl.lublin.wsei.apptesting.testingweb1;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeControllerTest {

    @Autowired
    private HomeController controller;

    @Test
    public void presence() throws Exception {
        assertThat(controller).isNotNull();
    }
    @Test
    public void testCalculate() {
        // Test addition
        String opcode = "add";
        String op1 = "2";
        String op2 = "3";
        String expectedResult = "Wynik operacji:5,00";
        String actualResult = controller.calculate(opcode, op1, op2);
        assertEquals(expectedResult, actualResult);

        // Test subtraction
        opcode = "subtract";
        op1 = "5";
        op2 = "3";
        expectedResult = "Wynik operacji:2,00";
        actualResult = controller.calculate(opcode, op1, op2);
        assertEquals(expectedResult, actualResult);

        // Test multiplication
        opcode = "multiply";
        op1 = "2";
        op2 = "3";
        expectedResult = "Wynik operacji:6,00";
        actualResult = controller.calculate(opcode, op1, op2);
        assertEquals(expectedResult, actualResult);

        // Test division
        opcode = "divide";
        op1 = "6";
        op2 = "3";
        expectedResult = "Wynik operacji:2,00";
        actualResult = controller.calculate(opcode, op1, op2);
        assertEquals(expectedResult, actualResult);
    }
}

package pl.lublin.wsei.apptesting.testingweb1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello, World");
    }
    @Test
    public void testCalculateAddition() {
        String opcode = "add";
        String op1 = "2";
        String op2 = "3";
        String expectedResult = "Wynik operacji:5,00";
        String actualResult = restTemplate.getForObject("http://localhost:" + port + "/calculate?opcode=" + opcode + "&op1=" + op1 + "&op2=" + op2,
                String.class, opcode, op1, op2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testCalculateSubtraction() {
        String  opcode = "subtract";
        String  op1 = "5";
        String  op2 = "3";
        String  expectedResult = "Wynik operacji:2,00";
        String  actualResult = restTemplate.getForObject("http://localhost:" + port + "/calculate?opcode=" + opcode + "&op1=" + op1 + "&op2=" + op2,
                String.class, opcode, op1, op2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testCalculateMultiplication() {
        String opcode = "multiply";
        String op1 = "2";
        String op2 = "3";
        String expectedResult = "Wynik operacji:6,00";
        String actualResult = restTemplate.getForObject("http://localhost:" + port + "/calculate?opcode=" + opcode + "&op1=" + op1 + "&op2=" + op2,
                String.class, opcode, op1, op2);
        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    public void testCalculateDivision() {
        String opcode = "divide";
        String op1 = "6";
        String op2 = "3";
        String expectedResult = "Wynik operacji:2,00";
        String actualResult = restTemplate.getForObject("http://localhost:" + port + "/calculate?opcode=" + opcode + "&op1=" + op1 + "&op2=" + op2,
                String.class, opcode, op1, op2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }






}

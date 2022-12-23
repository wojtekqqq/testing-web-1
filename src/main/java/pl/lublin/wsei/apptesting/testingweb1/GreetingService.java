package pl.lublin.wsei.apptesting.testingweb1;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hello, World of Services";
    }
}

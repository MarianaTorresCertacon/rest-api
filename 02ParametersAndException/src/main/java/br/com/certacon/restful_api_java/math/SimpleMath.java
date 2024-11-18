package br.com.certacon.restful_api_java.math;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SimpleMath {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }
}

package com.ifgoiano.br.edu.calculadora.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifgoiano.br.edu.calculadora.SimpleMath;


@RestController
public class MathController {
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum (@PathVariable(value = "number1")String number1,
                        @PathVariable(value ="number2")String number2){

                            Double n1 = Double.parseDouble(number1);
                            Double n2 = Double.parseDouble(number2);

                            return math.sum(n1, n2);
                        }
    
    
    
}

package com.ifgoiano.br.edu.calculadora.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifgoiano.br.edu.calculadora.NumConverter;
import com.ifgoiano.br.edu.calculadora.SimpleMath;
import com.ifgoiano.br.edu.calculadora.UnsupportedMathOperationException;

@RestController
public class MathController {
    private SimpleMath math = new SimpleMath();

    // Se receber apenas um número, define que number2 = 0
    @RequestMapping(value = "/sum/{number1}/", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "number1") String number1) throws Exception {
        return sum(number1, "0"); // Chama o outro método passando "0" como padrão
    }

    // Se receber apenas um número, define que number2 = 0
    @RequestMapping(value = "/sub/{number1}/", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "number1") String number1) throws Exception {
        return sub(number1, "0"); // Chama o outro método passando "0" como padrão
    }

    // Se receber apenas um número, define que number2 = 1
    @RequestMapping(value = "/div/{number1}/", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "number1") String number1) throws Exception {
        return div(number1, "1"); // Chama o outro método passando "1" como padrão
    }

    // ************** Metodo de soma **************
    // Define um endpoint GET para somar dois números passados na URL
    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2) throws Exception {

        // Verifica se os valores recebidos são numéricos
        if (!NumConverter.isNumeric(number1) || !NumConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Por favor, coloque um valor numérico!");
        }

        // Converte os valores para double e realiza a soma
        return math.sum(NumConverter.convertToDouble(number1),
                NumConverter.convertToDouble(number2));

    } // ************** Fim metodo de soma **************

    // ************** Metodo de subtração **************
    // Define um endpoint GET para subtrair dois numeros passados na URL
    @RequestMapping(value = "/sub/{number1}/{number2}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2) throws Exception {

        // Verifica se os valores passados são numericos
        if (!NumConverter.isNumeric(number1) || !NumConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Por favor, coloque um valor numerico!");
        }

        // Convete os valores para Double e realiza a subtração
        return math.subtraction(NumConverter.convertToDouble(number1),
                NumConverter.convertToDouble(number2));

    }// ************** Fim metodo de subtração **************

    // ************** Metodo de divisão **************
    @RequestMapping(value = "/div/{number1}/{number2}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2) throws Exception {

        if (!NumConverter.isNumeric(number1) || !NumConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Por favor, coloque um valor numerico!");
        }

        return math.division(NumConverter.convertToDouble(number1),
                NumConverter.convertToDouble(number2));

    }// ************** Fim metodo de divisão **************

}

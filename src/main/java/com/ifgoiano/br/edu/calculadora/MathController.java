package com.ifgoiano.br.edu.calculadora;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    private SimpleMath math = new SimpleMath();

    // Se receber apenas um número, define que number2 = 0
    @RequestMapping(value = "/sum/{number1}/", method = RequestMethod.GET)
    public Double sum1(@PathVariable(value = "number1") String number1) throws Exception {
        return sum(number1, "0"); // Chama o método 'sum' passando "0" como valor para number2
    }

    // Se receber apenas um número, define que number2 = 0
    @RequestMapping(value = "/sub/{number1}/", method = RequestMethod.GET)
    public Double sub1(@PathVariable(value = "number1") String number1) throws Exception {
        return sub(number1, "0"); // Chama o método 'sub' passando "0" como valor para number2
    }

    // Se receber apenas um número, define que number2 = 1
    @RequestMapping(value = "/div/{number1}/", method = RequestMethod.GET)
    public Double div1(@PathVariable(value = "number1") String number1) throws Exception {
        return div(number1, "1"); // Chama o método 'div' passando "1" como valor para number2
    }

    @RequestMapping(value = "/mean/{number1}/", method = RequestMethod.GET)
    public Double mean1(@PathVariable(value = "number1") String number1) throws Exception {
        return mean(number1, "0");
    }

    // ************** Metodo de soma **************
    // Defindo um endpoint GET para somar dois números passados na URL
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
    // Defindo um endpoint GET para subtrair dois numeros passados na URL
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
    // Definindo um endpoint GET para subtrair dois numeros passados na URL
    @RequestMapping(value = "/div/{number1}/{number2}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2) throws Exception {

        if (!NumConverter.isNumeric(number1) || !NumConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Por favor, coloque um valor numerico!");
        }

        return math.division(NumConverter.convertToDouble(number1),
                NumConverter.convertToDouble(number2));

    }// ************** Fim metodo de divisão **************

    // ************** Metodo de media dos numeros**************
    @RequestMapping(value = "/mean/{number1}/{number2}", method = RequestMethod.GET)
    public Double mean(@PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2) throws Exception {

        // Verifica se os valores inseridos são numericos
        if (!NumConverter.isNumeric(number1) & !NumConverter.isNumeric(number2)) {
            throw new UnsupportedOperationException("Por favor, coloque um valor numerico!");
        }
        // Converte os valores para Double e realiza a media dos numeros
        return math.mean(NumConverter.convertToDouble(number1),
                NumConverter.convertToDouble(number2));

    } // ************** Fim metodo de media dos numeros**************

}


/*
 * Aluno: Luis Henrique Rodrigues de Oliveira
 * Data de criação: 25/03/2025
 */

package br.edu.ifgoiano.urutai.models;

public class SimpleMath {

    public Double sum(Double number1, Double number2) {
        return number1 + number2;
    }

    public Double subtraction(Double number1, Double number2) {
        return number1 - number2;
    }

    public Double multiplication(Double number1, Double number2) {
        return number1 * number2;
    }

    public Double division(Double number1, Double number2) {
        return number1 / number2;
    }

    public Double mean(Double number1, Double number2) {
        return (number1 + number2) / 2;
    }

    public Double squadRoot(Double number) {
        return Math.sqrt(number);
    }

}


/*
 * Aluno: Luis Henrique Rodrigues de Oliveira
 * Data de criação: 25/03/2025
 */

package br.edu.ifgoiano.urutai.utils;

public class NumConverter {

    // Método que converte uma string para Double
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) // Se a string for nula retorna 0
            return 0D;

        String number = strNumber.replaceAll(",", "."); // Substitui vírgulas por pontos
        if (isNumeric(number)) // Verifica se o valor é numérico
            return Double.parseDouble(number); // Converte para Double
        return 0D; // Retorna 0 se não for numérico
    }

    // Método que verifica se uma string representa um número válido
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;

        String number = strNumber.replaceAll(",", "."); // Normaliza o formato numérico

        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // Verifica padrão numérico com regex
    }

}

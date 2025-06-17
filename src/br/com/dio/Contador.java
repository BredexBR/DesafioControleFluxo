package br.com.dio;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.dio.exceptions.ParametrosInvalidosException;
import br.com.dio.exceptions.NumeroNegativoException;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        try {
            System.out.println("Digite o primeiro parâmetro:");
            int parametroUm = terminal.nextInt();

            System.out.println("Digite o segundo parâmetro:");
            int parametroDois = terminal.nextInt();

            //chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException e) {
            //imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println("Erro: O segundo parâmetro deve ser maior que o primeiro.");
        } catch (NumeroNegativoException  | InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Por favor, digite apenas números inteiros positivos.");
        } finally {
            terminal.close();
        }
    }

    static void contar(int parametroUm, int parametroDois)
            throws ParametrosInvalidosException, NumeroNegativoException {

        validarParametros(parametroUm, parametroDois);

        int contagem = parametroDois - parametroUm;

        //realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    static void validarParametros(int parametroUm, int parametroDois)
            throws ParametrosInvalidosException, NumeroNegativoException {

        if (parametroUm < 0 || parametroDois < 0) {
            throw new NumeroNegativoException("Os parâmetros não podem ser negativos.");
        }

        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }
    }
}

package Main;

import Controller.*;

import java.util.Scanner;

public class Main {

    public static Status status;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String opS;

        while(true){

            System.out.println("t - Testes \t s - Sistema");

            opS = sc.nextLine();

            switch(opS){

                case "s", "S" -> {

                    status = Status.SISTEMA;

                    Sistema.getInstancia().iniciar();

                }

                case "t", "T" ->{

                    status = Status.TESTE;

                   Teste.getInstancia().teste();

                }

                case "0" -> {return;}

                default -> {
                    System.out.println("\nOpção invalida\n");
                    continue;
                }

            }


        }


    }

}

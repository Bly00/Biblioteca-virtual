package Model;

import java.util.Scanner;

public class    Autor {

    private int idAutor;
    private String nomeAutor;
    private String descricaoAutor;

    public Autor(){}

    public Autor(String nomeAutor, String descricaoAutor ) {
        this.descricaoAutor = descricaoAutor;
        this.nomeAutor = nomeAutor;
    }

    public String getDescriçaoAutor() {
        return descricaoAutor;
    }

    public void setDescriçaoAutor(String descriçaoAutor) {
        this.descricaoAutor = descriçaoAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

//    public void editarAutor(){
//
//        int op = 0;
//        Scanner sc = new Scanner(System.in);
//
//        do{
//
//            System.out.println("Editar: ");
//            System.out.println("1 - Nome\n2 - Descriçao\n\n 0 - terminar");
//
//            op = sc.nextInt();
//            sc.nextLine();
//
//            switch (op){
//
//                    case 0:
//                    break;
//
//                    case 1:
//
//                    System.out.println("Nome atual: " + this.nomeAutor);
//                    System.out.print("\nNovo Nome: ");
//                    this.setNomeAutor(sc.nextLine());
//
//                    break;
//
//                    case 2:
//
//                    System.out.println("Descriçao atual: " + this.descricaoAutor);
//                    System.out.print("\nNova descriçao: ");
//                    this.setDescriçaoAutor(sc.nextLine());
//
//                    break;
//
//                    default:
//
//                    System.out.println("Numero invalido");
//
//                    break;
//            }
//
//        }while(op != 0);
//
//    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Id: " + idAutor + "\n");
        sb.append("Nome: " + nomeAutor + "\n");
        sb.append("Descriçao: " + descricaoAutor + "\n");

        return sb.toString();
    } 


   }
   
   
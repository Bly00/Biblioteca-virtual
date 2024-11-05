import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        
        Biblioteca biblio = new Biblioteca();

        biblio.adicionarAutor();
        biblio.adicionarAutor();
        biblio.adicionarAutor();
        
        biblio.mostrarAutores();

        biblio.editarAutor(1);

        biblio.mostrarAutores();

    }
    
    
    private List<Autor> autores = new ArrayList<>();

    public void adicionarAutor(){

        Scanner sc = new Scanner(System.in);

        String nome, descriçao;

        System.out.print("Nome do autor:");
        nome = sc.nextLine();

        System.out.print("Descriçao do autor:");
        descriçao = sc.nextLine();

    
        Autor novoAutor = new Autor(autores.size(), nome, descriçao);
        autores.add(novoAutor);

       

    }

    public void editarAutor(int id){

        Autor autorEditado = null;

        for(Autor autor: autores){
            if(autor.getId() == id){
                autorEditado = autor;
                break;
            }
        }

        Scanner sc = new Scanner(System.in);

        int op;

        while(true){

            System.out.println("Editar nome?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nao");
            op = sc.nextInt();
            sc.nextLine();
            if(op == 1){

                System.out.println("Nome atual: " + autorEditado.getNomeAutor());
                System.out.printf("\n\nNovo nome:");

                autorEditado.setNomeAutor(sc.nextLine());

            }else{}

            System.out.println("Editar descriçao?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nao");
            op = sc.nextInt();
            sc.nextLine();
            if(op == 1){

                System.out.println("Descriçao atual: " + autorEditado.getDescriçaoAutor());
                System.out.printf("\n\nNova descriçao:");

                autorEditado.setDescriçaoAutor(sc.nextLine());

            }else{}

            break;

        }

    }

    public void mostrarAutores(){

        for (Autor autor : autores) {
            System.out.println(autor.infoAutor());
        }

    }


}

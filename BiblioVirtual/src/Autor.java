import java.util.Scanner;

public class Autor {

    private int idAutor;
    private String nomeAutor;
    private String descriçaoAutor;
    
    public String getNomeAutor() {
        return nomeAutor;
    }
    public String getDescriçaoAutor() {
        return descriçaoAutor;
    }
    
    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
    public void setDescriçaoAutor(String descriçaoAutor) {
        this.descriçaoAutor = descriçaoAutor;
    }

    public Autor(int idAutor, String nomeAutor, String descriçaoAutor) {
        this.idAutor = idAutor;
        this.nomeAutor = nomeAutor;
        this.descriçaoAutor = descriçaoAutor;
    }
    public Autor(){}

    public void editarAutor(){

        Scanner sc = new Scanner(System.in);

        int op;

        while(true){

            System.out.println("Editar nome?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nao");
            op = sc.nextInt();
            sc.nextLine();
            if(op == 1){

                System.out.println("Nome atual: " + nomeAutor);
                System.out.printf("\n\nNovo nome:");

                this.nomeAutor = sc.nextLine();

            }else{}

            System.out.println("Editar descriçao?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nao");
            op = sc.nextInt();
            sc.nextLine();
            if(op == 1){

                System.out.println("Descriçao atual: " + descriçaoAutor);
                System.out.printf("\n\nNova descriçao:");

                this.descriçaoAutor = sc.nextLine();

            }else{}

        }


    }

    public String infoAutor(){
        return "Id: " + idAutor + "\n" +
               "Nome: " + nomeAutor + "\n" +
               "Descriçao: " + descriçaoAutor + "\n";
    } 
     //edita as infos do autor

     public int getId(){
        return idAutor;
     }

     
   }
   
   
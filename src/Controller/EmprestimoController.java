package Controller;

import Model.Emprestimo;
import Model.ItemEmprestimo;
import Model.Livro;
import Model.Usuario;
import Service.EmprestimoService;
import Service.ItemEmprestimoService;
import Service.LivroService;
import Service.UsuarioService;

import java.text.SimpleDateFormat;
import java.util.*;

public class EmprestimoController {

    private EmprestimoController(){}

    private static EmprestimoController instancia;

    public static EmprestimoController getInstance(){
        if(instancia == null){
            instancia = new EmprestimoController();
        }
        return instancia;
    }

    Scanner sc = new Scanner(System.in);

    public void iniciar(){

        while(true){

            System.out.println("\n----- Menu Emprestimo-----");
            System.out.println("1 - Adicionar Emprestimo");
            System.out.println("2 - Listar Emprestimo");
            System.out.println("3 - Buscar Emprestimo por ID");
            System.out.println("4 - Remover Emprestimo");
            System.out.println("5 - Editar Emprestimo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch(op){

                case 1 -> adicionar();
                case 2 -> listar();
                case 3 -> buscarPorId();
                case 4 -> remover();
                case 5 -> editar();
                case 0 -> {
                    return;
                }
            }

        }

    }

    public void adicionar(){

        var l = LivroService.getInstancia().getLivros();

        if(l.isEmpty()){
            System.out.println("Sem livros");
            return;
        }

        var d = false;

        for(Livro x : l){
            if(x.isDisponivel()){
                d = true;
                break;
            }
        }

        if(!d){
            System.out.println("Nao ha livros disponiveis");
            return;
        }

        List<Livro> pedidos = new ArrayList<>();

        while(true){

            System.out.println("Livros disponiveis: ");

            for(Livro livro : LivroService.getInstancia().getLivros()){

              if(livro.isDisponivel() && !pedidos.contains(livro)){
                  System.out.println("Titulo: " + livro.getTituloDoLivro() + " - ID: " + livro.getIdLivro());
              }

            }

            System.out.println("Escolha o id do seu pedido\n0 - Sair");
            var op = sc.nextInt();
            sc.nextLine();

            if(op == 0){
                break;
            }

            var livro = LivroService.getInstancia().buscarPorId(op);

            if(livro != null){

                if(livro.isDisponivel()){
                    pedidos.add(livro);
                }else{
                    System.out.println("Indisponivel");
                }

            }else{
                System.out.println("Livro nao cadastrado");
            }

            System.out.println("Encerrar?\n1 - Sim\n2 - Nao");
            op = sc.nextInt();
            sc.nextLine();

            if(op == 1){
                break;
            }

        }

        List<ItemEmprestimo> itens = new ArrayList<>();

        for(Livro item : pedidos){
            itens.add(ItemEmprestimoService.getInstancia().adicionar(item));
        }

        System.out.println("Id do usuario solicitante: ");
        var u = UsuarioService.getInstancia().buscarPorId(sc.nextInt());

        if(u == null){
            System.out.println("Usuario invalido");
            return;
        }

        Emprestimo e = new Emprestimo(new Date(), itens, u);

        EmprestimoService.getInstancia().adicionar(e);

    }

    public void remover(){

    System.out.println("Digite o id: ");
    var e = EmprestimoService.getInstancia().buscarPorId(sc.nextInt());

    if(e == null){
        System.out.println("Id invalido");
        return;
    }

    System.out.println("Emprestimo removido");
    EmprestimoService.getInstancia().remover(e.getIdEmprestimo());

    }

    public void editar(){

        //implementar logica de editar

    }

    public void listar(){

      if(EmprestimoService.getInstancia().getEmprestimo().isEmpty()){
          System.out.println("Sem emprestimos");
          return;
      }

      for(Emprestimo e : EmprestimoService.getInstancia().getEmprestimo()){
          System.out.println("Id: " + e.getIdEmprestimo() + " - Quantidade de livros: " + e.getItensEmprestimo().size());
      }

      return;
    }

    public void buscarPorId(){

        System.out.println("Digite o id: ");
        Emprestimo e = EmprestimoService.getInstancia().buscarPorId(sc.nextInt());

        if(e == null){
            System.out.println("Emprestimo nao existente");
        }else{

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

            System.out.println("Id: " + e.getIdEmprestimo() + " - Quantidade de itens: " + e.getItensEmprestimo().size() + "\n\nData da realizaçao: " + sdf.format(e.getDataEmprestimo()) + "\nData de devoluçao: " + sdf.format(e.getDataDevolucao()));

            System.out.println("\nEmprestimos:");

            for(ItemEmprestimo i : e.getItensEmprestimo()){

                System.out.println(i);

            }

        }

    }

}

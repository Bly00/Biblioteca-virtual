package Main;

import Controller.*;
import Model.*;
import Service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Main.Main.status;

public class Sistema {

    static Scanner sc = new Scanner(System.in);

    private Sistema(){}

    private static Sistema instancia;

    public static Sistema getInstancia(){

        if(instancia == null){
            instancia = new Sistema();
        }

        return instancia;

    }

    private Usuario user;

    public Usuario getUser(){
        return user;
    }

    public static void main(String[] args) {

        status = Status.SISTEMA;
        Sistema.getInstancia().iniciar();

    }

    public void iniciar(){

//        Usuario admin = new Usuario("Admin", "admin@gmail.com", "admin123");
//
//        UsuarioService.getInstancia().adicionar(admin);
//
//        Autor a1 = new Autor("George Orwell", "George Orwell foi um escritor, ensaísta e jornalista britânico conhecido por sua forte crítica social e política. Sua obra é marcada por temas como totalitarismo, desigualdade social e liberdade individual. Além de 1984, Orwell escreveu A Revolução dos Bichos, outra famosa alegoria política. Seu estilo é direto e acessível, muitas vezes expondo as realidades sombrias da sociedade.");
//        Autor a2 = new Autor("John Ronald Reuel Tolkien", "J.R.R. Tolkien foi um filólogo, professor universitário e autor britânico, conhecido como o pai da moderna literatura de fantasia. Seu amor pelas línguas e mitologias influenciou suas obras, especialmente O Hobbit e O Senhor dos Anéis. Ele também criou línguas fictícias, como o élfico, e desenvolveu um rico universo de histórias na Terra Média. Seu trabalho é amplamente celebrado pela profundidade e complexidade narrativa.");
//        Autor a3 = new Autor("Machado de Assis", "Machado de Assis foi um dos maiores escritores brasileiros, fundador da Academia Brasileira de Letras e um dos principais nomes do realismo no Brasil. Suas obras, como Dom Casmurro, Memórias Póstumas de Brás Cubas e Quincas Borba, exploram temas como ironia, ambiguidades morais e introspecção psicológica. Ele é amplamente reconhecido por sua escrita refinada e capacidade de capturar as complexidades da alma humana.");
//
//        Editora e1 = new Editora(" Secker & Warburg", "Secker & Warburg foi uma editora britânica conhecida por publicar obras de cunho político e literário. Ela lançou 1984 e A Revolução dos Bichos, de George Orwell, além de livros de autores como Günter Grass e Philip Roth. A editora tinha uma forte reputação por promover autores progressistas e obras com críticas sociais marcantes. Posteriormente, foi incorporada ao Penguin Random House Group.");
//        Editora e2 = new Editora("George Allen & Unwin", "George Allen & Unwin é a editora que originalmente publicou as obras de J.R.R. Tolkien, incluindo O Hobbit e O Senhor dos Anéis. Reconhecida por seu foco em literatura acadêmica e de fantasia, a editora desempenhou um papel importante na popularização da literatura de Tolkien, ajudando a moldar a fantasia moderna. Hoje, parte de seu catálogo faz parte da HarperCollins.");
//        Editora e3 = new Editora("Tipografia Nacional", "A Tipografia Nacional foi uma das principais casas editoriais no Brasil durante o século XIX e início do século XX. Publicou Dom Casmurro, de Machado de Assis, e outras obras clássicas da literatura brasileira. Naquela época, muitas obras eram publicadas em edições limitadas e distribuídas de forma restrita, sendo acessíveis principalmente às elites literárias do país.");
//
//        Categoria c1 = new Categoria("Ficção Distópica", "A ficção distópica explora sociedades imaginárias caracterizadas por opressão, vigilância extrema e a ausência de liberdades individuais. Geralmente, essas histórias são ambientadas em futuros sombrios e têm como objetivo alertar sobre os perigos de regimes autoritários, avanços tecnológicos descontrolados e a manipulação ideológica. Em 1984, George Orwell retrata um mundo governado pelo totalitarismo, onde a privacidade e o livre-arbítrio são eliminados.");
//        Categoria c2 = new Categoria("Alta Fantasia", "A alta fantasia é um subgênero da literatura de fantasia caracterizado por mundos inteiramente fictícios, muitas vezes com uma mitologia rica, sistemas de magia complexos e narrativas épicas envolvendo o bem contra o mal. Em O Senhor dos Anéis, J.R.R. Tolkien cria a Terra Média, um universo detalhado com culturas, línguas e histórias próprias, oferecendo uma aventura profunda e inesquecível.\n");
//        Categoria c3 = new Categoria("Realismo", "O realismo busca representar a vida como ela é, com personagens complexos, dilemas morais e um foco nos aspectos psicológicos e sociais. Em Dom Casmurro, Machado de Assis mergulha nas ambiguidades emocionais e nas percepções subjetivas de Bento Santiago, explorando temas como ciúmes, traição e autoengano em um contexto da sociedade carioca do século XIX.");
//
//        AutorService.getInstancia().cadastrar(a1);
//        AutorService.getInstancia().cadastrar(a2);
//        AutorService.getInstancia().cadastrar(a3);
//
//        EditoraService.getInstancia().adiconar(e1);
//        EditoraService.getInstancia().adiconar(e2);
//        EditoraService.getInstancia().adiconar(e3);
//
//        CategoriaService.getInstancia().adicionar(c1);
//        CategoriaService.getInstancia().adicionar(c2);
//        CategoriaService.getInstancia().adicionar(c3);
//
//        List<Autor> lA = new ArrayList<>();
//        List<Categoria> lC = new ArrayList<>();
//
//        lA.add(a1);
//        lC.add(c1);
//
//        LivroService.getInstancia().adicionar(new Livro("1984", "Em um mundo controlado por um governo totalitário, onde até mesmo pensamentos são monitorados e manipulados, Winston Smith luta para preservar sua humanidade. \"1984\" é uma reflexão poderosa sobre liberdade, vigilância e a manipulação da verdade.", lA, e1, lC, 328, admin));
//
//        lA.clear();
//        lC.clear();
//
//        lA.add(a2);
//        lC.add(c2);
//
//        LivroService.getInstancia().adicionar(new Livro("O Senhor dos Anéis: A Sociedade do Anel", "Em um mundo mágico chamado Terra Média, Frodo Bolseiro embarca em uma jornada épica para destruir o Um Anel, um artefato poderoso capaz de destruir civilizações. A saga é repleta de batalhas, alianças e sacrifícios.", lA, e2, lC, 423, admin));
//
//        lA.clear();
//        lC.clear();
//
//        lA.add(a3);
//        lC.add(c3);
//
//        LivroService.getInstancia().adicionar(new Livro("Dom Casmurro", "Narrado por Bentinho, \"Dom Casmurro\" conta a história de seu amor por Capitu e os ciúmes que destruíram seu relacionamento. A obra é conhecida pela dúvida central: Capitu realmente traiu Bentinho?", lA, e3, lC, 256, admin));

        int opN = 0;

        Sistema.getInstancia().LoginCadastro();

        while(true){

            System.out.println("\n___BIBLIOTECA-VIRTUAL___\n\nUser: " + user.getNome());

            while(true){

            System.out.println("\nEntrar no acervo(1)\n\nSobre perfil de usuario(2)\n\nSobre emprestimos(3)");

            while(true){

                System.out.print("\nEscolha uma opção: ");

                opN = opcao(sc.nextLine());

            if(opN != -1){
                break;
            }else{
                System.out.println("Opção invalida");
            }

            }

            switch (opN){

                case 1 -> {Sistema.getInstancia().livros();}

                case 2 -> {System.out.println(UsuarioService.getInstancia().buscarPorId(user.getIdUsuario()));}

                case 3 -> {Sistema.getInstancia().emprestimos();}

                case 0 -> {return;}

                default -> {System.out.println("Opção invalida");}

            }

            break;

            }


        }

    }

    public void emprestimos(){

        int opN = 0;

        while(true){

            System.out.println("\t\tVoltar(0)\nVer meus emprestimos(1)\n\n");

            System.out.print("Sua opção: ");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {

                    for(Emprestimo e : user.getEmprestimosDoUsuario()){

                        System.out.println(e);

                        System.out.println();

                    }

                    System.out.println();

                }

                case 0 -> {return;}

                default -> {
                    System.out.println("Opção invalida");
                }

            }

        }

    }

    public void verMeusEmprestimos(){

        if(user.getEmprestimosDoUsuario().isEmpty()){
            System.out.println("\nVocê não tem emprestimos\n");
            return;
        }

        System.out.println("\nDados dos seus emprestimos\n");

        System.out.println("Total de emprestimos: " + user.getEmprestimosDoUsuario().size());

        System.out.print("\nEmprestimos no momento: ");

        int q = 0;

        for(Emprestimo e : user.getEmprestimosDoUsuario()){

            if(!e.getDevolvido()){
                q++;
            }

        }

        System.out.println(q);

        q = 0;

        for(Emprestimo e : user.getEmprestimosDoUsuario()){

            if(e.getDevolvido()){
                q++;
            }

        }

        System.out.println("Emprestimos finalizados: "  + q);

        if(!user.getEmprestimosDoUsuario().isEmpty()){

            System.out.print("\nEmprestimos: \n");


            for(Emprestimo e : user.getEmprestimosDoUsuario()){

                if(e.getDevolvido()){

                    System.out.print("ID: " + e.getIdEmprestimo() + " - Finalizado\n");

                }else{

                    System.out.print("ID: " + e.getIdEmprestimo() + " - Nao finalizado\n");
                }

            }

        }

        while(true){

            int opN = 0;

            System.out.println("\n\t\tVoltar(0)\n\nDevolver(1)\n");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {

                    EmprestimoController.getInstance().listar();

                    Emprestimo e = null;

                    while(true){

                        System.out.print("\nId do emprestimo: ");

                        opN = opcao(sc.nextLine());

                        e = EmprestimoService.getInstancia().buscarPorId(opN);

                        if(e != null  && user.getEmprestimosDoUsuario().contains(e)){
                            break;
                        }else{
                            System.out.println("\nOpção invalida\n");
                        }


                    }

                    EmprestimoController.getInstance().devolver(e);

                }

                case 0 -> {return;}

                default -> {
                    System.out.println("\nOpção invalida\n");
                }


            }


        }

    }

    public void livrosDisponiveis(){

        List<Livro> livros = new ArrayList<>();

        for(Livro l : LivroService.getInstancia().getLivros()){

            if(l.isDisponivel()){
                livros.add(l);
            }

        }

        if(livros.isEmpty()){
            System.out.println("Nenhum livro disponivel");
            return;
        }

        for(Livro l : livros){
            System.out.println(l.getTituloDoLivro() + " - ID: " + l.getIdLivro());
        }

        System.out.println();

    }

    public void filtrar(){

        while(true){

            int opN = 0;

            System.out.println("\n\t\tVoltar(0)\n\nPor disponiveis(1)\n\nPor autores(2)\n\nPor editoras(3)\n\nPor categoria(4)\n\nPor usuario(5)");

            System.out.print("Sua opção: ");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {
                    System.out.println();
                    Sistema.getInstancia().livrosDisponiveis();
                    System.out.println();
                }

                case 2 -> {porAutor();}

                case 3 -> {porEditora();}

                case 4 -> {porCategoria();}

                case 5 -> {porUsuario();}

                case 0 -> {return;}

                default -> {
                    System.out.println("\nOpção invalida\n");
                }
            }

        }

    }

    public void livros(){

        int opN = 0;

        if(!LivroService.getInstancia().getLivros().isEmpty()){

        System.out.println();
        LivroController.getInstancia().listar();
        System.out.println();

        }else{

            System.out.println("\nAinda não há livros cadastrados");

        }

        while(true){

            System.out.print("\n\t\tVoltar(0)\n\nPedir(1)\n\nFiltrar(2)\n\nAdicionar(3)\n\nMeus livros(4)\n\n");
            System.out.print("Sua opção: ");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {EmprestimoController.getInstance().adicionar();}

                case 2 -> {filtrar();}

                case 3 -> {adicionar();}

                case 4 -> {meusLivros();}

                case 0 -> {return;}

                default -> {
                    System.out.println("Opção invalida");
                }

            }

        }

    }

    public void meusLivros(){

        List<Livro> livrosUser = user.getLivrosDoUsuario();

        for(Livro l : livrosUser){

            System.out.print(l.getTituloDoLivro() + " ID: " + l.getIdLivro());

            if(l.isDisponivel()){
                System.out.println(" - Disponivel");
            }else{
                System.out.println(" - Indisponivel / Solicitante: " + l.getItemEmprestimo().getEmprestimoMae().getSolicitante().getNome() + "\n");
            }

        }

        while(true){

            int opN;

            System.out.println("\n\t\tVoltar(0)\n\nModificar status(1)\n\nRetirar livro(2)\n\n");

            System.out.print("Sua opção: ");

            opN = opcao(sc.nextLine());

        switch (opN){

            case 1 -> {modificarStatus();}

            case 2 -> {retirarLivro();}

            case 0 -> {return;}

            default -> {
                System.out.println("\nOpção invalida\n");
            }

        }

        }

    }

    public void modificarStatus(){

        Livro l = null;

        int opN;

        while(true){

            System.out.println("Livros não disponiveis: \n");

            for(Livro livro : user.getLivrosDoUsuario()){

                if(!livro.isDisponivel()){
                    System.out.println(livro.getTituloDoLivro() + " - ID: " + livro.getIdLivro());
                }

            }

            int aux = 0;

            for(Livro livro : user.getLivrosDoUsuario()){

               if(livro.isDisponivel()){
                   aux++;
               }

            }

            if(aux == user.getLivrosDoUsuario().size()){

                System.out.println("\nTodos os livros estão disponiveis\n");

                return;

            }


            System.out.print("\n0 - Parar \t Id do livro: ");

            opN = opcao(sc.nextLine());

            if(opN == 0){
                return;
            }

            LivroService.getInstancia().buscarPorId(opN);

            if(LivroService.getInstancia().buscarPorId(opN) != null && !LivroService.getInstancia().buscarPorId(opN).isDisponivel()){

                LivroService.getInstancia().buscarPorId(opN).setDisponivel(true);
                LivroService.getInstancia().buscarPorId(opN).getItemEmprestimo().setDevolvido(true);

                while(true){

                System.out.println("\nEncerrar? (s/n): ");

                String opS = sc.nextLine();

                if(opS.equals("s") || opS.equals("S")){
                    return;
                }else if(opS.equals("n") || opS.equals("N")){
                    break;
                }else{
                    System.out.println("\nOpção invalida\n");
                }

                }

            }else{
                System.out.println("Opção invalida");
            }

        }

    }

    public void retirarLivro(){}

    public void LoginCadastro(){

        user = null;

        System.out.println("\n___BIBLIOTECA-VIRTUAL___\n\n");

        String opS = null;
        int opN = 0;

        while(true){

            System.out.print("\n> Login < \t\t > Cadastrar < \t (L/C): ");

            opS = sc.nextLine();

            System.out.println();

            switch (opS){

                case "L", "l" -> {

                    String email;
                    String senha;

                  while(true){

                      System.out.print("Email: ");
                      email = sc.nextLine();

                      System.out.print("Senha: ");
                      senha = sc.nextLine();

                      if(email.isEmpty() || senha.isEmpty()){
                          System.out.println("\nPreenchar todos os campos\n");
                          continue;
                      }

                      break;

                  }

                  for(Usuario u : UsuarioService.getInstancia().getUsuarios()){

                      if(u.getEmail().equals(email)){

                          if(u.getSenha().equals(senha)){

                              System.out.println("Bem vindo de volta " + u.getNome() + "\n");

                              user = u;

                              break;

                          }

                      }

                  }

                  if(user != null){
                      return;
                  }else{
                      System.out.println("\nEmail ou senha invalida\n");
                  }

                  LoginCadastro();

                }

                case "C", "c" -> {

                    UsuarioController.getInstance().adicionar();

                    user = UsuarioService.getInstancia().buscarPorId(UsuarioService.getInstancia().getUsuarios().size());

                }

                default -> {

                    System.out.println("Opção invalida");
                    continue;

                }



            }

            break;

        }

    }

    public void adicionar(){

        int opN = 0;

        while(true){

            System.out.println("\n\nLivro(1)\n\nAutor(2)\n\nEditora(3)\n\nCategoria(4)\n\n");

            opN = opcao(sc.nextLine());

            switch (opN){

                case 1 -> {LivroController.getInstancia().adicionar();}

                case 2 -> {AutorController.getInstancia().adicionar();}

                case 3 -> {EditoraController.getInstancia().adicionar();}

                case 4 -> {CategoriaController.getInstancia().adicionar();}

                case 0 -> {return;}

                default -> {
                    System.out.println("\nOpção invalida\n");
                }

            }

        }

    }

    public void porAutor(){

        System.out.println();

        AutorController.getInstancia().listar();
        int opN = 0;

        Autor autor = null;

        while(true){

            System.out.print("ID do autor: ");

            opN = opcao(sc.nextLine());

            autor = AutorService.getInstancia().buscarPorId(opN);

            if(autor != null){
                break;
            }else{
                System.out.println("\nId invalido\n");
            }

        }

        System.out.println("Livros do autor: " + autor.getNomeAutor() + "\n");

        for(Livro l : autor.getLivros()){

            System.out.print(l.getTituloDoLivro() + " - ID: " + l.getIdLivro() + " - ");
            if(l.isDisponivel()){
                System.out.println("Disponivel");
            }else{
                System.out.println("Indisponivel");
            }

        }

    }

    public void porCategoria(){

        System.out.println();

        CategoriaController.getInstancia().listar();
        int opN = 0;

        Categoria categoria = null;

        while(true){

            System.out.print("ID do autor: ");

            opN = opcao(sc.nextLine());

            categoria = CategoriaService.getInstancia().buscarPorId(opN);

            if(categoria != null){
                break;
            }else{
                System.out.println("\nId invalido\n");
            }

        }

        System.out.println("Livros da categoria: " + categoria.getNomeCategoria() + "\n");

        for(Livro l : categoria.getLivros()){

            System.out.print(l.getTituloDoLivro() + " - ID: " + l.getIdLivro() + " - ");
            if(l.isDisponivel()){
                System.out.println("Disponivel");
            }else{
                System.out.println("Indisponivel");
            }

        }

    }

    public void porEditora(){

        System.out.println();

        EditoraController.getInstancia().listar();
        int opN = 0;

        Editora editora = null;

        while(true){

            System.out.print("ID do autor: ");

            opN = opcao(sc.nextLine());

            editora = EditoraService.getInstancia().buscarPorId(opN);

            if(editora != null){
                break;
            }else{
                System.out.println("\nId invalido\n");
            }

        }


        System.out.println("Livros da editora: " + editora.getNomeEditora() + "\n");

        for(Livro l : editora.getLivros()){

            System.out.print(l.getTituloDoLivro() + " - ID: " + l.getIdLivro() + " - ");
            if(l.isDisponivel()){
                System.out.println("Disponivel");
            }else{
                System.out.println("Indisponivel");
            }

        }

    }

    public void porUsuario(){

        System.out.println();

        UsuarioController.getInstance().listar();
        int opN = 0;

        Usuario user = null;

        while(true){

            System.out.print("ID do usuario: ");

            opN = opcao(sc.nextLine());

            user = UsuarioService.getInstancia().buscarPorId(opN);

            if(user != null){
                break;
            }else{
                System.out.println("\nId invalido\n");
            }

        }


        System.out.println("Livros da editora: " + user.getNome() + "\n");

        for(Livro l :user.getLivrosDoUsuario()){

            System.out.print(l.getTituloDoLivro() + " - ID: " + l.getIdLivro() + " - ");
            if(l.isDisponivel()){
                System.out.println("Disponivel");
            }else{
                System.out.println("Indisponivel");
            }

        }

    }

    public int opcao(String op){

        int opc;

        try{

            opc = Integer.parseInt(op);
            return opc;

        }catch (Exception e){
            return -1;
        }

    }

}

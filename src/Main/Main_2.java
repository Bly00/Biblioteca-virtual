//package Main;
//
//import Model.Emprestimo;
//import Model.Livro;
//import Model.Usuario;
//import Repository.*;
//        import Service.*;
//
//        import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main{
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//
//        Usuario Admin =   UsuarioService.getInstancia().cadasstraUsuario("Admin", "Admin@gmail.com", "Admin123");
//
//
//        int opCasos = 0;
//        int opAmostra = 0;
//        int opCadastro = 0;
//        int opFuncoes = 0;
//
//
//        do{//Loop principal
//
//            System.out.println("1 - Mostrar\n2 - Cadastro\n3 - Funcoes de emprestimo\n0 - Sair");
//            opCasos = sc.nextInt();
//
//            switch (opCasos){//escolhas de menu
//
//                case 1: //Caso de amostras
//
//                    do{
//
//                        System.out.println("Amostra:\n1 - Livros\n2 - Autores\n3 - Editoras\n4 - Categorias\n0 - Sair");
//                        opAmostra = sc.nextInt();
//
//
//                        switch (opAmostra){
//
//                            case 1:
//                                LivroRepository.getInstancia().listaTodosLivros();
//                                break;
//
//                            case 2:
//                                AutorRepository.getInstancia().ListaTodosAutor();
//                                break;
//
//                            case 3:
//                                EditoraRepository.getInstancia().ListaTodasEditora();
//                                break;
//
//                            case 4:
//                                CategoriaRepository.getInstancia().ListaTodosCategoria();
//                                break;
//                            case 5:
//                                EmprestimoRepository.getInstancia().ListaTodosEmprestimo();
//                                break;
//
//                        }
//
//                    }while(opAmostra != 0);
//
//                    break;
//
//                case 2://Caso de cadastros
//
//
//                    do{
//
//                        System.out.println("Cadastro:\n1 - Livros\n2 - Autores\n3 - Editoras\n4 - Categorias\n0 - Sair");
//                        opCadastro = sc.nextInt();
//                        sc.nextLine();
//
//                        switch (opCadastro){
//
//                            case 1:
//
//                                System.out.print("Titulo: ");
//                                String titulo = sc.nextLine();
//
//                                System.out.println("Escolha o autor pelo id\n0 - Sair");
//
//                                AutorRepository.getInstancia().ListaTodosAutor();
//
//                                System.out.println("Se o autor nao estiver aqui, saia e adicione ele");
//
//                                int idAutor = sc.nextInt();
//
//
//                                if(idAutor == 0){
//                                    break;
//                                }
//
//                                //---------------------------------------------------------
//
//                                System.out.println("Escolha a editora pelo id\n0 - Sair");
//
//                                EditoraRepository.getInstancia().ListaTodasEditora();
//
//                                System.out.println("Se a editora nao estiver aqui, saia e adicione ele");
//
//                                int idEditora = sc.nextInt();
//
//                                if(idEditora == 0){
//                                    break;
//                                }
//
//                                //---------------------------------------------------------
//
//                                System.out.println("Escolha a categoria pelo id\n0 - Sair");
//
//                                CategoriaRepository.getInstancia().ListaTodosCategoria();
//
//                                System.out.println("Se a categoria nao estiver aqui, saia e adicione ele");
//
//                                int idCategoria = sc.nextInt();
//
//                                if(idCategoria == 0){
//                                    break;
//                                }
//
//                                //-----------------------------------------------------------
//
//                                System.out.print("Quantodade de paginas:");
//                                int paginas = sc.nextInt();
//                                sc.nextLine();
//
//                                UsuarioService.getInstancia().emprestarLivro(titulo, AutorRepository.getInstancia().buscarPorId(idAutor),EditoraRepository.getInstancia().buscarPorId(idEditora),CategoriaRepository.getInstancia().buscarPorId(idCategoria), paginas, Admin);
//
//                                break;
//
//                            case 2:
//                                System.out.print("Nome do autor(a): ");
//                                String nomeAutor = sc.nextLine();
//
//                                System.out.print("Descriçao do autor(a): ");
//                                String descriçaoAutor = sc.nextLine();
//
//                                AutorService.getInstancia().cadastrarAutor(nomeAutor, descriçaoAutor);
//                                break;
//
//                            case 3:
//                                System.out.print("Nome da editora: ");
//                                String nomeEditora = sc.nextLine();
//
//                                System.out.print("Descriçao da editora: ");
//                                String descriçaoEditora = sc.nextLine();
//
//                                EditoraService.getInstancia().cadastrarEditora(nomeEditora, descriçaoEditora);
//                                break;
//
//                            case 4:
//                                System.out.print("Nome da categoria: ");
//                                String nomeCategoria = sc.nextLine();
//
//                                System.out.print("Descriçao da categoria: ");
//                                String descriçaoCategoria = sc.nextLine();
//
//                                CategoriaService.getInstancia().cadastrarCategoria(nomeCategoria, descriçaoCategoria);
//                                break;
//
//                        }
//
//                    }while(opCadastro != 0);
//
//                    break;
//
//                case 3://Escolha de funcoes;
//
//                    do{
//
//                        System.out.println("Funcoes de Emprestimo\n1 - Fazer emprestimo\n0 - Sair");
//                        opFuncoes = sc.nextInt();
//
//                        switch (opFuncoes){
//
//                            case 1:
//
//                                int escolhaLivros = 1;
//                                List<Livro> escolhas = new ArrayList<>();
//
//                                System.out.println("Livros:");
//                                LivroService.getInstancia().mostrarLivros();
//                                System.out.println("Escolha os livros pelo ID // 0 - Sair");
//
//                                while(true){
//
//                                    System.out.print("Digite o ID:");
//                                    escolhaLivros = sc.nextInt();
//
//                                    if(escolhaLivros == 0){
//                                        break;
//                                    }
//
//                                    escolhas.add(LivroRepository.getInstancia().buscarPirUd(escolhaLivros));
//
//                                }
//
//                                EmprestimoService.getInstancia().criarEmprestimo(Admin, escolhas);
//
//                                break;
//
//                            case 2:
//
//
//
//                                break;
//
//                        }
//
//                    }while(opFuncoes != 0);
//
//
//                    break;
//            }
//
//        }while(opCasos != 0);
//    }
//
//
//
//}

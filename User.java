import java.util.Scanner;
import java.util.UUID; //CLASSE PARA GERAR ID ÚNICO PARA CADA USUÁRIO

//CLASSE QUE REPRESENTA UM USUÁRIO DO SISTEMA.
public class User {

    //ATRIBUTOS DA CLASSE
    private String idUser, name, login, key;
    private Sector sector;

    //CONSTRUTOR QUE CRIA UM NOVO USUÁRIO E GERA ID ÚNICO AUTOMATICAMENTE:
    public User(String name, String login, String key, Sector sector){
        this.idUser = UUID.randomUUID().toString(); //GERA ID ÚNICO PARA CADA USER.
        this.name = name;
        this.login = login;
        this.key = key;
        this.sector = sector;
    }

    //GETTERS E SETTERS

    //RETORNA O ID DO USUÁRIO.
    public String getIdUser() {
        return idUser;
    }

    //ALTERA O ID DO USUÁRIO.
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    //RETORNA A SENHA DO USUÁRIO.
    public String getKey() {
        return key;
    }

    //ALTERA A SENHA DO USUÁRIO.
    public void setKey(String key) {
        this.key = key;
    }

    //RETORNA O LOGIN DO USUÁRIO.
    public String getLogin() {
        return login;
    }

    //ALTERA O LOGIN DO USUÁRIO.
    public void setLogin(String login) {
        this.login = login;
    }

    //RETORNA O NOME DO USUÁRIO.
    public String getName() {
        return name;
    }

    //ALTERA O NOME DO USUÁRIO.
    public void setName(String name) {
        this.name = name;
    }

    //RETORNA O SETOR DO USUÁRIO.
    public Sector getSector() {
        return sector;
    }

    //ALTERA O SETOR DO USUÁRIO.
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    //VERIFICA SE O USUÁRIO PERTENCE AO SETOR PROJECT.
    public boolean teamProject() {
        return this.sector == Sector.PROJECT;
    }

    //VERIFICA SE O USUÁRIO PERTENCE AO SETOR TEST.
    public boolean teamTest() {
        return this.sector == Sector.TEST;
    }

    //RETORNA UMA REPRESENTAÇÃO TEXTUAL DO USUÁRIO.
    public String toString() {
        return "ID: " + idUser + "\n"
                + "Nome: " + name + "\n"
                + "Setor: " + sector + "\n"
                + "Login: " + login;
    }

    //MENUS E MÉTODOS PRA INTERAÇÃO:

    //MENU PARA USUÁRIOS DO SETOR PROJECT.
    public static void showMenuProject(User newUser, ArrayDB arrayDB, Scanner scan) {
        while (true){
            System.out.println("\n--- MENU PROJETOS ---");
            System.out.println("1 - Cadastrar Obra");
            System.out.println("2 - Visualizar Obras");
            System.out.println("3 - Ler Solicitações de Revisão");
            System.out.println("4 - Histórico de Modificações");
            System.out.println("5 - Sair");

            int optionChosen = Integer.parseInt(scan.nextLine().trim());

            switch (optionChosen){
                case 1:
                    registerWork(arrayDB, newUser, scan);
                    break;
                case 2:
                    viewWork(arrayDB);
                    break;
                case 3:
                    readRequests(arrayDB);
                    break;
                case 4:
                    System.out.println("Em construção...");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    //METODO PARA CADASTRAR UMA NOVA OBRA (PROJETO) PELO SETOR PROJECT.
    public static void registerWork(ArrayDB arrayDB, User newUser, Scanner scan) {
        System.out.println("Informe o nome da Obra:");
        String nameProject = scan.nextLine().trim();
        System.out.println("Informe o CO da obra:");
        int numberReference = Integer.parseInt(scan.nextLine().trim());

        Project newProject = new Project(nameProject, numberReference, newUser);
        arrayDB.addProject(newProject);

        System.out.println("Obra cadastrada com sucesso!");
        System.out.println(newProject);
    }

    //EXIBE TODAS AS OBRAS CADASTRADAS.
    public static void viewWork(ArrayDB arrayDB) {
        if (arrayDB.getProjects().isEmpty()) {
            System.out.println("Nenhuma obra cadastrada.");
            return;
        }
        for (Project projectAdiction : arrayDB.getProjects()) {
            System.out.println(projectAdiction);
            System.out.println("----");
        }
    }

    //EXIBE TODAS AS SOLICITAÇÕES DE REVISÃO CADASTRADAS.
    public static void readRequests(ArrayDB arrayDB) {
        if (arrayDB.getReviewRequests().isEmpty()) {
            System.out.println("Nenhuma solicitação de revisão cadastrada.");
            return;
        }
        System.out.println("\n--- Solicitações de Revisão ---");
        for (RequestReview req : arrayDB.getReviewRequests()) {
            req.readRequest();
            System.out.println("----");
        }
    }

    //MENU PARA USUÁRIOS DO SETOR TEST.
    public static void showMenuTest(User newUser, ArrayDB arrayDB, Scanner scan) {
        while (true){
            System.out.println("\nMENU TESTE");
            System.out.println("1 - Visualizar Obras");
            System.out.println("2 - Solicitar Alteração");
            System.out.println("3 - Histórico de Modificações");
            System.out.println("4 - Sair");

            int optionChosen = Integer.parseInt(scan.nextLine().trim());

            switch (optionChosen){
                case 1:
                    viewWork(arrayDB);
                    break;
                case 2:
                    //SOLICITA DADOS PARA CRIAR UMA NOVA SOLICITAÇÃO DE REVISÃO
                    System.out.println("Digite o nome do projeto que deseja alterar:");
                    String projectName = scan.nextLine().trim();
                    System.out.println("Informe o motivo da solicitação:");
                    String justification = scan.nextLine().trim();
                    RequestReview req = new RequestReview(newUser, projectName, justification);
                    arrayDB.addReviewRequest(req);
                    System.out.println("Solicitação criada:");
                    req.readRequest();
                    break;
                case 3:
                    System.out.println("Em construção...");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
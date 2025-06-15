import java.util.Scanner; // SCANNER PARA A ENTRADA DE DADOS;

public class Application {

    // SCANNER ESTÁICO PARA MÚLTIPLAS ENTRADAS DE DADOS:
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args){
        ArrayDB arrayDB = new ArrayDB(); // Cria o "banco de dados" em memória

        // RECEBO OS DADOS DO USUÁRIO:
        System.out.println("\n-- Sistema de Gerenciamento de Projetos --");
        System.out.print("Informe seu nome: ");
        String nameIn = scan.nextLine().trim();
        System.out.print("Informe seu login: ");
        String loginIn = scan.nextLine().trim();
        System.out.print("Digite sua senha: ");
        String keyIn = scan.nextLine().trim();
        Sector sector = null;

        // ENQUANTO NÃO FOR VÁLIDO O SETOR, A SOLICITAÇÃO CONTINUA:
        while (sector == null) {
            System.out.println("Informe seu setor digitando o número correspondente:");
            System.out.println("Digite 1 para o setor de Projetos");
            System.out.println("Digite 2 para o setor de Teste");
            int sectorIn; //VARIÁVEL PARA RECEBER A RESPOSTA;

            try {
                sectorIn = Integer.parseInt(scan.nextLine().trim());//RECEBO A RESPOSTA;
            } catch (NumberFormatException e) {//TRATO A EXCEÇÕES;
                System.out.println("Entrada inválida! Digite apenas o número 1 ou 2.");
                continue;
            }

            // VALIDO O SETOR:
            if (sectorIn == 1) {
                sector = Sector.PROJECT;
            } else if (sectorIn == 2) {
                sector = Sector.TEST;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        // CRIA O OBJETO(USUÁRIO):
        User newUser = new User(nameIn, loginIn, keyIn, sector);
        //EXIBIR USUÁRIO:
        System.out.println("Esse é seu usuário atual: ");
        System.out.println(newUser);

        // EXIBE O MENU DE ACORDO COM O SETOR:
        if (newUser.teamProject()){
            User.showMenuProject(newUser, arrayDB, scan); // MENU DO SETOR DE PROJETOS
        } else {
            User.showMenuTest(newUser, arrayDB, scan); // MENU DO SETOR DE TESTE
        }
        scan.close();
    }
}
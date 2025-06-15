//CLASSE QUE REPRESENTA UMA SOLICITAÇÃO DE REVISÃO DE PROJETO.
public class RequestReview {
    private String projectName;//NOME DO PROJETO PARA O QUAL A REVISÃO FOI SOLICITADA
    private String justification;//JUSTIFICATIVA OU MOTIVO DA SOLICITAÇÃO
    private User requester;//USUÁRIO QUE FEZ A SOLICITAÇÃO

    //CONSTRUTOR DA CLASSE REQUESTREVIEW:
    public RequestReview(User requester, String projectName, String justification) {
        this.requester = requester;
        this.projectName = projectName;
        this.justification = justification;
    }

    //EXIBE OS DETALHES DA SOLICITAÇÃO DE REVISÃO PARA LEITURA.
    public void readRequest() {
        System.out.println("Projeto: " + projectName);
        System.out.println("Justificativa: " + justification);
        System.out.println("Solicitante: " + requester.getName());
    }
    //RETORNA O NOME DO PROJETO.
    public String getProjectName() {
        return projectName;
    }
    //RETORNA A JUSTIFICATIVA DA SOLICITAÇÃO.
    public String getJustification() {
        return justification;
    }
    //RETORNA O SOLICITANTE.
    public User getRequester() {
        return requester;
    }
}
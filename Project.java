import java.time.LocalDate; //CLASSE PARA OBTER DATA.
import java.util.UUID;      //CLASSE PARA GERAR ID ÚNICO PARA CADA PROJETO.

//CLASSE QUE REPRESENTA UM PROJETO CADASTRADO NO SISTEMA.
public class Project {

    //ATRIBUTOS PRINCIPAIS DO PROJETO
    private String idProject, nameProject; //IDENTIFICADOR ÚNICO E NOME DO PROJETO
    private int numberReference;           //NÚMERO DE REFERÊNCIA DO PROJETO
    private LocalDate createDate;          //DATA DE CRIAÇÃO DO PROJETO
    private User personInCharge;           //USUÁRIO RESPONSÁVEL PELO PROJETO

    //CONSTRUTOR DO PROJETO. GERA O ID E A DATA DE CRIAÇÃO AUTOMATICAMENTE.
    public Project(String nameProject, int numberReference, User personInCharge) {
        this.idProject = UUID.randomUUID().toString(); //GERA UM IDENTIFICADOR ÚNICO PARA O PROJETO
        this.nameProject = nameProject;
        this.numberReference = numberReference;
        this.createDate = LocalDate.now();            //DEFINE A DATA DE CRIAÇÃO COMO A DATA ATUAL
        this.personInCharge = personInCharge;
    }

    //GETTERS E SETTERS

    //RETORNA A DATA.
    public LocalDate getCreateDate() {
        return createDate;
    }

    //DEFINE A DATA.
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    //RETORNA O ID DO PROJETO.
    public String getIdProject() {
        return idProject;
    }

    //DEFINE O ID DO PROJETO.
    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    //RETORNA O NOME DO PROJETO.
    public String getNameProject() {
        return nameProject;
    }

    //DEFINE O NOME DO PROJETO.
    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    //RETORNA O NÚMERO DE REFERÊNCIA DO PROJETO.
    public int getNumberReference() {
        return numberReference;
    }

    //DEFINE O NÚMERO DE REFERÊNCIA DO PROJETO.
    public void setNumberReference(int numberReference) {
        this.numberReference = numberReference;
    }

    //RETORNA O RESPONSÁVEL PELO PROJETO.
    public User getPersonInCharge() {
        return personInCharge;
    }

    //DEFINE O RESPONSÁVEL PELO PROJETO.
    public void setPersonInCharge(User personInCharge) {
        this.personInCharge = personInCharge;
    }

    //EXIBE PROJETO
    public String toString() {
        return "ID: " + idProject + "\n"
                + "Nome: " + nameProject + "\n"
                + "Número de referência: " + numberReference + "\n"
                + "Data de Criação: " + createDate + "\n"
                + "Responsável: " + personInCharge;
    }
}
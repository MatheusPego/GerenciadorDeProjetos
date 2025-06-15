import java.util.ArrayList;
import java.util.List;

public class ArrayDB {
    // PROJETOS CADASTRADOS:
    private List<Project> projects = new ArrayList<>();
    // LISTA DE SOLICITÇÕES:
    private List<RequestReview> reviewRequests = new ArrayList<>();

    //METODO PARA ADIÇÃO DE PROJETOS:
    public void addProject(Project projectAdiction) {
        projects.add(projectAdiction);
    }

    //METODO PARA LISTAR PROJETOS:
    public List<Project> getProjects() {
        return projects;
    }

    //METODO PARA SOLICITAR REVISÃO:
    public void addReviewRequest(RequestReview requestReview) {
        reviewRequests.add(requestReview);
    }

    //METODO PARA LISTAR SOLICITAÇÕES DE REVISÃO:
    public List<RequestReview> getReviewRequests() {
        return reviewRequests;
    }
}
import java.util.Arrays;

public class Manager {
    protected Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket product) {
        repository.add(product);

    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void getId(int id) {
        repository.getId(id);
        ;
    }

    public void findById(int id) {
        repository.findById(id);

    }

    public void findAll() {
        repository.findAll();

    }

    public Ticket[] searchBy(String from, String tu) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (matches(product, from, tu)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String tu) {
        if (!ticket.getFrom().equals(from)) {
            return false;
        }
        if (!ticket.getTu().equals(tu)) {
            return false;
        }
        return true;
    }
}

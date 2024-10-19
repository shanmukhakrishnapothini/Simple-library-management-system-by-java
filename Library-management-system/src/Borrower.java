public class Borrower {
    private int id;
    private String name;

    public Borrower(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Borrower [id=" + id + ", name=" + name + "]";
    }
}

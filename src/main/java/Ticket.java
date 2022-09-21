public class Ticket implements Comparable<Ticket> {


    protected String from;
    protected String tu;
    protected int price;
    protected int id;
    protected int time;

    public Ticket(String from, String tu, int prise, int id, int time) {
        this.from = from;
        this.tu = tu;
        this.price = prise;
        this.id = id;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int prise) {
        this.price = price;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Ticket t) {
        if (price < t.price) {
            return -1;
        }
        if (price > t.price) {
            return 1;
        }
        return 0;
    }
}


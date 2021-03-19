package domain;

public class Editura {
    private String nume;

    public Editura(){
        this.nume = null;
    }

    public Editura(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return nume;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Editura))
            return false;
        Editura a = (Editura) obj;
        return nume.equals(a.nume);
    }
}

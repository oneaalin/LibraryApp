package domain;

public class Autor {
    private String nume;

    public Autor(){
        this.nume = null;
    }

    public Autor(String nume) {
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
        return nume ;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Autor))
            return false;
        Autor a = (Autor)obj;
        return nume.equals(a.nume);
    }
}

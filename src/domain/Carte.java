package domain;

public class Carte extends Object implements Comparable {

    private int id;
    private String titlu;
    private Autor autori;
    private int anul_aparitiei;
    private int pret;
    private Editura editura;
    private String cota;

    public Carte(){
        this.id=0;
        this.titlu = null;
        this.autori = null;
        this.anul_aparitiei = 0;
        this.pret = 0;
        this.editura = null;
        this.cota = null;
    }

    public Carte(int id,String titlu, Autor autori, int anul_aparitiei, int pret, Editura editura, String cota) {
        this.id=id;
        this.titlu = titlu;
        this.autori = autori;
        this.anul_aparitiei = anul_aparitiei;
        this.pret = pret;
        this.editura = editura;
        this.cota = cota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Autor getAutori() {
        return autori;
    }

    public void setAutori(Autor autori) {
        this.autori = autori;
    }

    public int getAnulAparitiei() {
        return anul_aparitiei;
    }

    public void setAnulAparitiei(int anul_aparitiei) {
        this.anul_aparitiei = anul_aparitiei;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public Editura getEditura() {
        return editura;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public String getCota() {
        return cota;
    }

    public void setCota(String cota) {
        this.cota = cota;
    }

    @Override
    public String toString() {
        return id + "," + titlu + "," + autori + "," + anul_aparitiei + "," + pret + "," + editura + "," + cota;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Carte))
            return -1;
        Carte c = (Carte) o;
        if(id < c.id) return -1;
        if(id > c.id) return 1;
        return 0;
    }
    public boolean equals(Object o){
        if(!(o instanceof  Carte))
            return false;
        Carte c = (Carte) o;
        return (id==c.id) && (titlu.equals(c.titlu)) && (autori.equals(c.autori)) && (anul_aparitiei==c.anul_aparitiei) && (pret==c.pret) && (editura.equals(c.editura)) && (cota.equals(c.cota));
    }
}

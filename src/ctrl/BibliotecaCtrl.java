package ctrl;

import domain.Biblioteca;
import domain.Carte;
import domain.Editura;

public class BibliotecaCtrl {

    private Biblioteca biblioteca;

    public BibliotecaCtrl(Biblioteca biblioteca){
        this.biblioteca=biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void addCarte(Carte c){
        if(biblioteca.getTabel().saveObject(c) == false)
            System.out.println("Cartea " + c.toString() + " nu a putut fi adaugata ! ");
        else
            System.out.println("Cartea " + c.toString() + " a fost adaugata cu succes ! ");
    }

    public void updateCarte(int id,Carte c){
        if(biblioteca.getTabel().updateObject(id,c) == false)
            System.out.println("Cartea cu id-ul " + id + " a fost actualizata ! ");
        else
            System.out.println("Cartea cu id-ul " + id + " nu a putut fi actualizata ! ");
    }

    public void deleteCarte(int id){
        if(biblioteca.getTabel().deleteObject(id) == false)
            System.out.println("Cartea cu id-ul " + id + " a fost stearsa ! ");
        else
            System.out.println("Cartea cu id-ul " + id + " nu a putut fi stearsa ! ");
    }

    public Object[] getCarti(){return biblioteca.getTabel().getAll();}

    private boolean haveThisAutor(String autori,String autor){
        String[] autori_split = autori.split("-");
        for(int i=0;i<autori_split.length;i++)
            if(autori_split[i].equals(autor))
                return true;
        return false;
    }

    public Object[] getCartiByAutor(String autor){
        Object[] carti = biblioteca.getTabel().getAll();
        int nrAutori=0;
        for(int i=0;i<carti.length;i++)
            if(haveThisAutor(((Carte) carti[i]).getAutori().getNume(),autor))
                nrAutori++;
        Object[] carti_rez = new Object[nrAutori];
        int contor=0;
        for(int i=0;i<carti.length;i++)
            if(haveThisAutor(((Carte) carti[i]).getAutori().getNume(),autor)){
                carti_rez[contor]=carti[i];
                contor++;
            }
        return carti_rez;
    }

    public Object[] getCartiByYears(int year_begin,int year_end){
        Object[] carti = biblioteca.getTabel().getAll();
        int nrCarti = 0;
        for(int i=0;i<carti.length;i++)
            if(((Carte)carti[i]).getAnulAparitiei() >= year_begin && ((Carte)carti[i]).getAnulAparitiei() <= year_end)
                nrCarti++;
        Object[] carti_rez = new Object[nrCarti];
        int contor = 0;
        for(int i=0;i<carti.length;i++)
            if(((Carte)carti[i]).getAnulAparitiei() >= year_begin && ((Carte)carti[i]).getAnulAparitiei() <= year_end) {
                carti_rez[contor] = carti[i];
                contor++;
            }
        return carti_rez;
    }

    public Object[] getCartiByEditura(Editura editura){
        Object[] carti = biblioteca.getTabel().getAll();
        int nrCarti = 0;
        for(int i=0;i<carti.length;i++)
            if(((Carte)carti[i]).getEditura().equals(editura))
                nrCarti++;
        Object[] carti_rez = new Object[nrCarti];
        int contor = 0;
        for(int i=0;i<carti.length;i++)
            if(((Carte)carti[i]).getEditura().equals(editura)) {
                carti_rez[contor] = carti[i];
                contor++;
            }
        return carti_rez;
    }

}

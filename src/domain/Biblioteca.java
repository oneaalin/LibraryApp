package domain;

import repository.BibliotecaRepository;

public class Biblioteca {

    private BibliotecaRepository tabel;

    public Biblioteca(BibliotecaRepository tabel){this.setTabel(tabel);}

    public BibliotecaRepository getTabel(){return tabel;}

    public void setTabel(BibliotecaRepository tabel){this.tabel = tabel;}

    public String toString(){
        String rez = "";
        Carte[] arr = (Carte[])tabel.getAll();
        if(arr==null)
            return "";
        for(int i=0;i< arr.length;i++)
            rez+=arr[i].toString()+'\n';
        return rez;
    }
}

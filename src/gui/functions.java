package gui;

import ctrl.BibliotecaCtrl;
import domain.Autor;
import domain.Carte;
import domain.Editura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class functions {
    private BibliotecaCtrl bibliotecaGUI;

    public functions(BibliotecaCtrl bibliotecaGUI) {
        this.bibliotecaGUI = bibliotecaGUI;
    }

    public void loadFromFile() throws FileNotFoundException, IOException {

        BufferedReader fileIn = new BufferedReader(new FileReader("D:\\MAP Projects\\Laborator 4\\src\\BibliotecaBD.txt"));
        String s;
        while((s = fileIn.readLine()) != null){
            String felii[] = s.split(",");
            int id = Integer.parseInt(felii[0]);
            String titlu = felii[1];
            Autor autori = new Autor(felii[2]);
            int anul_aparitiei = Integer.parseInt(felii[3]);
            int pret = Integer.parseInt(felii[4]);
            Editura editura = new Editura(felii[5]);
            String cota = felii[6];
            Carte carte = new Carte(id,titlu,autori,anul_aparitiei,pret,editura,cota);
            bibliotecaGUI.addCarte(carte);
        }
        Object[] carti = bibliotecaGUI.getCarti();
        System.out.println();
        if(carti != null)
            System.out.println("Cartile din baza de date au fost incarcate cu succes ! ");
        else
            System.out.println("Nu sunt carti in baza de date ! Te rugam sa incarci tu cateva ! ");
        fileIn.close();
    }
}

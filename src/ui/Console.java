package ui;

import ctrl.BibliotecaCtrl;
import domain.Autor;
import domain.Carte;
import domain.Editura;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Console {

    private BibliotecaCtrl bCtrl;

    public Console(BibliotecaCtrl bCtrl) {
        this.bCtrl = bCtrl;
    }

    private void exitApp(){
        System.out.println(" Inchiderea aplicatiei de biblioteca personala ! ");
        System.out.println(" La revedere ... ");
    }

    private void loadFromFile() throws FileNotFoundException, IOException {

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
            bCtrl.addCarte(carte);
        }
        Object[] carti = bCtrl.getCarti();
        System.out.println();
        if(carti != null)
            System.out.println("Cartile din baza de date au fost incarcate cu succes ! ");
        else
            System.out.println("Nu sunt carti in baza de date ! Te rugam sa incarci tu cateva ! ");
        fileIn.close();
    }

    private void saveToFile()throws IOException{
        FileWriter output = new FileWriter("D:\\MAP Projects\\Laborator 4\\src\\BibliotecaBD.txt");
        BufferedWriter writer = new BufferedWriter(output);
        Object[] carti = bCtrl.getCarti();
        for(int i=0;i<carti.length;i++){
            String contents = ((Carte)carti[i]).toString();
            writer.write(contents);
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    private void addCarte() throws NumberFormatException , IOException{
        System.out.println();
        System.out.println(" Adaugarea unei carti noi ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nId = ");
        int id = Integer.parseInt(br.readLine());
        System.out.println("Titlu = ");
        String titlu = br.readLine();
        System.out.println("Autori = ");
        Autor autori = new Autor(br.readLine());
        System.out.println("Anul aparitiei = ");
        int anul_aparitiei = Integer.parseInt(br.readLine());
        System.out.println("Pretul = ");;
        int pret = Integer.parseInt(br.readLine());
        System.out.println("Editura = ");
        Editura editura = new Editura(br.readLine());
        System.out.println("Cota = ");
        String cota = br.readLine();
        Carte carte = new Carte(id,titlu,autori,anul_aparitiei,pret,editura,cota);
        bCtrl.addCarte(carte);
    }

    private void removeCarte()throws NumberFormatException,IOException{
        System.out.println("\nStergerea unei carti ");
        System.out.println("Id-ul cartii = ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(br.readLine());
        bCtrl.deleteCarte(id);
    }

    private void updateCarte()throws NumberFormatException,IOException{
        System.out.println("\nActualizarea unei carti ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nId-ul cartii de actualizat = ");
        int id = Integer.parseInt(br.readLine());
        System.out.println("Titlu nou = ");
        String titlu = br.readLine();
        System.out.println("Autori noi = ");
        Autor autori = new Autor(br.readLine());
        System.out.println("Anul nou al aparitiei = ");
        int anul_aparitiei = Integer.parseInt(br.readLine());
        System.out.println("Pretul nou = ");;
        int pret = Integer.parseInt(br.readLine());
        System.out.println("Editura noua = ");
        Editura editura = new Editura(br.readLine());
        System.out.println("Cota noua = ");
        String cota = br.readLine();
        Carte carte = new Carte(id,titlu,autori,anul_aparitiei,pret,editura,cota);
        bCtrl.updateCarte(id,carte);
    }

    private void printCarti(){

        System.out.println("\nPrintare carti : \n");
        Object[] carti = bCtrl.getCarti();
        if(carti!=null){
            CapTabel.capTabel();
            for(int i=0;i<carti.length;i++)
                System.out.format("|%-4d|%-24s|%-42s|%-15d|%-6d|%-17s|%-9s|\n",((Carte)carti[i]).getId(),((Carte)carti[i]).getTitlu(),((Carte)carti[i]).getAutori(),((Carte)carti[i]).getAnulAparitiei(),((Carte)carti[i]).getPret(),((Carte)carti[i]).getEditura(),((Carte)carti[i]).getCota());
        }
        else
            System.out.println("Nu exista carti in biblioteca !");
    }

    private void printCartiAutor()throws IOException{

        System.out.println("Da un autor : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String autor = br.readLine();
        System.out.println("\nPrintare carti scrise de " + autor + " : \n");
        Object[] carti = bCtrl.getCartiByAutor(autor);
        if(carti!=null){
            CapTabel.capTabel();
            for(int i=0;i<carti.length;i++)
                System.out.format("|%-4d|%-24s|%-42s|%-15d|%-6d|%-17s|%-9s|\n",((Carte)carti[i]).getId(),((Carte)carti[i]).getTitlu(),((Carte)carti[i]).getAutori(),((Carte)carti[i]).getAnulAparitiei(),((Carte)carti[i]).getPret(),((Carte)carti[i]).getEditura(),((Carte)carti[i]).getCota());
        }
        else
            System.out.println("Nu exista carti in biblioteca !");
    }

    private void printCartiAni()throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Da anul de inceput : ");
        int year_begin = Integer.parseInt(br.readLine());
        System.out.println("Da anul de sfarsit : ");
        int year_end = Integer.parseInt(br.readLine());
        System.out.println("\nPrintare carti scrise intre anii " + year_begin + " si " + year_end +" : \n");
        Object[] carti = bCtrl.getCartiByYears(year_begin,year_end);
        if(carti!=null){
            CapTabel.capTabel();
            for(int i=0;i<carti.length;i++)
                System.out.format("|%-4d|%-24s|%-42s|%-15d|%-6d|%-17s|%-9s|\n",((Carte)carti[i]).getId(),((Carte)carti[i]).getTitlu(),((Carte)carti[i]).getAutori(),((Carte)carti[i]).getAnulAparitiei(),((Carte)carti[i]).getPret(),((Carte)carti[i]).getEditura(),((Carte)carti[i]).getCota());
        }
        else
            System.out.println("Nu exista carti in biblioteca !");
    }

    private void printCartiEditura()throws IOException{

        System.out.println("Da o editura : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Editura editura = new Editura(br.readLine());
        System.out.println("\nPrintare carti produse de " + editura + " : \n");
        Object[] carti = bCtrl.getCartiByEditura(editura);
        if(carti!=null){
            CapTabel.capTabel();
            for(int i=0;i<carti.length;i++)
                System.out.format("|%-4d|%-24s|%-42s|%-15d|%-6d|%-17s|%-9s|\n",((Carte)carti[i]).getId(),((Carte)carti[i]).getTitlu(),((Carte)carti[i]).getAutori(),((Carte)carti[i]).getAnulAparitiei(),((Carte)carti[i]).getPret(),((Carte)carti[i]).getEditura(),((Carte)carti[i]).getCota());
        }
        else
            System.out.println("Nu exista carti in biblioteca !");
    }

    private int readOption()throws NumberFormatException,IOException{
        System.out.println("\nMenu option (0 / 1 / 2 / 3 / 4 / 5 / 6 / 7) :");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
    private void showMenu(){
        System.out.println("\nMeniu Biblioteca personala ");
        System.out.println("1. Adauga carte in biblioteca ");
        System.out.println("2. Sterge o carte din biblioteca ");
        System.out.println("3. Actualizeaza o carte din biblioteca ");
        System.out.println("4. Afiseaza cartile din biblioteca ");
        System.out.println("5. Afiseaza cartile din biblioteca scrise de un anumit autor ");
        System.out.println("6. Afiseaza cartile din biblioteca aparute intre anumiti ani ");
        System.out.println("7. Afiseaza cartile din biblioteca produse de o editura ");
        System.out.println("0. Inchide aplicatia ");
    }

    public void runApp(){
        int option = 1;
        try{
            loadFromFile();
            while(option!=0){
                showMenu();
                option = readOption();
                switch(option){
                    case 0: exitApp(); break;
                    case 1: addCarte(); break;
                    case 2: removeCarte(); break;
                    case 3: updateCarte(); break;
                    case 4: printCarti(); break;
                    case 5: printCartiAutor(); break;
                    case 6: printCartiAni(); break;
                    case 7: printCartiEditura(); break;
                    default:
                        System.out.println("Ai dat o optiune invalida ! ");
                }
            }
            saveToFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

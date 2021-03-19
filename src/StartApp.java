import ctrl.BibliotecaCtrl;
import domain.Biblioteca;
import gui.MainFrame;
import repository.array.BibliotecaRepositoryArray;
import ui.Console;

public class StartApp {
    public static void main(String[] args){
        BibliotecaRepositoryArray bRepA = new BibliotecaRepositoryArray(40);
        Biblioteca biblioteca = new Biblioteca(bRepA);
        BibliotecaCtrl bibliotecaCtrl = new BibliotecaCtrl(biblioteca);

        Console console = new Console(bibliotecaCtrl);
        //.runApp();
        new MainFrame(bibliotecaCtrl);
    }
}

package gui;

import ctrl.BibliotecaCtrl;
import domain.Carte;
import domain.Editura;

import javax.swing.*;
import java.awt.*;

public class AfisareEdituraFrame extends JFrame{

    AfisareEdituraFrame(BibliotecaCtrl bibliotecaGUI){

        String[] columns = new String[] {
                "ID","Titlu","Autori","Anul Aparitiei","Pret","Editura","Cota"
        };

        String editura_string = JOptionPane.showInputDialog("Ce editura vrei sa cauti ? : ");

        Editura editura = new Editura(editura_string);

        Object[] carti = bibliotecaGUI.getCartiByEditura(editura);

        Object[][] data = new Object[carti.length][7];

        for(int i=0;i< carti.length;i++)
        {
            data[i][0]= ((Carte)carti[i]).getId();
            data[i][1]= ((Carte)carti[i]).getTitlu();
            data[i][2]= ((Carte)carti[i]).getAutori();
            data[i][3]= ((Carte)carti[i]).getAnulAparitiei();
            data[i][4]= ((Carte)carti[i]).getPret();
            data[i][5]= ((Carte)carti[i]).getEditura();
            data[i][6]= ((Carte)carti[i]).getCota();
        }

        JTable table = new JTable(data, columns);

        JScrollPane table_pane = new JScrollPane(table);
        table_pane.setBounds(0,0,1080,720);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1080,720);
        this.setBackground(Color.darkGray);
        this.setVisible(true);

        this.add(table_pane);
    }

}

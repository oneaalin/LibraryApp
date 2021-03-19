package gui;

import ctrl.BibliotecaCtrl;
import domain.Carte;

import javax.swing.*;
import java.awt.*;

public class AfisareAniFrame extends JFrame{

    AfisareAniFrame(BibliotecaCtrl bibliotecaGUI){

        String[] columns = new String[] {
                "ID","Titlu","Autori","Anul Aparitiei","Pret","Editura","Cota"
        };

        String ani = JOptionPane.showInputDialog("Intre ce ani cautati carti ? [yyyy-yyyyy] : ");
        String[] ani_split = ani.split("-");
        int an_inceput = Integer.parseInt(ani_split[0]);
        int an_sfarsit = Integer.parseInt(ani_split[1]);


        Object[] carti = bibliotecaGUI.getCartiByYears(an_inceput,an_sfarsit);

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

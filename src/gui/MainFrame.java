package gui;

import ctrl.BibliotecaCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener{

    BibliotecaCtrl bibliotecaGUI;
    JButton butonCitireFisier;
    JButton butonAfisareCarti;
    JButton butonAfisareCartiAutor;
    JButton butonAfisareCartiAni;
    JButton butonAfisareCartiEditura;

    public MainFrame(BibliotecaCtrl biblGui){

        this.bibliotecaGUI=biblGui;

        ImageIcon backgroundImage = new ImageIcon("D:\\MAP Projects\\Laborator 4\\src\\background2.png");
        ImageIcon app_logo = new ImageIcon("D:\\MAP Projects\\Laborator 4\\src\\app_logo.jpg");

        JLabel contentPane = new JLabel();
        contentPane.setIcon( backgroundImage );
        contentPane.setLayout( new BorderLayout() );
        this.setContentPane( contentPane );

        butonCitireFisier = new JButton("Citeste din fisier cartile din biblioteca");
        butonCitireFisier.setBounds(250,30,580,70);
        butonCitireFisier.addActionListener(this);
        butonCitireFisier.setFocusable(false);

        butonAfisareCarti = new JButton("Afiseaza cartile din biblioteca");
        butonAfisareCarti.setBounds(250,130,580,70);
        butonAfisareCarti.addActionListener(this);
        butonAfisareCarti.setFocusable(false);

        butonAfisareCartiAutor = new JButton("Afiseaza cartile din biblioteca scrise de un anumit autor");
        butonAfisareCartiAutor.setBounds(250,230,580,70);
        butonAfisareCartiAutor.addActionListener(this);
        butonAfisareCartiAutor.setFocusable(false);

        butonAfisareCartiAni = new JButton("Afiseaza cartile din biblioteca aparute intre anumiti ani");
        butonAfisareCartiAni.setBounds(250,330,580,70);
        butonAfisareCartiAni.addActionListener(this);
        butonAfisareCartiAni.setFocusable(false);

        butonAfisareCartiEditura = new JButton("Afiseaza cartile din biblioteca produse de o anumita editura");
        butonAfisareCartiEditura.setBounds(250,430,580,70);
        butonAfisareCartiEditura.addActionListener(this);
        butonAfisareCartiEditura.setFocusable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1024,720);
        //this.setBackground(Color.darkGray);
        this.setVisible(true);
        this.setTitle("Biblioteca personala");
        this.setIconImage(app_logo.getImage());

        this.add(butonCitireFisier);
        this.add(butonAfisareCarti);
        this.add(butonAfisareCartiAutor);
        this.add(butonAfisareCartiAni);
        this.add(butonAfisareCartiEditura);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        functions function = new functions(bibliotecaGUI);
        if(e.getSource() == butonCitireFisier){
            try {
                function.loadFromFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(e.getSource() == butonAfisareCarti){
            new AfisareFrame(bibliotecaGUI);
        }
        else if(e.getSource() == butonAfisareCartiAutor){
            new AfisareAutoriFrame(bibliotecaGUI);
        }
        else if(e.getSource() == butonAfisareCartiAni){
            new AfisareAniFrame(bibliotecaGUI);
        }
        else if(e.getSource() == butonAfisareCartiEditura){
            new AfisareEdituraFrame(bibliotecaGUI);
        }
    }
}

package com.company.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeGUI extends JFrame{
    private String nome;
    JLabel title;
    JPanel panelAddDipendente;
    JLabel label1;

    JPanel panelDeleteDipendente;
    JLabel label2;

    JPanel panelModifyDipendente;
    JLabel label3;

    JPanel panelSearchDipendente;
    JLabel label4;
    public HomeGUI(String nome){
        this.nome = nome;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Home");
        setSize(600,600);

        title = new JLabel("Ciao "+nome+"!");
        title.setFont(new Font("Roboto", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        if(nome.length() <= 7)
            title.setBounds(20,30,200, 30);
        else
            title.setBounds(20,30,250, 30);

        panelNuovoDipendente();
        //panelEliminaDipendente();
        //panelModificaDipendente();
        panelCercaDipendente();

        add(title);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void panelNuovoDipendente(){
        label1 = new JLabel("AGGIUNGI DIPENDENTE");
        label1.setFont(new Font("Roboto", Font.PLAIN, 20));
        label1.setForeground(Color.BLACK);
        label1.setBounds(0,50,150, 20);

        panelAddDipendente = new JPanel();
        panelAddDipendente.setBackground(new Color(96, 109, 150));
        panelAddDipendente.setBounds(150,200,300,50);
        panelAddDipendente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new AddDipendenteGUI(nome);
            }
        });
        panelAddDipendente.add(label1);

        add(panelAddDipendente);
    }

    /*
    public void panelEliminaDipendente(){
        label2 = new JLabel("ELIMINA DIPENDENTE");
        label2.setFont(new Font("Roboto", Font.PLAIN, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(0,50,150, 20);

        panelDeleteDipendente = new JPanel();
        panelDeleteDipendente = new JPanel();
        panelDeleteDipendente.setBackground(new Color(96, 109, 150));
        panelDeleteDipendente.setBounds(150,200,300,50);
        panelDeleteDipendente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("elimina dipendente");
            }
        });
        panelDeleteDipendente.add(label2);

        add(panelDeleteDipendente);
    }

    public void panelModificaDipendente(){
        label3 = new JLabel("MODIFICA DIPENDENTE");
        label3.setFont(new Font("Roboto", Font.PLAIN, 20));
        label3.setForeground(Color.BLACK);
        label3.setBounds(0,50,150, 20);

        panelModifyDipendente = new JPanel();
        panelModifyDipendente = new JPanel();
        panelModifyDipendente.setBackground(new Color(96, 109, 150));
        panelModifyDipendente.setBounds(150,270,300,50);
        panelModifyDipendente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SearchDipendenteGUI(nome);
            }
        });
        panelModifyDipendente.add(label3);

        add(panelModifyDipendente);
    }*/

    public void panelCercaDipendente(){
        label4 = new JLabel("CERCA DIPENDENTE");
        label4.setFont(new Font("Roboto", Font.PLAIN, 20));
        label4.setForeground(Color.BLACK);
        label4.setBounds(0,50,150, 20);

        panelSearchDipendente = new JPanel();
        panelSearchDipendente = new JPanel();
        panelSearchDipendente.setBackground(new Color(96, 109, 150));
        panelSearchDipendente.setBounds(150,300,300,50);
        panelSearchDipendente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new SearchDipendenteGUI(nome);
            }
        });
        panelSearchDipendente.add(label4);

        add(panelSearchDipendente);
    }
}

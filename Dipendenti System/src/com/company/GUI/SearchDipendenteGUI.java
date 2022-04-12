package com.company.GUI;

import com.company.backend.CercaDipendente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SearchDipendenteGUI extends JFrame implements ActionListener {
    JLabel title;
    JTextField inputDip;
    JButton btnSearch;
    JButton btnIndietro;
    String nome;
    public SearchDipendenteGUI(String nome){
        this.nome = nome;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cerca dipendente");
        setSize(600,600);
        setLayout(null);

        title = new JLabel("CERCA DIPENDENTE");
        title.setFont(new Font("Roboto", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        title.setBounds(165,40,270,40);

        add(buttonIndietro());
        add(btnSearch());
        add(inputDipendente());
        add(title);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method create the input, and modify the design
     * @return JTextField, input for the name of the employee
     */
    public JTextField inputDipendente(){
        inputDip = new JTextField();
        inputDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputDip.setForeground(Color.BLACK);
        inputDip.setBorder(BorderFactory.createEtchedBorder());
        inputDip.setBackground(Color.WHITE);
        inputDip.setText("Nome");
        inputDip.setBounds(50, 110, 350, 40);

        return inputDip;
    }

    /**
     * @return JButton, button for search the employee
     */
    public JButton btnSearch(){
        btnSearch = new JButton("Cerca");
        btnSearch.setFocusable(false);
        btnSearch.setBackground(Color.BLUE);
        btnSearch.setFont(new Font("Roboto", Font.PLAIN, 20));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setBounds(410, 110, 150, 40);
        btnSearch.addActionListener(this);

        return btnSearch;
    }

    /**
     * @return JButton, button to come back
     */
    public JButton buttonIndietro(){
        btnIndietro = new JButton("INDIETRO");
        btnIndietro.setFocusable(false);
        btnIndietro.setBackground(Color.BLUE);
        btnIndietro.setFont(new Font("Roboto", Font.PLAIN, 20));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.setBounds(225, 450, 150, 50);
        btnIndietro.addActionListener(this);

        return btnIndietro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSearch){ //if the button for search is pressed
            String nomeDip = inputDip.getText(); //variable that contain the content of the input

            JPanel panel = new JPanel();
            JLabel label2 = new JLabel("Dipendente non trovato");
            CercaDipendente cerDip = new CercaDipendente(nomeDip); //create the instance of class CercaDipendente, to search the employee

            try {
                if(cerDip.cercaDipendenteNome()){
                    resize();
                    dipendenteTrovato(panel, cerDip).addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            String[] opt = {"Elimina", "Modifica"};
                            int res = JOptionPane.showOptionDialog(null,
                                    "Premere i seguenti pulsanti per",
                                    "Elimina, modifica dipendente",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    opt,
                                    null);

                            if(res==0) {
                                System.out.println(res);
                                dispose();
                                new DeleteDipendenteGUI(nomeDip);
                            }else{
                                dispose();
                                new ModificaDipendenteGUI("Admin", nomeDip);
                            }
                        }
                    });
                    add(dipendenteTrovato(panel,cerDip));
                }else{
                    resize();
                    add(dipendenteNonTrovato(label2));
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource() == btnIndietro){
            dispose();
            new HomeGUI(nome);
        }
    }

    public JPanel dipendenteTrovato(JPanel panel, CercaDipendente cerDip)throws IOException{
        JLabel label1 = new JLabel("Nome: "+cerDip.getNome()+" Id: "+cerDip.cercaDipendenteId()+" Reparto: "+cerDip.repartoDipendente());
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Roboto", Font.PLAIN, 17));
        label1.setBounds(0,20,300, 30);

        panel.setBackground(Color.BLUE);
        panel.setBounds(100, 170, 400, 37);
        panel.add(label1);
        return panel;
    }

    public JLabel dipendenteNonTrovato(JLabel label2){
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Roboto", Font.PLAIN, 15));
        label2.setBounds(200,170,200, 30);
        return label2;
    }

    public void resize(){
        setSize(600,650);
        btnIndietro.setBounds(225, 500, 150, 50);
        setLocationRelativeTo(null);
    }
}

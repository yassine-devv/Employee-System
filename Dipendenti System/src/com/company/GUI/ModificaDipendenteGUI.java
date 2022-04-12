package com.company.GUI;

import com.company.backend.ModificaDipendente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModificaDipendenteGUI extends JFrame implements ActionListener {
    String nomeDip;
    String nome;
    String initialIdDip;
    String initialRepartoDip;
    JLabel title;
    JTextField inputNomeDip;
    JTextField inputIdDip;
    JTextField inputRepartoDip;
    JButton btnIndietro;
    JButton btnConferma;
    public ModificaDipendenteGUI(String nome, String nomeDip) {
        this.nomeDip = nomeDip;
        this.nome = nome;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Modifica dipendente");
        setSize(600,600);
        setLayout(null);

        title = new JLabel("MODIFICA DIPEDENTE");
        title.setFont(new Font("Robot", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        title.setBounds(160,80,280,30);

        ModificaDipendente modDip = new ModificaDipendente(nomeDip);
        add(inputNomeDipendente(nomeDip));

        try{
            initialIdDip = modDip.trovaId();
            initialRepartoDip = modDip.trovaReparto();
            add(inputIdDipendente(initialIdDip));
            add(inputRepartoDipendente(initialRepartoDip));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Errore di lettura del database "+e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        add(buttonIndietro());
        add(buttonConfirm());
        add(title);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public JTextField inputNomeDipendente(String nomeDip){
        inputNomeDip = new JTextField();
        inputNomeDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputNomeDip.setForeground(Color.BLACK);
        inputNomeDip.setText(nomeDip);
        inputNomeDip.setBounds(100,160,400,40);

        return inputNomeDip;
    }

    public JTextField inputIdDipendente(String initialIdDip)throws IOException{
        inputIdDip = new JTextField();
        inputIdDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputIdDip.setForeground(Color.BLACK);
        inputIdDip.setText(initialIdDip);
        inputIdDip.setBounds(100,230,400,40);

        return inputIdDip;
    }

    public JTextField inputRepartoDipendente(String initialRepartoDip)throws IOException{
        inputRepartoDip = new JTextField();
        inputRepartoDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputRepartoDip.setForeground(Color.BLACK);
        inputRepartoDip.setText(initialRepartoDip);
        inputRepartoDip.setBounds(100,300,400,40);

        return inputRepartoDip;
    }

    public JButton buttonIndietro(){
        btnIndietro = new JButton("INDIETRO");
        btnIndietro.setBackground(Color.BLUE);
        btnIndietro.setFont(new Font("Roboto", Font.PLAIN, 20));
        btnIndietro.setForeground(Color.WHITE);
        btnIndietro.addActionListener(this);
        btnIndietro.setFocusable(false);
        btnIndietro.setBounds(130,380,150,50);

        return btnIndietro;
    }

    public JButton buttonConfirm(){
        btnConferma = new JButton("CONFERMA");
        btnConferma.setBackground(Color.BLUE);
        btnConferma.setFont(new Font("Roboto", Font.PLAIN, 20));
        btnConferma.setForeground(Color.WHITE);
        btnConferma.addActionListener(this);
        btnConferma.setFocusable(false);
        btnConferma.setBounds(330,380,150,50);

        return btnConferma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnConferma){
            //check if the user change anything data of employee
            if(!inputIdDip.getText().equals(initialIdDip) || !inputNomeDip.getText().equals(nomeDip) || !inputRepartoDip.getText().equals(initialRepartoDip)) {
                ModificaDipendente modDip = new ModificaDipendente(nomeDip);
                int ris = JOptionPane.showConfirmDialog(null, "Apportare le modifiche?", "Salva", JOptionPane.YES_NO_OPTION);

                try {
                    metSaveModify(ris, modDip);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Qualcosa è andato storto :(", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(e.getSource() == btnIndietro){
            dispose();
            new SearchDipendenteGUI(nome);
        }
    }

    public void metSaveModify(int ris, ModificaDipendente modDip)throws IOException{
        if(ris==0){
            modDip.replaceNome(inputNomeDip.getText());
            modDip.setId(inputIdDip.getText());
            modDip.setReaprto(inputRepartoDip.getText());

            JOptionPane.showMessageDialog(null, "Modifiche salvate con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new SearchDipendenteGUI(nome);
        }
    }
}

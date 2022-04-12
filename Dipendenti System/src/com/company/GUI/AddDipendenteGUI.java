package com.company.GUI;

import com.company.backend.AddDipendente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDipendenteGUI extends JFrame implements ActionListener {
    JLabel title;
    JTextField inputNomeDip;
    JTextField inputIdDip;
    JTextField inputRepartoDip;
    JButton btnIndietro;
    JButton btnConferma;
    private String nome;
    public AddDipendenteGUI(String nome){
        this.nome = nome;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Nuovo dipendente");
        setSize(600,600);
        setLayout(null);
        setResizable(false);

        title = new JLabel("AGGIUNGI DIPEDENTE");
        title.setFont(new Font("Robot", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        title.setBounds(160,80,280,30);

        add(inputNomeDipendente());
        add(inputIdDipendente());
        add(inputRepartoDipendente());
        add(buttonIndietro());
        add(buttonConfirm());
        add(title);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField inputNomeDipendente(){
        inputNomeDip = new JTextField();
        inputNomeDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputNomeDip.setForeground(Color.BLACK);
        inputNomeDip.setText("Nome");
        inputNomeDip.setBounds(100,160,400,40);

        return inputNomeDip;
    }

    public JTextField inputIdDipendente(){
        inputIdDip = new JTextField();
        inputIdDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputIdDip.setForeground(Color.BLACK);
        inputIdDip.setText("Id");
        inputIdDip.setBounds(100,230,400,40);

        return inputIdDip;
    }

    public JTextField inputRepartoDipendente(){
        inputRepartoDip = new JTextField();
        inputRepartoDip.setFont(new Font("Roboto", Font.PLAIN, 17));
        inputRepartoDip.setForeground(Color.BLACK);
        inputRepartoDip.setText("Reparto");
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
        if(e.getSource() == btnIndietro){
            dispose();
            new HomeGUI(nome);
        }

        if(e.getSource() == btnConferma){
            String nomeDip = inputNomeDip.getText();
            String idDip = inputIdDip.getText();
            String repartoDip = inputRepartoDip.getText();

            AddDipendente addDip = new AddDipendente(nomeDip, Integer.parseInt(idDip), repartoDip);

            if(!nomeDip.equals("") && !repartoDip.equals("")){
                if(idDip.length() == 4){
                    if(addDip.AddNomeDipendente() && addDip.AddIdDipendente() && addDip.AddRepartoDipendente()){
                        JOptionPane.showMessageDialog(null, "Dipendente aggiunto con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new HomeGUI(nome);
                    }else{
                        JOptionPane.showMessageDialog(null, "Qualcosa e' andato storto :(", "Errore", JOptionPane.ERROR_MESSAGE);
                        dispose();
                        new HomeGUI(nome);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "L'id deve essere lungo 4 numeri", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Inserire i dati negli input", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

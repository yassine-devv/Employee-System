package com.company.GUI;

import com.company.backend.EliminaDipendente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class DeleteDipendenteGUI extends JFrame implements ActionListener {
    private String nomeDip;
    JLabel title;
    JTextField inputNomeDip;
    JTextField inputIdDip;
    JTextField inputRepartoDip;
    JButton btnIndietro;
    JButton btnConferma;
    public DeleteDipendenteGUI(String nomeDip){
        this.nomeDip = nomeDip;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Elimina dipendente");
        setSize(600,600);
        setLayout(null);

        title = new JLabel("ELIMINA DIPEDENTE");
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
            new SearchDipendenteGUI(nomeDip);
        }

        if(e.getSource() == btnConferma){
            final String nome = inputNomeDip.getText();
            final String id = inputIdDip.getText();
            final String reparto = inputRepartoDip.getText();

            EliminaDipendente elDip = new EliminaDipendente(nome, id, reparto);

            try {
                if (elDip.eliminaNome() && elDip.eliminaId() && elDip.eliminaReparto()) {
                    JOptionPane.showMessageDialog(null, "Il dipendente è stato eliminato con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else{
                    JOptionPane.showMessageDialog(null, "Qualcosa è andato storto :(", "Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}

package com.company.GUI;

import com.company.backend.Registrazione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneGUI extends JFrame implements ActionListener {
    JLabel title;
    JLabel label1;
    JTextField inputNome;
    JLabel label2;
    JPasswordField inputPassword;
    JButton btnConfirm;
    JButton btnLogin;
    public RegistrazioneGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Registrazione");
        setSize(600, 600);

        title = new JLabel("REGISTRATI");
        title.setFont(new Font("Roboto", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        title.setBounds(225,110,150, 30);

        label1 = new JLabel("Nome:");
        label1.setFont(new Font("Roboto", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        label1.setBounds(70,190,90, 30);

        inputNome = new JTextField();
        inputNome.setFont(new Font("Roboto", Font.PLAIN, 20));
        inputNome.setForeground(Color.BLACK);
        inputNome.setBounds(170,190,300, 30);

        label2 = new JLabel("Password:");
        label2.setFont(new Font("Roboto", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(60,240,120, 30);

        inputPassword = new JPasswordField();
        inputPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
        inputPassword.setForeground(Color.BLACK);
        inputPassword.setBounds(170,240,300, 30);

        btnConfirm = new JButton("CONFERMA");
        btnConfirm.setBackground(Color.BLUE);
        btnConfirm.setFont(new Font("Robot", Font.BOLD, 20));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFocusable(false);
        btnConfirm.setBounds(330,320,150,60);
        btnConfirm.addActionListener(this);

        btnLogin = new JButton("LOGIN");
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setFont(new Font("Robot", Font.BOLD, 20));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusable(false);
        btnLogin.setBounds(120,320,150,60);
        btnLogin.addActionListener(this);

        add(btnLogin);
        add(btnConfirm);
        add(inputPassword);
        add(label2);
        add(inputNome);
        add(label1);
        add(title);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            se si conferma:
                _vedere se la casella dell'input del nome non è vuota(se lo è manda errore joptionpane)
                _vedere se la password è lunga almeno 7 carattere
         */
        String nome = inputNome.getText();
        String password = inputPassword.getText();
        Registrazione reg = new Registrazione(nome, password);
        if(e.getSource() == btnConfirm){
            if(!nome.equals("")){
                if(password.length() > 7){
                    reg.addNameDatabase();
                    reg.addPasswordDatabase();
                    JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo", "Registrazione", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LoginGUI();

                    //TODO: finito login e registrazione iniziare home.
                }else
                    JOptionPane.showMessageDialog(null, "La password deve essere lunga almeno 7 caratteri", "Errore", JOptionPane.ERROR_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null, "Inserire il nome nell'input", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        if(e.getSource()==btnLogin){
            dispose();
            new LoginGUI();
        }
    }
}

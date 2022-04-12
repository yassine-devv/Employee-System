package com.company.GUI;

import com.company.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class LoginGUI extends JFrame implements ActionListener {
    JLabel title;
    JLabel label1;
    JTextField inputNome;
    JLabel label2;
    JPasswordField inputPassword;
    JButton btnConfirm;
    JButton btnRegistrazione;
    public LoginGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Login");
        setSize(600, 600);

        title = new JLabel("ACCEDI");
        title.setFont(new Font("Roboto", Font.BOLD, 25));
        title.setForeground(Color.BLACK);
        title.setBounds(250,110,100, 30);

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

        btnConfirm = new JButton("ACCEDI");
        btnConfirm.setBackground(Color.BLUE);
        btnConfirm.setFont(new Font("Robot", Font.BOLD, 20));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFocusable(false);
        btnConfirm.setBounds(330,320,150,60);
        btnConfirm.addActionListener(this);

        btnRegistrazione = new JButton("REGISTRATI");
        btnRegistrazione.setBackground(Color.BLUE);
        btnRegistrazione.setFont(new Font("Robot", Font.BOLD, 20));
        btnRegistrazione.setForeground(Color.WHITE);
        btnRegistrazione.setFocusable(false);
        btnRegistrazione.setBounds(70,320,200,60);
        btnRegistrazione.addActionListener(this);

        add(btnRegistrazione);
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
        if(e.getSource()==btnConfirm){
            String nome = inputNome.getText();
            String password = inputPassword.getText();
            Login log = new Login(nome, password);
            if(!nome.equals("") && !password.equals("")) {
                try {
                    if(log.cercaNomeUtente() && log.cercaPasswordUtente()) {
                        JOptionPane.showMessageDialog(null, "Login avvenuto con successo!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new HomeGUI(nome);
                    }else
                        JOptionPane.showMessageDialog(null, "Credenziali non valide", "Errore", JOptionPane.ERROR_MESSAGE);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }else
                JOptionPane.showMessageDialog(null, "Inserire i dati negli input appositi", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        if(e.getSource()==btnRegistrazione){
            dispose();
            new RegistrazioneGUI();
        }
    }
}

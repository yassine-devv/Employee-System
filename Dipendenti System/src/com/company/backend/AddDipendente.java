package com.company.backend;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AddDipendente {
    private String nome;
    private int id;
    private String reparto;

    public AddDipendente(String nome, int id, String reparto){
        this.nome = nome;
        this.id = id;
        this.reparto = reparto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    /**
     * @return a boolean if the system add the name of the employee in the right mode
     */

    public boolean AddNomeDipendente(){
        boolean ris = true;
        String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\nomeDip.txt";
        try {
            String lineToAppend = getNome()+"\n";
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(pathFile), byteArr, StandardOpenOption.APPEND);
            ris=true;
        }catch(Exception e){
            e.printStackTrace();
            ris=false;
        }
        return ris;
    }

    /**
     * @return a boolean if the system add the department where the employee works of the employee in the right mode
     */
    public boolean AddIdDipendente(){
        boolean ris = true;
        String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\idDip.txt";
        try {
            String lineToAppend = getId()+"\n";
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(pathFile), byteArr, StandardOpenOption.APPEND);
            ris=true;
        }catch(Exception e){
            e.printStackTrace();
            ris=false;
        }
        return ris;
    }

    /**
     * @return a boolean if the system add the id of the employee in the right mode
     */
    public boolean AddRepartoDipendente(){
        boolean ris=true;
        String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\repartoDip.txt";
        try {
            String lineToAppend = getReparto()+"\n";
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(pathFile), byteArr, StandardOpenOption.APPEND);
            ris=true;
        }catch(Exception e){
            e.printStackTrace();
            ris=false;
        }
        return ris;
    }
}

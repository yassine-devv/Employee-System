/*
package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tSISTEMA DI DIPENDENTI");

        String scelta;
        String nome="";
        String password="";

        System.out.print("Inserisci:\n[1]Login\n[0]Registrazione\n[E]Uscire\n>");
        scelta = sc.next();

        while(!scelta.equalsIgnoreCase("e")){
            switch(scelta){
                case "1":
                    login(nome, password, sc);
                    sleep();
                    break;
                case "0":
                    registrazione(nome, password, sc);
                    sleep();
                    break;
                default:
                    System.out.print("Opzione non valida!\nInserisci:\n[1]Login\n[0]Registrazione\n[E]Uscire\n>");
                    scelta = sc.next();
                    break;
            }
            System.out.print("Inserisci:\n[1]Login\n[0]Registrazione\n[E]Uscita\n>");
            scelta = sc.next();
        }

        exit(sc);
    }

    public static void home(String nome, Scanner sc) throws FileNotFoundException {
        System.out.print("\n\t\tCiao "+nome+"!");
        sleep();

        System.out.print("\nInserisci:\n[0]Elimina dipendente\n[1]Aggiungi dipendente\n[2]Modifica dipendente\n[3]Cerca dipendente\n[E]Esci\n>");
        String scelta = sc.next();

        while(!scelta.equalsIgnoreCase("E")){
            switch(scelta){
                case "0":
                    eliminaDipendente(sc);
                    break;
                case "1":
                    aggiungiDipendente(sc);
                    break;
                case "2":
                    modificaDipendente(sc);
                    break;
                case "3":
                    cercaDipendente(sc);
                default:
                    System.out.print("\nInserisci:\n[0]Elimina dipendente\n[1]Aggiungi dipendente\n[2]Modifica dipendente\n[3]Cerca dipendente\n[E]Esci\n>");
                    scelta = sc.next();
                    break;
            }
            System.out.print("\nInserisci:\n[0]Elimina dipendente\n[1]Aggiungi dipendente\n[2]Modifica dipendente\n[3]Cerca dipendente\n[E]Esci\n>");
            scelta = sc.next();
        }

        exit(sc);
    }

    public static void caricamento(){
        System.out.print("\t\tVericamento");
        for(int i=0; i<3; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }

        System.out.println();
    }

    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void exit(Scanner sc) {
        sleep();
        System.out.println("Grazie e arrivederci!");
        System.exit(0);
    }

    public static void login(String nome, String password, Scanner sc){
        System.out.print("\t\tLOGIN\nInserisci nome: ");
        nome = sc.next();

        System.out.print("Inserisci password: ");
        password = sc.next();

        Login log = new Login(nome, password);

        caricamento();

        try {
            if(log.cercaNomeUtente() && log.cercaPasswordUtente()) {
                home(nome, sc);
                sleep();
            }else
                System.out.println("Errore, credenziali non valide!\n");
        }catch(FileNotFoundException e){
            systemError();
        }
    }

    public static void registrazione(String nome, String password, Scanner sc){
        System.out.print("\t\tREGISTRAZIONE\nInserisci nome: ");
        nome = sc.next();

        System.out.print("Inserisci la password: ");
        password = sc.next();

        Registrazione reg = new Registrazione(nome, password);

        caricamento();

        reg.addNameDatabase();
        reg.addPasswordDatabase();

        System.out.println("Registrazione avvenuta con successo!");
    }

    public static void aggiungiDipendente(Scanner sc){
        System.out.print("\n\t\tAGGIUNGI DIPENDENTE\nInserisci il nome del dipendente: ");
        String nomeDip = sc.next();

        System.out.print("Inserisci l'id del dipendente(solo 4 numeri): ");
        int idDip = sc.nextInt();

        if(String.valueOf(idDip).length() != 4){
            System.out.println("L'id del dipendente deve essere lunga 4 cifre!");
            System.out.print("Inserisci l'id del dipendente(solo 4 numeri): ");
            idDip = sc.nextInt();
        }

        System.out.print("Inserisci il reparto del dipendente: ");
        String repartoDip = sc.next();

        AddDipendente adddip = new AddDipendente(nomeDip, idDip, repartoDip);

        caricamento();
        System.out.println();

        if(adddip.AddNomeDipendente() && adddip.AddRepartoDipendente() && adddip.AddIdDipendente())
            System.out.println("Dipendente aggiunto con successo!");
        else
            System.out.println("Qualcosa e' andato storto :(");
        sleep();
    }

    public static void cercaDipendente(Scanner sc) throws FileNotFoundException {
        System.out.print("\n\t\tCERCA DIPENDENTE\nCerca il dipendente per:\n[0]Nome\n[1]Id\n>");
        int sceltaCercaDipendente = sc.nextInt();

        CercaDipendente cercadip = new CercaDipendente();

        switch(sceltaCercaDipendente){
            case 1:
                System.out.print("Inserisci l'id del dipendente: ");
                int iddip = sc.nextInt();

                if(cercadip.cercaDipendenteId(iddip))
                    System.out.println("Dipendente trovato");
                else
                    System.out.println("Dipendente non trovato");
                break;
            case 0:
                System.out.print("Inserisci il nome del dipendente: ");
                String nomedip = sc.next();

                if(cercadip.cercaDipendenteNome(nomedip))
                    System.out.println("Dipendente trovato");
                else
                    System.out.println("Dipendente non trovato");
                break;
            default:
                System.out.println("Opzione non valida!");
        }

        sleep();
    }

    public static void eliminaDipendente(Scanner sc) throws FileNotFoundException {
        System.out.print("\n\t\tELIMINA DIPENDENTE\n");

        System.out.print("Inserisci il nome del dipendente: ");
        String nome=sc.next();

        System.out.print("Inserisci l'id del dipendente: ");
        String id=sc.next();

        System.out.print("Inserisci il reparto del dipendente: ");
        String reparto=sc.next();

        EliminaDipendente deldip = new EliminaDipendente(nome, id, reparto);

        if(deldip.eliminaNome() && deldip.eliminaId() && deldip.eliminaReparto())
            System.out.println("Il dipendente è stato eliminato con successo");
        else
            systemError();
    }

    public static void modificaDipendente(Scanner sc) throws FileNotFoundException {
        System.out.print("\n\t\tMODIFICA DIPENDENTE\nInserisci il nome del dipendente che vuoi modificare: ");
        String nomedip = sc.next();

        ModificaDipendente moddip = new ModificaDipendente(nomedip);

        if(moddip.ceDipendente()){
            System.out.println("Nome: "+nomedip);
            try{
                System.out.println("Id: "+moddip.trovaId());
                System.out.println("Reparto: "+moddip.trovaReparto());
            }catch (IOException e){
                systemError();
            }
            sleep();
            System.out.print("\nInserisci:\n[0]per modificare l'id\n[1]per modificare il nome\n[2]per modificare il reparto\n>");
            int scelta = sc.nextInt();

            switch (scelta){
                case 0:
                    replaceId(sc, moddip);
                    break;
                case 1:
                    replaceNome(sc, moddip);
                    break;
                case 2:
                    replaceReparto(sc, moddip);
                    break;
                default:
                    System.out.println("Opzione non valida!");
            }
        }else
            System.out.println("Dipendente non trovato");
    }

    public static void replaceId(Scanner sc, ModificaDipendente moddip){
        System.out.print("Inserisci il nuovo id: ");
        String nuovoid = sc.next();

        try {
            if(moddip.setId(nuovoid))
                System.out.println("Dipendente modificato con successo!");
            else
                System.out.println("Qualcosa e' andato storto riprova");
        } catch (IOException e) {
            systemError();
        }
    }

    public static void replaceNome(Scanner sc, ModificaDipendente moddip){
        System.out.print("Inserisci il nuovo nome: ");
        String nuovoNome = sc.next();

        try {
            if(moddip.replaceNome(nuovoNome))
                System.out.println("Dipendente modificato con successo!");
            else
                System.out.println("Qualcosa e' andato storto riprova");
        } catch (IOException e) {
            systemError();
        }
    }

    public static void replaceReparto(Scanner sc, ModificaDipendente moddip){
        System.out.print("Inserisci il nuovo reparto: ");
        String nuovoReparto = sc.next();

        try {
            if(moddip.replaceNome(nuovoReparto))
                System.out.println("Dipendente modificato con successo!");
            else
                System.out.println("Qualcosa e' andato storto riprova");
        } catch (IOException e) {
            systemError();
        }
    }

    public static void systemError(){
        System.out.println("Errore di sistema, prova in un altro momento!");
    }
}

 */

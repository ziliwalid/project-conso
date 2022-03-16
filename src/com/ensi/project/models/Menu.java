package com.ensi.project.models;

import java.util.Scanner;

public class Menu {
    final  Scanner in;

    private final Projet projet;


    public Menu() {
        this.in = new Scanner(System.in);
        this.projet = new Projet(1, 4, in);
    }

    public void execute() {
        int choice = -1;
        do {
            choice = getChoice();
            process(choice);
        }while (choice!=0);
    }

    private void process(int choice){
        clearBuffer();
        switch (choice){
            case 1 : projet.ajouterProgrammeurs()       ; break;
            case 2 : projet.afficherProgrammeur()       ; break;
            case 3 : projet.supprimerProgrammeur()      ; break;
            case 4 : projet.modifierBureau()            ; break;
            case 5 : projet.afficherListeProgrammeurs() ; break;
            case 6 : projet.ajouterConso()              ; break;
            case 7 : projet.afficherTotalTasses()       ; break;
            case 8 : projet.afficherOrderByTassesDesc() ; break;
        }
    }

    private void clearBuffer() {
        in.nextLine();
    }

    private int getChoice() {
            afficherMenu();
            return  in.nextInt();
    }

    private void afficherMenu() {
        System.out.println("~Menu~");
        System.out.println("1 : Ajouter programmeurs,");
        System.out.println("2 : afficher un programmeur,");
        System.out.println("3 : supprimer un programmeur,");
        System.out.println("4 : modifier le Bureau d'un programmeur,");
        System.out.println("5 : afficher la liste des programmeurs,");
        System.out.println("6 : ajouter une Consommation,");
        System.out.println("7 : afficher le total des tasses,");
        System.out.println("8 : afficherOrderByTassesDesc,");
        System.out.println("0 : Quitter,");
        System.out.print("~Saisir votre choix :");
    }


    public void close() {
        in.close();
    }
}

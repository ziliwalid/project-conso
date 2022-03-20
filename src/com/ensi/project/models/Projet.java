package com.ensi.project.models;

import java.util.*;

public class Projet {
    private final Scanner in;
    private int code;
    private int duree;
    private final Programmeur[] programmeurs;
    private final List<Conso> consos;
    private int current_index;
    final int MAX_PROG = 10;

    public Projet(int code, int duree, Scanner in) {
        this.current_index = 1;
        this.programmeurs = new Programmeur[MAX_PROG];
        this.consos = new ArrayList<>();
        this.in = in;
        this.code = code;
        this.duree = duree;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    private void checkProg() throws Exception {
        if(current_index>MAX_PROG) throw new Exception("Liste des programmeurs est déjà pleine !");
    }

    public void ajouterProgrammeurs() {
        while (true) {
            try {
                ajouterUnProgrammeur();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    private void ajouterUnProgrammeur() throws Exception {
        checkProg();
        System.out.println("~Nouveau programmeur~");
        System.out.println("Nom : ");
        String nom = in.nextLine();
        System.out.println("Prénom : ");
        String prenom = in.nextLine();
        System.out.println("Bureau : ");
        int bureau = in.nextInt();
        Programmeur prg = new Programmeur(current_index,nom, prenom, bureau);
        programmeurs[current_index++]=prg;
        String ok="";
        in.nextLine();
        do {
            System.out.print("Continuez (o/n)...");
            ok = in.nextLine();
        } while (!ok.equals("n") && !ok.equals("o"));

        if(ok.equals("n"))
            throw new Exception("Fin de saisie");
    }
    public void showProg(int id) throws Exception {
        if(id>=current_index) throw new Exception("Programmeur introuvable !");
        Programmeur prg = this.programmeurs[id];
        prg.show();
    }


    public void afficherProgrammeur() {
        System.out.println("Saisir un Id :");
        int id = in.nextInt();
        if(id>=current_index){
            System.out.println("Programmeur introuvable");
            return;
        }
        this.programmeurs[id].show();
    }

    public void afficherListeProgrammeurs() {
        for (int i = 1; i <current_index; i++) {
            if (programmeurs[i] == null){
                continue;
            }
            this.programmeurs[i].show();
        }
    }

    public void modifierBureau() {
        System.out.println("Saisissez l'id du programmeur pour modifier son bureau: ");
        int id = in.nextInt();
        System.out.println("veuillez saisir le num du bureau: ");
        programmeurs[id].setBureau(in.nextInt());
    }

    public void ajouterConso() {
        System.out.println("Saisissez l'id du programmeur pour lui ajouter");
        int id = in.nextInt();
        if (id >= current_index) {
            System.out.println("Programmeur introuvable");
            return;
        }
        System.out.println("Numero de la semaine ?");
        int sem= in.nextInt();
        System.out.println("Nombre de tasses?");
        int tasse= in.nextInt();
        this.consos.add(new Conso(sem,tasse, id));

    }
    public void afficherTotalTasses() {
        System.out.println("Numero de la semaine ?");
        int sem = in.nextInt();
        int sum = 0;
        for (Conso c: this.consos ) {
            if(c.getNum_semaine()==sem)
            sum += c.getNb_tasses();
        }
        System.out.println("Total des tasses : " + sum);
    }

    public void supprimerProgrammeur() {
        System.out.print("Saisissez l'id du programmeur que vous voulez supprimer: ");
        int idSup = in.nextInt();
        if (idSup>= current_index){
            System.out.println("Programmeur introuvable");
        }
            Programmeur[] newArray = new Programmeur[programmeurs.length - 1];
            for (int i = 0,k=0; i <programmeurs.length; i++) {
                if (i==idSup){
                    continue;
                }

                newArray[k++]=programmeurs[i] ;
            }

        for (int i = 0,a=0; i < newArray.length; i++) {
            programmeurs[a++]=newArray[i];


        }

        System.out.println("edited array"+Arrays.toString(newArray));


    }


    public void afficherOrderByTassesDesc() {
        if(this.current_index==1) {
            System.out.println("La liste des programmeurs est vide !");
            return;
        }
        System.out.println("Numero de la semaine ?");
        int sem = in.nextInt();
        List<ConsoHebdo> consoHebdos = new ArrayList<>();
        for (Programmeur prog: programmeurs ) {
            if(prog==null) continue;
            int sumCons = getTotalCons(prog.getId(), sem);
            consoHebdos.add(new ConsoHebdo(prog, sumCons));
        }
        consoHebdos.sort(Comparator.comparing(ConsoHebdo::getTotal).reversed());
        consoHebdos.forEach(System.out::println);

    }

    private int getTotalCons(int id, int sem) {
        int sum = 0;
        for (Conso c: this.consos ) {
            if(c.getNum_semaine()==sem && c.getProgrammeur_id()==id)
                sum += c.getNb_tasses();
        }
        return sum;
    }
}

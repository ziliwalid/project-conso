package com.ensi.project.models;

public class Conso {
    private int num_semaine;
    private int nb_tasses;
    private int programmeur_id;

    public Conso() {
    }

    public Conso(int num_semaine, int nb_tasses, int programmeur_id) {
        this.num_semaine = num_semaine;
        this.nb_tasses = nb_tasses;
        this.programmeur_id = programmeur_id;
    }

    public int getNum_semaine() {
        return num_semaine;
    }

    public void setNum_semaine(int num_semaine) {
        this.num_semaine = num_semaine;
    }

    public int getNb_tasses() {
        return nb_tasses;
    }

    public void setNb_tasses(int nb_tasses) {
        this.nb_tasses = nb_tasses;
    }

    public int getProgrammeur_id() {
        return programmeur_id;
    }

    public void setProgrammeur_id(int programmeur_id) {
        this.programmeur_id = programmeur_id;
    }
}

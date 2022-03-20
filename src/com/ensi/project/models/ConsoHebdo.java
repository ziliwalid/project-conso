package com.ensi.project.models;

public class ConsoHebdo {
    private Programmeur programmeur;
    private int total;

    @Override
    public String toString() {
        return String.format("Nom : %s\t Prénom : %s\t Total : %d",
                programmeur.getNom(), programmeur.getPrenom(), total);
    }

    public ConsoHebdo() {
    }

    public ConsoHebdo(Programmeur programmeur, int total) {
        this.programmeur = programmeur;
        this.total = total;
    }

    public Programmeur getProgrammeur() {
        return programmeur;
    }

    public void setProgrammeur(Programmeur programmeur) {
        this.programmeur = programmeur;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

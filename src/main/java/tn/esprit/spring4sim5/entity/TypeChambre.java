package tn.esprit.spring4sim5.entity;

public enum TypeChambre {
    SIMPLE(1),
    DOUBLE(2),
    TRIPLE(3);

    private final int capaciteMax;

    TypeChambre(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }
}

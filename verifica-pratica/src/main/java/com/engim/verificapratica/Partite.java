package com.engim.verificapratica;

public class Partite {
    private Squadra primaSquadra;
    private Squadra secondaSquadra;

    public Partite(Squadra primaSquadra, Squadra secondaSquadra) {
        this.primaSquadra = primaSquadra;
        this.secondaSquadra = secondaSquadra;
    }

    public Squadra getPrimaSquadra() {
        return primaSquadra;
    }

    public void setPrimaSquadra(Squadra primaSquadra) {
        this.primaSquadra = primaSquadra;
    }

    public Squadra getSecondaSquadra() {
        return secondaSquadra;
    }

    public void setSecondaSquadra(Squadra secondaSquadra) {
        this.secondaSquadra = secondaSquadra;
    }
}

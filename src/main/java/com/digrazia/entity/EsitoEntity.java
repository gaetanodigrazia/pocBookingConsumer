package com.digrazia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "esito")
public class EsitoEntity {
    @Id
    private String id;
    private String prenotazioneId;
    private String descrizione;
    private String prescrizioni;
    private boolean chiuso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenotazioneId() {
        return prenotazioneId;
    }

    public void setPrenotazioneId(String prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPrescrizioni() {
        return prescrizioni;
    }

    public void setPrescrizioni(String prescrizioni) {
        this.prescrizioni = prescrizioni;
    }
    public boolean isChiuso() {
        return chiuso;
    }
    public void setChiuso(boolean chiuso) {
        this.chiuso = chiuso;
    }
}

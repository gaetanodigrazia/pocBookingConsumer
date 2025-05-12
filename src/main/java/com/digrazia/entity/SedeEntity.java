package com.digrazia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "sede")
public class SedeEntity {
    @Id
    private String id;
    private String nome;
    private String citta;
    private String indirizzo;

    @OneToMany(mappedBy = "sedeEntity")
    @JsonManagedReference
    private List<DottoreSedeER> assegnazioni;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<DottoreSedeER> getAssegnazioni() {
        return assegnazioni;
    }

    public void setAssegnazioni(List<DottoreSedeER> assegnazioni) {
        this.assegnazioni = assegnazioni;
    }
}

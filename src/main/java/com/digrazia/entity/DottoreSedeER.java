package com.digrazia.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity(name = "dottore_sede")
public class DottoreSedeER {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "dottore_id", nullable = false)
    @JsonBackReference
    private DottoreEntity dottoreEntity;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    @JsonBackReference
    private SedeEntity sedeEntity;

    private boolean attivo;
    private String note;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public DottoreEntity getDottore() { return dottoreEntity; }
    public void setDottore(DottoreEntity dottoreEntity) { this.dottoreEntity = dottoreEntity; }

    public SedeEntity getSede() { return sedeEntity; }
    public void setSede(SedeEntity sedeEntity) { this.sedeEntity = sedeEntity; }

    public boolean isAttivo() { return attivo; }
    public void setAttivo(boolean attivo) { this.attivo = attivo; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = java.util.UUID.randomUUID().toString();
        }
    }
}

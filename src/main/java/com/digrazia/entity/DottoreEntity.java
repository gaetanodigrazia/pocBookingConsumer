
package com.digrazia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

import java.util.List;

@Entity(name = "dottore")
public class DottoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "dottoreEntity")
    @JsonManagedReference
    @JsonIgnore
    private List<DottoreSedeER> assegnazioni;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<DottoreSedeER> getAssegnazioni() {
        return assegnazioni;
    }

    public void setAssegnazioni(List<DottoreSedeER> assegnazioni) {
        this.assegnazioni = assegnazioni;
    }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = java.util.UUID.randomUUID().toString();
        }
    }

}

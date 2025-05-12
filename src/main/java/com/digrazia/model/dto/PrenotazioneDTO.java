package com.digrazia.model.dto;

public class PrenotazioneDTO {
    private String id;
    private String utenteId;
    private String disponibilitaId;
    private String data;
    private String email;
    private String telefono;
    private String nome;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUtenteId() { return utenteId; }
    public void setUtenteId(String utenteId) { this.utenteId = utenteId; }

    public String getDisponibilitaId() { return disponibilitaId; }
    public void setDisponibilitaId(String disponibilitaId) { this.disponibilitaId = disponibilitaId; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}

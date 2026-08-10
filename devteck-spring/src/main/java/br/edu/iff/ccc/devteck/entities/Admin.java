package br.edu.iff.ccc.devteck.entities;

import java.time.LocalDate;

public class Admin extends Usuario {

    private String nivelAcesso;

    public Admin() {
        super();
    }

    public Admin(Long id, String nome, String email, String senha,
                 LocalDate dataCadastro, String nivelAcesso) {
        super(id, nome, email, senha, dataCadastro);
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String getTipo() {
        return "ADMIN";
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

}

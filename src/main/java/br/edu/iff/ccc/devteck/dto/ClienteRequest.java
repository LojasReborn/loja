package br.edu.iff.ccc.devteck.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 50, message = "A senha deve ter entre 6 e 50 caracteres")
    private String senha;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O CEP é obrigatório")
    @Size(min = 8, max = 9, message = "Informe um CEP válido")
    private String cep;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Size(min = 2, max = 2, message = "Informe a sigla do estado (ex: RJ)")
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

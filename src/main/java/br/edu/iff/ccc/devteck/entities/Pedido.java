package br.edu.iff.ccc.devteck.entities;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Pedido
 */
public class Pedido {

    private UUID id;
    private UUID produtoId;
    private int quantidade;
    private String status;
    private LocalDateTime dataCriacao;

    public Pedido(UUID id, UUID produtoId, int quantidade, String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Pedido() {
    }

    public UUID getId() {
        return id;
    }

    public UUID getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProdutoId(UUID produtoId) {
        this.produtoId = produtoId;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}

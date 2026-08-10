package br.edu.iff.ccc.devteck.entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class Carrinho {

    private Long id;
    private Long clienteId;
    private Map<Long, Integer> itens;
    private double valorTotal;

    public Carrinho() {
        this.itens = new LinkedHashMap<>();
    }

    public Carrinho(Long id, Long clienteId) {
        this();
        this.id = id;
        this.clienteId = clienteId;
    }

    public void adicionarProduto(Long produtoId, int quantidade) {
        itens.merge(produtoId, quantidade, Integer::sum);
    }

    public void removerProduto(Long produtoId) {
        itens.remove(produtoId);
    }

    public void definirQuantidade(Long produtoId, int quantidade) {
        if (quantidade <= 0) {
            itens.remove(produtoId);
        } else {
            itens.put(produtoId, quantidade);
        }
    }

    public void limparCarrinho() {
        itens.clear();
        valorTotal = 0;
    }

    // ===== Getters e Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Map<Long, Integer> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}

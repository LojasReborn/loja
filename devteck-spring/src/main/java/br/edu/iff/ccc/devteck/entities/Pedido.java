package br.edu.iff.ccc.devteck.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private Long clienteId;
    private LocalDate dataPedido;
    private String status;
    private double valorTotal;
    private String enderecoEntrega;
    private List<ItemPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(Long id, Long clienteId, String enderecoEntrega) {
        this.id = id;
        this.clienteId = clienteId;
        this.enderecoEntrega = enderecoEntrega;
        this.dataPedido = LocalDate.now();
        this.status = "PENDENTE";
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        this.valorTotal = total;
        return total;
    }

    public void alterarStatus(String novoStatus) {
        this.status = novoStatus;
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

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

}

package br.edu.iff.ccc.devteck.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.devteck.entities.Pedido;

@Repository
public class PedidoRepositorio {

    private List<Pedido> pedidos;

    public PedidoRepositorio() {
        // Inicialização do repositório, se necessário
        this.pedidos = new ArrayList<Pedido>();

    }

    public void salvar(Pedido pedido) {
        // Lógica para salvar o pedido no repositório
        this.pedidos.add(pedido);
        System.out.println("Pedido salvo: " + pedido.getId());
    }

    public Pedido buscarPorId(String id) {
        // Lógica para buscar um pedido pelo ID no repositório
        return null; // Retornar o pedido encontrado ou null se não encontrado
    }

    public List<Pedido> listar() {
        // Lógica para listar todos os pedidos do repositório
        return this.pedidos;
    }

}

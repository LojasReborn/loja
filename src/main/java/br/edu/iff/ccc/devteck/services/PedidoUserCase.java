package br.edu.iff.ccc.devteck.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.iff.ccc.devteck.dto.PedidoRequest;
import br.edu.iff.ccc.devteck.entities.Pedido;
import br.edu.iff.ccc.devteck.repository.PedidoRepositorio;

@Service
public class PedidoUserCase {

    private static final int QUANTIDADE_MAXIMA_POR_PEDIDO = 100;

    private final PedidoRepositorio pedidoRepositorio;

    public PedidoUserCase(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido criarPedido(PedidoRequest pedidoRequest) {
        // Regra de negócio: criação de um pedido

        // O produto do pedido é obrigatório
        if (pedidoRequest.getProdutoId() == null || pedidoRequest.getProdutoId().isBlank()) {
            throw new IllegalArgumentException("O produto do pedido é obrigatório.");
        }

        // A quantidade deve ser maior que zero
        if (pedidoRequest.getQuantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade do pedido deve ser maior que zero.");
        }

        // A quantidade não pode ultrapassar o limite máximo permitido por pedido
        if (pedidoRequest.getQuantidade() > QUANTIDADE_MAXIMA_POR_PEDIDO) {
            throw new IllegalArgumentException(
                    "A quantidade do pedido não pode ultrapassar " + QUANTIDADE_MAXIMA_POR_PEDIDO + " unidades.");
        }

        UUID id = UUID.randomUUID();
        UUID produtoId = UUID.fromString(pedidoRequest.getProdutoId());

        // Todo pedido novo nasce com status "PENDENTE"
        Pedido novoPedido = new Pedido(id, produtoId, pedidoRequest.getQuantidade(), "PENDENTE", LocalDateTime.now());
        this.pedidoRepositorio.salvar(novoPedido);

        return novoPedido;
    }

    public void atualizarPedido() {
        // Lógica para atualizar um pedido
    }

    public void cancelarPedido() {
        // Lógica para cancelar um pedido
    }

    public void buscarPedido() {
        // Lógica para buscar um pedido
    }

    public void listarPedidos() {
        // Lógica para listar todos os pedidos
    }

    public void validarPedido() {
        // Lógica para validar um pedido
    }

}

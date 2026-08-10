package br.edu.iff.ccc.devteck.services;

import br.edu.iff.ccc.devteck.entities.Carrinho;
import br.edu.iff.ccc.devteck.entities.ItemPedido;
import br.edu.iff.ccc.devteck.entities.Pedido;
import br.edu.iff.ccc.devteck.entities.Produto;
import br.edu.iff.ccc.devteck.repository.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PedidoUseCase {

    private final PedidoRepositorio pedidoRepositorio;
    private final CarrinhoUseCase carrinhoUseCase;
    private final ProdutoUseCase produtoUseCase;

    public PedidoUseCase(PedidoRepositorio pedidoRepositorio,
                          CarrinhoUseCase carrinhoUseCase,
                          ProdutoUseCase produtoUseCase) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.carrinhoUseCase = carrinhoUseCase;
        this.produtoUseCase = produtoUseCase;
    }

    public Pedido finalizarPedido(Long clienteId, String enderecoEntrega) {
        Carrinho carrinho = carrinhoUseCase.buscarCarrinho(clienteId);

        if (carrinho.getItens().isEmpty()) {
            throw new IllegalStateException("Carrinho vazio, nao e possivel finalizar o pedido");
        }

        Pedido pedido = new Pedido(null, clienteId, enderecoEntrega);

        for (Map.Entry<Long, Integer> entry : carrinho.getItens().entrySet()) {
            Long produtoId = entry.getKey();
            int quantidade = entry.getValue();
            Produto produto = produtoUseCase.buscarPorId(produtoId);

            if (quantidade > produto.getQuantidadeEstoque()) {
                throw new IllegalStateException(
                        "Estoque insuficiente para " + produto.getNome() +
                        " (disponivel: " + produto.getQuantidadeEstoque() + ")");
            }

            pedido.adicionarItem(new ItemPedido(produto.getId(), produto.getNome(),
                    quantidade, produto.getPreco()));
        }

        for (ItemPedido item : pedido.getItens()) {
            produtoUseCase.darBaixaEstoque(item.getProdutoId(), item.getQuantidade());
        }

        pedido.calcularTotal();
        pedidoRepositorio.salvar(pedido);
        carrinhoUseCase.limparCarrinho(clienteId);

        return pedido;
    }

    public List<Pedido> listarPorCliente(Long clienteId) {
        return pedidoRepositorio.listarPorCliente(clienteId);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepositorio.listarTodos();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido nao encontrado: id " + id));
    }

    public void atualizarStatus(Long id, String novoStatus) {
        Pedido pedido = buscarPorId(id);
        pedido.alterarStatus(novoStatus);
        pedidoRepositorio.salvar(pedido);
    }

    public void cancelarPedido(Long id) {
        Pedido pedido = buscarPorId(id);

        for (ItemPedido item : pedido.getItens()) {
            produtoUseCase.devolverEstoque(item.getProdutoId(), item.getQuantidade());
        }

        pedidoRepositorio.remover(id);
    }

}

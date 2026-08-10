package br.edu.iff.ccc.devteck.repository;

import br.edu.iff.ccc.devteck.entities.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PedidoRepositorio {

    private final Map<Long, Pedido> pedidos = new LinkedHashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public Pedido salvar(Pedido pedido) {
        if (pedido.getId() == null) {
            pedido.setId(proximoId.getAndIncrement());
        }
        pedidos.put(pedido.getId(), pedido);
        return pedido;
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public List<Pedido> listarPorCliente(Long clienteId) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos.values()) {
            if (pedido.getClienteId().equals(clienteId)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return Optional.ofNullable(pedidos.get(id));
    }

    public void remover(Long id) {
        pedidos.remove(id);
    }

}

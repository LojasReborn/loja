package br.edu.iff.ccc.devteck.repository;

import br.edu.iff.ccc.devteck.entities.Carrinho;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CarrinhoRepositorio {

    private final Map<Long, Carrinho> carrinhosPorCliente = new LinkedHashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public Carrinho buscarPorCliente(Long clienteId) {
        return carrinhosPorCliente.computeIfAbsent(clienteId,
                id -> new Carrinho(proximoId.getAndIncrement(), id));
    }

    public Carrinho salvar(Carrinho carrinho) {
        carrinhosPorCliente.put(carrinho.getClienteId(), carrinho);
        return carrinho;
    }

}

package br.edu.iff.ccc.devteck.repository;

import br.edu.iff.ccc.devteck.entities.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProdutoRepositorio {

    private final Map<Long, Produto> produtos = new LinkedHashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public Produto salvar(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(proximoId.getAndIncrement());
        }
        produtos.put(produto.getId(), produto);
        return produto;
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos.values());
    }

    public Optional<Produto> buscarPorId(Long id) {
        return Optional.ofNullable(produtos.get(id));
    }

    public void remover(Long id) {
        produtos.remove(id);
    }

}

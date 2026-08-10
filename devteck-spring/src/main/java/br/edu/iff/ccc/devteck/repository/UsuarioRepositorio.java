package br.edu.iff.ccc.devteck.repository;

import br.edu.iff.ccc.devteck.entities.Admin;
import br.edu.iff.ccc.devteck.entities.Cliente;
import br.edu.iff.ccc.devteck.entities.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UsuarioRepositorio {

    private final Map<Long, Usuario> usuarios = new LinkedHashMap<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    @PostConstruct
    public void seed() {
        salvar(new Admin(null, "Admin DevTeck", "admin@devteck.com", "admin123",
                LocalDate.now(), "TOTAL"));

        salvar(new Cliente(null, "Joao Silva", "joao@email.com", "123456", LocalDate.now(),
                "22999999999", "Rua das Flores, 123", "28000-000", "Campos dos Goytacazes", "RJ"));
    }

    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(proximoId.getAndIncrement());
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.values().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Usuario usuario : usuarios.values()) {
            if (usuario instanceof Cliente cliente) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void remover(Long id) {
        usuarios.remove(id);
    }

}

package br.edu.iff.ccc.devteck.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.ccc.devteck.dto.PedidoRequest;
import br.edu.iff.ccc.devteck.services.PedidoUserCase;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoUserCase pedidoUserCase;

    PedidoController(PedidoUserCase pedidoUserCase) {
        this.pedidoUserCase = pedidoUserCase;
    }

    @GetMapping("/novo")
    public String novoPedido(Model model) {
        PedidoRequest novoPedido = new PedidoRequest();
        model.addAttribute("pedido", novoPedido);
        return "pedidoForm.html";
    }

    @PostMapping()
    public String criarPedido(PedidoRequest pedidoRequest) {
        // Lógica para criar um pedido
        this.pedidoUserCase.criarPedido(pedidoRequest);
        return "pedidos.html";
    }

}

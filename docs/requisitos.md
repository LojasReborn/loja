# 📋 Requisitos do Sistema

## 📌 Descrição Geral

O sistema tem como objetivo permitir que o lojista gerencie produtos, estoque e pedidos realizados por clientes através de uma plataforma online simples e intuitiva.

O sistema possuirá dois perfis principais:

- Administrador (Admin)
- Cliente

---

## 📌 Requisitos Funcionais

### RF01 - Cadastro de Produtos
O sistema deve permitir que o administrador cadastre produtos informando:

- nome
- descrição
- preço
- quantidade em estoque
- categoria

---

### RF02 - Atualização de Produtos
O sistema deve permitir que o administrador edite informações dos produtos cadastrados.

---

### RF03 - Controle de Estoque
O sistema deve validar a quantidade disponível em estoque antes da finalização de um pedido.

---

### RF04 - Remoção de Produtos
O sistema deve permitir que o administrador remova ou desative produtos cadastrados.

---

### RF05 - Listagem de Produtos
O sistema deve permitir que os clientes visualizem os produtos disponíveis.

---

### RF06 - Filtro por Categoria
O sistema deve permitir a filtragem de produtos por categoria.

---

### RF07 - Carrinho de Compras
O sistema deve permitir que o cliente adicione e remova produtos do carrinho.

---

### RF08 - Fechamento de Pedido
O sistema deve permitir que o cliente finalize pedidos.

---

### RF09 - Baixa Automática no Estoque
Ao finalizar um pedido, o sistema deve atualizar automaticamente a quantidade disponível em estoque.

---

### RF10 - Histórico de Pedidos
O sistema deve permitir que o cliente visualize o histórico de pedidos realizados.

---

### RF11 - Gerenciamento de Pedidos
O sistema deve permitir que o administrador acompanhe os pedidos realizados.

---

## 📌 Requisitos Não Funcionais

### RNF01 - Segurança de Dados
As informações dos usuários devem ser armazenadas de forma segura.

---

### RNF02 - Desempenho
O sistema deve responder às ações do usuário em tempo adequado.

---

### RNF03 - Usabilidade
A interface deve ser simples, intuitiva e de fácil navegação.

---

### RNF04 - Persistência de Dados
Os dados do sistema devem ser armazenados em banco de dados relacional.

---

## 📌 Regra de Negócio Principal

Cada pedido realizado deve associar um cliente a um ou mais produtos.

Ao finalizar um pedido:

- o estoque deve ser atualizado automaticamente;
- os itens devem ser vinculados ao pedido;
- o pedido deve ser armazenado no histórico do cliente.

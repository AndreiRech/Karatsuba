# ALUNO

- [Andrei Rech | 23102140](https://github.com/AndreiRech)  

# INTRODUÇÃO

Aplicação capaz de realizar multiplicação de números binários utilizando o método de Karatsuba.

# 🛠 PRÉ REQUISITOS

É necessária possuir alguma versão do [Java](https://www.java.com/pt-BR/download/) instalado em sua máquina.

# ⚙ INICIALIZAÇÃO E UTILIZAÇÃO

Para podermos utilizar o projeto, primeiro compile o programa em sua máquina.

```bash
    javac Karatsuba.java
```

Após isso, você pode informar os números desejados, sendo que os mesmos devem ser **obrigatóriamente**: *binários* [01] e separados por um *espaço*. Siga o exemplo abaixo.

```bash
    java Karatsuba 101010100101010010010100101001010010100101010101010101001101 10010100101010010100101010100101001010
```

O resultado esperado deve aparecer no terminal logo abaixo de seu input.

```bash
    1100010111010011000100101101111111100110000011001100001111111010101101001001001000111110101000010
```

# O QUE FAZER

Aqui está a lista de a fazeres do trabalho.

**LÓGICA DE KARATSUBA**

> Implementação da lógica de como o programa deve funcionar: sequência de operações e condicionais

- [X] Lógica do programa

**OPERAÇÕES SOB N° BINÁRIOS**

> Podem ser descritas como as operações matemáticas necessárias para a utilização do programa

- [X] Subtração
- [X] Adição
- [X] Multiplicação

**MÉTODOS AUXILIARES**

> Métodos que complementam ou são utilizados durante a execução

- [X] Shift de valores
- [X] Igualar número de dígitos
- [X] Remover 0 adicionais em frente ao resultado final

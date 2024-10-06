# "Wolvesville" em Java

Este é um projeto universitário desenvolvido como parte de uma disciplina de Ciência da Computação. O projeto é inspirado no jogo *Wolvesville* (um jogo no estilo *Among Us*), focado em elementos de dedução social e estratégias. Todo o jogo foi implementado em Java puro, sem o uso de APIs externas, para reforçar conceitos básicos e avançados da linguagem Java.

## Índice

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

## Visão Geral

Este projeto é uma versão simplificada do jogo *Wolvesville*, onde jogadores assumem papéis diferentes e devem trabalhar juntos ou contra outros para vencer o jogo. Cada jogador pode ser parte de uma equipe ou ser um lobo solitário (traidor), e o objetivo é sobreviver até o fim.

O projeto visa demonstrar o uso de conceitos avançados de Java, como classes abstratas, métodos estáticos, enumeradores (enum) e modificadores de acesso como `final`. O código é inteiramente escrito em Java puro, sem nenhuma biblioteca ou API externa.

## Funcionalidades

- **Jogadores com papéis distintos**: Cada jogador pode ter um papel diferente, como aldeão ou lobo (traidor).
- **Sistema de votação**: Implementação de um sistema de votação para eliminar suspeitos.
- **Mecânicas de Dia e Noite**: Durante a noite, os lobos fazem suas jogadas, enquanto durante o dia os jogadores discutem e votam.
- **Condicionais para vitória**: Implementação de diferentes condições para a vitória, dependendo do papel dos jogadores.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para todo o projeto.
- **Conceitos Avançados de Java**:
  - **Classes Abstratas**: Para definir comportamentos genéricos para os jogadores.
  - **Métodos Estáticos**: Para funções utilitárias, como cálculo de votos.
  - **Enums**: Para definir os diferentes papéis no jogo.
  - **Modificador Final**: Para garantir que certas classes ou métodos não possam ser modificados.

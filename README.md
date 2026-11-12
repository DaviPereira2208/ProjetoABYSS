# PROJECT: ABYSS

**Um jogo conceitual de Survival Horror desenvolvido em Java.**

## Sobre o projeto

PROJECT: ABYSS é um projeto acadêmico desenvolvido em Java com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO) por meio da criação de um jogo inspirado no gênero Survival Horror.

O jogo se passa em um laboratório secreto de pesquisas biológicas que sofreu um acidente envolvendo experimentos de infecção. O jogador assume o papel de Julian Reed, que precisa explorar o ambiente, encontrar recursos e sobreviver às criaturas infectadas enquanto tenta descobrir o que aconteceu.

## História

Uma forma de vida microscópica encontrada em uma amostra de Marte dá início a uma série de experimentos em um laboratório secreto no Brasil.

Após tentativas de desenvolver uma vacina, os testes acabam provocando consequências inesperadas. O laboratório entra em colapso e seus ocupantes são afetados pela infecção.

O protagonista, Julian Reed, acorda no complexo sem compreender completamente o que aconteceu. Agora, precisa explorar as instalações e enfrentar os perigos para descobrir a verdade.

## Funcionalidades implementadas

- Exploração de salas e ambientes.
- Movimentação entre áreas conectadas.
- Sistema de combate contra criaturas.
- Sistema de vida e dano dos personagens.
- Inventário para armazenar itens.
- Coleta e utilização de itens.
- Utilização de kits médicos para recuperar vida.
- Equipamento e utilização de armas.
- Controle de munição e recarga.
- Cartões de acesso para abrir portas.
- Sistema de contaminação dos personagens.

## Estrutura do projeto

O projeto é organizado em classes com responsabilidades específicas:

| Classe | Responsabilidade |
|---|---|
| `Main` | Inicialização e execução do jogo. |
| `Personagem` | Classe abstrata com características comuns aos personagens. |
| `Jogador` | Representa o personagem controlado pelo usuário. |
| `Criatura` | Representa os inimigos do jogo. |
| `Infectado` | Representa um tipo de criatura infectada. |
| `Arma` | Gerencia dano, munição, disparos e recarga. |
| `Item` | Classe abstrata para os itens do jogo. |
| `KitMedico` | Recuperação de vida do jogador. |
| `CartaoDeAcesso` | Representa cartões utilizados para liberar acessos. |
| `Inventario` | Gerencia os itens coletados. |
| `ItemInventario` | Organiza os itens armazenados no inventário. |
| `Combate` | Gerencia os confrontos. |
| `Exploracao` | Gerencia a exploração do ambiente. |
| `Fase` | Organiza as fases do jogo. |
| `Sala` | Representa os ambientes exploráveis. |
| `Porta` | Controla o acesso entre ambientes. |
| `Contaminavel` | Interface relacionada ao comportamento de contaminação. |

## Conceitos de Programação Orientada a Objetos

Durante o desenvolvimento, foram aplicados os seguintes conceitos:

- **Abstração:** utilização de classes abstratas, como `Personagem` e `Item`.
- **Encapsulamento:** organização e proteção dos atributos por meio de modificadores de acesso e métodos.
- **Herança:** reutilização de características entre classes, como `Jogador` e `Criatura`, que herdam de `Personagem`.
- **Polimorfismo:** utilização de sobrescrita e sobrecarga de métodos.
- **Interfaces:** utilização de `Contaminavel` para definir um comportamento relacionado à contaminação.

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Git
- GitHub
- IntelliJ IDEA (ambiente de desenvolvimento)

## Como executar o projeto

1. Clone este repositório:

   ```bash
   git clone URL_DO_SEU_REPOSITORIO
   ```

2. Abra o projeto em uma IDE compatível com Java, como IntelliJ IDEA.

3. Verifique se o JDK está configurado.

4. Localize o arquivo `Main.java`.

5. Execute o método `main` para iniciar o jogo.

## Objetivo acadêmico

Este projeto foi desenvolvido como atividade acadêmica para demonstrar a aplicação prática dos conceitos de Programação Orientada a Objetos utilizando a linguagem Java.

Além da implementação das mecânicas principais, o projeto busca demonstrar organização de código, divisão de responsabilidades e relacionamento entre classes.

## Desenvolvedores

Projeto desenvolvido para fins acadêmicos.

---

**PROJECT: ABYSS — A sobrevivência é apenas o começo.**

# 📄 Documentação Completa
Acesse o documento oficial com toda a história, regras, personagens e arquitetura POO do projeto:

👉 **[Abrir Documentação no Google Docs](https://docs.google.com/document/d/1v4WscJyBJtY775_ha5gkp1DF5UBXcv69tSPDFL28McE/edit?usp=sharing)**


# 📊 Diagrama de Classes (UML)

👉 **[Diagrama de Classes]
(<img width="1195" height="1261" alt="PROJECT_ABYSS_Diagrama" src="https://github.com/user-attachments/assets/c0ff4a55-3ac3-4d77-995e-d686386593e2" />)**

# 📊 Apresentação (Slides)

👉 **[Visualizar Slides da Apresentação (PDF)]
(./PROJECT_ABYSS_Apresentacao.pdf)**

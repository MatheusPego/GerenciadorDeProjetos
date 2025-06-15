# Sistema de Gerenciamento de Projetos

Este projeto é um **Sistema de Gerenciamento de Projetos** desenvolvido como atividade acadêmica para praticar conceitos de programação orientada a objetos utilizando a linguagem Java. O sistema funciona no terminal (linha de comando) e tem como objetivo simular o dia a dia de cadastro de obras, gerenciamento de usuários e solicitações de alteração em projetos, proporcionando uma experiência didática para estudantes.

## O que o sistema faz?

- Permite cadastrar diferentes usuários, separando-os por setores de atuação (Projetos ou Teste).
- Torna possível cadastrar novas obras/projetos, com geração automática de identificação e data.
- Mostra todos os projetos já cadastrados para consulta.
- Usuários podem solicitar revisões ou alterações em projetos, justificando o motivo.
- Permite visualizar todas as solicitações de revisão cadastradas.
- O menu apresentado se adapta conforme o setor do usuário, mostrando apenas as opções relevantes para cada função.

## Como está estruturado?

O sistema é composto por algumas classes principais:

- **User**: Representa o usuário, seu setor, login, senha e métodos para interação.
- **Project**: Representa a obra/projeto, com seus dados principais.
- **RequestReview**: Guarda as informações sobre as solicitações de revisão feitas pelos usuários.
- **ArrayDB**: Simula um “banco de dados” em memória para guardar usuários, projetos e solicitações enquanto o programa está rodando.
- **Sector**: Enumeração que define os setores possíveis.
- **Application**: Ponto de partida do programa, responsável por coordenar o fluxo de funcionamento.

## Ferramentas utilizadas

- **Java 11**: Linguagem de programação usada para todo o desenvolvimento. Escolhida por ser muito utilizada em cursos universitários e oferecer recursos modernos para a construção de sistemas orientados a objetos.
- **IntelliJ IDEA**: Ambiente de desenvolvimento integrado (IDE) escolhido para facilitar a escrita, organização, execução e depuração do código.

## Como rodar o sistema?

1. Certifique-se de ter o Java 11 instalado em seu computador.
2. Baixe ou clone este repositório.
3. Abra o projeto na IDE IntelliJ IDEA.
4. Compile o projeto.
5. Execute a classe principal (`Application.java`).
6. Siga as instruções no terminal para criar usuários, cadastrar obras ou fazer solicitações.

## Observações para estudantes

- O sistema não usa banco de dados real. Todas as informações existem apenas enquanto o programa está rodando. Ao fechar, tudo é apagado.
- Os comentários no código foram feitos de forma clara e direta, buscando facilitar a compreensão dos conceitos aplicados.
- O projeto é ideal para quem está aprendendo sobre organização de sistemas, orientação a objetos, validação de dados e interação com o usuário via terminal.

---

Desenvolvido para fins didáticos por MatheusPego.

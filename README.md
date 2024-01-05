# ☕ Java Aplicado a Redes de Computadores..

## Este material foi desenvolvido em resposta a disciplina 'Redes', a qual faz parte do curso de Pós Graduação em Tecnologia Java, ministrado pela Universidade Tecnológica Federal do Paraná.
🎉 Este exercício foi retirado da prova de avaliação do curso de REDES. Ao longo do curso, a média final é composta por variados exercícios (50% questionários + aplicações) + (nota da avaliação-prova 50%).

🥋 Se você está entrando no Java agora, vou deixar um comentário apenas para orientá-lo, caso considere o código deste exercício estranho. Este exercício, foi considerado pelo professor e os demais colegas como HARD + em função do tempo para elaboração, pois, trata-se de exercício da prova. (_😎tirei nota máxima_), contudo, o assunto aqui é REDES. Isso, por si só, não é nada convencional para desenvolvedores acostumados com devWeb. Caso se identifique, considere que REDES é uma potencialidade do Java explorada por poucos, más que pode perfeitamente unir forças com o desenvolvimento web. É perfeitamente possível que uma aplicação Java-Swing + Java-Spring, possua funcionalidades associadas as bibliotecas de REDE (lan - local area network), inclusive RMI para aumentar sua eficiência.

## Servidor de Redes

😵 Objetivo:

Neste ponto, vamos abordar o conceito de Java RMI (Remote Method Invocation) relacionado à programação de redes..

🧭 Conceito:
Java RMI (Remote Method Invocation) é uma tecnologia Java que permite a execução de métodos em objetos que residem em máquinas remotas, proporcionando assim a comunicação entre processos distribuídos em uma rede. Com o RMI, você pode invocar métodos de objetos remotos da mesma forma que invoca métodos locais.

- Interface Remota:
Define a interface que contém os métodos que podem ser chamados remotamente.
Deve estender a interface java.rmi.Remote e cada método deve lançar java.rmi.RemoteException.

- Implementação Remota:
Implementa a interface remota.
Herda da classe java.rmi.server.UnicastRemoteObject.

- Servidor RMI:
Registra uma instância do objeto remoto para torná-lo acessível para os clientes.
Usa a classe java.rmi.registry.Registry para registrar objetos remotos.

- Cliente RMI:
Obtém uma referência para o objeto remoto no registro.
Usa a referência para chamar métodos remotos.

### Passos Gerais para Usar RMI:
1. Defina a Interface Remota: Crie uma interface que estenda Remote e declare os métodos que podem ser chamados remotamente.
2. Implemente a Interface: Implemente a interface remota em uma classe que herde de UnicastRemoteObject.
3. Crie o Servidor: No servidor, crie uma instância da implementação remota, registre-a no registro RMI e aguarde por chamadas remotas.
4. Crie o Cliente: No cliente, obtenha uma referência para o objeto remoto do registro RMI e chame os métodos remotos normalmente.
5. Inicie o Registry: Certifique-se de iniciar o registro RMI (ou usar um já em execução) antes de executar o servidor e cliente.

## Enunciado da atividade
👉 Desenvolva uma aplicação em que um cliente, utilizando tecnologia Java RMI (Remote Method Invocation), possa executar uma calculadora com as quatro operações básicas, sendo que os cálculos sejam executados pelo Cliente de forma remota...

### 📽️ Click na imagem e assista ao vídeo de apresentação do Projeto..     

[![Assista ao Vídeo de Apresentação do Projeto](https://img.youtube.com/vi/nl5RILbI7jw/maxresdefault.jpg)](https://www.youtube.com/watch?v=nl5RILbI7jw)

# Tecnologia utilizada:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## Tabela de Conteúdos

- [Instalação](#Instalação)
- [Uso](#Uso)
- [Contribuição](#Contribuição)

## Instalação

1. Clone o repositório ou baixe o arquivo .zip:

```bash
git clone https://github.com/alfecjo/redes.git
```
## Uso

1. Execute em sua IDE de preferência. Contudo, o desenvolvimento foi feito no NetBeans, ideal JDK 11 ao 13! Você pode começar com: "mvn install", no diretório raiz, que é onde se    encontra o arquivo pom.xml. Desta forma, serão baixadas as dependências, caso seja necessário.
2. A idéia central aqui é que usando RMI, o Cliente forneça os dados de entrada para a operação matemática básica (+-/*) e o efetivo algoritmo do cálculo seja construído no Servidor.
3. Caso tenha o Java instalado, você precisa apenas executar os arquivos .class em máquinas distintas. Caso queira, também é possível, através da criação de dois projetos Java simples e em máquinas distintas dispor os devidos .java para máquina1 e máquina2. Observando que a Interface está associada ao Servidor.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, abra um problema ou envie uma solicitação pull ao repositório.

Ao contribuir para este projeto, siga o estilo de código existente, [convenções de commit](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em um branch separado.

Muito obrigado!!





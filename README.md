# ☕ Java Aplicado a Redes de Computadores..
![redes](redes.jpg)

## Este material foi desenvolvido em resposta a disciplina 'Redes', a qual faz parte do curso de Pós Graduação em Tecnologia Java, ministrado pela Universidade Tecnológica Federal do Paraná.
🎉 Os projetos estão distribuídos nos branch's e são exercícios solicitados ao longo do curso que juntos perfazem a nota que compõem a média final.

🥋 Se você está entrando no Java agora, vou deixar um comentário apenas para orientá-lo, caso considere o código deste exercício estranho. Este exercício, foi considerado pelo professor e os demais colegas como HARD. (_😎tirei nota máxima_), contudo, o assunto aqui é REDES. Isso, por si só, não é nada convencional para desenvolvedores acostumados com DevWeb. Caso se identifique, considere que REDES é uma potencialidade do Java explorada por poucos, más que pode perfeitamente unir forças com o desenvolvimento web. É perfeitamente possível que uma aplicação Java-Swing + Java-Spring, possua funcionalidades associadas as bibliotecas de REDE (lan - local area network), inclusive RMI para aumentar sua eficiência.

## Servidor de Redes

### 😵 Objetivo:

Neste ponto, vamos abordar o conceito de Java RMI (Remote Method Invocation) relacionado à programação de redes..

### 🧭 Conceito:
Java RMI (Remote Method Invocation) é uma tecnologia Java que permite a execução de métodos em objetos que residem em máquinas remotas, proporcionando assim a comunicação entre processos distribuídos em uma rede. Com o RMI, você pode invocar métodos de objetos remotos da mesma forma que invoca métodos locais.

✔️ Interface Remota:
    - Define a interface que contém os métodos que podem ser chamados remotamente.
    - Deve estender a interface java.rmi.Remote e cada método deve lançar java.rmi.RemoteException.

✔️ Implementação Remota:
    - Implementa a interface remota.
    - Herda da classe java.rmi.server.UnicastRemoteObject.

✔️ Servidor RMI:
    - Registra uma instância do objeto remoto para torná-lo acessível para os clientes.
    - Usa a classe java.rmi.registry.Registry para registrar objetos remotos.

✔️ Cliente RMI:
    - Obtém uma referência para o objeto remoto no registro.
    - Usa a referência para chamar métodos remotos.

### 👨‍💻 Passos Gerais para Usar RMI:
1. Defina a Interface Remota: Crie uma interface que estenda Remote e declare os métodos que podem ser chamados remotamente.
2. Implemente a Interface: Implemente a interface remota em uma classe que herde de UnicastRemoteObject.
3. Crie o Servidor: No servidor, crie uma instância da implementação remota, registre-a no registro RMI e aguarde por chamadas remotas.
4. Crie o Cliente: No cliente, obtenha uma referência para o objeto remoto do registro RMI e chame os métodos remotos normalmente.
5. Inicie o Registry: Certifique-se de iniciar o registro RMI (ou usar um já em execução) antes de executar o servidor e cliente.

## 👉 Enunciado da atividade
Desenvolva uma aplicação baseado na situação-problema: uma cidade está realizando uma eleição. Você é o desenvolvedor que projetará uma aplicação capaz de receber os votos de cada urna espalhada na cidade. Muita atenção neste trecho do enunciado. Estamos emulando uma eleição real. Tal como as urnas eletrônicas funcionam. Lembre-se que programas existem para solucionar situações da vida real, utilizando estudos de caso na vida real. 

Assim, pede-se:

- O servidor RMI deverá estar apto a realizar duas funções:
    - Contar todos os votos;
    - Receber votos (contendo os nomes dos candidatos e os números de votos);

- Cada urna (cliente RMI) deverá enviar os nomes e o número de votos de cada candidato para o servidor.  Esses nomes deverão ser entrados no console. Os números de votos também deverão ser entrados pelo console.

- O servidor deverá exibir a apuração de votos atualizada a cada 5 segundos....

  ### Alguns pontos importantes:
  - Sua aplicação deverá receber candidatos do mundo real (João, Maria, Vitor, etc.)
  - O usuário (o avaliador) deverá interagir com seu programa. O nome do candidato (ou o número do candidato) deverá ser entrado (lembre-se que na urna eletrônica real votamos por     números, mas aqui pode entrar também o nome). Os votos também.
  - Não pré-programe inserção automática de candidatos e votos, no código.
  - O usuário (o avaliador) deverá observar as atualizações no output do servidor que será atualizado a cada 5 segundos.
  - Não quebre padrões de programação. Exemplo: Se seus programas sempre possuem interface em português, não utilize outro idioma. Não faria o menor sentido corporativo, um programador   passar a exibir na sua interface, o idioma russo ou árabe, depois que apresentou 05 programas em português. Isso mesmo com um programa funcionando e atendendo os requisitos solicitados.  Quebrar padrões desfavorece o programador.
  - Evite que seu programa seja um robô que faça tudo automaticamente, com parâmetros passados automaticamente, imperceptíveis ao usuário. Lembre-se que este programa interage.

### 📽️ Click na imagem e assista ao vídeo de apresentação do Projeto..     

[![Assista ao Vídeo de Apresentação dos Testes](https://img.youtube.com/vi/Xm-1FmxwFXU/maxresdefault.jpg)](https://www.youtube.com/watch?v=Xm-1FmxwFXU)

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
2. A idéia central aqui é que usando RMI, o Cliente forneça os dados de entrada para a urna e o efetivo algoritmo do cálculo de contabilização dos votos seja construído no Servidor. Lembrando que o acesso será de várias máquinas simultâneas e que é considerado boa prática, ao encerrar as operações no Cliente com a contabilização total, desligar o servidor através do Cliente com envio do comando partindo do Cliente e interceptado/executado pelo Servidor...(por se tratar de boa prática, não está no enunciado, más é dever do programador incluir esta rotina na execução do código)
3. Caso tenha o Java instalado, você precisa apenas executar os arquivos .class em máquinas distintas. Caso queira, também é possível, através da criação de dois projetos Java simples e em máquinas distintas dispor os devidos .java para máquina1 e máquina2. Observando que a Interface está associada ao Servidor.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, abra um problema ou envie uma solicitação pull ao repositório.

Ao contribuir para este projeto, siga o estilo de código existente, [convenções de commit](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em um branch separado.

Muito obrigado!!





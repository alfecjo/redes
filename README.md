# Redes..

## Este material foi desenvolvido em resposta a disciplina 'Redes', a qual faz parte do curso de Pós Graduação em Tecnologia Java, ministrado pela Universidade Tecnológica Federal do Paraná.
🎉 Os projetos, são exercícios solicitados ao longo do curso que juntos perfazem a nota que compõem a média final.

## Enunciado da atividade
👉 A máquina cliente deverá solicitar:
- Digite um CPF para verificação:
- O usuário deverá entrar um número de CPF. + <Enter>

👉 A máquina que é o servidor receberá o CPF e verificará:
- Se o número é válido ou inválido.
- Se o CPF for válido, o servidor deverá retornar a mensagem “Este CPF é válido” para o cliente.
- Se o CPF for inválido, o servidor deverá retornar a mensagem “Este CPF é inválido.”

## Regras para construir o programa
- Faça apenas uma classe Servidor e uma classe Cliente. Não utilize nomes diferentes 
destas classes, para facilitar a correção. O cliente tratará de capturar a entrada do 
usuário, enviar o CPF; e, recuperar o CPF quando o servidor responder se o CPF é válido 
ou inválido. O servidor tratará de receber o CPF que vem do cliente, tratar os dados, 
conferindo se é um CPF genuíno ou não, e devolver o resultado

- Todo tratamento do CPF deverá ser feito no servidor. Não utilize nenhuma classe 
externa auxiliar. O programa precisa interagir com o usuário via entrada do teclado. O 
localhost, ou seja, o IP 127.0.0.1, deverá ser o IP entrado neste exercício e não o 
endereçamento de sua LAN (ex. 192.168.10.10). A porta fica por conta do aluno, desde 
que não seja pertencente às portas baixas ou portas reservadas.

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

1. Execute em sua IDE de preferência. Contudo, o desenvolvimento foi feito no VSCode! Você pode começar com: "mvn install", no diretório raiz, que é onde se encontra o
   arquivo pom.xml. Desta forma, serão baixadas as dependências, caso seja necessário.
2. A idéia central aqui é que usando SOCKET, você instale o Cliente em uma máquina, o Servidor em outra e através do wifi ou rede cabeada, de um PC você forneça o CPF
   (Cliente) e do outro (Servidor) é onde reside os métodos que validam o CPF e retornam se é válido ou não para o Cliente usando Socket...
3. Para executar crie duas estruturas idênticas em duas máquinas distintas. Ambas devem estar usando a mesma rede Wifi. Na primeira máquina elimine o arquivo Cliente.java.
   Na segunda máquina elimine o arquivo Servidor.java, desta forma você terá uma estrutura baixada do repositório, considerando a máquina1 apenas com Cliente.java e máquina2
   apenas com Servidor.java. Execute primeiro o Servidor.java na máquina2. Em seguida execute o Cliente na máquina1. Forneça o CPF e a máquina2 Servidor deve validá-lo.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, abra um problema ou envie uma solicitação pull ao repositório.

Ao contribuir para este projeto, siga o estilo de código existente, [convenções de commit](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em um branch separado.

Muito obrigado!!





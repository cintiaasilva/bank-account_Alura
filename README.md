<h1> Conta Bancária - Java: criando a sua primeira aplicação (Alura) </h1>

Este desafio tem o objetivo de controlar a conta bancária virtual.

* A proposta é iniciarmos os dados do cliente como um extrato:

(O objetivo era para ser com dados HARDCODE, mas realizei com dados dinâmicos por leitura do Scanner)

=========================

Nome: Jacqueline Oliveira

Tipo conta: Corrente

Saldo inicial: R$ 2500,00 (Deixei zerado a conta como saldo inicial)

=========================

_O objetivo desta primeira etapa é aprender a criar classe e método, a declarar de variáveis e a concatenar String._

------------------------
* E em seguida, teremos quatro opções de operações com a linha para inserir a opção desejada:
  nomearemos os métodos, como, por exemplo: recebeTransferencia(), fazTransferencia(),
  enviaPix() ou recebePix().

=========================

1- Consultar saldos

2- Receber valor

3- Transferir valor

4- Sair

=========================

<h3>REGRAS DE NEGÓCIO</h3>

*O menu de opções deverá aparecer até que a pessoa aperte a tecla para sair.*

Ao digitar a opção 1:

Será consultado o saldo e exibirá a consulta para o usuário.

==========================================

Ao digitar a opção 2:

Será exibido uma mensagem "Informe o valor a receber: "  , e será lido e armazenado o valor depositado que o usuário 
digitalizou, e atualizará o saldo e será exibido este novo saldo para o utilizador.

==========================================

Ao digitar a opção 3:

Será exibido uma mensagem "Informe o valor que deseja transferir: "  , e será lido e armazenado o valor de transferência 
que o usuário digitalizou, e atualizará o saldo e será exibido este novo saldo para o utilizador.

 _Se for tentar transferir um valor maior do que estiver no saldo, será exibido a mensagem
  "Não há saldo suficiente para fazer essa transferência. "_

==========================================

Ao digitar a opção 4: (Acréscimo da minha parte)

Será exibido o extrato do saldo que foi movimentado da conta.

==========================================

Ao digitar a opção 5:

Encerrará a aplicação

==========================================

Caso digite um número de opção inválida, será exibido a mensagem "Opção inválida!"


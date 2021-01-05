# Projeto da Unidade 2 - Sistema Bancária
A partir de novembro, o Banco Central determinou que todas as contas bancárias doBrasil possam fazer transferências usando PIX. Dessa forma, é preciso criar ummódulo onde os bancos possam manipular os dados dos clientes e do próprio BancoCentral. Esse módulo deve ter as seguintes funcionalidades:

- Fazer a manutenção do cadastro do banco e agência
  - Todo banco tem um código
  - Cada agência tem um código

- Fazer a manutenção do cadastro dos clientes
  - Cada cliente está associado a pelo menos uma agência do banco
  - Um cliente pode ter mais de uma conta
  - Cada conta tem um código

- Fazer a manutenção de contas e chaves PIX
  - Existem 3 tipos de conta: Conta corrente, poupança e conta-salário (nãorecebe depósitos, a não ser do empregador)
  
  - Cada conta pode ter no máximo 5 chaves PIX
  
  - As chaves PIX podem ser: e-mail, telefone ou um código gerado peloBanco Central, contendo 20 caracteres (entre letras e números)
  
  - Uma chave PIX é única para o sistema do Banco Central
  
  - No momento da transferência via PIX, os dados de quem for receber odinheiro devem aparecer na tela, com informações vindas do Banco Central

- Operações a serem realizadas
  - Exibir o montante em dinheiro aplicado no banco
  - Exibir o montante em dinheiro aplicado em uma determinada agência
  - Exibir o saldo de um cliente em uma agência
  - Fazer transferências entre clientes
  - Exibir   um   extrato   detalhado   de   um   cliente,   com   todas   as   operações realizadas e o saldo da conta por operação

- Requisitos de Java e Orientação a Objetos
  - No mínimo 3 classes herdadas
  - Usar bem Polimorfismo e Encapsulamento
  - No mínimo 2 interfaces
  - No mínimo 2 classes abstratas
  - Usar ambiente gráfico
  - Fazer teste de software usando JUnit em pelo menos 2 classes
  - Separar parte gráfica de regra de negócio
  - Separar os módulos em pacotes

- Requisitos Gerais
  - Grupo com no máximo 3 pessoas
  - Se optar por fazer individualmente, terá a pontuação reduzida em 20%
  - Todo o material guardado em um servidor git. Quero apenas o link doprojeto para a avaliação
  - A  qualidade   do   código   será   avaliada,   assim   como   as   boas   práticas   deprogramação e convenção de código Java

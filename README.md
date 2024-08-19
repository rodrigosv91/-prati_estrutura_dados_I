# Estrutura de Dados em Java
## 1. Pré-requisitos
Antes de começar, certifique-se de ter o seguinte instalado:
- Java Development Kit (JDK) 17: Siga as instruções abaixo para instalar e configurar o JDK 17.
### Instalando o Java 17
No Windows
1. Baixe o JDK 17:
   Acesse o site oficial da Oracle ou o AdoptOpenJDK e baixe a versão do JDK 17 compatível com o seu sistema.

2. Instale o JDK:
   Siga o assistente de instalação e escolha as opções padrão.

3. Configure o JAVA_HOME:
   Vá em Configurações do Sistema > Variáveis de Ambiente. Crie uma nova variável de sistema chamada JAVA_HOME apontando para o diretório onde o JDK foi instalado e adicione ao final da variável Path:
    ```bash
    ;%JAVA_HOME%\bin 
    ```
4. Verifique a instalação:
   Abra o terminal (cmd ou PowerShell) e digite:
    ```bash
    java -version
    ```
   A saída deve indicar que o Java 17 está instalado.

## 2. Como executar o projeto localmente
1. Clonar o repositório
   Primeiro, clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/rodrigosv91/-prati_estrutura_dados_I.git
    cd -prati_estrutura_dados_I
    ```
2. Navegar até o diretório do exercício

   Escolha o exercício que deseja executar e navegue até o diretório correspondente. Por exemplo, para o exercício sobre Fila de Processos:

    ```bash
    cd Exercicio_01/src
    ```
3. Compilar o código

   Compile o código Java utilizando o javac:
    ```bash
    for %f in (*.java) do javac %f
    ```
4. Executar o programa

   Após a compilação, execute o programa principal:
    ```bash
    java Main
    ```

5. Interaja com o menu:

   Adicione, execute e visualize os processos na fila conforme as opções disponíveis no menu.
# 🪙 Conversor de Moedas em Tempo Real (Java)

Este é um projeto para o desafio Alura, de um conversor de moedas desenvolvido em **Java**.  
A aplicação funciona via **console (terminal)** e permite ao usuário converter valores entre diferentes moedas de forma dinâmica.

As taxas de câmbio são obtidas **em tempo real** através do consumo da **API ExchangeRate-API**, garantindo que os valores de conversão sejam sempre atualizados.

---

## ✨ Funcionalidades
- **Conversão em Tempo Real:** Utiliza uma API externa para buscar as taxas de câmbio mais recentes.  
- **Interface Interativa:** O usuário informa a moeda de origem, a moeda de destino e o valor a ser convertido diretamente no console.  
- **Flexibilidade:** Permite a conversão entre quaisquer moedas suportadas pela API (ex: `USD`, `BRL`, `EUR`, `JPY`, `ARS`, etc.).  
- **Fácil de Usar:** Execução direta pela linha de comando sem necessidade de um menu fixo de opções.  

---

## 🛠️ Pré-requisitos
Para compilar e executar este projeto, você precisará de:
- **Java Development Kit (JDK):** Versão 8 ou superior.  
- **IDE (Opcional, mas recomendado):** IntelliJ IDEA, Eclipse ou VS Code.  
- **Biblioteca Gson:** Para processar a resposta JSON da API.  

---

## ⚙️ Instalação e Configuração

### **Passo 1: Obter o Código-Fonte**
Salve o código Java fornecido em um arquivo chamado **`ConversorMoedas.java`**.

---

### **Passo 2: Adicionar a Biblioteca Gson**
Este projeto depende da biblioteca **Gson** do Google.  
Você pode adicioná-la manualmente ao seu projeto no IntelliJ IDEA da seguinte forma:

1. Baixe o arquivo `.jar` do Gson a partir do Maven Repository:  
   📥 [Download Gson 2.10.1](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar)  
2. No IntelliJ IDEA:  
   - Vá em **`File > Project Structure`**  
   - No menu à esquerda, selecione **Modules**  
   - Clique na aba **Dependencies**  
   - Clique no ícone **`+`** e selecione **`JARs or directories...`**  
   - Localize o arquivo `gson-2.10.1.jar` baixado e selecione-o  
   - Clique em **OK** para confirmar  

---

### **Passo 3: Chave da API**
A chave da API já está configurada no código-fonte na constante:
```java
private static final String API_KEY = "INSIRA SUA CHAVE DA API AQUI";

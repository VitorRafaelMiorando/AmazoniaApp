# Raízes Da Amazônia App 🌳

Um aplicativo Android para catalogar e explorar árvores da região amazônica. 

## 📋 Funcionalidades

- **Pesquisar árvores**: Utilize a barra de pesquisa para encontrar árvores específicas.
- **Visualizar detalhes botânicos**: Informações detalhadas sobre cada árvore.
- **Atualização de dados**: Atualize os dados da API externa.
- **Suporte offline**: Funciona mesmo sem conexão com a internet, utilizando banco de dados local.
- **Mapas**: Exibição de mapas utilizando o Mapbox.

## 🛠️ Tecnologias utilizadas

- **Linguagem**: Java
- **API REST**: Para buscar os dados das árvores.
- **SQLite**: Banco de dados local para armazenamento offline.
- **Android Framework**: Para desenvolvimento mobile.

## 📝 Pré-requisitos
1. **Ambiente de Desenvolvimento Android**:
   - Android Studio instalado (versão recomendada: 2022.3.1 ou superior).
   - JDK 11 ou superior configurado.

2. **Dependências**:
   - Certifique-se de instalar todas as dependências mencionadas no arquivo `build.gradle`.

3. **Configuração da API**:
   - Este aplicativo utiliza uma API externa para buscar dados das árvores. 
   - **Importante**: Você precisará configurar o URL da sua API no código-fonte.
   - No arquivo `MainActivity.java`, localize o seguinte trecho de código e substitua pelo seu próprio endpoint da API:
     ```java
     String urlBase = "http://sua/API/gellAllArvores";  // Substitua com o URL da sua API
     ```
   - O endpoint deve retornar uma lista de árvores no formato JSON. O exemplo abaixo mostra a estrutura esperada:
     ```json
     {
       "response": [
         {
           "arvoreID": "id_123",
           "nome": "Arvore X",
           "descricaoBotanica": "Descrição completa da árvore...",
           // outros dados da árvore
         }
       ]
     }
     ```

4. **Configuração do Mapbox**:
   Este aplicativo utiliza o Mapbox para funcionalidades de mapa. Siga estas etapas para configurar o token:
   - Crie uma conta no [Mapbox](https://www.mapbox.com).
   - Obtenha o token de acesso no **Dashboard** do Mapbox.
   - Substitua o valor `"seu Mapbox token"` no arquivo `DetalhesActivity.java`:
     ```java
     String token = "seu Mapbox token";
     ```
   - **Nota**: Evite expor o token em repositórios públicos. Se possível, utilize variáveis de ambiente para maior segurança.

## 🚀 Como usar

1. Faça o download do APK ou clone o repositório.
2. Abra o projeto no Android Studio.
3. Sincronize as dependências do Gradle.
4. Configure o URL da API e o token do Mapbox conforme descrito acima.
5. Conecte um dispositivo Android ou utilize um emulador.
6. Compile e execute o aplicativo.

## Estrutura do Projeto

- **MainActivity.java**:
  Gerencia a exibição da lista de árvores e integração com a API.
  
- **DetalhesActivity.java**:
  Exibe detalhes individuais da árvore, incluindo localização no mapa.

- **ArvoreAdapter.java**:
  Adaptador para exibição de itens no RecyclerView.

- **ArvoreDatabaseHelper.java**:
  Gerencia o banco de dados SQLite local.

## 📦 Requisitos para Desenvolvimento

- **Android Studio**: Para compilar e executar o projeto.
- **SDK Android**: Versão mínima 21 (Lollipop).
- **Conexão com a API**: Certifique-se de que o endpoint da API esteja ativo.

## 📜 Licença

Este projeto está licenciado sob uma licença personalizada. Você pode usar, modificar e compartilhar o código, **mas não para fins comerciais**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

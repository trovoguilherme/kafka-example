# Exemplo de Projeto com Spring Cloud Stream

Este projeto é um exemplo de estudo que utiliza Spring Cloud Stream para integração com Kafka. O projeto é composto por três módulos principais e um arquivo `docker-compose` para gerenciar os containers necessários. Abaixo estão descritos os módulos e como configurar o ambiente.

## Estrutura do Projeto

### Módulos

1. **skeleton-producer-api**
    - **Descrição**: Este módulo é responsável por produzir mensagens para tópicos no Kafka. Utiliza Avro para serialização das mensagens.
    - **Responsabilidades**:
        - Produzir mensagens para tópicos Kafka.
        - Serializar dados utilizando Avro.

2. **skeleton-producer-async**
    - **Descrição**: Este módulo consome as mensagens produzidas pelo módulo `skeleton-producer-api`.
    - **Responsabilidades**:
        - Consumir mensagens dos tópicos Kafka.
        - Processar as mensagens consumidas.

3. **skeleton-core**
    - **Descrição**: Módulo comum utilizado para compartilhar classes e recursos entre os módulos `skeleton-producer-api` e `skeleton-producer-async`.
    - **Responsabilidades**:
        - Fornecer classes utilitárias e compartilhadas.
        - Manter o código reutilizável e organizado.

### Docker Compose

O arquivo `docker-compose.yml` está localizado na pasta `docker`. Este arquivo é utilizado para subir os containers necessários para o projeto.

#### Para iniciar os containers:

1. Navegue até o diretório `docker`:
   ```bash
   cd docker

2. Execute o comando Docker Compose para subir os containers:
   ```bash
   docker-compose up -d
   
Isso iniciará os containers necessários para o funcionamento do projeto, incluindo o Kafka e o Schema Registry.

## Configuração do Projeto

Certifique-se de que os seguintes serviços estão funcionando antes de iniciar o projeto:

- **Kafka**: Servidor de mensagens que armazena e distribui as mensagens produzidas.
- **Schema Registry**: Serviço para gerenciar e validar esquemas Avro.
- **Zookeeper**: Serviço que coordena e gerencia os brokers Kafka.

### Instruções de Uso

#### Para produzir mensagens

1. Inicie o módulo `skeleton-producer-api`. Ele começará a produzir mensagens para os tópicos Kafka definidos.

#### Para consumir mensagens

1. Inicie o módulo `skeleton-producer-async`. Ele começará a consumir as mensagens produzidas e processá-las conforme a lógica definida.

#### Para compartilhar classes

1. Utilize o módulo `skeleton-core` para acessar classes comuns entre `skeleton-producer-api` e `skeleton-producer-async`.

### Dependências

Este projeto utiliza as seguintes dependências:

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Cloud Stream**: Framework para integração com sistemas de mensagens como Kafka.
- **Kafka**: Servidor de mensagens que armazena e distribui mensagens.
- **Zookeeper**: Serviço de coordenação para Kafka.
- **Avro**: Framework para serialização de dados.

Certifique-se de que todas as dependências estão corretamente configuradas nos arquivos de build do Gradle.

### Contribuindo

Se você deseja contribuir para este projeto, por favor, faça um fork do repositório, faça suas alterações e envie um pull request com suas contribuições.

### Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

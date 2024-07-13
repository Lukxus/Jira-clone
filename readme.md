## Fluxo de Autenticação e Autorização no Spring Security

### Visão Geral

O Spring Security é um framework poderoso e altamente customizável para autenticação e controle de acesso em aplicações Spring. Este projeto utiliza JWT (JSON Web Tokens) para autenticação e autorização. A seguir, descrevemos o fluxo de uma requisição dentro do Spring Security e as classes envolvidas em cada fase.

### Fluxo da Requisição

1. **Requisição HTTP**
    - O cliente (navegador, aplicativo móvel, etc.) faz uma requisição HTTP a um endpoint protegido da aplicação.

2. **Filtros de Segurança**
    - A requisição passa pela cadeia de filtros configurada pelo Spring Security. O filtro principal neste projeto é o `JwtRequestFilter`.

3. **JwtRequestFilter**
    - **Classe**: `JwtRequestFilter`
    - **Função**: Verifica o cabeçalho "Authorization" para um token JWT.
        - Se o cabeçalho estiver presente e começar com "Bearer ", o token JWT é extraído e validado.
        - O nome de usuário é extraído do token JWT e os detalhes do usuário são carregados usando `UserDetailsServiceImpl`.
        - Um `UsernamePasswordAuthenticationToken` é criado e definido no contexto de segurança do Spring (`SecurityContextHolder`).

4. **Autorização**
    - **Classe**: `SecurityConfig`
    - **Função**: Configura as permissões de acesso aos endpoints.
        - Verifica se o usuário tem as permissões necessárias para acessar o endpoint solicitado.

5. **Controle do Endpoint**
    - Se o usuário estiver autenticado e autorizado, a requisição é encaminhada para o controlador correspondente.

6. **Controller**
    - **Classe**: `UsuarioController`, entre outros.
    - **Função**: Processa a requisição, executa a lógica de negócios e interage com os serviços e repositórios conforme necessário.
    - O controlador retorna uma resposta HTTP (`ResponseEntity`).

7. **Resposta HTTP**
    - A resposta é enviada de volta ao cliente, passando por qualquer filtro de saída necessário.

### Classes Envolvidas

- **JwtRequestFilter**: Filtra as requisições, extrai e valida o token JWT, carrega os detalhes do usuário e configura o contexto de segurança.
- **SecurityConfig**: Configura a segurança da aplicação, definindo quais endpoints requerem autenticação e quais são públicos.
- **UserDetailsServiceImpl**: Carrega os detalhes do usuário a partir do banco de dados com base no nome de usuário.
- **UsuarioController**: Controlador que lida com endpoints relacionados a usuários, incluindo registro e autenticação.
- **UsuarioService**: Serviço que contém a lógica de negócios para manipulação de dados de usuários.
- **JwtUtil**: Classe utilitária para operações com JWT, como extração de informações e validação de tokens.

### Endpoints Públicos

- `/api/v1/usuarios`: Endpoint público para registro de novos usuários.
- `/api/v1/login`: Endpoint público para login de usuários.

### Conclusão

Este fluxo garante que apenas usuários autenticados e autorizados possam acessar os recursos protegidos da aplicação, mantendo a segurança dos dados e da aplicação. Endpoints públicos, como registro e login, são configurados para serem acessíveis sem autenticação.

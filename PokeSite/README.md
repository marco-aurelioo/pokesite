# PokeSite examplo

## Lista de tarefas:
- [x] setup inicial com docker.
- [x] Estrutura de projeto fontend Bootstrap + Thymeleaf 
- [x] Base de dados JPA e Flyway
- [x] Layout pagina principal.
- [ ] Layout pagina detalhe.
- [ ] Processo de CI
- [ ] Proximas ideias ...

### Tecnologias:
Kotlin
Thymeleaf
JPA

Comandos para zerar o banco de dados.

** depois de integrar com o CI nao sera possivel rodar drop na base de dados. **
``` roomsql
drop table pokemon_type;
drop table pokemon_pokemon_type;
drop table pokemon;
drop table pokemon_imgs;
truncate flyway_schema_history;
```


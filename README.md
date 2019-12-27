book-api 
======

CRUD de livros utilizando Spring Framework.

## Tecnologias
- [Java](https://docs.oracle.com/en/java/javase/11)
- [Spring Framework](https://spring.io/projects/spring-framework)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#spring-web)
- [Mongo](https://docs.mongodb.com)


## Executando aplicação com Docker
```
$ git clone git@github.com:hiroinamine/book-api.git
$ cd book-api
$ docker-compose build
$ docker-compose up
```
A API estará disponível no endereço `http://localhost:8080/api/`.

## Documentação da API

#### Consulta de livros

- **URL**
    `GET /api/books`

- **Parâmetros via query**

  | Atributo | Tipo do dado | Descrição                                | Obrigatório | Valor padrão | Exemplo     |
  | -------- | ------------ | ---------------------------------------- | ----------- | ------------ | ----------- |
  | size     | numérico     | Quantidade de registros por página       | não         | 5            | 10          |
  | page     | numérico     | Índice da página                         | não         | 0            | 2           |
  | sortBy   | texto        | Ordena consulta pelo campo               | não         | null         | year        |

- **Retorno**
```json
{
    "content": [
        {
            "id": "5e061c453ea2635dc73de561",
            "name": "O pequeno príncipe",
            "publisher": "Google Books",
            "category": "ficção",
            "year": 1943
        },
        {
            "id": "5e061df53ea2635dc73de562",
            "name": "2001: Uma odisséia no espaço",
            "publisher": "Aleph",
            "category": "ficção",
            "year": 2013
        },
        {
            "id": "5e061e753ea2635dc73de564",
            "name": "Pai rico, pai pobre",
            "publisher": "Alta Books",
            "category": "finanças",
            "year": 2017
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 3,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 2,
    "totalElements": 4,
    "last": false,
    "first": true,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "number": 0,
    "numberOfElements": 3,
    "size": 3,
    "empty": false
}
```

-----

#### Insere um novo livro

- **URL**
    `POST /api/books`

- **Corpo**
```json
{
    "name": "O pequeno principe",
    "category": "ficção",
    "publisher": "Cia das Letras",
    "year": 2009
}
```

- **Retorno**
```json
{
    "id": "5e061c453ea2635dc73de561",
    "name": "O pequeno principe",
    "category": "ficção",
    "publisher": "Cia das Letras",
    "year": 2009
}
```

-----

#### Consulta de um livro pelo seu identificador

- **URL**
    `GET /api/books/{id}`

- **Retorno**
```json
{
    "id": "5e061c453ea2635dc73de561",
    "name": "O pequeno principe",
    "category": "ficção",
    "publisher": "Cia das Letras",
    "year": 2009
}
```

-----

#### Atualiza um livro pelo seu identificador

- **URL**
    `PUT /api/books/{id}`

- **Corpo**
```json
{
    "name": "O pequeno príncipe",
    "category": "ficção",
    "publisher": "Google Books",
    "year": 1943
}
```

- **Retorno**
```json
{
    "id": "5e061c453ea2635dc73de561",
    "name": "O pequeno príncipe",
    "publisher": "Google Books",
    "category": "ficção",
    "year": 1943
}
```

-----

#### Remove um livro pelo seu identificador

- **URL**
    `DELETE /api/books/{id}`

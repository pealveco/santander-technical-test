# Demo - Technical Test

Este repo es una API sencilla de tarjetas hecha con Spring Boot.
La idea es manejar cosas básicas como emitir, activar, bloquear y consultar tarjetas.

## Stack

- Java 17
- Spring Boot 4.0.3
- Spring Data JPA / Data REST
- PostgreSQL

## Qué necesitas

- JDK 17
- Docker (opcional, pero recomendado para levantar la BD rápido)

## Levantar la base de datos (igual para todos)

```bash
docker run -d \
--name interview \
-e POSTGRES_DB=testdb \
-e POSTGRES_USER=test \
-e POSTGRES_PASSWORD=test \
-p 5432:5432 \
postgres:16
```

## Correr el proyecto

```bash
./mvnw spring-boot:run
```

## Correr tests

```bash
./mvnw test
```

## Endpoints pensados

- `POST /cards`
- `POST /cards/{cardId}/activate`
- `POST /cards/{cardId}/block`
- `GET /cards/{cardId}`

## Nota importante

El proyecto todavía está en construcción, así que si lo bajas tal cual:

- `CardController` está con endpoints comentados.
- `CardRepository` está mal tipado (usa `Product` en vez de `Card`).
- `CardService` tiene un error con `saveAllAndFlush`.
- `application.yaml` tiene varios typos en la config de datasource.

## Estructura rápida

- `controllers/`: endpoints HTTP
- `service/`: lógica de negocio
- `domain/entity/`: entidades JPA
- `repository/`: acceso a datos
- `controllers/request` y `controllers/response`: DTOs

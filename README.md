# newsPhoenix

## Description
Hello, it's simple news app with auth and docker.

I created this project for the test task.

## Implemented

- List of news, getById
- news creation
- authorization with jwt
- email validation
- make app in docker-compose


## Prerequisites

- java 17 or later 
- docker/postgres

## Execution

### docker
```
docker-compose up -d
```

### locally

- In IntelijIDEA go Run>Edit configurations> modify options>enable Environmental variables

- In environmental variables put:
```
DB_NAME=news;DB_USER=postgres;DB_PASSWORD=postgres;DB_HOST=localhost;DB_PORT=5432
```

- Don't forget to create corresponding database in postgres
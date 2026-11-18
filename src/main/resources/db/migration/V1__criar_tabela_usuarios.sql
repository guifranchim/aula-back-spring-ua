CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO usuarios (login, senha, role)
VALUES ('admin', '$2a$12$mHPZlv29aKE9WxUzQ/dWYO2bx6Uv3hdOjPllnAiPidUubSq1OuJZu', 'ADMIN');

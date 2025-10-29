CREATE TABLE company (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    cnpj VARCHAR UNIQUE NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    description TEXT,
    country VARCHAR,
    cep VARCHAR,
    password VARCHAR NOT NULL,
    createAt DATE,
    updateAt DATE
);

CREATE TABLE candidate (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    surname VARCHAR,
    date_of_birth DATE,
    email VARCHAR UNIQUE NOT NULL,
    cpf VARCHAR UNIQUE NOT NULL,
    country VARCHAR,
    cep VARCHAR,
    description TEXT,
    password VARCHAR NOT NULL,
    createAt DATE,
    updateAt DATE
);

CREATE TABLE competence (
    id SERIAL PRIMARY KEY,
    skill VARCHAR NOT NULL,
    createAt DATE,
    updateAt DATE
);

CREATE TABLE vacancy (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    description TEXT,
    state VARCHAR,
    city VARCHAR,
    id_company INT NOT NULL,
    createAt DATE,
    updateAt DATE,
    CONSTRAINT fk_vacancy_company FOREIGN KEY (id_company) REFERENCES company (id)
);


CREATE TABLE candidate_competence (
    id SERIAL PRIMARY KEY,
    id_candidate INT NOT NULL,
    id_competence INT NOT NULL,
    createAt DATE,
    updateAt DATE,
    CONSTRAINT fk_candidate_competence_candidate FOREIGN KEY (id_candidate) REFERENCES candidate (id),
    CONSTRAINT fk_candidate_competence_competence FOREIGN KEY (id_competence) REFERENCES competence (id)
);

CREATE TABLE vacancy_competence (
    id SERIAL PRIMARY KEY,
    id_vacancy INT NOT NULL,
    id_competence INT NOT NULL,
    createAt DATE,
    updateAt DATE,
    CONSTRAINT fk_vacancy_competence_vacancy FOREIGN KEY (id_vacancy) REFERENCES vacancy (id),
    CONSTRAINT fk_vacancy_competence_competence FOREIGN KEY (id_competence) REFERENCES competence (id)
);

INSERT INTO company (name, cnpj, email, description, country, cep, password) VALUES
('Amazon', '12345678000101', 'info@amazon.com', 'Empresa Amazon', 'Brasil', '01001-000', '123456'),
('Oracle', '98765432000155', 'info@oracle.com', 'Empresa Oracle', 'Brasil', '20000-000', '123456'),
('Apple', '11223344000199', 'info@apple.com', 'Empresa Apple', 'Brasil', '30100-100', '123456'),
('ZG Soluções', '22334455000166', 'info@zgsolucoes.com', 'Empresa ZG Soluções', 'Brasil', '40000-200', '123456'),
('Microsoft', '33445566000177', 'info@microsoft.com', 'Empresa Microsoft', 'Brasil', '50000-300', '123456');

INSERT INTO vacancy (name, description, state, city, id_company) VALUES
('Desenvolvedor Java Pleno', 'Trabalhar com Spring Boot ', 'SP', 'São Paulo', 3),
('Analista de Dados SQL', 'Gerenciar banco de ', 'RJ', 'Rio de Janeiro', 2),
('Administrador de Sistemas Linux', 'Gerenciar servidores', 'MG', 'Belo Horizonte', 1);

INSERT INTO candidate (name, surname, date_of_birth, email, cpf, country, cep, description, password) VALUES
('Lucas', 'Silva', '1995-06-10', 'lucas@email.com', '12345678901', 'Brasil', '01001-000', 'Desenvolvedor backend', '123456'),
('Mariana', 'Souza', '1998-11-25', 'mariana@email.com', '98765432100', 'Brasil', '20000-000', 'Analista de dados ', '123456'),
('Pedro', 'Oliveira', '1993-03-14', 'pedro@email.com', '55566677788', 'Brasil', '30100-100', 'Administrador', '123456'),
('Ana', 'Costa', '2000-09-01', 'ana@email.com', '99988877766', 'Brasil', '40000-200', 'Desenvolvedora fullstack', '123456'),
('João', 'Pereira', '1997-01-20', 'joao@email.com', '11122233344', 'Brasil', '50000-300', 'Engenheiro de software ', '123456');

INSERT INTO competence (skill) VALUES
('Java'),
('SQL'),
('Linux'),
('Node.js'),
('C++');

INSERT INTO candidate_competence (id_candidate, id_competence) VALUES 
(1, 1), 
(1, 2),
(2, 2), 
(2, 3),
(3, 3),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(5, 1),
(5, 3),
(5, 5);

INSERT INTO vacancy_competence (id_vacancy, id_competence) VALUES
(1, 1), 
(2, 2), 
(3, 3);


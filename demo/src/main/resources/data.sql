-- Inserindo os Autores
INSERT INTO autor (nome, nacionalidade) VALUES ('Machado de Assis', 'Brasileira');
INSERT INTO autor (nome, nacionalidade) VALUES ('J.R.R. Tolkien', 'Britânica');
INSERT INTO autor (nome, nacionalidade) VALUES ('George Orwell', 'Britânica');

-- Inserindo os Livros vinculados aos Autores
INSERT INTO livro (titulo, isbn, ano_publicacao, autor_id)
VALUES ('Dom Casmurro', '978-85-08-15361-9', 1899, 1);

INSERT INTO livro (titulo, isbn, ano_publicacao, autor_id)
VALUES ('Memórias Póstumas de Brás Cubas', '978-85-08-15362-6', 1881, 1);

INSERT INTO livro (titulo, isbn, ano_publicacao, autor_id)
VALUES ('O Senhor dos Anéis: A Sociedade do Anel', '978-85-336-1337-9', 1954, 2);

INSERT INTO livro (titulo, isbn, ano_publicacao, autor_id)
VALUES ('O Hobbit', '978-85-336-1554-0', 1937, 2);

INSERT INTO livro (titulo, isbn, ano_publicacao, autor_id)
VALUES ('1984', '978-85-359-1484-9', 1949, 3);
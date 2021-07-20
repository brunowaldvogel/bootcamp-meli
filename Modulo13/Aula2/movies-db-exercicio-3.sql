/*
    Este arquivo conterá as respostas para os enunciados do Exercício Individual SQL 3 - Movies DB

    EXERCÍCIOS

    1) Explique o conceito de normalização e para que é usado.
    2) Adicione um filme à tabela de filmes.
    3) Adicione um gênero à tabela de gêneros.
    4) Associe o filme do Ex 2. ao gênero criado no Ex. 3.
    5) Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
    6) Crie uma cópia temporária da tabela de filmes.
    7) Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
    8) Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
    9) Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
    10) Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.
    11) O que são os índices? Para que servem?
    12) Crie um índice sobre o nome na tabela de filmes.
    13) Verifique se o índice foi criado corretamente.

    RESPOSTAS

    1) O conceito de normalização é um conjunto de regras aplicadas ao design de banco de dados que reduz a 
    redundância e elimina anomalias de inserção, atualização e remoção de registros. A aplicação do conceito
    envolve utilizar as Formas Normais de 1 a 6 e também a Forma Normal de Boyce-Codd (BCNF).
*/

-- 2)
INSERT INTO movies(created_at, updated_at, title, rating, awards, release_date, length, genre_id) 
VALUES (
    NULL,
    NULL,
    "Spider-Man: Into the Spider-Verse",
    10.0,
    2,
    '2019-01-10 00:00:00',
    120,
    7
);

-- 3)
INSERT INTO genres(created_at, updated_at, name, ranking, active) 
VALUES(
    '2000-01-12 00:00:00',
    NULL,
    "Espacial",
    13,
    1
);

-- 4)
UPDATE movies 
SET movies.genre_id = 
    (SELECT genres.id FROM genres WHERE genres.name = "Espacial") 
WHERE movies.id = 22;

-- 5)
UPDATE actors
SET actors.favorite_movie_id = 
    (SELECT movies.id FROM movies WHERE movies.title = "Spider-Man: Into the Spider-Verse")
WHERE actors.id = 4;

-- 6)
CREATE TEMPORARY TABLE IF NOT EXISTS temp_movies SELECT * FROM movies;

-- 7)
DELETE FROM temp_movies 
WHERE id IN 
	(SELECT movies.id FROM movies WHERE movies.awards < 5);

-- 8)
SELECT genres.name, COUNT(movies.title) as NumberOfMovies FROM genres
INNER JOIN movies on genres.id = movies.genre_id
GROUP BY genres.name
HAVING NumberOfMovies > 0;

-- 9)
SELECT
	CONCAT(actors.first_name, ' ', actors.last_name) AS FullName,
    movies.title,
    movies.awards
FROM actors
INNER JOIN movies ON movies.id = actors.favorite_movie_id
WHERE movies.awards > 3;

-- 10)
EXPLAIN SELECT * FROM temp_movies;
EXPLAIN DELETE FROM temp_movies 
WHERE id IN 
	(SELECT movies.id FROM movies WHERE movies.awards < 5);

-- 11)
/*
    Indexes são uma técnica de melhoria de performance de consultas de SQL.
    Indexes servem para acelerar consultas em uma tabela com base no conteúdo de uma ou mais colunas.
*/

-- 12
CREATE INDEX index_movies_name ON movies(title);

-- 13
SELECT DISTINCT TABLE_NAME, INDEX_NAME
FROM INFORMATION_SCHEMA.STATISTICS
WHERE TABLE_SCHEMA = 'movies_db'
AND INDEX_NAME = 'index_movies_name';



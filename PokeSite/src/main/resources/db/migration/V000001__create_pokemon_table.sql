CREATE TABLE pokemon(
    id SERIAL PRIMARY KEY ,
    external_id INTEGER,
    pokemon_name VARCHAR(100),
    pokemon_img VARCHAR(200),
    weight INTEGER,
    height INTEGER,
    hp INTEGER,
    attack INTEGER,
    defense INTEGER,
    special_attack INTEGER,
    special_defense INTEGER,
    speed INTEGER);
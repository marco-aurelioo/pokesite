CREATE TABLE pokemon_moves (
    id SERIAL PRIMARY KEY ,
    external_id INTEGER,
    move_name VARCHAR(100),
    hp INTEGER,
    attack INTEGER,
    defense INTEGER,
    special_attack INTEGER,
    special_defense INTEGER,
    speed INTEGER )
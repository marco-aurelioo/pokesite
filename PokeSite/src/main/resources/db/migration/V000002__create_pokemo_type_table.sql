CREATE TABLE pokemon_type(
   id INTEGER PRIMARY KEY ,
   type_name varchar(100)
);

CREATE TABLE pokemon_pokemon_type(
    id SERIAL PRIMARY KEY ,
    pokemon_id INTEGER,
    pokemon_type_id INTEGER,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (pokemon_type_id) REFERENCES pokemon_type(id)
);

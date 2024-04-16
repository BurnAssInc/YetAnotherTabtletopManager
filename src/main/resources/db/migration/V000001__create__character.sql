CREATE TABLE characters (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            player_name VARCHAR(255) NOT NULL,
                            race VARCHAR(255) NOT NULL,
                            class VARCHAR(255) NOT NULL,
                            lvl INTEGER NOT NULL,
                            hp INTEGER NOT NULL,
                            feats TEXT
);
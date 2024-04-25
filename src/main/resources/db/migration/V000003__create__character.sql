CREATE TABLE feat (
                            id SERIAL PRIMARY KEY,
                            feat_name VARCHAR(255) NOT NULL,
                            feat_description text NOT NULL
);
CREATE TABLE skill (
                            id SERIAL PRIMARY KEY,
                            skill_name VARCHAR(255) NOT NULL,
                            skill_description text NOT NULL
);
CREATE TABLE item (
                            id SERIAL PRIMARY KEY,
                            item_name VARCHAR(255) NOT NULL,
                            item_description text NOT NULL,
                            item_price INTEGER NOT NULL
);
CREATE TABLE deity (
                            id SERIAL PRIMARY KEY,
                            deity_name VARCHAR(255) NOT NULL

);
CREATE TABLE race (
                            id SERIAL PRIMARY KEY,
                            race_name VARCHAR(255) NOT NULL

);
CREATE TABLE player (
                            id SERIAL PRIMARY KEY,
                            player_name VARCHAR(255) NOT NULL,
                            campaign_id INTEGER NOT NULL,
--                            FOREIGN KEY(campaign_id) REFERENCES campaign(id),
                            character_id INTEGER Not NULL
--                            FOREIGN KEY(character_id) REFERENCES dnd_character(id)


);
CREATE TABLE campaign (
                            id SERIAL PRIMARY KEY,
                            campaign_name VARCHAR(255) NOT NULL,
                            player_id int,
                            FOREIGN KEY(player_id) REFERENCES player(id),
                            character_id INTEGER NOT NULL
--                            FOREIGN KEY(character_id) REFERENCES dnd_character(id)

);

CREATE TABLE dnd_character (
                            id SERIAL PRIMARY KEY,
                            character_name VARCHAR(255) NOT NULL,
                            strength INTEGER NOT NULL,
                            dexterity INTEGER NOT NULL,
                            constitution INTEGER NOT NULL,
                            intelligence INTEGER NOT NULL,
                            wisdom INTEGER NOT NULL,
                            charisma INTEGER NOT NULL,
                            character_hp INTEGER NOT NULL,
                            character_ac INTEGER NOT NULL,
                            character_speed INTEGER NOT NULL,
                            character_base_attack_bonus INTEGER NOT NULL,
                            player_id INTEGER,
--          TODO 001: При создании МТМ не следует использовать сохранять id  в таблице сущности.
--          Так как подобный вариант позволяет записывть только один экземпляр id (а не лист, как предпологается в моделе данных).
                            FOREIGN KEY (player_id) REFERENCES player(id),
                            campaign_id INTEGER,
                            FOREIGN KEY (campaign_id) REFERENCES campaign(id),
                            feat_id INTEGER,
                            FOREIGN KEY (feat_id) REFERENCES feat(id),
                            skill_id INTEGER,
                            FOREIGN KEY (skill_id) REFERENCES skill(id),
                            item_id INTEGER,
                            FOREIGN KEY(item_id) REFERENCES item(id),
                            race_id INTEGER,
                            FOREIGN KEY(race_id) REFERENCES race(id),
                            deity_id INTEGER,
                            FOREIGN KEY(deity_id) REFERENCES deity(id),
                            other text
);
--          TODO 002: Необходимо создать линковую таблицу и добавить констренты
ALTER TABLE player
    ADD FOREIGN KEY(campaign_id) REFERENCES campaign(id),
    ADD FOREIGN KEY(character_id) REFERENCES dnd_character(id);

ALTER TABLE campaign
    ADD FOREIGN KEY(character_id) REFERENCES dnd_character(id);


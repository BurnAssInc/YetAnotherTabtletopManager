CREATE TABLE feat (
                            id UUID PRIMARY KEY,
                            feat_name VARCHAR(255) NOT NULL,
                            feat_description text NOT NULL,
                            dnd_character_id UUID
);
CREATE TABLE skill (
                            id UUID PRIMARY KEY,
                            skill_name VARCHAR(255) NOT NULL,
                            skill_description text NOT NULL,
                            dnd_character_id UUID
);
CREATE TABLE item (
                            id UUID PRIMARY KEY,
                            item_name VARCHAR(255) NOT NULL,
                            item_description text NOT NULL,
                            item_price INTEGER NOT NULL,
                            dnd_character_id UUID
);
CREATE TABLE deity (
                            id UUID PRIMARY KEY,
                            deity_name VARCHAR(255) NOT NULL,
                            dnd_character_id UUID

);
CREATE TABLE race (
                            id UUID PRIMARY KEY,
                            race_name VARCHAR(255) NOT NULL,
                            dnd_character_id UUID

);
CREATE TABLE player (
                            id UUID PRIMARY KEY,
                            player_name VARCHAR(255) NOT NULL,
                            campaign_id UUID NOT NULL,
                            dnd_character_id UUID Not NULL

);
CREATE TABLE campaign (
                            id UUID PRIMARY KEY,
                            campaign_name VARCHAR(255) NOT NULL,
                            player_id UUID,
                            dnd_character_id UUID NOT NULL

);

CREATE TABLE dnd_character (
                            id UUID PRIMARY KEY,
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
                            player_id UUID,
                            campaign_id UUID,
                            feat_id UUID,
                            skill_id UUID,
                            item_id UUID,
                            race_id UUID,
                            deity_id UUID,
                            other text
);


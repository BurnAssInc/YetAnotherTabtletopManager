ALTER TABLE dnd_character
    ADD CONSTRAINT FK_dnd_character_race FOREIGN KEY(race_id) REFERENCES race(id),
    ADD CONSTRAINT FK_dnd_character_deity FOREIGN KEY(deity_id) REFERENCES deity(id),
    ADD CONSTRAINT FK_dnd_character_player FOREIGN KEY(player_id) REFERENCES player(id),
    DROP COLUMN feat_id,
    DROP COLUMN skill_id,
    DROP COLUMN item_id,
    DROP COLUMN campaign_id;
ALTER TABLE feat
    DROP COLUMN dnd_character_id;
ALTER TABLE skill
    DROP COLUMN dnd_character_id;
ALTER TABLE item
    DROP COLUMN dnd_character_id;
ALTER TABLE campaign
    DROP COLUMN dnd_character_id;
ALTER TABLE player
    DROP COLUMN dnd_character_id;
ALTER TABLE race
    DROP COLUMN dnd_character_id;
ALTER TABLE deity
    DROP COLUMN dnd_character_id;


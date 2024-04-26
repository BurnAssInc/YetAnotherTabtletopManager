CREATE TABLE dnd_character_campaign (
                            dnd_character_id UUID REFERENCES dnd_character(id) on delete cascade on update cascade,
                            campaign_id UUID REFERENCES campaign(id) on delete cascade on update cascade,
                            PRIMARY KEY (dnd_character_id,campaign_id)

);

CREATE TABLE dnd_character_feat (
                            dnd_character_id UUID REFERENCES dnd_character(id) on delete cascade on update cascade,
                            feat_id UUID REFERENCES feat(id) on delete cascade on update cascade,
                            PRIMARY KEY (dnd_character_id, feat_id)

);

CREATE TABLE dnd_character_skill (
                            dnd_character_id UUID REFERENCES dnd_character(id) on delete cascade on update cascade,
                            skill_id UUID REFERENCES skill(id) on delete cascade on update cascade,
                            PRIMARY KEY (dnd_character_id,skill_id)

);

CREATE TABLE dnd_character_item (
                            dnd_character_id UUID REFERENCES dnd_character(id) on delete cascade on update cascade,
                            item_id UUID REFERENCES item(id) on delete cascade on update cascade,
                            PRIMARY KEY (dnd_character_id,item_id)

);

CREATE TABLE player_campaign (
                            player_id UUID REFERENCES player(id) on delete cascade on update cascade,
                            campaign_id UUID REFERENCES campaign(id) on delete cascade on update cascade,
                            PRIMARY KEY (player_id,campaign_id)

);


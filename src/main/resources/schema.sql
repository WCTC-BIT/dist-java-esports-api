create table esports_team
(
    team_id identity primary key,
    team_name varchar(100) not null,
    game_name varchar(100) not null,
    wins int default 0,
    losses int default 0
);

create table player
(
    player_id identity primary key,
    team_id int,
    foreign key (team_id) references esports_team(team_id) on delete cascade,
    first_name varchar(100) not null,
    last_name varchar(100) not null
);
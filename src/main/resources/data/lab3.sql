CREATE DATABASE IF NOT EXISTS dmitrenko;
USE dmitrenko;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS audio;
DROP TABLE IF EXISTS media;
DROP TABLE IF EXISTS game_chat;
DROP TABLE IF EXISTS game;


CREATE TABLE payment (
    id INT NOT NULL AUTO_INCREMENT,
    card_number VARCHAR(45) NOT NULL,
    expiration_date CHAR(4) NOT NULL ,
    cvc CHAR(3) NOT NULL,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE security (
    login VARCHAR(30) NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (login)
);

CREATE TABLE game (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    price VARCHAR(300),
    category VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE game_chat (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    game_id INT NOT NULL,
    PRIMARY KEY(id),
    INDEX idx_fk_game_chat_game (game_id ASC),
    CONSTRAINT FK_game_chat_game
        FOREIGN KEY (game_id)
            REFERENCES game (id)
);

CREATE TABLE message (
     id INT NOT NULL AUTO_INCREMENT,
     date DATE NOT NULL,
     message LONGTEXT NOT NULL,
     game_chat_id INT NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT FK_message_game_chat
         FOREIGN KEY (game_chat_id)
             REFERENCES game_chat (id)
);

CREATE TABLE audio (
    id INT NOT NULL AUTO_INCREMENT,
    duration INT NOT NULL,
    game_chat_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_audio_game_chat
       FOREIGN KEY (game_chat_id)
           REFERENCES game_chat (id)
);

CREATE TABLE media (
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(45) NOT NULL,
   size VARCHAR(45) NOT NULL,
   date DATE NOT NULL,
   game_chat_id INT NOT NULL,
   PRIMARY KEY (id),
   CONSTRAINT FK_media_game_chat
       FOREIGN KEY (game_chat_id)
           REFERENCES game_chat (id)
);

CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45),
    username VARCHAR(45) NOT NULL,
    phone_number VARCHAR(45) NOT NULL,
    inform VARCHAR(500),
    game_chat_id INT NOT NULL,
    payment_id INT NOT NULL,
    security_login VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    INDEX idx_fk_user_game_chat (game_chat_id ASC),
    INDEX idx_fk_user_security (security_login ASC),
    CONSTRAINT FK_user_game_chat
      FOREIGN KEY (game_chat_id)
          REFERENCES game_chat (id),
    CONSTRAINT FK_user_payment
      FOREIGN KEY (payment_id)
          REFERENCES payment (id),
    CONSTRAINT FK_user_security
      FOREIGN KEY (security_login)
          REFERENCES security (login)
);

INSERT INTO payment (`card_number`, `expiration_date`, `cvc`, `name`) VALUES
    ('4856385546', '3436', '463', 'Vitaliy'),
    ('2975935836', '6435', '054', 'Svitlana'),
    ('543974473', '7747', '123', 'Taras'),
    ('4597357945', '4868', '342', 'Polina'),
    ('5285785785', '4785', '463', 'Nazar'),
    ('45862583563', '2695', '648', 'Mariya'),
    ('53593575733', '9532', '368', 'Pavlo'),
    ('38579285572', '5096', '972', 'Anastasiya'),
    ('59729759535', '3575', '082', 'Anna'),
    ('28952897574', '4930', '580', 'Maks');

INSERT INTO security (`login`, `password`) VALUES
    ('2001pavlo', 'thvr5'),
    ('alex14092', 'lfbbm'),
    ('country32', 'thtrh'),
    ('light454', '5754vht'),
    ('main234', 'jv563v'),
    ('marksum234', 'trhhht'),
    ('moon5556', 'ryvr356'),
    ('olena1208', 't4gds'),
    ('sea120393', '2353x'),
    ('vlad124', 'jkrrg');

INSERT INTO game (`name`, `price`, `category`) VALUES
    ('Kingdom: New Lands', '15$', 'Arcade'),
    ('League of Legends', 'Free', 'Arcade'),
    ('Among Us', '5$', 'Party'),
    ('Minion Masters', 'Free', 'Arcade'),
    ('Rocket League', '25$', 'Arcade'),
    ('Pokémon GO', 'Free', 'Arcade'),
    ('Valorant', 'Free', 'Strategy'),
    ('Karuta', '12$', 'Cards'),
    ('King of the Hat', 'Free', 'Party'),
    ('Last Year: The Nightmare', '10$', 'Horror');

INSERT INTO game_chat (`name`, `game_id`) VALUES
    ('League of Legends', '2'),
    ('Among Us', '3'),
    ('Minion Masters', '4'),
    ('Rocket League', '5'),
    ('Pokémon GO', '6'),
    ('Valorant', '7'),
    ('Karuta  ', '8'),
    ('King of the Hat', '9'),
    ('Last Year: The Nightmare', '10'),
    ('Kingdom: New Lands', '1');

INSERT INTO audio (`duration`, `game_chat_id`) VALUES
    ('12', '2'),
    ('23', '3'),
    ('12', '4'),
    ('45', '5'),
    ('34', '6'),
    ('52', '7'),
    ('26', '8'),
    ('34', '9'),
    ('27', '10'),
    ('3', '1');

INSERT INTO media (`name`, `size`, `date`, `game_chat_id`) VALUES
    ('league', '4МБ', '2021-09-23', '2'),
    ('among us', '3.8МБ', '2021-03-12', '3'),
    ('minion', '12МБ', '2021-03-15', '4'),
    ('rocket', '5МБ', '2021-08-25', '5'),
    ('pokemon', '5.5МБ', '2021-08-24', '6'),
    ('valorant', '6МБ', '2021-04-19', '7'),
    ('karuta', '4.9МБ', '2021-11-28', '8'),
    ('king', '3.7МБ', '2021-02-19', '9'),
    ('last nigtmare', '5МБ', '2021-07-12', '10'),
    ('kingdom', '7МБ', '2021-09-17', '1');

INSERT INTO message (`date`, `message`, `game_chat_id`) VALUES
    ('2021-09-12', 'league', '2'),
    ('2021-11-14', 'among us', '3'),
    ('2021-02-14', 'minion masters', '4'),
    ('2021-02-14', 'rocket league', '5'),
    ('2021-03-14', 'pokemon', '6'),
    ('2021-06-12', 'valorant', '7'),
    ('2021-07-23', 'karuta', '8'),
    ('2021-05-09', 'hat king', '9'),
    ('2021-03-23', 'last year', '10'),
    ('2021-04-02', 'new lands of kingdom', '1');

INSERT INTO user (`name`, `username`, `phone_number`, `game_chat_id`, `payment_id`, `security_login`) VALUES
    ('Vitaliy', 'vitak', '+380956474358', '1', '1', 'alex14092'),
    ('Svitlana', 'sveta', '+380689376238', '2', '2', 'country32'),
    ('Taras', 'taraas', '+380273846283', '3', '3', 'light454'),
    ('Polina', 'ppolina', '0982428479', '4', '4', 'main234'),
    ('Nazar', 'nnazar', '0973742846', '5', '5', 'moon5556'),
    ('Mariya', 'mariyaa', '0953286373', '6', '6', 'sea120393'),
    ('Pavlo', 'pavvlo', '0662829476', '7', '7', '2001pavlo'),
    ('Anastasia', 'nastya', '+80968373883', '8', '8', 'vlad124'),
    ('Anna', 'annaa', '0663439827', '9', '9', 'olena1208'),
    ('Maks', 'maksim', '0983736273', '10', '10', 'marksum234');

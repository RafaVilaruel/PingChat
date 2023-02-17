CREATE SCHEMA IF NOT EXISTS ping;

-- Drop tables
DROP TABLE IF EXISTS ping_rooms;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS messages;

CREATE TABLE ping.ping_rooms (
  chat_id INT PRIMARY KEY,
  url_song_being_played VARCHAR(255),
  chat_password VARCHAR(255),
  user_host INT,
  user_logged INT
);

CREATE TABLE ping.user_info (
  user_id INT PRIMARY KEY,
  name VARCHAR(255),
  chat_id INT
);

CREATE TABLE ping.messages (
  chat_id INT,
  content VARCHAR(255),
  sent_at TIMESTAMP,
  user_id INT
);

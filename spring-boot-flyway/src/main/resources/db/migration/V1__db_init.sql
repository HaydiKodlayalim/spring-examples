CREATE SEQUENCE seq_users start 1 increment 1;

CREATE TABLE users (
   id bigint NOT NULL default nextval('seq_users'),
   username varchar(100) NOT NULL,
   firstname varchar(50) NOT NULL,
   lastname varchar(50) DEFAULT NULL,
   PRIMARY KEY (id)
);

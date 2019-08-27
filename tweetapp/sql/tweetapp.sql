set names utf8;
set foreign_key_checks=0;
drop database if exists tweetapp;

create database if not exists tweetapp;
use tweetapp;

drop table if exists user_info;

create table user_info(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
login_flag int,
insert_date datetime,
updated_date datetime);

drop table if exists text_info;

create table text_info(
id int not null primary key auto_increment,
user_name varchar(50),
content varchar(255),
insert_date datetime,
update_date datetime);
show databases;

create database motw;

use motw;

create table member(
username varchar(200) not null primary key,
userPw varchar(200) not null,
userEmail varchar(200) not null
) default charset=utf8;

create table community(
no int auto_increment primary key,
cGroup int default 0,
indent int not null,
step int not null,
title varchar(400) not null,
content text not null,
username varchar(200) not null,
regDate datetime not null,
likeCnt int default 0 not null,
hit int default 0 not null,
foreign key(username) references member(username)
) default charset=utf8;

create table cLike(
boardno int not null,
username varchar(200) not null,
likeCheck int default 0 null,
foreign key(username) references member(username) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key(boardno) references community(no) ON DELETE CASCADE ON UPDATE CASCADE
) default charset=utf8;

create table thisweek(
no int auto_increment primary key,
title varchar(400) not null,
content text not null,
catchph varchar(600) not null,
username varchar(200) not null,
image varchar(500),
director varchar(200) not null,
stars varchar(400) not null,
rlsDate varchar(100) not null,
regDate datetime not null,
likeCnt int default 0 not null,
hit int default 0 not null,
foreign key(username) references member(username)
) default charset=utf8;

create table cart(
username varchar(200) not null,
title varchar(400) not null,
image varchar(500),
director varchar(200) not null,
rlsDate varchar(100) not null,
cartDate datetime not null,
primary key(username, title)
) default charset=utf8;
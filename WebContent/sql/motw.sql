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
update community set likeCnt=0 where step=0;
select * from community;

update community set likeCnt=0 where no=22;

drop table community;

insert into community(indent, step, title,content,username,regDate,likeCnt,hit) values(0,0,'title1','content1','12',sysdate(),0,0);
insert into community(indent, step, title,content,username,regDate,likeCnt,hit) values(0,0,'title2','content2','12',sysdate(),0,0);
insert into community(indent, step, title,content,username,regDate,likeCnt,hit) values(0,1,'title3','content3','12',sysdate(),0,0);
SELECT * FROM community WHERE cGroup=1 and step>0 ORDER BY step ASC LIMIT 0, 5;
insert into community(cGroup,indent,step,title,content,username,regDate) values(1,1,1,'hihi','hhhh','yoojin',sysdate());

create table cLike(
boardno int not null,
username varchar(200) not null,
likeCheck int default 0 null,
foreign key(username) references member(username) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key(boardno) references community(no) ON DELETE CASCADE ON UPDATE CASCADE
) default charset=utf8;

ALTER TABLE cLike DROP FOREIGN KEY clike_ibfk_2;
ALTER TABLE cLike ADD FOREIGN KEY (boardno) REFERENCES  community(no) ON DELETE CASCADE ON UPDATE CASCADE;

select * from cLike;
insert into cLike values(3, 'admin',1);

drop table cLike;
select * from information_schema.table_constraints where table_name = 'cLike';


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

desc thisweek;
drop table thisweek;
select * from thisweek;
update thisweek set catchph='"Her voice became his passion. Her love became his obsession. <br>Her refusal became his rage…"' where no=9;

update thisweek set rotten='https://www.rottentomatoes.com/m/begin_again_2013', imdb='https://www.imdb.com/title/tt1980929', wiki='https://en.wikipedia.org/wiki/Begin_Again_(film)', youtube='https://www.youtube.com/watch?v=0NQC4fzDZz0' where no=2;
update thisweek set rotten='https://www.rottentomatoes.com/m/once', imdb='https://www.imdb.com/title/tt0907657', wiki='https://en.wikipedia.org/wiki/Once_(film)', youtube='https://www.youtube.com/watch?v=K4uFFNl6FQ4' where no=3;
update thisweek set rotten='https://www.rottentomatoes.com/m/la_la_land', imdb='https://www.imdb.com/title/tt3783958', wiki='https://en.wikipedia.org/wiki/La_La_Land_(film)', youtube='https://www.youtube.com/watch?v=0pdqf4P9MB8' where no=5;
update thisweek set rotten='https://www.rottentomatoes.com/m/sing_street', imdb='https://www.imdb.com/title/tt3544112', wiki='https://en.wikipedia.org/wiki/Sing_Street', youtube='https://www.youtube.com/watch?v=jYk2Vx1z6lk' where no=4;
update thisweek set rotten='https://www.rottentomatoes.com/m/les_miserables_2012', imdb='https://www.imdb.com/title/tt1707386', wiki='https://en.wikipedia.org/wiki/Les_Mis%C3%A9rables_(2012_film)', youtube='https://www.youtube.com/watch?v=YmvHzCLP6ug' where no=7;
update thisweek set rotten='https://www.rottentomatoes.com/m/bohemian_rhapsody', imdb='https://www.imdb.com/title/tt1727824', wiki='https://en.wikipedia.org/wiki/Bohemian_Rhapsody_(film)', youtube='https://www.youtube.com/watch?v=mP0VHJYFOAU' where no=6;

alter table thisweek add column rlsDate datetime not null;
alter table thisweek add column director varchar(200) not null;
alter table thisweek add column stars varchar(200) not null;
alter table thisweek modify column stars varchar(400) not null;

alter table thisweek add column rotten varchar(500);
alter table thisweek add column imdb varchar(500);
alter table thisweek add column wiki varchar(500);
alter table thisweek add column youtube varchar(500);

insert into thisweek(title, content, username, image, director, stars, rlsDate, regDate) values('La La Land','music movie','admin','la_la_land.jpg','Damien Chazelle','Ryan Gosling, Emma Stone','2016',sysdate());
insert into thisweek(title, content, username, image, director, stars, rlsDate, regDate) values('Begin Again','music movie','admin','begin_again.jpg','John Carney','Mark Ruffalo, Keira Knightley, Adam Levine, Hailey Steinfield','2014',sysdate());
use motw;

create table cart(
username varchar(200) not null,
title varchar(400) not null,
image varchar(500),
director varchar(200) not null,
rlsDate varchar(100) not null,
cartDate datetime not null,
primary key(username, title)
) default charset=utf8;
ALTER TABLE cart add PRIMARY KEY (username, title);
drop table cart;
desc cart;
select * from cart;
delete from cart where title='Once';

SHOW CREATE TABLE member;
SHOW CREATE TABLE member;
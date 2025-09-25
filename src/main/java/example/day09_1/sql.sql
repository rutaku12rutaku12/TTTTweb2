drop database if exists springweb2;
create database springweb2;
use springweb2;

create table movie(
mno int auto_increment, -- 영화 게시물 번호
mtitle varchar(200) , -- 영화 제목
mdirector varchar(200) , -- 영화 감독
mgenre varchar(100), -- 영화 장르
mcontent varchar(500) , -- 영화 소개
mpwd varchar(30), -- 영화 비밀번호
constraint primary key (mno)
);

create table post(
mno int, -- 영화 게시물 번호
pno int auto_increment, -- 토론 글 번호
pcontent longtext , -- 토론 글 내용
ppwd varchar(30) , -- 토론 글 비밀번호
constraint primary key (pno),
 foreign key (mno) references movie(mno)
);
insert into movie (mtitle, mdirector , mgenre , mcontent , mpwd) values ('어쩔수가없다','박찬욱','스릴러','다 이루었다','1324');
-- delete from movie where mno = 1;

insert into post (mno,pcontent,ppwd) values (1, '수수수수수수수수수수','1324');
-- delete from post where pno = 1 and ppwd = 1324;
select p.pno , p.pcontent, p.ppwd, m.mtitle from post p join movie m on p.mno = m.mno where p.mno = 1;
select * from movie;
select * from post;
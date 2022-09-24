create database learners_academy;
USE learners_academy;
CREATE table classlist (
	classname varchar(100),
    primary key(classname)
);
CREATE table teacherlist (
	teacherid int auto_increment,
	teachername varchar(100),
    primary key(teacherid)
);

CREATE table subjectlist (
	subjectname varchar(100),
    primary key(subjectname)
);

CREATE table studentlist (
	studentname varchar(100),
    classname varchar(100),
    foreign key(classname) references classlist(classname)
);

CREATE table assignedlist (
	classname varchar(100) not null,
    teacherid int not null,
    subjectname varchar(100) not null,
     foreign key(classname) references classlist(classname),
      foreign key(teacherid) references teacherlist(teacherid),
       foreign key(subjectname) references subjectlist(subjectname)
);

alter table teacherlist modify column teacherid int auto_increment;



insert into classlist values("1st");
insert into classlist values("2st");
insert into classlist values("3st");
insert into classlist values("4st");
insert into classlist values("5st");
insert into classlist values("6st");



insert into teacherlist  values("1","A");
insert into teacherlist  values("2","B");
insert into teacherlist  values("3","C");
insert into teacherlist  values("4","D");
insert into teacherlist  values("5","E");
insert into teacherlist  values("6","F");

insert into subjectlist  values("hindi");
insert into subjectlist  values("english");
insert into subjectlist  values("maths");
insert into subjectlist values("science");
insert into subjectlist values("social");
insert into subjectlist values("GK");



insert into assignedlist  values("3st",3,"hindi");
insert into assignedlist  values("3st",4,"english");
insert into assignedlist  values("3st",5,"maths");
insert into assignedlist  values("3st",6,"science");
insert into assignedlist  values("3st",1,"social");
insert into assignedlist  values("3st",2,"gk");

insert into assignedlist  values("1st",1,"hindi");
insert into assignedlist  values("1st",2,"english");
insert into assignedlist  values("1st",3,"maths");
insert into assignedlist  values("1st",4,"science");
insert into assignedlist  values("1st",5,"social");
insert into assignedlist  values("1st",6,"gk");

insert into assignedlist  values("2st",2,"hindi");
insert into assignedlist  values("2st",3,"english");
insert into assignedlist  values("2st",4,"maths");
insert into assignedlist  values("2st",5,"science");
insert into assignedlist  values("2st",6,"social");
insert into assignedlist  values("2st",1,"gk");

insert into assignedlist  values("4st",4,"hindi");
insert into assignedlist  values("4st",5,"english");
insert into assignedlist  values("4st",6,"maths");
insert into assignedlist  values("4st",1,"science");
insert into assignedlist  values("4st",2,"social");
insert into assignedlist  values("4st",3,"gk");

insert into assignedlist  values("5st",5,"hindi");
insert into assignedlist  values("5st",6,"english");
insert into assignedlist  values("5st",1,"maths");
insert into assignedlist  values("5st",2,"science");
insert into assignedlist  values("5st",3,"social");
insert into assignedlist  values("5st",4,"gk");

insert into assignedlist  values("6st",6,"hindi");
insert into assignedlist  values("6st",1,"english");
insert into assignedlist  values("6st",2,"maths");
insert into assignedlist  values("6st",3,"science");
insert into assignedlist  values("6st",4,"social");
insert into assignedlist  values("6st",5,"gk");

insert into studentlist  values("a","1st");
insert into studentlist  values("b","1st");
insert into studentlist  values("c","1st");
insert into studentlist  values("d","2st");
insert into studentlist  values("e","2st");
insert into studentlist  values("f","2st");
insert into studentlist  values("g","3st");
insert into studentlist  values("h","3st");
insert into studentlist  values("i","3st");




select studentname from studentlist where studentlist.classname = "2st";

select subjectname, teacherid from assignedlist where assignedlist.classname = "2st";

select teachername, subjectname from assignedlist,teacherlist where classname="2st" and teacherlist.teacherid = assignedlist.teacherid;




create table administrator(
 userid varchar(100) not null,
 password varchar(100) not null
);


insert into administrator  values("admin","admin@123");
show databases



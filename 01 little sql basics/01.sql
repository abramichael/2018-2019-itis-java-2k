-- comments in sql.

-- creating table

create table students (
	id serial not null primary key,
	name varchar(15),
	year int,
	city varchar(30)
);

-- insert new info

insert into students(name, year, city) values ('Gleb', 1999, 'Kazan');
insert into students(name, year, city) values ('Nail', 1999, 'Kazan');
insert into students(name, year, city) values ('Kolya', 1999, 'Yoshkar-Ola');
insert into students(name, year, city) values ('Andrey', 2000, 'Kazan');
insert into students(name, year, city) values ('Dima', 2000, 'Ufa');
insert into students(name, year, city) values ('Misha', 1989, 'Kazan');

-- all students, all their info

select * from students;

-- deleting by condition

delete from students where name = 'Misha';

-- update info by condition

update students
set name='Dmitry'
where name='Dima' and city='Ufa';

-- another table with foreign key on students

create table messages(
  id serial not null PRIMARY KEY,
  text text not null,
  date TIMESTAMP,
  sender int REFERENCES students(id),
  receiver int REFERENCES students(id)
)

insert into messages(sender, receiver, text)
    values(1, 2, 'Cho posony?');
insert into messages(sender, receiver, text)
  values(3, 7, 'Zdorovo! Cho s Andoida ushel?');
 
-- select with production (not efficient in some DB)
 
select s1.name, s2.name, "text"
from students s1, students s2, messages
where s1.id = messages.sender and s2.id = messages.receiver;

-- select with join

select s1.name, s2.name, "text"
from students as s1
  join messages on sender = s1.id
  join students as s2 on receiver = s2.id;

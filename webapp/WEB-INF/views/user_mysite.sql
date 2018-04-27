drop table users;
drop sequence seq_users_no;


create table users (
  no number,
  name varchar2(80),
  email varchar2(100) unique not null,
  password varchar2(20) not null,
  gender  varchar2(10),
  primary key(no)
);


create sequence seq_users_no
increment by 1
start with 1
nocache;

insert into users
values (seq_users_no.nextval, '황일영', 'iremys@gmail.com', '1234' , 'male');

insert into users
values (seq_users_no.nextval, '정우성', 'jungusung@gmail.com', '1234' , 'male');

select no, name, email, password, gender
from users
order by no desc;

select no, name, email, password, gender
from users
where no = 4;

select no, name, email, gender
from users
where email = 'iremys@gmail.com'
and password = '1234' ;


update users
set name = '이효리',
    email = 'leehry@gmail.com',
    password = '1234',
    gender ='female'
where no = 4;
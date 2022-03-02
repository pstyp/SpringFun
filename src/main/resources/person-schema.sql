drop table if exists person CASCADE;
create table person (id integer AUTO_INCREMENT, age integer, height integer, name varchar(255) not null, primary key (id));
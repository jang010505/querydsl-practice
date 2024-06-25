create user querydsl@localhost identified by 'querydsl';
create database querydsl;
grant all privileges on querydsl.* to querydsl@localhost with grant option;
commit;
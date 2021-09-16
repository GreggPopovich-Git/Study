create database jsl49;
-- 사용자 계정 추가 및 localhost 접근 권한 추가
grant select,insert,update,delete,create,drop,alter on jsl49.* to 'jsl49'@'localhost' identified by 'ehfkdl12';

-- 사용자 계정 추가 및 모든 서버 접근 권한 추가
grant select,insert,update,delete,create,drop,alter on jsl49.* to 'jsl49'@'%' identified by 'ehfkdl12';

show databases;
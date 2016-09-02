create database school;

use school;

create table user(
id int primary key auto_increment,
username varchar(20) ,
password varchar(20) ,
role varchar(20)
)default charset=utf8;

insert into user(id,username ,password,role) values(1,'admin','admin','����Ա');
insert into user(id,username ,password,role) values(2,'cyf','111111','�û�');


CREATE TABLE school (
school_id INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
DESC TEXT,
PRIMARY KEY(school_id)
)
CREATE TABLE major (
major_id INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
school_id INT,
DESC TEXT,
PRIMARY KEY(major_id),
FOREIGN KEY(school_id) REFERENCES school(school_id)
)

CREATE TABLE course (
course_id INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
major_id  INT,
DESC TEXT,
PRIMARY KEY(course_id),
FOREIGN KEY(major_id) REFERENCES major(major_id)
)

//��������
insert into school(name) values('�Ͼ��ʵ��ѧ');
insert into major (name,school_id) values('ͨ�Ź���',1);
insert into major (name,school_id) values('������Ϣ����',1);
insert into major (name,school_id) values('�������',1);
insert into major (name,school_id) values('���ӿ�ѧ�뼼��',1);
insert into course (name,major_id) values('ͨ��ԭ��',1);
insert into course (name,major_id) values('�ź���ϵͳ',1);
insert into course (name,major_id) values('��ų��벨',1);
insert into course (name,major_id) values('��Ƭ��',2);
insert into course (name,major_id) values('���������',2);
insert into course (name,major_id) values('��Ƶ������·',2);
insert into course (name,major_id) values('�߼����Գ������',3);
insert into course (name,major_id) values('�������',3);
insert into course (name,major_id) values('�������',3);
insert into course (name,major_id) values('��·��������',4);
insert into course (name,major_id) values('��ų�����',4);
insert into course (name,major_id) values('����ԭ�������',4);
insert into school(name) values('�Ͼ��ƾ���ѧ');
insert into major (name,school_id) values('���ڹ���',2);
insert into major (name,school_id) values('Ӧ�û�ѧ',2);
insert into major (name,school_id) values('����ѧ',2);
insert into major (name,school_id) values('����ѧ',2);
insert into course (name,major_id) values('���ڹ���ѧ',5);
insert into course (name,major_id) values('֤ȯͶ��ѧ',5);
insert into course (name,major_id) values('���ڷ��չ���',5);
insert into course (name,major_id) values('�޻���ѧ',6);
insert into course (name,major_id) values('������ѧ',6);
insert into course (name,major_id) values('��������',6);
insert into course (name,major_id) values('΢�۾���ѧ',7);
insert into course (name,major_id) values('��۾���ѧ',7);
insert into course (name,major_id) values('�м�΢�۾���ѧ',7);
insert into course (name,major_id) values('����ѧ',8);
insert into course (name,major_id) values('˰��ѧ',8);
insert into course (name,major_id) values('�й�˰��',8);
insert into school(name) values('�Ͼ�ʦ����ѧ');
insert into major (name,school_id) values('��������ѧ',3);
insert into major (name,school_id) values('��ʷѧ',3);
insert into major (name,school_id) values('˼�����ν���',3);
insert into major (name,school_id) values('��ѧ��Ӧ�ý�ѧ',3);
insert into course (name,major_id) values('�ִ�����',9);
insert into course (name,major_id) values('�Ŵ�����',9);
insert into course (name,major_id) values('����ʷ',9);
insert into course (name,major_id) values('�й��Ŵ�ʷ',10);
insert into course (name,major_id) values('�й����ִ�ʷ',10);
insert into course (name,major_id) values('����Ŵ�ʷ',10);
insert into course (name,major_id) values('˼�����ν���ԭ��',11);
insert into course (name,major_id) values('��������������ʵ��',11);
insert into course (name,major_id) values('��������ѧ',11);
insert into course (name,major_id) values('�ߵȴ���',12);
insert into course (name,major_id) values('���亯��',12);
insert into course (name,major_id) values('ʵ�亯��',12);
insert into school(name) values('�Ͼ���ѧ');
insert into major (name,school_id) values('�й�������ѧ',4);
insert into major (name,school_id) values('����ѧ',4);
insert into major (name,school_id) values('����ѧ',4);
insert into major (name,school_id) values('�������ѧ�뼼��',4);
insert into course (name,major_id) values('�ִ�����',13);
insert into course (name,major_id) values('�Ŵ�����',13);
insert into course (name,major_id) values('��ѧ����',13);
insert into course (name,major_id) values('���ﻯѧ',14);
insert into course (name,major_id) values('ֲ��ѧ',14);
insert into course (name,major_id) values('����ѧ',14);
insert into course (name,major_id) values('��ѧ',15);
insert into course (name,major_id) values('��ѧ',15);
insert into course (name,major_id) values('��ѧ',15);
insert into course (name,major_id) values('���ݽṹ',16);
insert into course (name,major_id) values('���������',16);
insert into course (name,major_id) values('����ϵͳ',16);
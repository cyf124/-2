create database school;

use school;

create table user(
id int primary key auto_increment,
username varchar(20) ,
password varchar(20) ,
role varchar(20)
)default charset=utf8;

insert into user(id,username ,password,role) values(1,'admin','admin','管理员');
insert into user(id,username ,password,role) values(2,'cyf','111111','用户');


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

//插入数据
insert into school(name) values('南京邮电大学');
insert into major (name,school_id) values('通信工程',1);
insert into major (name,school_id) values('电子信息工程',1);
insert into major (name,school_id) values('软件工程',1);
insert into major (name,school_id) values('电子科学与技术',1);
insert into course (name,major_id) values('通信原理',1);
insert into course (name,major_id) values('信号与系统',1);
insert into course (name,major_id) values('电磁场与波',1);
insert into course (name,major_id) values('单片机',2);
insert into course (name,major_id) values('计算机网络',2);
insert into course (name,major_id) values('高频电子线路',2);
insert into course (name,major_id) values('高级语言程序设计',3);
insert into course (name,major_id) values('软件工程',3);
insert into course (name,major_id) values('软件测试',3);
insert into course (name,major_id) values('电路分析基础',4);
insert into course (name,major_id) values('电磁场理论',4);
insert into course (name,major_id) values('天线原理与设计',4);
insert into school(name) values('南京财经大学');
insert into major (name,school_id) values('金融工程',2);
insert into major (name,school_id) values('应用化学',2);
insert into major (name,school_id) values('经济学',2);
insert into major (name,school_id) values('财政学',2);
insert into course (name,major_id) values('金融工程学',5);
insert into course (name,major_id) values('证券投资学',5);
insert into course (name,major_id) values('金融风险管理',5);
insert into course (name,major_id) values('无机化学',6);
insert into course (name,major_id) values('分析化学',6);
insert into course (name,major_id) values('仪器分析',6);
insert into course (name,major_id) values('微观经济学',7);
insert into course (name,major_id) values('宏观经济学',7);
insert into course (name,major_id) values('中级微观经济学',7);
insert into course (name,major_id) values('财政学',8);
insert into course (name,major_id) values('税收学',8);
insert into course (name,major_id) values('中国税制',8);
insert into school(name) values('南京师范大学');
insert into major (name,school_id) values('汉语言文学',3);
insert into major (name,school_id) values('历史学',3);
insert into major (name,school_id) values('思想政治教育',3);
insert into major (name,school_id) values('数学与应用教学',3);
insert into course (name,major_id) values('现代汉语',9);
insert into course (name,major_id) values('古代汉语',9);
insert into course (name,major_id) values('汉语史',9);
insert into course (name,major_id) values('中国古代史',10);
insert into course (name,major_id) values('中国近现代史',10);
insert into course (name,major_id) values('世界古代史',10);
insert into course (name,major_id) values('思想政治教育原理',11);
insert into course (name,major_id) values('国际政治理论与实践',11);
insert into course (name,major_id) values('经济伦理学',11);
insert into course (name,major_id) values('高等代数',12);
insert into course (name,major_id) values('复变函数',12);
insert into course (name,major_id) values('实变函数',12);
insert into school(name) values('南京大学');
insert into major (name,school_id) values('中国语言文学',4);
insert into major (name,school_id) values('生物学',4);
insert into major (name,school_id) values('物理学',4);
insert into major (name,school_id) values('计算机科学与技术',4);
insert into course (name,major_id) values('现代汉语',13);
insert into course (name,major_id) values('古代汉语',13);
insert into course (name,major_id) values('文学概论',13);
insert into course (name,major_id) values('生物化学',14);
insert into course (name,major_id) values('植物学',14);
insert into course (name,major_id) values('动物学',14);
insert into course (name,major_id) values('力学',15);
insert into course (name,major_id) values('热学',15);
insert into course (name,major_id) values('光学',15);
insert into course (name,major_id) values('数据结构',16);
insert into course (name,major_id) values('计算机网络',16);
insert into course (name,major_id) values('操作系统',16);
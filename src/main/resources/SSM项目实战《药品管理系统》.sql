/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/3/13 10:54:15                           */
/*==============================================================*/
-- 删除数据库
DROP DATABASE drugdb;
-- 创建数据库
CREATE DATABASE drugdb;
-- 使用数据库
USE drugdb;
-- 删除数据表
drop table if exists action;
drop table if exists admin;
drop table if exists admin_role;
drop table if exists drug;
drop table if exists item;
drop table if exists role;
drop table if exists role_action;
drop table if exists stock;
/*==============================================================*/
/* Table: action                                                */
/*==============================================================*/
create table action
(
   actid                INT not null auto_increment,
   title                VARCHAR(50),
   flag                 VARCHAR(30),
   primary key (actid)
)ENGINE=INNODB;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   aid                  VARCHAR(50) not null,
   password             VARCHAR(32),
   name                 VARCHAR(50),
   regdate              DATETIME,
   flag                 INT,
   locked               INT,
   primary key (aid)
)ENGINE=INNODB;

/*==============================================================*/
/* Table: admin_role                                            */
/*==============================================================*/
create table admin_role
(
   rid                  INT,
   aid                  VARCHAR(50)
)ENGINE=INNODB;

/*==============================================================*/
/* Table: drug                                                  */
/*==============================================================*/
create table drug
(
   drid                 VARCHAR(50) not null ,
   iid                  INT,
   title                VARCHAR(50),
   prodate              DATETIME,
   address              VARCHAR(150),
   phone                VARCHAR(50),
   count                INT,
   status               INT,
   primary key (drid)
)ENGINE=INNODB;

/*==============================================================*/
/* Table: item                                                  */
/*==============================================================*/
create table item
(
   iid                  INT not null auto_increment,
   title                VARCHAR(50),
   note                 VARCHAR(50),
   primary key (iid)
)ENGINE=INNODB;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   rid                  INT not null auto_increment,
   title                VARCHAR(50),
   flag                 VARCHAR(30),
   primary key (rid)
)ENGINE=INNODB;

/*==============================================================*/
/* Table: role_action                                           */
/*==============================================================*/
create table role_action
(
   rid                  INT,
   actid                INT
)ENGINE=INNODB;

/*==============================================================*/
/* Table: stock                                                 */
/*==============================================================*/
create table stock
(
   stid                 INT not null auto_increment,
   title                VARCHAR(50),
   name                 VARCHAR(50),
   regdate              DATETIME,
   count                INT,
   primary key (stid)
)ENGINE=INNODB;

alter table admin_role add constraint FK_Reference_1 foreign key (rid)
      references role (rid) on delete restrict on update restrict;

alter table admin_role add constraint FK_Reference_2 foreign key (aid)
      references admin (aid) on delete restrict on update restrict;

alter table drug add constraint FK_Reference_5 foreign key (iid)
      references item (iid) on delete restrict on update restrict;

alter table role_action add constraint FK_Reference_3 foreign key (rid)
      references role (rid) on delete restrict on update restrict;

alter table role_action add constraint FK_Reference_4 foreign key (actid)
      references action (actid) on delete restrict on update restrict;
-- 增加测试数据
-- 超级管理员 admin/hello
INSERT INTO admin(aid, password, name, regdate, flag, locked) VALUES ('admin','5D41402ABC4B2A76B9719D911017C592','小李','2020-3-13',1,0);
-- 普通用户 xmkeshe/hello
INSERT INTO admin(aid, password, name, regdate, flag, locked) VALUES ('xmkeshe','5D41402ABC4B2A76B9719D911017C592','xmedu','2020-3-13',2,0);
-- 增加角色信息
INSERT INTO role(title, flag) VALUES ('超级管理员','admin');
INSERT INTO role(title, flag) VALUES ('药品管理员','xmkeshe');
-- 增加权限信息
INSERT INTO action(title, flag) VALUES ('增加管理员','admin:add');
INSERT INTO action(title, flag) VALUES ('管理员列表','admin:list');
INSERT INTO action(title, flag) VALUES ('增加列表','drug:add');
INSERT INTO action(title, flag) VALUES ('药品列表','drug:list');
INSERT INTO action(title, flag) VALUES ('增加分类','item:add');
INSERT INTO action(title, flag) VALUES ('分类列表','item:list');
INSERT INTO action(title, flag) VALUES ('增加出库记录','stock:add');
INSERT INTO action(title, flag) VALUES ('出库记录列表','stock:list');
-- 管理员与角色信息表
INSERT INTO admin_role(rid, aid) VALUES (1,'admin');
INSERT INTO admin_role(rid, aid) VALUES (2,'xmkeshe');
-- 角色与权限关系
INSERT INTO role_action(rid, actid) VALUES (1,1);
INSERT INTO role_action(rid, actid) VALUES (1,2);
INSERT INTO role_action(rid, actid) VALUES (2,3);
INSERT INTO role_action(rid, actid) VALUES (2,4);
INSERT INTO role_action(rid, actid) VALUES (2,5);
INSERT INTO role_action(rid, actid) VALUES (2,6);
INSERT INTO role_action(rid, actid) VALUES (2,7);
INSERT INTO role_action(rid, actid) VALUES (2,8);
-- 提交
COMMIT;

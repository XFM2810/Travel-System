/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/11/19 22:31:34                          */
/*==============================================================*/


drop table if exists mat_reply;

drop table if exists "match";

drop table if exists travelTip;

drop table if exists user;

/*==============================================================*/
/* Table: mat_reply                                             */
/*==============================================================*/
create table mat_reply
(
   reply_id             int not null auto_increment,
   reply_content        varchar(500) not null,
   reply_date           date not null,
   mat_id               int,
   user_id              int,
   primary key (reply_id)
);

/*==============================================================*/
/* Table: "match"                                               */
/*==============================================================*/
create table "match"
(
   mat_id               int not null auto_increment,
   mat_name             varchar(20),
   mat_content          varchar(500),
   mat_date             date not null,
   user_id              int,
   primary key (mat_id)
);

/*==============================================================*/
/* Table: travelTip                                             */
/*==============================================================*/
create table travelTip
(
   tip_id               int not null auto_increment,
   tip_name             varchar(20),
   tip_tips             varchar(2000),
   tip_likes            int,
   tip_collections      int,
   tip_shares           int,
   user_id              int,
   primary key (tip_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment,
   user_name            varchar(10),
   password             varchar(20) not null,
   telephone            int,
   description          int,
   icon                 varchar(50),
   primary key (user_id)
);

alter table mat_reply add constraint FK_Reference_3 foreign key (mat_id)
      references "match" (mat_id) on delete restrict on update restrict;

alter table mat_reply add constraint FK_Reference_4 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table "match" add constraint FK_Reference_2 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table travelTip add constraint FK_Reference_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;


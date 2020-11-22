


drop table if exists mat_reply;

drop table if exists mat;

drop table if exists travelTip;

drop table if exists user;

create table mat_reply
(
   reply_id             int not null auto_increment,
   reply_content        varchar(500) not null,
   reply_date           date not null,
   mat_id               int,
   user_id              int,
   primary key (reply_id)
);

create table mat
(
   mat_id               int not null auto_increment,
   mat_name             varchar(20),
   mat_content          varchar(500),
   mat_date             date not null,
   user_id              int,
   primary key (mat_id)
);

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
      references mat (mat_id) on delete restrict on update restrict;

alter table mat_reply add constraint FK_Reference_4 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table mat add constraint FK_Reference_2 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table travelTip add constraint FK_Reference_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;


drop database if exists simple;
create database simple;
use simple;

create table if not exists user(
	`user_id` bigint(22) auto_increment,
	`user_email` varchar(255) not null,
	`user_password` varchar(255) not null,
	primary key `user_id` (`user_id`),
	unique key `email` (`user_email`),
	index `user_email_index` (`user_email`)
);

-- insert into user(user_email,user_password) values ('damducthoai@gmail.com','x');
-- insert into user(user_email,user_password) values ('thoainddse62100@gmail.com','x');

create table if not exists user_profile(
	`profile_id` bigint(22) auto_increment,
    `user_id` bigint(22) not null,
    `gender` int(1),
    `first_name` varchar(255),
    `middle_name` varchar(255),
    `last_name` varchar(255),
    `address` varchar(255),
    `phone` varchar(255),
    `action_code` varchar(255),
    `status_code` varchar(255),
    `last_acive` datetime,
    foreign key (`user_id`) references user(`user_id`),
    primary key (`profile_id`)
);

create table if not exists role(
	`role_id` int(11) auto_increment,
	`role_name` varchar(255),
	primary key `role_id` (`role_id`),
	unique key `role` (`role_name`),
	index `role_index` (`role_name`)
);
insert into role(role_name) values ('ROLE_ADMIN');
insert into role(role_name) values ('ROLE_USER');


create table if not exists authority (
	`authority_id` int(11) auto_increment,
	`user_id` bigint(22),
	`role_id` int(11),
	primary key(`authority_id`),
	foreign key (`user_id`) references user(`user_id`),
	foreign key (`role_id`) references role(`role_id`),
	unique key `authority_detail` (`user_id`,`role_id`)
);

-- insert into authority(user_id, role_id) values (1,1);
-- insert into authority(user_id, role_id) values (1,2);
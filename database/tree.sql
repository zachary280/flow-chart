/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.21 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `tree` (
	`id` int (11),
	`name` varchar (96),
	`message` varchar (96),
	`parent` varchar (96),
	`direction` varchar (96)
); 
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('1','1','是否非跨账单','0','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('2','2','是否有定向流量包','1','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('3','3','是否在定向流量包生效后使用','2','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('4','4','是否使用定向流量','3','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('5','5','是否在定向流量包限额内','4','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('6','6','是否有空闲流量包','5','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('7','6','是否有空闲流量包','4','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('8','6','是否有空闲流量包','3','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('9','6','是否有空闲流量包','2','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('10','7','是否在规定时间内使用','6','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('11','8','是否在空闲流量包限额内','7','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('12','9','是否有校园流量包','8','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('13','9','是否有校园流量包','7','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('14','9','是否有校园流量包','6','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('15','10','是否在校园内使用','9','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('16','11','是否在校园流量包限额内','10','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('17','12','是否有单模流量','11','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('18','12','是否有单模流量','10','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('19','12','是否有单模流量','9','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('20','13','是否在单模流量包生效后使用','12','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('21','14','是否使用4G网','13','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('22','15','是否在省内使用单模流量包','14','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('23','16','是否在单模流量限额内','15','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('24','17','是否有省内流量包','16','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('25','17','是否有省内流量包','15','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('26','17','是否有省内流量包','14','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('27','17','是否有省内流量包','13','rigth');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('28','17','是否有省内流量包','12','rigth');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('29','18','是否在省内流量包生效后使用','17','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('30','19','是否在省内使用省内流量包','18','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('31','20','是否在省内流量包限额内','19','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('32','21','是否有国内流量包','20','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('33','21','是否有国内流量包','19','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('34','21','是否有国内流量包','18','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('35','21','是否有国内流量包','17','right');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('36','22','是否在国内流量包生效后使用','21','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('37','23','是否在国内流量包限额内','22','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('38','24','流量使用无问题','5','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('39','24','流量使用无问题','8','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('40','24','流量使用无问题','11','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('41','24','流量使用无问题','16','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('42','24','流量使用无问题','20','left');
insert into `tree` (`id`, `name`, `message`, `parent`, `direction`) values('43','24','流量使用无问题','23','left');

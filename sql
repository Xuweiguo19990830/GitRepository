/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `itrip_user` (
	`id` double ,
	`userCode` varchar (765),
	`userPassword` varchar (765),
	`userType` double ,
	`flatID` double ,
	`userName` varchar (765),
	`weChat` varchar (765),
	`QQ` varchar (765),
	`weibo` varchar (765),
	`baidu` varchar (765),
	`creationDate` datetime ,
	`createdBy` double ,
	`modifyDate` datetime ,
	`modifiedBy` double ,
	`activated` double 
); 
insert into `itrip_user` (`id`, `userCode`, `userPassword`, `userType`, `flatID`, `userName`, `weChat`, `QQ`, `weibo`, `baidu`, `creationDate`, `createdBy`, `modifyDate`, `modifiedBy`, `activated`) values('12','1044732267@qq.com','e10adc3949ba59abbe56e057f20f883e','0','12','tester',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');
insert into `itrip_user` (`id`, `userCode`, `userPassword`, `userType`, `flatID`, `userName`, `weChat`, `QQ`, `weibo`, `baidu`, `creationDate`, `createdBy`, `modifyDate`, `modifiedBy`, `activated`) values('29','itrip@163.com','e10adc3949ba59abbe56e057f20f883e','0','29','桃子',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');
insert into `itrip_user` (`id`, `userCode`, `userPassword`, `userType`, `flatID`, `userName`, `weChat`, `QQ`, `weibo`, `baidu`, `creationDate`, `createdBy`, `modifyDate`, `modifiedBy`, `activated`) values('32','18704619726@163.com','5f1e22c6bc26ebc04fec0e6ec6a322ed','0','32','hash124',NULL,NULL,NULL,NULL,'2018-11-13 22:31:47',NULL,NULL,NULL,'1');
insert into `itrip_user` (`id`, `userCode`, `userPassword`, `userType`, `flatID`, `userName`, `weChat`, `QQ`, `weibo`, `baidu`, `creationDate`, `createdBy`, `modifyDate`, `modifiedBy`, `activated`) values('33','152213122@163.com','dfb7a2f8d057b63e1619d1bc3a151fd1',NULL,'33','徐彬',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');

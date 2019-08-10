/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.12-log : Database - design
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`design` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `design`;

/*Table structure for table `payment_channel` */

DROP TABLE IF EXISTS `payment_channel`;

CREATE TABLE `payment_channel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `channel_name` varchar(32) DEFAULT NULL COMMENT '渠道名称',
  `channel_id` varchar(32) DEFAULT NULL COMMENT '渠道ID',
  `strategy_bean_id` varchar(255) DEFAULT NULL COMMENT '策略执行beanid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='支付渠道 ';

/*Data for the table `payment_channel` */

insert  into `payment_channel`(`id`,`channel_name`,`channel_id`,`strategy_bean_id`) values 
(4,'支付宝渠道','ali_pay','aliPayStrategy'),
(5,'小米支付渠道','xiaomi_pay','xiaoMiPayStrategy');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

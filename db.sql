-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: example
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(145) NOT NULL,
  `title` varchar(445) NOT NULL DEFAULT '',
  `content` text NOT NULL COMMENT '文章内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1.有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='发布号作者表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (5,'abba','莎士比亚fff','莎士比亚fff','2017-10-25 01:08:45','2019-03-25 02:37:54','1'),(6,'莎士比亚','亚里士多德','亚里士多德','2017-10-26 02:49:28','2019-03-25 02:37:54','1'),(10,'abba','亚历山大','亚历山大','2017-10-26 06:57:45','2019-03-25 02:37:54','1'),(11,'莎士比亚','李白','李白','2017-10-26 07:23:42','2019-03-25 02:37:54','1'),(19,'abba','文章test2','文章test2','2017-11-18 05:37:07','2019-03-25 02:37:54','1'),(20,'abba','ee','ee','2018-11-30 01:27:15','2019-03-25 02:37:54','1'),(21,'ha','你好','你好','2018-11-30 01:28:21','2019-03-25 02:37:54','1'),(22,'莎士比亚','123','123','2018-12-03 04:30:51','2019-03-25 02:37:54','2'),(23,'莎士比亚','与','与','2018-12-03 05:54:44','2019-03-25 02:37:54','2'),(24,'莎士比亚','rrrr','rrrr','2019-02-12 08:13:47','2019-03-25 02:37:54','2'),(25,'就看看列表','g','ko','2019-03-14 06:00:43','2019-03-25 09:04:57','1'),(26,'就看看列表','q','q','2019-03-14 06:00:48','2019-03-25 02:37:54','1'),(27,'就看看列表','e','e','2019-03-14 06:00:52','2019-03-25 02:37:54','1'),(28,'就看看列表','ff','ff','2019-03-14 06:00:56','2019-03-25 02:37:54','1'),(29,'超级用户','op','<p style=\"text-align: center;\"><img src=\"http://localhost:8080//ueditor/jsp/upload/image/20190322/1553217313583011160.jpg\" title=\"1553217313583011160.jpg\" alt=\"img_14.jpg\"/></p>','2019-03-22 01:15:33','2019-03-22 01:15:33','1'),(30,'超级用户','ee','<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom: 2px solid rgb(204, 204, 204); padding: 0px 4px 0px 0px; text-align: center; margin: 0px 0px 20px;\">hello<br/></h1><p style=\"text-align: center;\"><img src=\"http://localhost:8080//ueditor/jsp/upload/image/20190322/1553222007585002096.jpg\" title=\"1553222007585002096.jpg\" alt=\"img_23.jpg\"/></p>','2019-03-22 02:33:37','2019-03-22 02:33:37','1'),(31,'超级用户','哟','<p style=\"text-align: center;\"><img src=\"http://localhost:8080//ueditor/jsp/upload/image/20190325/1553498435118028327.jpg\" title=\"1553498435118028327.jpg\" alt=\"img_13.jpg\"/></p>','2019-03-25 07:20:42','2019-03-25 07:20:42','1'),(32,'莎士比亚','hy','<p><img src=\"http://localhost:8080//ueditor/jsp/upload/image/20190325/1553505308765008405.jpg\" title=\"1553505308765008405.jpg\" alt=\"img_14.jpg\"/></p>','2019-03-25 09:15:11','2019-03-25 09:15:11','1');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(245) NOT NULL,
  `num` int(11) DEFAULT '0',
  `delete_status` varchar(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,'iphone',2000,'2'),(2,'ipad',301,'1'),(3,'wwwwwwwww',48,'1'),(4,'gggggggg',3,'1'),(5,'app',333333333,'1'),(6,'hp',12,'2'),(7,'45',3,'1');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `name` varchar(145) DEFAULT NULL,
  `content` text,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,5,'ha','真不怎么样','2019-03-22 07:07:07'),(2,5,'user','挺不错','2019-03-22 07:07:07'),(3,5,'超级用户','comment','2019-03-25 05:48:19'),(4,5,'超级用户','qie','2019-03-25 05:51:25'),(10,5,'超级用户','ha','2019-03-25 06:04:18'),(11,5,'超级用户','嘿嘿','2019-03-25 06:04:31'),(12,5,'超级用户','哟','2019-03-25 06:05:58'),(13,5,'超级用户','手动','2019-03-25 06:14:39'),(14,5,'超级用户','jioo','2019-03-25 06:17:22'),(15,5,'超级用户','放入','2019-03-25 06:30:29'),(16,5,'超级用户','放入','2019-03-25 06:33:03'),(17,31,'超级用户','方法','2019-03-25 07:20:56'),(18,31,'超级用户','刚刚','2019-03-25 07:21:00'),(19,31,'超级用户','海域','2019-03-25 07:21:04'),(20,32,'莎士比亚','fffffff','2019-03-25 09:15:23'),(21,31,'就看看列表','eeee','2019-03-25 09:31:24');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1245) NOT NULL,
  `imgurl` varchar(245) NOT NULL,
  `author` varchar(145) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (5,'当我年轻的时候，我梦想改变这个世界；当我成熟以后，我发现我不能够改变这个世界，我将目光缩短了些，决定只改变我的国家；当我进入暮年以后，我发现我不能够改变我们当我现在躺变我的变这个世界。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553046388081018636.jpg','超级用户','2019-03-20 01:46:42','2019-03-20 02:03:54','1'),(6,'当我年轻的时候，我梦想改变这个世界；当我成熟以后，','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553048991860094522.jpg','超级用户','2019-03-20 02:29:57','2019-03-20 02:29:57','1'),(7,'能够改变这个世界，我将目光缩短了些，决定只改变我的国家；当我进入暮年以后，我发现我不能够改变我们当我现在躺','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553049280079090981.jpg','超级用户','2019-03-20 02:34:43','2019-03-20 02:34:43','1'),(8,'能够改变这个世界，我将目光缩短了些，决定只改变我的国家；当我进入暮年以后，我发现我不能够改变我们当我现在躺','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553049288748016821.jpg','超级用户','2019-03-20 02:34:51','2019-03-20 02:34:51','1'),(9,'能够改变这个世界，我将目光缩短了些，决定只改变我的国家；当我进入暮年以后，我发现我不能够改变我们当我现在躺','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553049295869094887.jpg','超级用户','2019-03-20 02:34:58','2019-03-20 02:34:58','1'),(10,'能够改变这个世界，我将目光缩短了些，决定只改变我的国家；当我进入暮年以后，我发现我不能够改变我们当我现在躺','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553049301286027918.jpg','超级用户','2019-03-20 02:35:02','2019-03-20 02:35:02','1'),(11,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。那接下来我们就看Flexbox怎么实现瀑布流布局。如果你从未接触过Flexbox相关的属性，那建议你点击这里阅读。如果你觉得这里信息量过于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051645012007472.jpg','超级用户','2019-03-20 03:14:34','2019-03-20 03:14:34','1'),(12,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。那接下来我们就看Flexbox怎么实现瀑布流布局。如果你从未接触过Flexbox相关的属性，那建议你点击这里阅读。如果你觉得这里信息量过于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051679030075538.jpg','超级用户','2019-03-20 03:14:40','2019-03-20 03:14:40','1'),(13,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。那接下来我们就看Flexbox怎么实现瀑布流布局。如果你从未接触过Flexbox相关的属性，那建议你点击这里阅读。如果你觉得这里信息量过于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051684030011177.jpg','超级用户','2019-03-20 03:14:45','2019-03-20 03:14:45','1'),(14,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。那接下来我们就看Flexbox怎么实现瀑布流布局。如果你从未接触过Flexbox相关的属性，那建议你点击这里阅读。如果你觉得这里信息量过于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051688066093745.jpg','超级用户','2019-03-20 03:14:48','2019-03-20 03:14:48','1'),(15,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。那接下来我们就看Flexbox怎么实现瀑布流布局。如果你从未接触过Flexbox相关的属性，那建议你点击这里阅读。如果你觉得这里信息量过于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051691593083443.jpg','超级用户','2019-03-20 03:14:53','2019-03-20 03:14:53','1'),(16,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051698781022750.jpg','超级用户','2019-03-20 03:15:04','2019-03-20 03:15:04','1'),(17,'Flexbox布局到今天已经是使用非常广泛的，也算是很成熟的一个特性。于太多，那强列建议你阅读下面几篇文章，阅读完之后你对Flexbox相关属性会有一个彻底的了解。','http://localhost:8080//ueditor/jsp/upload/image/20190320/1553051712394088385.jpg','超级用户','2019-03-20 03:15:14','2019-03-20 03:15:14','1'),(18,'额鹅鹅鹅','http://localhost:8080//ueditor/jsp/upload/image/20190321/1553148535658055531.jpg','超级用户','2019-03-21 06:15:49','2019-03-21 06:15:49','1'),(19,'hei','http://localhost:8080//ueditor/jsp/upload/image/20190325/1553497975179072270.jpg','超级用户','2019-03-25 07:13:02','2019-03-25 07:13:02','1'),(20,'hello','http://localhost:8080//ueditor/jsp/upload/image/20190408/1554715562381095713.jpg','超级用户','2019-04-08 09:26:08','2019-04-08 09:26:08','1'),(21,'here you are.','http://localhost:8080//ueditor/jsp/upload/image/20190408/1554715584409016957.jpg','超级用户','2019-04-08 09:26:34','2019-04-08 09:26:34','1'),(22,'','http://localhost:8080//ueditor/jsp/upload/image/20190409/1554779410624041221.jpg','超级用户','2019-04-09 03:10:12','2019-04-09 03:10:12','1'),(23,'rr','http://localhost:8080//ueditor/jsp/upload/image/20190509/1557393513924059889.jpg','超级用户','2019-05-09 09:18:37','2019-05-09 09:18:37','1'),(24,'嗯嗯呃','http://localhost:8080//ueditor/jsp/upload/image/20190626/1561537950507093170.gif','超级用户','2019-06-26 08:32:35','2019-06-26 08:32:35','1'),(25,'','http://localhost:8080//ueditor/jsp/upload/image/20190626/1561537991586055914.gif','超级用户','2019-06-26 08:33:14','2019-06-26 08:33:14','1'),(26,'','http://localhost:8080//ueditor/jsp/upload/image/20190626/1561539328755023599.gif','超级用户','2019-06-26 08:55:30','2019-06-26 08:55:30','1'),(27,'','http://localhost:8080//ueditor/jsp/upload/image/20190626/1561539983867030476.gif','超级用户','2019-06-26 09:06:47','2019-06-26 09:06:47','1'),(28,'','http://localhost:8080//ueditor/jsp/upload/image/20190626/1561539983867030476.gif','超级用户','2019-06-26 09:07:16','2019-06-26 09:07:16','1');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (101,'article','文章管理','article:list','列表',1),(102,'article','文章管理','article:add','新增',2),(103,'article','文章管理','article:update','修改',2),(104,'article','文章管理','article:delete','删除',2),(105,'editor','文章编辑','editor:add','新增',1),(106,'show','文章展示','show:list','显示',1),(110,'wall','图片/展示','wall:show','显示',1),(120,'upload','图片/上传','upload:show','显示',1),(201,'cart','购物车','cart:list','列表',1),(202,'cart','购物车','cart:add','新增',2),(203,'cart','购物车','cart:update','修改',2),(204,'cart','购物车','cart:delete','删除',2),(205,'cart','购物车','cart:addOne','商品数量增一',2),(206,'cart','购物车','cart:decOne','商品数量减一',2),(601,'user','用户','user:list','列表',1),(602,'user','用户','user:add','新增',2),(603,'user','用户','user:update','修改',2),(701,'role','角色权限','role:list','列表',1),(702,'role','角色权限','role:add','新增',2),(703,'role','角色权限','role:update','修改',2),(704,'role','角色权限','role:delete','删除',2),(3001,'button','按钮','button:show','显示',1),(3002,'layout','布局','layout:show','显示',1),(3003,'slot','插槽','slot:show','显示',1),(3004,'prop','属性','prop:show','显示',1);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','2017-11-22 08:24:34','2017-11-22 08:24:52','1'),(2,'作家','2017-11-22 08:24:34','2017-11-22 08:24:52','1'),(3,'程序员','2017-11-22 08:28:47','2017-11-22 08:28:47','1'),(4,'test','2018-11-30 04:20:28','2018-11-30 04:21:22','2'),(5,'ha','2018-11-30 04:21:36','2018-11-30 04:21:36','1');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 1有效     2无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (1,2,101,'2017-11-22 08:26:21','2017-11-22 08:26:32','1'),(2,2,102,'2017-11-22 08:26:21','2019-02-12 06:19:42','2'),(5,2,602,'2017-11-22 08:28:28','2019-02-12 06:19:42','2'),(6,2,601,'2017-11-22 08:28:28','2019-03-25 08:26:18','2'),(7,2,603,'2017-11-22 08:28:28','2019-02-12 06:19:42','2'),(8,2,703,'2017-11-22 08:28:28','2019-02-12 06:19:42','2'),(9,2,701,'2017-11-22 08:28:28','2019-03-25 08:26:18','2'),(10,2,702,'2017-11-22 08:28:28','2019-02-12 06:19:42','2'),(11,2,704,'2017-11-22 08:28:31','2019-02-12 06:19:42','2'),(12,2,103,'2017-11-22 08:28:31','2019-02-12 06:19:42','2'),(13,3,601,'2017-11-22 08:28:47','2019-03-25 08:26:38','2'),(14,3,701,'2017-11-22 08:28:47','2019-03-25 08:26:38','2'),(15,3,702,'2017-11-22 08:35:01','2019-03-25 08:26:38','2'),(16,3,704,'2017-11-22 08:35:01','2019-03-25 08:26:38','2'),(17,3,102,'2017-11-22 08:35:01','2019-03-25 09:11:53','2'),(18,3,101,'2017-11-22 08:35:01','2017-11-22 08:35:01','1'),(19,3,603,'2017-11-22 08:35:01','2019-03-25 08:26:38','2'),(20,4,601,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(21,4,602,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(22,4,603,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(23,4,701,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(24,4,702,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(25,4,703,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(26,4,704,'2018-11-30 04:20:29','2018-11-30 04:21:22','2'),(27,5,601,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(28,5,602,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(29,5,603,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(30,5,701,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(31,5,702,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(32,5,703,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(33,5,704,'2018-11-30 04:21:36','2018-12-04 03:20:17','2'),(34,5,101,'2018-12-04 03:20:17','2019-03-25 09:12:23','2'),(35,5,102,'2018-12-04 03:20:17','2019-03-25 09:12:23','2'),(36,5,103,'2018-12-04 03:20:17','2019-03-25 09:12:23','2'),(37,5,201,'2018-12-04 03:20:17','2019-03-25 09:12:23','2'),(38,5,202,'2018-12-04 03:20:17','2019-03-25 09:12:23','2'),(39,5,203,'2018-12-04 03:20:17','2019-03-25 09:12:23','2'),(40,2,3001,'2019-02-12 06:19:42','2019-02-12 08:10:12','2'),(41,2,3002,'2019-02-12 06:19:42','2019-02-12 08:10:12','2'),(42,2,201,'2019-02-12 06:19:42','2019-03-25 09:12:08','2'),(43,5,3001,'2019-02-12 06:20:53','2019-02-12 06:20:53','1'),(44,5,3002,'2019-02-12 06:20:53','2019-02-12 06:20:53','1'),(45,2,102,'2019-02-12 08:10:12','2019-02-12 08:10:12','1'),(46,2,103,'2019-02-12 08:10:12','2019-02-12 08:10:12','1'),(47,2,104,'2019-02-12 08:10:12','2019-02-12 08:10:12','1'),(48,2,202,'2019-02-12 08:10:12','2019-03-25 09:12:08','2'),(49,2,203,'2019-02-12 08:10:12','2019-03-25 09:12:08','2'),(50,2,204,'2019-02-12 08:10:12','2019-03-25 09:12:08','2'),(51,2,602,'2019-02-12 08:10:12','2019-03-25 08:26:18','2'),(52,2,603,'2019-02-12 08:10:12','2019-03-25 08:26:18','2'),(53,2,704,'2019-02-12 08:10:12','2019-03-25 08:26:18','2'),(54,2,703,'2019-02-12 08:10:12','2019-03-25 08:26:18','2'),(55,2,702,'2019-02-12 08:10:12','2019-03-25 08:26:18','2'),(56,5,3003,'2019-02-27 02:16:25','2019-02-27 02:16:25','1'),(57,5,3004,'2019-02-27 02:16:25','2019-02-27 02:16:25','1'),(58,3,106,'2019-03-25 09:11:53','2019-03-25 09:11:53','1'),(59,2,105,'2019-03-25 09:12:08','2019-03-25 09:12:08','1'),(60,2,106,'2019-03-25 09:12:08','2019-03-25 09:12:08','1'),(61,2,110,'2019-03-25 09:24:28','2019-03-25 09:24:28','1'),(62,2,120,'2019-03-25 09:24:28','2019-03-25 09:24:28','1');
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  `avatar` varchar(5545) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10009 DEFAULT CHARSET=utf8 COMMENT='运营后台用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (10003,'admin','e10adc3949ba59abbe56e057f20f883e','超级用户',1,'2017-10-30 03:52:38','2019-07-04 07:28:16','1','http://localhost:8080//ueditor/jsp/upload/image/20190704/1562225292477073072.jpg'),(10004,'user','e10adc3949ba59abbe56e057f20f883e','莎士比亚',2,'2017-10-30 08:13:02','2019-03-25 08:07:27','1',NULL),(10005,'aaa','e10adc3949ba59abbe56e057f20f883e','abba',1,'2017-11-15 06:02:56','2019-03-25 07:52:52','1',NULL),(10007,'test','e10adc3949ba59abbe56e057f20f883e','就看看列表',3,'2017-11-22 08:29:41','2019-03-25 07:52:52','1',NULL),(10008,'ha','e10adc3949ba59abbe56e057f20f883e','学习页面',5,'2018-11-30 04:22:08','2019-03-25 09:29:45','1',NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `text` varchar(1245) NOT NULL,
  `done` tinyint(1) NOT NULL,
  `date` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
INSERT INTO `todo` VALUES (18,'张山','6666666',0,'2018-07-05 10:10:55'),(20,'张山','rrrrrr ',0,'2018-07-10 08:52:38'),(22,'hongguosong','yyyyyyyyy',0,'2018-07-10 12:27:03'),(23,'hongguosong','ttttttt',0,'2018-07-10 12:27:12'),(24,'hongguosong','ggggggggggg',0,'2018-07-10 15:31:25'),(29,'admin','iiiiiiiget',1,'2018-11-28 16:03:46'),(30,'admin','uuuuuuuuuuu',1,'2018-11-28 17:08:09'),(31,'admin','ffffffffff',1,'2018-11-29 16:26:03'),(32,'admin','fg',1,'2019-06-24 14:03:18');
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-10 16:17:08

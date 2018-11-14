/**
drop database if exists cloud_shop ;
create database cloud_shop charset utf8 ;
use cloud_shop ;
*/

create table TC_Customer (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, birthday datetime(6), name varchar(20), primary key (id)) ;
create table TC_YG (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, ygType varchar(10) not null, zd1 varchar(255), zd2 varchar(255), zd3 varchar(255), zd4 varchar(255), zd5 varchar(255), customerId bigint, ygsId bigint, primary key (id)) ;
create table TC_YGMX (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, c_add varchar(16), cyl varchar(16), eyeType varchar(10) not null, jd varchar(16), js varchar(16), slj varchar(16), sph varchar(16), sz varchar(16), tg varchar(16), tj varchar(16), useType varchar(10) not null, xt bit, ztj varchar(16), zw varchar(16), zy bit, ygId bigint, ygmx_ext_id bigint, primary key (id)) ;
create table TC_YGMX_Ext (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, colorFeel varchar(40), fun_ac_a varchar(40), funacuity varchar(40), funcm40 varchar(40), funm5 varchar(40), funword4 varchar(40), jm varchar(40), jzt varchar(40), ygmxId bigint, primary key (id)) ;
create table TG_Goods (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, kcjb varchar(20), name varchar(40) not null, priceIn double precision, priceOut double precision, brandId bigint, colorId bigint, kindId bigint, versionId bigint, primary key (id)) ;
create table TG_Goods_Ext (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, attr1 varchar(40), attr10 varchar(40), attr11 varchar(40), attr12 varchar(40), attr13 varchar(40), attr14 varchar(40), attr15 varchar(40), attr2 varchar(40), attr3 varchar(40), attr4 varchar(40), attr5 varchar(40), attr6 varchar(40), attr7 varchar(40), attr8 varchar(40), attr9 varchar(40), goodsId bigint, primary key (id)) ;
create table TG_Kind (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, attr1 varchar(255), attr2 varchar(255), attr3 varchar(255), attr4 varchar(255), fid bigint, lens bit, name varchar(45), sw bit, xq bit, primary key (id)) ;
create table TG_Kind_Setup (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, defVal varchar(255), htmlType varchar(10), msg varchar(30), name varchar(10), kindId bigint, primary key (id)) ;
create table TK_KC (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, can_kc bigint, ci_kc bigint, cyl float, priceIn double precision, priceOut double precision, sph float, xy_kc bigint, zp_kc bigint, comId bigint, goodsId bigint, storeId bigint, primary key (id)) ;
create table TSL_Cart (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, name varchar(40) not null, userId bigint, primary key (id)) ;
create table TSL_CartGoods (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, goodsNum bigint, cartId bigint, goodsId bigint, primary key (id)) ;
create table TSL_Sell (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, pickTime datetime(6), buy_storeId bigint, customerId bigint, pickupStoreId bigint, userId bigint, primary key (id)) ;
create table TSL_SellGoods (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, priceOutNow double precision, priceOutSrc double precision, printIn double precision, qk double precision, goodsId bigint, kcId bigint, sellGoodsId bigint, primary key (id)) ;
create table TSL_SellGroup (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, bz varchar(255), groupType varchar(10) not null, lcwz varchar(20) not null, ygd_photo varchar(255), ygs_bm varchar(20), ygs_xm varchar(20), sellId bigint, ygId bigint, primary key (id)) ;
create table TSYS_SetupCom (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, ext1 varchar(100), ext2 varchar(100), ext3 varchar(100), ext4 varchar(100), ext5 varchar(100), name varchar(30) not null, note varchar(200) not null, val varchar(100) not null, comId bigint, primary key (id)) ;
create table TU_Com (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, addr varchar(255), adminName varchar(20), adminTel varchar(20), cp_kc bit, fid bigint, jg_Center bit, jp_kc bit, kind varchar(20) not null, name varchar(80) not null, tel varchar(20), zy bit, primary key (id)) ;
create table TU_ComExt (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, adminPassword varchar(20) not null, amdinLoginName varchar(20) not null, dq_jzy varchar(20) not null, test bit not null, ymjz bit not null, ymjz_riqi varchar(20) not null, comId bigint not null, primary key (id)) ;
create table TU_Fun (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, c_group varchar(18) not null, fid bigint not null, htmlPath varchar(255), iconPath varchar(255), name varchar(30) not null, studyPath varchar(200), viewPath varchar(255), primary key (id)) ;
create table TU_Message (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, messageType varchar(12) not null, msg varchar(500) not null, title varchar(50) not null, readerId bigint, primary key (id)) ;
create table TU_Role (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, name varchar(40), comId bigint, primary key (id)) ;
create table TU_Role_Fun (roleId bigint not null, funId bigint not null) ;
create table TU_User (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, addr varchar(120), brithday datetime(6), loginName varchar(40) not null, name varchar(80) not null, password varchar(36) not null, phone varchar(20), photo varchar(120), sex varchar(4), xue_li varchar(20), zhi_wu varchar(20), comId bigint, roleId bigint, storeId bigint, primary key (id)) ;
create table TU_UserExt (id bigint not null auto_increment, b_isDel Boolean default false not null, b_wtime datetime(6) not null, gq bit, userId bigint, primary key (id)) ;






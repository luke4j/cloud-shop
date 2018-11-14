/**
drop database if exists cloud_shop ;
create database cloud_shop charset utf8 ;
use cloud_shop ;
*/

create table tc_customer (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, birthday datetime(6), name varchar(20), primary key (id)) ;
create table tc_yg (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, yg_type varchar(10) not null, zd1 varchar(255), zd2 varchar(255), zd3 varchar(255), zd4 varchar(255), zd5 varchar(255), customer_id bigint, ygs_id bigint, primary key (id)) ;
create table tc_ygmx (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, c_add varchar(16), cyl varchar(16), eye_type varchar(10) not null, jd varchar(16), js varchar(16), slj varchar(16), sph varchar(16), sz varchar(16), tg varchar(16), tj varchar(16), use_type varchar(10) not null, xt bit, ztj varchar(16), zw varchar(16), zy bit, yg_id bigint, ygmx_ext_id bigint, primary key (id)) ;
create table tc_ygmx_ext (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, color_feel varchar(40), fun_ac_a varchar(40), funacuity varchar(40), funcm40 varchar(40), funm5 varchar(40), funword4 varchar(40), jm varchar(40), jzt varchar(40), ygmx_id bigint, primary key (id)) ;
create table tg_goods (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, kcjb varchar(20), name varchar(40) not null, price_in double precision, price_out double precision, brand_id bigint, color_id bigint, kind_id bigint, version_id bigint, primary key (id)) ;
create table tg_goods_ext (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, attr1 varchar(40), attr10 varchar(40), attr11 varchar(40), attr12 varchar(40), attr13 varchar(40), attr14 varchar(40), attr15 varchar(40), attr2 varchar(40), attr3 varchar(40), attr4 varchar(40), attr5 varchar(40), attr6 varchar(40), attr7 varchar(40), attr8 varchar(40), attr9 varchar(40), goods_id bigint, primary key (id)) ;
create table tg_kind (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, attr1 varchar(255), attr2 varchar(255), attr3 varchar(255), attr4 varchar(255), fid bigint, lens bit, name varchar(45), sw bit, xq bit, primary key (id)) ;
create table tg_kind_setup (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, def_val varchar(255), html_type varchar(10), msg varchar(30), name varchar(10), kind_id bigint, primary key (id)) ;
create table tk_kc (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, can_kc bigint, ci_kc bigint, cyl float, price_in double precision, price_out double precision, sph float, xy_kc bigint, zp_kc bigint, com_id bigint, goods_id bigint, store_id bigint, primary key (id)) ;
create table tsl_cart (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, name varchar(40) not null, user_id bigint, primary key (id)) ;
create table tsl_cart_goods (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, goods_num bigint, cart_id bigint, goods_id bigint, primary key (id)) ;
create table tsl_sell (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, pick_time datetime(6), buy_store_id bigint, customer_id bigint, pickup_store_id bigint, user_id bigint, primary key (id)) ;
create table tsl_sell_goods (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, price_out_now double precision, price_out_src double precision, print_in double precision, qk double precision, goods_id bigint, kc_id bigint, sell_goods_id bigint, primary key (id)) ;
create table tsl_sell_group (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, bz varchar(255), group_type varchar(10) not null, lcwz varchar(20) not null, ygd_photo varchar(255), ygs_bm varchar(20), ygs_xm varchar(20), sell_id bigint, yg_id bigint, primary key (id)) ;
create table tsys_setup_com (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, ext1 varchar(100), ext2 varchar(100), ext3 varchar(100), ext4 varchar(100), ext5 varchar(100), name varchar(30) not null, note varchar(200) not null, val varchar(100) not null, com_id bigint, primary key (id)) ;
create table tu_com (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, addr varchar(255), admin_name varchar(20), admin_tel varchar(20), cp_kc bit, fid bigint, jg_center bit, jp_kc bit, kind varchar(20) not null, name varchar(80) not null, tel varchar(20), zy bit, primary key (id)) ;
create table tu_com_ext (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, admin_password varchar(20) not null, amdin_login_name varchar(20) not null, dq_jzy varchar(20) not null, test bit not null, ymjz bit not null, ymjz_riqi varchar(20) not null, com_id bigint not null, primary key (id)) ;
create table tu_fun (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, c_group varchar(18) not null, fid bigint not null, html_path varchar(255), icon_path varchar(255), name varchar(30) not null, study_path varchar(200), view_path varchar(255), primary key (id)) ;
create table tu_message (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, message_type varchar(12) not null, msg varchar(500) not null, title varchar(50) not null, reader_id bigint, primary key (id)) ;
create table tu_role (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, name varchar(40), com_id bigint, primary key (id)) ;
create table tu_role_fun (role_id bigint not null, fun_id bigint not null) ;
create table tu_user (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, addr varchar(120), brithday datetime(6), login_name varchar(40) not null, name varchar(80) not null, password varchar(36) not null, phone varchar(20), photo varchar(120), sex varchar(4), xue_li varchar(20), zhi_wu varchar(20), com_id bigint, role_id bigint, store_id bigint, primary key (id)) ;
create table tu_user_ext (id bigint not null auto_increment, b_is_del Boolean default false not null, b_wtime datetime(6) not null, gq bit, user_id bigint, primary key (id)) ;







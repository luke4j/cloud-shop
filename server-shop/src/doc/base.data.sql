/**站点*/
INSERT INTO tu_com (id, b_is_del, b_wtime, addr, admin_name, admin_tel, cp_kc, jg_center, jp_kc, kind, name, tel, zy) VALUES
('1', '0', '2018-01-01', '北京', 'luke', '18613806246', 0,  0, 0, '总公司', 'luke-club', '18613806246', 1) ;
INSERT INTO tu_com (id, b_is_del, b_wtime, addr, admin_name, admin_tel, cp_kc, fid, jg_center, jp_kc, kind, name, tel, zy) VALUES
('2', '0', '2018-01-01', '北京', 'luke', '18613806246', 0, 1, 0, 0, '分公司', 'luke-1-club', '18613806246', 1) ;
INSERT INTO tu_com (id, b_is_del, b_wtime, addr, admin_name, admin_tel, cp_kc, fid, jg_center, jp_kc, kind, name, tel, zy) VALUES
('3', '0', '2018-01-01', '北京', 'luke', '18613806246', 1, 2, 1, 1, '站点', 'luke-1-club-shp', '18613806246', 1);

/**角色*/
INSERT INTO tu_role (id, b_is_del, b_wtime, name, com_id) VALUES ('1', '0', '2018-01-01', 'dev', '1');
/**功能*/
INSERT INTO tu_fun VALUES (1,0,'2018-06-14 17:00:47.000000','Root',0,NULL,NULL,'公司',NULL,''),(2,0,'2018-06-14 17:00:47.000000','Root',1,NULL,NULL,'公司业务',NULL,'app/user/com.view.js'),(3,0,'2018-06-14 17:00:47.000000','Root',1,NULL,NULL,'程序功能',NULL,'app/user/fun.view.js'),(4,0,'2018-06-14 17:00:47.000000','user',0,NULL,NULL,'用户管理',NULL,''),(5,0,'2018-06-14 17:00:47.000000','user',4,NULL,NULL,'用户',NULL,'app/user/user.view.js'),(6,0,'2018-06-14 17:00:47.000000','user',4,NULL,NULL,'角色',NULL,'app/user/role.view.js'),(7,0,'2018-06-14 17:00:47.000000','user',4,NULL,NULL,'站点',NULL,'app/user/store.view.js'),(8,0,'2018-06-14 17:00:47.000000','goods',0,NULL,NULL,'商品信息',NULL,''),(9,0,'2018-06-14 17:00:47.000000','goods',8,NULL,NULL,'商品属性',NULL,'app/goods/goodsTree.view.js'),(10,0,'2018-06-14 17:00:47.000000','goods',8,NULL,NULL,'商品库存',NULL,'app/kc/goods.kc.view.js'),(11,0,'2018-06-14 17:00:47.000000','goods',8,NULL,NULL,'商品价格',NULL,'app/goods/goodsPrice.view.js'),(12,0,'2018-06-14 17:00:47.000000','goods',8,NULL,NULL,'站点价格',NULL,'app/goods/goodsStorePrice.view.js');
/** 角色与权限关系*/
INSERT INTO tu_role_fun VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12);


/**开发用户*/
INSERT INTO tu_user (id, b_is_del, b_wtime, addr, brithday, login_name, name, password, phone, sex, xue_li, zhi_wu, com_id,role_id,store_id) VALUES
('1', '0', '2018-01-01', '北京', '1984-01-16', 'cc', 'luke', 'E0323A9039ADD2978BF5B49550572C7C', '18613806246', '男', '小学', 'CEO', '1',1,3);




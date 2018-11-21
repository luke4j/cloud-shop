/**库存商品视图*/
drop table v_kc_goods;
create or replace view V_KC_Goods
as
select
kc.id as kcid ,g.id as goodsid,k.id as kindid ,b.id as brandid ,v.id as versionid ,c.id as colorid,kc.comid as comid,kc.storeid as storeid,
g.name as goodsname,g.kcjb,kc.sph as sph, kc.cyl as cyl,com.name as comname,store.name as storename,
kc.pricein ,kc.priceout,kc.zp_kc,kc.can_kc,kc.ci_kc,kc.xy_kc,
k.name as kindname,b.name as brandname,v.name as versionname,c.name as colorname,
ge.attr1,ge.attr2,ge.attr3,ge.attr4,ge.attr5,ge.attr6,ge.attr7,ge.attr8,ge.attr9,ge.attr10,ge.attr11,ge.attr12,ge.attr13,ge.attr14,ge.attr15
from tk_kc kc
left join tg_goods g on kc.goodsid = g.id
left join tg_kind k on g.kindid = k.id
left join tg_kind b on g.brandid = b.id
left join tg_kind v on g.versionid = v.id
left join tg_kind c on g.colorid = c.id
left join tg_goods_ext ge on ge.goodsid = g.id
left join tu_com com on kc.comid = com.id
left join tu_com store on kc.storeid = store.id ;
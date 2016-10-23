-- Admin
CREATE TABLE admin_user(
  id int PRIMARY KEY auto_increment comment'主键',
  account VARCHAR(50) comment'账户名',
  cipher VARCHAR(50) comment'密码',
  token VARCHAR(50) comment'身份标识码',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment'创建时间',
  info int(10) comment'信息'
)charset=utf8, engine=innodb;
CREATE index index_info ON admin_user(info, create_time, cipher);

CREATE TABLE admin_user_info(
  id int PRIMARY KEY auto_increment comment'主键',
  user_name VARCHAR(50) comment'昵称',
  sex VARCHAR (10) comment'性别',
  portrait_url VARCHAR(300) comment'头像URL'
)charset=utf8, engine=innodb;

create table admin_statics (
  id int PRIMARY KEY auto_increment comment'主键',
  date date comment'日期',
  visit int(20) comment'访问人次'
)charset=utf8, engine=innodb;

CREATE table admin_operate_log (
  id int PRIMARY KEY auto_increment comment'主键',
  operation VARCHAR(20) UNIQUE comment'执行的操作',
  user int(10) comment'执行操作的人',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;

-- Blog
CREATE TABLE blog_article(
  id int PRIMARY KEY auto_increment comment'主键',
  title VARCHAR(50) comment'标题，不超过五十字',
  digest VARCHAR(300) comment'摘要，不超过三百字',
  content text comment'正文',
  recover_url VARCHAR(300) comment'封面URL',
  author_id int(10) comment'作者',
  visit_count int(20) comment'访问人数',
  category tinyint(8) comment'分类',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;
CREATE index index_category ON blog_article(category);
CREATE index index_author_id ON blog_article(author_id);

CREATE TABLE blog_article_category(
  id int PRIMARY KEY auto_increment comment'主键',
  name VARCHAR(50) comment'标题,不超过五十字',
  recover_url VARCHAR(300) comment'封面URL',
  digest VARCHAR(300) comment'摘要，不超过三百字',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;

CREATE TABLE blog_word (
  id int PRIMARY KEY auto_increment comment'主键',
  title VARCHAR(50) comment'标题，不超过五十字',
  content VARCHAR(500) comment'摘要，不超过三百字',
  recover_url VARCHAR(300) comment'封面URL',
  author_id int(10) comment'作者',
  category tinyint(8) comment'分类，0代表心情，1代表后台留言',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;

-- Test
insert into blog_word (title, content, author_id, category) VALUES ('心情不错', '今天呱呱公主来北京啦，好开心', 1, 1);
insert into admin_statics (date, visit) VALUES ('2016-10-21', 21);
insert into admin_operate_log (operation, user) VALUES ('添加留言', 1);
insert into admin_user (account, cipher, token, info) VALUES ('wd', 123, 'aAJgNAsIWsSaseSEadDdgNXAGsQWFGAKSD', 1);
insert into admin_user (account, cipher, token, info) VALUES ('wXd', 533, 'aAJgNSWsSaSdsSDGsQWFgGAKgSDgDdgDSg', 2);
insert into admin_user_info (user_name, sex) VALUES ('王兑', '男');
insert into admin_user_info (user_name, sex) VALUES ('XD.Wang', '男');
insert into blog_article (title, digest, content, recover_url, author_id, visit_count, category) VALUES ('勇气', '好文章', '时常感觉，四季里春秋格外的短。还未察觉到花实正盛，换幕的大雨便猝然而来，将世界隔绝于水雾之外。翌日，雾幕初开，窗外若非日炙蝉鸣，便是树寒凄切。春秋总这样倏然而别，轻轻挪步，云彩都带不走一片。
春秋容易绽开在回忆里，在言谈中扎下深根。而冬夏，不及春秋那样铺满一地。春秋，写在岁月的心里。生活如冬夏，人生若春秋。
四年时光，最后一年的二三事，写给自己。它是一场雨幕，分割了两个颜色不同的天空。
', '', 1, 533, 1);
insert into blog_article_category (name,digest) VALUES ('心情随笔','没有摘要');
insert into blog_article_category (name,digest) VALUES ('技术博客','没有摘要');
insert into blog_article_category (name,digest) VALUES ('网上文摘','没有摘要');
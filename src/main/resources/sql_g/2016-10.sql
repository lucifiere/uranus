-- Admin
CREATE TABLE admin_user(
  id int PRIMARY KEY auto_increment comment'主键',
  account VARCHAR(50) comment'账户名',
  cipher VARCHAR(50) comment'密码',
  token VARCHAR(50) comment'身份标识码',
  create_time datetime DEFAULT CURRENT_TIMESTAMP comment'创建时间',
  info int(10) comment'信息'
)charset=utf8, engine=innodb;
CREATE index index_info ON admin_user(info);

CREATE TABLE admin_user_info(
  id int PRIMARY KEY auto_increment comment'主键',
  user_name VARCHAR(50) comment'昵称',
  sex VARCHAR (10) comment'性别',
  portrait_url VARCHAR(300) comment'头像URL'
)charset=utf8, engine=innodb;

create table admin_statics (
  id int PRIMARY KEY auto_increment comment'主键',
  date date comment'日期',
  visit int(20) comment'访问人次',
)charset=utf8, engine=innodb;

CREATE table admin_operate_log (
  id int PRIMARY KEY auto_increment comment'主键',
  operation VARCHAR(20) UNIQUE comment'执行的操作',
  user int(10) comment'执行操作的人',
  create_time datetime DEFAULT CURRENT_TIMESTAMP comment'操作时间'
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
  create_time datetime DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;
CREATE index index_category ON blog_article(category);
CREATE index index_author_id ON blog_article(author_id);

CREATE TABLE blog_article_category(
  id int PRIMARY KEY auto_increment comment'主键',
  name VARCHAR(50) comment'标题,不超过五十字',
  recover_url VARCHAR(300) comment'封面URL',
  digest VARCHAR(300) comment'摘要，不超过三百字',
  create_time datetime DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;

CREATE TABLE blog_word (
  id int PRIMARY KEY auto_increment comment'主键',
  title VARCHAR(50) comment'标题，不超过五十字',
  content VARCHAR(500) comment'摘要，不超过三百字',
  recover_url VARCHAR(300) comment'封面URL',
  author_id int(10) comment'作者',
  category tinyint(8) comment'分类，0代表心情，1代表后台留言',
  create_time datetime DEFAULT CURRENT_TIMESTAMP comment'创建时间'
)charset=utf8, engine=innodb;

-- Test
insert into blog_word (title, content, author_id, category) VALUES ('心情不错', '今天呱呱公主来北京啦，好开心', 1, 1)
insert into admin_statics (date, visit) VALUES ('2016-10-21', 21)
insert into admin_operate_log (operation, user) VALUES ('添加留言', 1)
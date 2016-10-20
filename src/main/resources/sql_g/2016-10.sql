CREATE TABLE admin_user(
  id int PRIMARY KEY auto_increment comment'主键',
  account VARCHAR(50) comment'账户名',
  cipher VARCHAR(50) comment'密码',
  create_time datetime DEFAULT CURRENT_TIMESTAMP comment'创建时间',
  info int(10) comment'信息'
)charset=utf8, engine=innodb;
CREATE index index_info ON admin_user(info);

CREATE TABLE admin_user_info(
  id int PRIMARY KEY auto_increment comment'主键',
  user_name VARCHAR(50) comment'昵称',
  sex tinyint(1) comment'性别',
  portrait_url VARCHAR(300) comment'头像URL'
)charset=utf8, engine=innodb;

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
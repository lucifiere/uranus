CREATE TABLE wd_test(
  id int auto_increment PRIMARY KEY comment'主键',
  des VARCHAR(60)
)engine=innodb

CREATE TABLE wd_mybatis_test(
  id int auto_increment PRIMARY KEY comment'主键',
  des VARCHAR(60),
  rank int(50),
  status tinyint(1),
  date_time datetime DEFAULT CURRENT_TIMESTAMP
)engine=innodb
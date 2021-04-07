create  table  `computer`(
    `id` int auto_increment primary key ,
    `ip` varchar(255)  ,
    `c_status` char(10) ,
    `current_user` int ,
    `create_at` datetime default  now()
)engine = innodb  char set = utf8mb4;

create  table  `base_user`(
    `id` int auto_increment primary key ,
    `wx_id` varchar(255) ,
    `password` char(32) ,
    `real_name` char(32) ,
    `tel`       char(32),
    `role`      char(32)  default  'student' comment 'student 学生用户 admin 管理员'
)engine = innodb  char set = utf8mb4;

create  table  `use_computer_record` (
    `id` int auto_increment primary key  ,
    `c_id` int  comment '计算机编号',
    `u_id` int  comment '用户id',
    `up_time` datetime default  now() comment '上机时间',
    `down_time` datetime  comment '下机时间',
    `total_time` char(32)  comment '上网用时'
)engine = innodb  char set = utf8mb4;
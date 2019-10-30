CREATE TABLE `int001t0` (
  `id` char(36) NOT NULL,
  `rc_date_b` datetime NOT NULL,
  `rc_date_e` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  `team` varchar(50) NOT NULL,
  `sys_type` varchar(10) NOT NULL,
  `mat_type` varchar(20) NOT NULL,
  `bug_type` varchar(6) NOT NULL,
  `bug_degree` varchar(20) NOT NULL,
  `hang_marks` varchar(2000),
  `ma_user` varchar(10) NOT NULL,
  `ld_user` varchar(10) NOT NULL,
  `fa_user` varchar(20) NOT NULL,
  `main_plan` varchar(2000),
  `Program_list` varchar(20),
  `data_list` varchar(20),
  `main_marks` varchar(2000),
  `ins_date` DATE,
  `upd_date` DATE,
  `time` int default '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
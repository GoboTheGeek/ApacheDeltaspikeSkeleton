CREATE USER 'skel'@'%';
ALTER USER 'skel'@'%' IDENTIFIED BY 'XXXXXX' ;
CREATE DATABASE `skelbase` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
GRANT Delete ON skelbase.* TO 'skel'@'%';
GRANT Insert ON skelbase.* TO 'skel'@'%';
GRANT Select ON skelbase.* TO 'skel'@'%';
GRANT Update ON skelbase.* TO 'skel'@'%';

CREATE TABLE skelbase.skel_user (
	id varchar(36) NULL,
	login varchar(50) NULL,
	password varchar(128) NULL,
	registration TIMESTAMP NULL,
	lastLogin TIMESTAMP NULL,
	enabled TINYINT(1) NULL,
	CONSTRAINT skel_user_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
CREATE INDEX skel_user_id_IDX USING BTREE ON skelbase.skel_user (id);
CREATE INDEX skel_user_login_IDX USING BTREE ON skelbase.skel_user (login,enabled);

CREATE TABLE `member` (
	`seq`	number	NULL,
	`id`	varchar(20)	NULL,
	`pw`	varchar(128)	NULL,
	`name`	varchar(20)	NULL,
	`nickname`	varchar(20)	NULL,
	`phone`	varchar(20)	NULL,
	`email`	varchar(100)	NULL,
	`bank`	varchar(100)	NULL,
	`account`	varchar(100)	NULL,
	`money`	number	NULL,
	`grade`	varchar(20)	NULL,
	`blacklist`	varchar(20)	NULL,
	`kakaologin`	varchar(1)	NULL
);
?
CREATE TABLE `chal` (
	`chalseq`	number	NULL,
	`chalName`	varchar(200)	NULL,
	`startDate`	timestamp	NULL,
	`endDate`	timestamp	NULL,
	`personnel`	number	NULL,
	`chalInfo`	varchar(200)	NULL,
	`tag`	varchar(20)	NULL,
	`price`	number	NULL,
	`day`	number	NULL,
	`category`	varchar(20)	NULL
);
?
CREATE TABLE `JoinChal` (
	`seq`	number	NULL,
	`refChalSeq`	number	NULL,
	`refNickname`	varchar(20)	NULL,
	`chalName`	varchar(200)	NULL,
	`startDate`	timestamp	NULL,
	`endDate`	timestamp	NULL,
	`personnel`	number	NULL,
	`chalInfo`	varchar(200)	NULL,
	`tag`	varchar(20)	NULL,
	`chalStat`	varchar(20)	NULL
);
?
CREATE TABLE `pay` (
	`seq`	number	NULL,
	`refChalSeq`	number	NULL,
	`refNickname`	varchar(20)	NULL,
	`payWay`	varchar(200)	NULL,
	`price`	number	NULL,
	`payStat`	varchar(20)	NULL
);
?
CREATE TABLE `ChalImg` (
	`seq`	number	NULL,
	`chalseq`	number	NULL,
	`oriName`	varchar(200)	NULL,
	`sysName`	varchar(200)	NULL
);
?
CREATE TABLE `Certi` (
	`seq`	number	NULL,
	`refNickname`	varchar(20)	NULL,
	`certiTitle`	varchar(200)	NULL,
	`certiContents`	varchar(200)	NULL,
	`certiDate`	timestamp	NULL
);
?
CREATE TABLE `CertiImg` (
	`seq`	number	NULL,
	`parentSeq`	number	NULL,
	`oriName`	varchar(200)	NULL,
	`sysName`	varchar(200)	NULL
);
?
CREATE TABLE `BoardReply` (
	`seq`	number	NULL,
	`refBoardSeq`	number	NULL,
	`writerNickname`	varchar(200)	NULL,
	`write_date`	number	NULL,
	`repContents`	varchar(200)	NULL
);
?
CREATE TABLE `Like` (
	`seq`	number	NULL,
	`refChalSeq`	number	NULL,
	`refNickname`	varchar(200)	NULL
);
?
CREATE TABLE `profile` (
	`seq`	number	NULL,
	`parentSeq`	number	NULL,
	`oriName`	varchar(200)	NULL,
	`sysName`	varchar(200)	NULL
);
?
CREATE TABLE `boardPic` (
	`seq`	number	NULL,
	`parentSeq`	number	NULL,
	`oriName`	varchar(200)	NULL,
	`sysName`	varchar(200)	NULL
);
?
CREATE TABLE `board` (
	`seq`	number	NULL,
	`title`	varchar(200)	NULL,
	`contents`	varchar(200)	NULL,
	`nickname`	varchar(200)	NULL,
	`view_count`	number	NULL,
	`write_date`	timestamp	NULL
);
?
CREATE TABLE `CertiReply` (
	`seq`	number	NULL,
	`refCertiSeq`	number	NULL,
	`writerNickname`	varchar(200)	NULL,
	`write_date`	timestamp	NULL,
	`repContents`	varchar(200)	NULL
);

CREATE TABLE mypage (
	seq number	NULL,
	id	varchar(20)	NULL,
	pw	varchar(128)	NULL,
	name	varchar(20)	NULL,
	nickname	varchar(20)	NULL,
	phone	varchar(20)	NULL,
	email	varchar(100)	NULL,
	bank	varchar(100)	NULL,
	account	varchar(100)	NULL,
	money	number	NULL,
	grade	varchar(20)	NULL,
	blacklist	varchar(20)	NULL,
	kakaologin	varchar(1)	NULL
);

create sequence mypage_seq start with 1 increment by 1 nomaxvalue nocache;

?
ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `Chal` ADD CONSTRAINT `PK_CHAL` PRIMARY KEY (
	`chalseq`
);
?
ALTER TABLE `JoinChal` ADD CONSTRAINT `PK_JOINCHAL` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `pay` ADD CONSTRAINT `PK_PAY` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `ChalImg` ADD CONSTRAINT `PK_CHALIMG` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `Certi` ADD CONSTRAINT `PK_CERTI` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `CertiImg` ADD CONSTRAINT `PK_CERTIIMG` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `BoardReply` ADD CONSTRAINT `PK_BOARDREPLY` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `Like` ADD CONSTRAINT `PK_LIKE` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `profile` ADD CONSTRAINT `PK_PROFILE` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `boardPic` ADD CONSTRAINT `PK_BOARDPIC` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`seq`
);
?
ALTER TABLE `CertiReply` ADD CONSTRAINT `PK_CERTIREPLY` PRIMARY KEY (
	`seq`
);

select * from mypage;


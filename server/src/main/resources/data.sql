/*
DROP TABLE User;
DROP TABLE Post;
DROP TABLE Heart;
CREATE TABLE user (
                      id bigint not null auto_increment,
                      account_id bigint,
                      account_type ENUM('REALTOR','LESSOR','LESSEE'),
                      created_at datetime(6),
                      nickname varchar(255),
                      quit boolean,
                      updated_at datetime(6),
                      primary key (id)
);

CREATE TABLE post (
                      id bigint not null auto_increment,
                      account_id bigint,
                      account_nickname varchar(255),
                      account_type varchar(255),
                      actived boolean not null,
                      contents varchar(255),
                      created_at datetime(6),
                      deleted_at datetime(6),
                      heart_number bigint,
                      title varchar(255),
                      updated_at datetime(6),
                      primary key (id)
);
CREATE TABLE heart (
                       id bigint not null auto_increment,
                       account_id bigint,
                       checked boolean,
                       created_at datetime(6),
                       post_id bigint,
                       primary key (id)
);
INSERT INTO user (id,account_id, account_type,nickname, quit, created_at, updated_at)
VALUES (0,47,'Realtor','김씨','0',now(),now()),(0,21,'Lessor','박씨',false,now(),now()),(0,562,'Lessee','유씨','0',now(),null);

INSERT INTO post (account_id, account_nickname, account_type, actived, contents, created_at, deleted_at, heart_number, title, updated_at)
    VALUE (562,'유씨','LESSEE',1,'집이 너무 좋아요',now(),null,true,'집구경 후기',null);

INSERT INTO heart (account_id, checked, created_at, post_id) VALUE (47,false,now(),1);
*/


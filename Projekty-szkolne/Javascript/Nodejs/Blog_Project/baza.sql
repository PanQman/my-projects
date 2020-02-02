-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-12-28 16:14:23.771

-- tables
-- Table: Permission
CREATE TABLE `Permission` (
    `id` int  NOT NULL,
    `permission` Varchar(255)  NOT NULL,
    CONSTRAINT `Permission_pk` PRIMARY KEY (`id`),
    PRIMARY KEY (id)
);

-- Table: Post
CREATE TABLE `Post` (
    `id` int  NOT NULL,
    `post` Varchar(8000)  NOT NULL,
    CONSTRAINT `Post_pk` PRIMARY KEY (`id`),
    PRIMARY KEY (`id`)
);

-- Table: User
CREATE TABLE `User` (
    `id` int NOT NULL,
    name Varchar(64)  NOT NULL,
    password Varchar(64)  NOT NULL,
    `permission_id` int  NOT NULL,
    `post_id` int  NOT NULL,
    CONSTRAINT `User_pk` PRIMARY KEY (`id`),
    PRIMARY KEY (`id`)
);

-- foreign keys
-- Reference: Post_User (table: User)
ALTER TABLE `User` ADD CONSTRAINT `Post_User`
    FOREIGN KEY (`post_id`)
    REFERENCES `Post` (`id`)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_Permission (table: User)
ALTER TABLE `User` ADD CONSTRAINT `User_Permission`
    FOREIGN KEY (`permission_id`)
    REFERENCES `Permission` (`id`)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.


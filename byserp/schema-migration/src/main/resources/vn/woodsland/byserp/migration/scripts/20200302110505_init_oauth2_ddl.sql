--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // init_oauth2_ddl
-- Migration SQL that makes the change goes here.

create table branch (
  "id" varchar(10) not null,
  "branch_name" varchar(255) not null,
  "creator" varchar(50),
  "created" timestamp,
  "updater" varchar(50),
  "updated" timestamp,
  primary key ("id")
);

create table department (
  "id" SERIAL,
  "department_name" varchar(100) not null,
  "branch_id" varchar(10) not null,
  "creator" varchar(50),
  "created" timestamp,
  "updater" varchar(50),
  "updated" timestamp,
  primary key ("id")
);

CREATE TABLE users (
  username VARCHAR(50)  NOT NULL PRIMARY KEY,
  password VARCHAR(100) NOT NULL,
  fullname VARCHAR(60) ,
  position int2,
  department_id int4,
  phone_no  VARCHAR(15),
  email VARCHAR(100),
  enabled  BOOLEAN DEFAULT true,
  "creator" varchar(50),
  "created" timestamp,
  "updater" varchar(50),
  "updated" timestamp
);

CREATE TABLE authorities (
  username  VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  "creator" varchar(50),
  "created" timestamp,
  "updater" varchar(50),
  "updated" timestamp,
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
CREATE UNIQUE INDEX ix_auth_username
  ON authorities (username, authority);

CREATE TABLE oauth_client_details (
  client_id               VARCHAR(256) PRIMARY KEY,
  resource_ids            VARCHAR(256),
  client_secret           VARCHAR(256),
  scope                   VARCHAR(256),
  authorized_grant_types  VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities             VARCHAR(256),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(256)
);

CREATE TABLE oauth_client_token (
  token_id          VARCHAR(256),
  token             BYTEA,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name         VARCHAR(256),
  client_id         VARCHAR(256)
);

CREATE TABLE oauth_access_token (
  token_id          VARCHAR(256),
  token             BYTEA,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name         VARCHAR(256),
  client_id         VARCHAR(256),
  authentication    BYTEA,
  refresh_token     VARCHAR(256)
);

CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(256),
  token          BYTEA,
  authentication BYTEA
);

CREATE TABLE oauth_code (
  code           VARCHAR(256),
  authentication BYTEA
);

CREATE TABLE oauth_approvals (
  userId         VARCHAR(256),
  clientId       VARCHAR(256),
  scope          VARCHAR(256),
  status         VARCHAR(10),
  expiresAt      TIMESTAMP,
  lastModifiedAt TIMESTAMP
);

-- //@UNDO
-- SQL to undo the change goes here.
drop table if exists branch;
drop table if exists department;
DROP TABLE IF EXISTS oauth_approvals;
DROP TABLE IF EXISTS oauth_code;
DROP TABLE IF EXISTS oauth_refresh_token;
DROP TABLE IF EXISTS oauth_access_token;
DROP TABLE IF EXISTS oauth_client_token;
DROP TABLE IF EXISTS oauth_client_details;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
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

-- // init_DDL_TABLE_EOFFICE
-- Migration SQL that makes the change goes here.

CREATE TABLE request_type (
  "id" varchar(30) not null,
  "title" varchar(255),
   "total_step" int2 DEFAULT 2,
  "delete_flg" bool DEFAULT false,
  PRIMARY KEY ("id")
);

CREATE TABLE request (
  "id" SERIAL,
  "request_type_id" varchar(30) NOT NULL,
  "priority" varchar(30),
  "description" varchar(255) NOT NULL,
  "deadline" timestamp,
  "subject" varchar(255) NOT NULL,
  "request_status" varchar(30) DEFAULT 'OPENED',
   "assigned_user" varchar(50) NOT NULL,
  "step" int2 NOT NULL,
  "creator" varchar(50),
  "created" timestamp,
  "updater" varchar(50),
  "updated" timestamp,
  "user_approved_prev" varchar(50),
  PRIMARY KEY ("id")
);

CREATE TABLE request_comment (
  "id" SERIAL,
  "request_id" int4 NOT NULL,
  "step" int2 NOT NULL,
  "comment" text,
  "creator" varchar(50),
  "created" timestamp,
  PRIMARY KEY ("id")
);

CREATE TABLE request_history (
  "id" SERIAL,
  "request_id" int4,
  "step" int2,
  "assigned_user" varchar(50),
  "priority" varchar(30),
  "subject" varchar(255),
  "description" varchar(255),
  "deadline" timestamp,
  "detail_request" text,
  "request_status" varchar(30),
  "creator" varchar(50),
  "created" timestamp,
  "updater" varchar(50),
  "updated" timestamp,
  PRIMARY KEY ("id")
);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE IF EXISTS request_type;
DROP TABLE IF EXISTS request_type_department
DROP TABLE IF EXISTS request_step;
DROP TABLE IF EXISTS request;
DROP TABLE IF EXISTS request_comment;
DROP TABLE IF EXISTS request_history;


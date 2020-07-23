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

-- // mock-insert-eoffice-data
-- Migration SQL that makes the change goes here.

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO "public"."branch" VALUES ('1', 'Thuan hung');
INSERT INTO "public"."branch" VALUES ('2', 'Tuyen Quang');
INSERT INTO "public"."branch" VALUES ('3', 'Ha Giang');
INSERT INTO "public"."branch" VALUES ('4', 'Nam Hong1');
INSERT INTO "public"."branch" VALUES ('5', 'Nam Hong2');
INSERT INTO "public"."branch" VALUES ('6', 'Nam Hong3');
INSERT INTO "public"."branch" VALUES ('7', 'Nam Hong4');
INSERT INTO "public"."branch" VALUES ('8', 'Nam Hong5');
INSERT INTO "public"."branch" VALUES ('9', 'Nam Hong6');
INSERT INTO "public"."branch" VALUES ('10', 'Nam Hong7');
INSERT INTO "public"."branch" VALUES ('11', 'Nam Hong8');

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO "public"."department" VALUES (1, 'Phòng hành chính', '1');
INSERT INTO "public"."department" VALUES (2, 'Phòng nhân sự', '1');
INSERT INTO "public"."department" VALUES (3, 'Phòng IT', '1');
INSERT INTO "public"."department" VALUES (4, 'Phòng bảo vệ', '1');
INSERT INTO "public"."department" VALUES (5, 'Phòng ban giám đốc', '1');
INSERT INTO "public"."department" VALUES (6, 'Phòng sản xuất', '1');
INSERT INTO "public"."department" VALUES (7, 'Phòng marketing', '1');
INSERT INTO "public"."department" VALUES (8, 'Phòng nấu ăn', '1');
INSERT INTO "public"."department" VALUES (9, 'Phòng vệ sinh', '1');
INSERT INTO "public"."department" VALUES (10, 'Phòng kế toán', '1');
INSERT INTO "public"."department" VALUES (11, 'Phòng họp', '1');

--pass:admin - $2a$10$f/EksN9IJWu6avgHUo6iB.ewm1pHn62awBEgnzyjYBJwPgAjHXia6
INSERT INTO users (username, password, enabled, fullname, department_id, phone_no, email, position )
VALUES ('admin', '$2a$10$f/EksN9IJWu6avgHUo6iB.ewm1pHn62awBEgnzyjYBJwPgAjHXia6', TRUE, 'Ngô Hải Đăng', 3, '0978534865', 'dang.nh.aprotrain@gmail.com', 3);

--pass:user - $2a$10$nVYYhAf6.8nAdGEvrAikkOWk9EPlc54mAp2D/ouBjwvfN5fB1xWsS
INSERT INTO users (username, password, enabled, fullname, department_id, phone_no, email, position)
VALUES ('user', '$2a$10$nVYYhAf6.8nAdGEvrAikkOWk9EPlc54mAp2D/ouBjwvfN5fB1xWsS', TRUE, 'Nguyễn Văn A', 3, '0974847547', 'user@google.com',2);

--pass:ameizi - $2a$10$P7gR3wyZetWwVLD/2J2F3.9eNzd1EHBhlD2DY/2ZO0m2DS5vc1UNi
INSERT INTO users (username, password, enabled, fullname, department_id, phone_no, email, position)
VALUES ('ameizi', '$2a$10$P7gR3wyZetWwVLD/2J2F3.9eNzd1EHBhlD2DY/2ZO0m2DS5vc1UNi', TRUE, 'Trần Văn B', 3, '0978246575', 'ameizi@google.com',1);

INSERT INTO users (username, password, enabled, fullname, department_id, phone_no, email, position)
VALUES ('user1', '$2a$10$P7gR3wyZetWwVLD/2J2F3.9eNzd1EHBhlD2DY/2ZO0m2DS5vc1UNi', TRUE, 'Nguyễn Khắc Đoàn', 3, '0978246575', 'user1@google.com',1);


INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('ameizi', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('user1', 'ROLE_USER');

--pass:secret - $2a$10$hlFTWBkAolRCiJUis3kSpeDrGBN161X/3dRshmT/jnGi/kou4l4Oy
INSERT INTO oauth_client_details (client_id, client_secret, scope, access_token_validity, authorized_grant_types, web_server_redirect_uri, autoapprove)
VALUES ('client', '$2a$10$hlFTWBkAolRCiJUis3kSpeDrGBN161X/3dRshmT/jnGi/kou4l4Oy', 'read,write', 3600, 'password,refresh_token,client_credentials,authorization_code,implicit', 'http://localhost:8080/login,http://localhost:8081/login', true);

--pass:acmesecret - $2a$10$ZV4sLmljItEI7EF/qASuMOnvyCkUbCk/8Up9n51Pkw7Vddwm5aL9K
INSERT INTO oauth_client_details (client_id, client_secret, scope, access_token_validity, authorized_grant_types, web_server_redirect_uri, autoapprove)
VALUES
  ('acme', '$2a$10$ZV4sLmljItEI7EF/qASuMOnvyCkUbCk/8Up9n51Pkw7Vddwm5aL9K', 'read,write', 3600, 'password,refresh_token,client_credentials,authorization_code,implicit', 'http://localhost:8081/login/oauth2/code/,http://localhost:8083/login/oauth2/code/', true);

-- ----------------------------
-- Records of request_type
-- ----------------------------
INSERT INTO "public"."request_type"(id, title, total_step, delete_flg) VALUES ('LOAF0001', 'Yêu cầu xin nghỉ phép', 2, 'f');
INSERT INTO "public"."request_type"(id, title, total_step, delete_flg) VALUES ('PMOD0001', 'Đề nghị thanh toán', 2, 'f');
INSERT INTO "public"."request_type"(id, title, total_step, delete_flg) VALUES ('PMOD0002', 'Đề nghị thanh toán tiền tạm ứng', 2, 'f');

/*-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO "public"."request" VALUES (1, 'LOAF0001', 'HIGHT', 'Xin nghỉ phép dài ngày', '2020-07-08 13:38:01', 'Đơn xin nghỉ phép', 'OPENED', 1, 'admin', '2020-07-06 13:38:36', 'admin', '2020-07-06 13:38:49');

-- ----------------------------
-- Records of time_off_request
-- ----------------------------
INSERT INTO "public"."time_off_request" VALUES (1, 'SABB', '2020-07-07 13:43:39', '2020-07-08 13:43:44', 'user');*/



-- //@UNDO
-- SQL to undo the change goes here.



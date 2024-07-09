-- license table query --
insert into smart_license.license VALUES ('기사', NOW());
insert into smart_license.license VALUES ('기능사', NOW());
insert into smart_license.license VALUES ('산업기사', NOW());

-- detail_license table query --
insert into smart_license.detail_license VALUES ('정보처리기사', NOW(), null, '기사');
insert into smart_license.detail_license VALUES ('정보보안기사', NOW(), null, '기사');
insert into smart_license.detail_license VALUES ('가스기사', NOW(), null, '기사');
insert into smart_license.detail_license VALUES ('가스기능사', NOW(), null, '기능사');
insert into smart_license.detail_license VALUES ('정보처리기능사', NOW(), null, '기능사');
insert into smart_license.detail_license VALUES ('제빵기능사', NOW(), null, '기능사');
insert into smart_license.detail_license VALUES ('정보처리산업기사', NOW(), null, '산업기사');
insert into smart_license.detail_license VALUES ('정보통신산업기사', NOW(), null, '산업기사');
insert into smart_license.detail_license VALUES ('제품디자인산업기사', NOW(), null, '산업기사');


-- subject table query --
insert into smart_license.subject VALUES (1, '소프트웨어 설계', 1, NOW(), '정보처리기사');
insert into smart_license.subject VALUES (2, '소프트웨어 개발', 2, NOW(), '정보처리기사');
insert into smart_license.subject VALUES (3, '데이터베이스 구축', 3, NOW(), '정보처리기사');
insert into smart_license.subject VALUES (4, '프로그래밍 언어 활용', 4, NOW(), '정보처리기사');
insert into smart_license.subject VALUES (5, '정보시스템 구축관리', 5, NOW(), '정보처리기사');
insert into smart_license.subject VALUES (6, '시스템 보안', 1, NOW(), '정보보안기사');
insert into smart_license.subject VALUES (7, '네트워크 보안', 2, NOW(), '정보보안기사');
insert into smart_license.subject VALUES (8, '어플리케이션 보안', 3, NOW(), '정보보안기사');
insert into smart_license.subject VALUES (9, '정보 보안 일반', 4, NOW(), '정보보안기사');
insert into smart_license.subject VALUES (10, '정보보안 관리 및 법규', 5, NOW(), '정보보안기사');
insert into smart_license.subject VALUES (11, '가스유체역학', 1, NOW(), '가스기사');
insert into smart_license.subject VALUES (12, '연소공학', 2, NOW(), '가스기사');
insert into smart_license.subject VALUES (13, '가스설비', 3, NOW(), '가스기사');
insert into smart_license.subject VALUES (14, '가스안전관리', 4, NOW(), '가스기사');
insert into smart_license.subject VALUES (15, '가스계측기기', 5, NOW(), '가스기사');

insert into smart_license.subject VALUES (16, '가스안전관리', 1, NOW(), '가스기능사');
insert into smart_license.subject VALUES (17,'가스장치 및 기기', 2, NOW(), '가스기능사');
insert into smart_license.subject VALUES (18,'가스일반', 3, NOW(), '가스기능사');

insert into smart_license.subject VALUES (19, '전자 계산기 일반', 1, NOW(), '정보처리기능사');
insert into smart_license.subject VALUES (20, '패키지 활용', 2, NOW(), '정보처리기능사');
insert into smart_license.subject VALUES (21, 'PC 운영 체제', 3, NOW(), '정보처리기능사');
insert into smart_license.subject VALUES (22, '정보 통신 일반', 4, NOW(), '정보처리기능사');

insert into smart_license.subject VALUES (23, '제조이론', 1, NOW(), '제빵기능사');
insert into smart_license.subject VALUES (24,'재료과학', 2, NOW(), '제빵기능사');
insert into smart_license.subject VALUES (25, '영양학', 3, NOW(), '제빵기능사');
insert into smart_license.subject VALUES (26, '식품위생학', 4, NOW(), '제빵기능사');

insert into smart_license.subject VALUES (27, '데이터 베이스', 1, NOW(), '정보처리산업기사');
insert into smart_license.subject VALUES (28, '전자 계산기 구조', 2, NOW(), '정보처리산업기사');
insert into smart_license.subject VALUES (29, '시스템분석설계', 3, NOW(), '정보처리산업기사');
insert into smart_license.subject VALUES (30, '운영체제', 4, NOW(), '정보처리산업기사');
insert into smart_license.subject VALUES (31, '정보통신개론', 5, NOW(), '정보처리산업기사');

insert into smart_license.subject VALUES (32, '디지털전자회로', 1, NOW(), '정보통신산업기사');
insert into smart_license.subject VALUES (33, '정보통신기기', 2, NOW(), '정보통신산업기사');
insert into smart_license.subject VALUES (34, '정보전송개론', 3, NOW(), '정보통신산업기사');
insert into smart_license.subject VALUES (35, '전자계산일반 및 정보설비기준', 4, NOW(), '정보통신산업기사');

insert into smart_license.subject VALUES (36, '제품디자인론', 1, NOW(), '제품디자인산업기사');
insert into smart_license.subject VALUES (37, '인간공학', 2, NOW(), '제품디자인산업기사');
insert into smart_license.subject VALUES (38, '공업재료 및 모형제작론', 3, NOW(), '제품디자인산업기사');
insert into smart_license.subject VALUES (39, '색채학', 4, NOW(), '제품디자인산업기사');

-- examination_date table --
insert into smart_license.examination_date VALUES ('2022년 04월 24일', NOW());
insert into smart_license.examination_date VALUES ('2022년 03월 05일', NOW());
insert into smart_license.examination_date VALUES ('2021년 08월 14일', NOW());



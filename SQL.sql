CREATE TABLE detail_license
(
	detail_license_name VARCHAR(100) NOT NULL PRIMARY KEY,
    create_date TIMESTAMP DEFAULT NOW(),
    detail_license_description VARCHAR(255),
    license_name VARCHAR(100)
);

CREATE TABLE exam_log_info
(
	idx INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	event_time TIMESTAMP DEFAULT NOW(),
    ip VARCHAR(50),
    device VARCHAR(100),
    browser_name VARCHAR(50),
    event_type VARCHAR(100),
    event_type_info VARCHAR(255),
    member_id VARCHAR(100)
);

CREATE TABLE examination_date
(
	examination_date VARCHAR(50) NOT NULL PRIMARY KEY,
    create_date TIMESTAMP DEFAULT NOW()
);

CREATE TABLE license
(
	license_name VARCHAR(100) NOT NULL PRIMARY KEY,
    create_date TIMESTAMP DEFAULT NOW()
);

CREATE TABLE login_log_info
(
	idx INT AUTO_INCREMENT PRIMARY KEY,
    event_time TIMESTAMP DEFAULT NOW(),
    ip VARCHAR(50),
    device VARCHAR(100),
    browser_name VARCHAR(50),
    event_type VARCHAR(100),
    event_type_info VARCHAR(255),
    member_id VARCHAR(100)
);

CREATE TABLE member
(
	member_id VARCHAR(100) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    gender CHAR(1) NOT NULL,
    is_active CHAR(1) NOT NULL DEFAULT '1',
    registration_date TIMESTAMP DEFAULT NOW(),
    update_date TIMESTAMP DEFAULT NOW()
);

CREATE TABLE question
(
	question_idx INT AUTO_INCREMENT PRIMARY KEY,
    question_number TINYINT UNSIGNED NOT NULL,
    question TEXT NOT NULL,
    option1 TEXT NOT NULL,
    option2 TEXT NOT NULL,
    option3 TEXT NOT NULL,
    option4 TEXT NOT NULL,
    answer TINYINT UNSIGNED NOT NULL,
    create_date TIMESTAMP DEFAULT NOW(),
    image VARCHAR(255),
    subject_idx int,
    question_description TEXT
);

CREATE TABLE ranking
(
	ranking_idx INT AUTO_INCREMENT PRIMARY KEY,
    score INT,
    member_id VARCHAR(100),
    create_date TIMESTAMP DEFAULT NOW()
);

CREATE TABLE session_question
(
	session_question_idx INT AUTO_INCREMENT PRIMARY KEY,
    examination_date VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT NOW(),
    question_idx INT,
    detail_license_name VARCHAR(100) NOT NULL
);

CREATE TABLE subject
(
    subject_idx INT AUTO_INCREMENT PRIMARY KEY,
	subject_name VARCHAR(100) NOT NULL,
    subject_number INT NOT NULL,
    create_date TIMESTAMP DEFAULT NOW(),
    detail_license_name VARCHAR(100)
);

CREATE TABLE user_attempt
(
	user_attempt_idx INT AUTO_INCREMENT PRIMARY KEY,
    detail_license_name VARCHAR(100) NOT NULL,
    examination_date VARCHAR(50),
    mode CHAR(1) NOT NULL,
    remaining_time VARCHAR(50),
    score INT,
    member_id VARCHAR(100) NOT NULL,
    start_test_date VARCHAR(18),
    create_date TIMESTAMP DEFAULT NOW()
);

CREATE TABLE user_select_answer
(
	user_select_answer_idx INT AUTO_INCREMENT PRIMARY KEY,
    is_correct CHAR(1),
    select_answer INT,
    start_test_date VARCHAR(50),
    member_id VARCHAR(100),
    examination_date VARCHAR(50),
    subject_idx int,
    create_date TIMESTAMP DEFAULT NOW()
);

ALTER TABLE detail_license
ADD FOREIGN KEY R_9 (license_name) REFERENCES license (license_name);

ALTER TABLE exam_log_info
ADD FOREIGN KEY R_17 (member_id) REFERENCES member (member_id);

ALTER TABLE examination_date
ADD FOREIGN KEY R_28 (detail_license_name) REFERENCES detail_license (detail_license_name);

ALTER TABLE login_log_info
ADD FOREIGN KEY R_16 (member_id) REFERENCES member (member_id);

ALTER TABLE question
ADD FOREIGN KEY R_22 (subject_idx) REFERENCES subject (subject_idx);

ALTER TABLE ranking
ADD FOREIGN KEY R_27 (member_id) REFERENCES member (member_id);

ALTER TABLE session_question
ADD FOREIGN KEY R_23 (examination_date) REFERENCES examination_date (examination_date);

ALTER TABLE session_question
ADD FOREIGN KEY R_26 (question_idx) REFERENCES question (question_idx);

ALTER TABLE subject
ADD FOREIGN KEY R_10 (detail_license_name) REFERENCES detail_license (detail_license_name);

ALTER TABLE user_attempt
ADD FOREIGN KEY R_20 (member_id) REFERENCES member (member_id);

ALTER TABLE user_select_answer
ADD FOREIGN KEY R_11 (member_id) REFERENCES member (member_id);

ALTER TABLE user_select_answer
ADD FOREIGN KEY R_12 (examination_date) REFERENCES examination_date (examination_date);

ALTER TABLE user_select_answer
ADD FOREIGN KEY R_25 (subject_idx) REFERENCES subject (subject_idx);

ALTER TABLE session_question
ADD FOREIGN KEY R_29 (detail_license_name) REFERENCES detail_license (detail_license_name);
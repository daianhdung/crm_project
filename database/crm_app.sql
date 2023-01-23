CREATE database crm_app;
use crm_app;

CREATE TABLE IF NOT EXISTS roles (
                                     id INT NOT NULL AUTO_INCREMENT,
                                     name VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS users (
                                     id INT NOT NULL AUTO_INCREMENT,
                                     email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    avatar VARCHAR(100),
    role_id INT NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS status (
                                      id INT NOT NULL AUTO_INCREMENT,
                                      name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS jobs (
                                    id INT NOT NULL AUTO_INCREMENT,
                                    name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS tasks (
                                     id INT NOT NULL AUTO_INCREMENT,
                                     name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    user_id INT NOT NULL,
    job_id INT NOT NULL,
    status_id INT NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS users_detail(
                                           user_id INT NOT NULL,
                                           age int,
                                           cmnd varchar(12),
    PRIMARY KEY (user_id),
    foreign key(user_id) references users(id)
    );


ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (user_id) REFERENCES users (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (job_id) REFERENCES jobs (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (status_id) REFERENCES status (id)  ON DELETE CASCADE;

INSERT INTO roles( name, description ) VALUES ("ROLE_ADMIN", "Quản lí trang");
INSERT INTO roles( name, description ) VALUES ("ROLE_MANAGER", "Quản lí");
INSERT INTO roles( name, description ) VALUES ("ROLE_USER", "Nhân viên");
INSERT INTO roles( name, description ) VALUES ("ROLE_TEST", "Quản lý test");

INSERT INTO status( name ) VALUES ("Chưa thực hiện");
INSERT INTO status( name ) VALUES ("Đang thực hiện");
INSERT INTO status( name ) VALUES ("Đã hoàn thành");

INSERT INTO users(email,password,fullname,avatar,role_id) VALUES ("nguyenvana@gmail.com", "123456","Nguyễn Văn A", "", "1");
INSERT INTO users(email,password,fullname,avatar,role_id) VALUES ("nguyenvanb@gmail.com", "123456","Nguyễn Văn B", "", "3");
INSERT INTO users(email,password,fullname,avatar,role_id) VALUES ("nguyenvanc@gmail.com", "123456","Nguyễn Văn C", "", "2");

INSERT INTO jobs(name, start_date, end_date)
VALUES ("Dự án 1", STR_TO_DATE('22-10-2022', '%d-%m-%Y'), STR_TO_DATE('22-11-2022', '%d-%m-%Y'));
INSERT INTO jobs(name, start_date, end_date)
VALUES ("Dự án 2", STR_TO_DATE('22-10-2022', '%d-%m-%Y'), STR_TO_DATE('22-11-2022', '%d-%m-%Y'));

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("Task1", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"1", "1", "3");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("Task2", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"1", "2", "3");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("Task3", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"1", "2", "2");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("TaskOfB", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"2", "1", "1");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("TaskOfB", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"2", "1", "2");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("TaskOfJob2B", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"2", "2", "1");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("TaskOfJob1C", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"3", "1", "3");

INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)
VALUES ("TaskOfJob2C", STR_TO_DATE('22-10-2022', '%d-%m-%Y')
       , STR_TO_DATE('22-11-2022', '%d-%m-%Y')
       ,"3", "2", "1");






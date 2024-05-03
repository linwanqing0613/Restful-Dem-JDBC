INSERT INTO movies (title, director, release_year, created_date, last_modified_date) VALUES('Inception', 'Christopher Nolan', 2010, '2024-05-01 15:30:00', '2024-05-01 15:30:00');
INSERT INTO movies (title, director, release_year, created_date, last_modified_date) VALUES('Interstellar', 'Christopher Nolan', 2014, '2024-05-01 15:30:00', '2024-05-01 15:30:00');
INSERT INTO movies (title, director, release_year, created_date, last_modified_date) VALUES('The Dark Knight', 'Christopher Nolan', 2008, '2024-05-01 15:30:00', '2024-05-01 15:30:00');
INSERT INTO role(role_id, role_name) values('1', 'ROLE_GUEST');
INSERT INTO role(role_id, role_name) values('2', 'ROLE_NORMAL_MEMBER');
INSERT INTO role(role_id, role_name) values('3', 'ROLE_ADMIN');
INSERT INTO users(id, email, password) values('guest', 'guest@gmail.com', '$2a$10$Xu61KnQRBD9F8/dgiGXpnuTfQwmn.KtNXkyuI3ZeGM4JJiBQcUOvC');
INSERT INTO users(id, email, password) values('member', 'member@gmail.com', '$2a$10$Xu61KnQRBD9F8/dgiGXpnuTfQwmn.KtNXkyuI3ZeGM4JJiBQcUOvC');
INSERT INTO users(id, email, password) values('admin', 'admin@gmail.com', '$2a$10$Xu61KnQRBD9F8/dgiGXpnuTfQwmn.KtNXkyuI3ZeGM4JJiBQcUOvC');

INSERT INTO member_role (users_id, role_id) VALUES ('guest', 1);

INSERT INTO member_role (users_id, role_id) VALUES ('member', 1);
INSERT INTO member_role (users_id, role_id) VALUES ('member', 2);

INSERT INTO member_role (users_id, role_id) VALUES ('admin', 1);
INSERT INTO member_role (users_id, role_id) VALUES ('admin', 2);
INSERT INTO member_role (users_id, role_id) VALUES ('admin', 3);
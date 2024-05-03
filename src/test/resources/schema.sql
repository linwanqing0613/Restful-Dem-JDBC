CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    release_year INT NOT NULL,
    created_date DATETIME NOT NULL,
    last_modified_date DATETIME NOT NULL
);
CREATE TABLE users (
    id VARCHAR(255) PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE role (
    role_id int AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);
CREATE TABLE member_role (
    users_id VARCHAR(255)NOT NULL,
    role_id int NOT NULL,
    PRIMARY KEY (users_id, role_id),
    FOREIGN KEY (users_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE
);
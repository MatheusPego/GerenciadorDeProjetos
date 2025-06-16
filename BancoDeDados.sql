CREATE TABLE users (
    id_user VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    `key` VARCHAR(100) NOT NULL,
    sector ENUM('TEST', 'PROJECT') NOT NULL
);

CREATE TABLE projects (
    id_project VARCHAR(36) PRIMARY KEY,
    name_project VARCHAR(100) NOT NULL,
    number_reference INT NOT NULL,
    create_date DATE NOT NULL,
    person_in_charge VARCHAR(36) NOT NULL,
    FOREIGN KEY (person_in_charge) REFERENCES users(id_user)
);

CREATE TABLE request_reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    justification TEXT NOT NULL,
    requester_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (requester_id) REFERENCES users(id_user)
);

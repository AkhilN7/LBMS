CREATE DATABASE library;
USE library;
CREATE TABLE Book(
	bookid INT(5) PRIMARY KEY,
    bookname VARCHAR(25),
    bookcount INT(5)
);

CREATE TABLE Student(
	studentid INT(5) PRIMARY KEY,
    studentname VARCHAR(25)
);

CREATE TABLE Lending(
	b_id INT(5),
    s_id INT(5),
    FOREIGN KEY(b_id) REFERENCES Book(bookid),
    FOREIGN KEY(S_id) REFERENCES Student(studentid)
);
-- FK's --

ALTER TABLE DB_NEEDS ADD CONSTRAINT FK_NEED_CATEGORY FOREIGN KEY (category) REFERENCES DB_Category (name);
ALTER TABLE DB_NEEDS ADD CONSTRAINT FK_NEED_USER FOREIGN KEY (idUser) REFERENCES DB_User(userId);
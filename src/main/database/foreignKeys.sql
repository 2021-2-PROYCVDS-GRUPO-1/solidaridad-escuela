-- FK's --
ALTER TABLE Offer ADD CONSTRAINT FK_OFFER_CATEGORY FOREIGN KEY (offerCategory) REFERENCES DB_Category (Name);
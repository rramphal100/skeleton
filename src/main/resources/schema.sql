CREATE TABLE receipts (
  id INT UNSIGNED AUTO_INCREMENT,
  uploaded TIME DEFAULT CURRENT_TIME(),
  merchant VARCHAR(255),
  amount DECIMAL(12,2),
  receipt_type INT UNSIGNED,

  PRIMARY KEY (id)
);

CREATE TABLE tags(
  id INT UNSIGNED,
  tag VARCHAR(20) NOT NULL,

  PRIMARY KEY (id, tag),

  INDEX tag_index (id),
  FOREIGN KEY (id)
    REFERENCES receipts(id)
  ON DELETE CASCADE
);
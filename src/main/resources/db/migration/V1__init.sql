create TABLE IF NOT EXISTS book_data (
    bd_id bigint(20) NOT NULL AUTO_INCREMENT,
    bd_name VARCHAR(256),
    bd_excerpt VARCHAR(1000),
    bd_content VARCHAR(1000),
    bd_author VARCHAR(256) ,
    bd_publisher VARCHAR(256),
    bd_created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    bd_updated_at DATETIME DEFAULT NULL ON update CURRENT_TIMESTAMP,
    PRIMARY KEY (bd_id)
);
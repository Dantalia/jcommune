/* CODE_REVIEW.CODE_REVIEW_ID -> CODE_REVIEW.CR_ID */
ALTER TABLE `CODE_REVIEW_COMMENTS` DROP FOREIGN KEY `FK_CRC_CODE_REVIEW`;
ALTER TABLE `TOPIC` DROP FOREIGN KEY `TOPIC_CODE_REVIEW_FK`;
ALTER TABLE `CODE_REVIEWS`
    CHANGE COLUMN `CODE_REVIEW_ID` `CR_ID` BIGINT(20) NOT NULL AUTO_INCREMENT FIRST;
ALTER TABLE `TOPIC`
    ADD CONSTRAINT `FK_TOPIC_CODE_REVIEW` FOREIGN KEY (`CODE_REVIEW_ID`) REFERENCES `CODE_REVIEWS` (`CR_ID`);
ALTER TABLE `CODE_REVIEW_COMMENTS`
    ADD CONSTRAINT `FK_CRC_CODE_REVIEW` FOREIGN KEY (`CODE_REVIEW_ID`) REFERENCES `CODE_REVIEWS` (`CR_ID`);

/* CODE_REVIEW_COMMENTS.AUTHOR -> CODE_REVIEW_COMMENTS.AUTHOR_ID */
ALTER TABLE `CODE_REVIEW_COMMENTS`
    DROP FOREIGN KEY `FK_CRC_AUTHOR`;
ALTER TABLE `CODE_REVIEW_COMMENTS`
    ALTER `AUTHOR` DROP DEFAULT;
ALTER TABLE `CODE_REVIEW_COMMENTS`
    CHANGE COLUMN `AUTHOR` `AUTHOR_ID` BIGINT(20) NOT NULL AFTER `LINE_NUMBER`;
ALTER TABLE `CODE_REVIEW_COMMENTS`
    ADD CONSTRAINT `FK_CRC_AUTHOR` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `USERS` (`ID`);

    
/* Renaming regular columns */
ALTER TABLE `CODE_REVIEW_COMMENTS`
    CHANGE COLUMN `COMMENT` `BODY` LONGTEXT NOT NULL COLLATE 'utf8_bin' AFTER `LIST_INDEX`;

/* Adding/removing columns */
ALTER TABLE `CODE_REVIEW_COMMENTS`
    ADD COLUMN `CREATION_DATE` DATETIME NOT NULL AFTER `BODY`,
    DROP COLUMN `LIST_INDEX`;
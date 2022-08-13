-- -----------------------------------------------------
-- Table `quarkusdb`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quarkusdb`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `details` TEXT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `user_id1` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id1`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_task_user_idx` (`user_id1` ASC) VISIBLE,
  CONSTRAINT `fk_task_user`
    FOREIGN KEY (`user_id1`)
    REFERENCES `quarkusdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
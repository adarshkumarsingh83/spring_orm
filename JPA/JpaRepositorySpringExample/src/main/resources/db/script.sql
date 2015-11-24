INSERT INTO `users`
(`userId`,`email`,`enabled`,`firstName`,`lastName`,`password`,`phoneNumber`,`userName`)
VALUES(1,'adarh@kumar',0,'Adarsh','kumar','adarsh','999999999','adarsh'),
      (2,'amti@kumar',0,'Amit','kumar','amit','999999999','amit'),
      (3,'radha@singh',0,'Radha','Singh','singh','8888888','radha');

INSERT INTO `user_roles`
(`roleId`,`roleName`)
VALUES( 1 ,'ROLE_ADMIN'),
       ( 2 ,'ROLE_USER');


INSERT INTO `user_role_mapping`
(`users_userId`,`roles_roleId`)
VALUES(1,1),
      (2,2),
	    (3,1);
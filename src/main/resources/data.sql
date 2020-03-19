INSERT INTO user(id,username,firstname,lastname,email,password,librarian)
VALUES
(0,'adminUser','Bilbo','Swaggins','bigbilbo@theshire.com','password',true),
(1,'normalUser','Average','McMediocre','normie@ucd.ie','password2',false),
(2,'normalUser2','Average2','McMediocre2','normie2@ucd.ie','password3',false),
(3,'normalUser3','Average3','McMediocre3','normie3@ucd.ie','password4',false);

INSERT INTO book(id,title,author,available,reserved,userid,reservedid,dueDate)
VALUES
(0,'Generic Book 1','Skippy McGee',true,false,null,null,null),
(1,'Some Other Book','Lance Butterscotch',false,true,1,2,'2020-03-25'),
(2,'Yet Another Book','Zest McLemon',false,false,2,null,'2020-03-22');

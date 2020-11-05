




```sql

Create Table Book (
    ISBN varchar(255) not NULL Primary Key,
    Bname varchar(255) NULL,
    Bpublish int NULL,
    Bauthor varchar(255) NULL, 
    Bpress varchar(255) NULL,
    Bnumber int not NULL,
    Kind char(255) NULL,
);

Create Table Users (
    ID int not NULL Primary Key check (ID > 10000 And ID < 99999),
    Upassword1 varchar(255) not NULL,
    Uname varchar(255) not NULL,
    Uage int NULL check (Uage > 0 And Uage < 120),
    Usex char(2) NULL,
    Umarjor varchar(255) NULL,
    Uphone varchar(255) Unique not NULL,
    Upassword2 varchar(255) not NULL
);

Create Table Borrowing (
    ISBN varchar(255) not NULL,
    ID int not NULL Check (ID > 10000 And ID < 99999),
    BTime int not NULL,
    Primary Key (ISBN, ID)
    Foreign key (ISBN) References Book(ISBN)
);

/*
Book表(主键 : ISBN):
    ISBN : 图书编号
    Bname : 书名
    Bpublish : 出版时间
    Bauthor : 作者
    Bpress : 出版社
    Bnumber : 库存数量
    Kind : 书类
Users表(主键 : ID):
    ID : 用户id, 5位数字
    Upassword1 : 密码
    Uname : 姓名
    Uage : 年龄
    Usex : 性别
    Uphone : 手机号
    Upassword2 : 二级密码
Borrowing(主键 : ISBN + ID) : 借阅表
    ISBN : 图书编号
    ID : 用户id
    BTime : 借阅时间(起始时间)

PS: BTime 借书时间, 为了简化问题, 从0开始, 系统开启时是第0天
*/

```



/*
insert into book.users(ID, Upassword1, Uname, Uage, Uphone, Upassword2) values(99999, '4636', 'Admin', 100, 15194150732, 4636)

*/

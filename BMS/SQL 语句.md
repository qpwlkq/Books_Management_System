




```sql
Create Table Book (
    ISBN char(13) not NULL Primary Key check (Count(ISBN) = 13)
    Bname char(10) NULL
    Bauthor char(10) NULL 
    Bpress char(10) NULL
    Bnumber int not NULL
    Kind char(10) NULL
    Foreign key (ISBN) References Borrowers(ISBN)
);

Create Table Users (
    ID int not NULL Primary Key check (ID > 10000 And ID < 99999)
    Upassword char(15) not NULL
    Uname char(10) not NULL
    Uage int not NULL check (Uage > 0 And Uage < 120)
    Usex char(2) not NULL check (Usex in ('男', '女'))
    Umarjor char(10) NULL
    Uphone char(11) Unique not NULL check (Count(Uphone) = 11)
    Us char(15) not NULL
);

Create Table Borrowers (
    ISBN char(13) not NULL Check(Count(ISBN) = 13)
    ID int not NULL Check (ID > 10000 And ID < 99999)
    BTime int not NULL
    Primary Key (ISBN, ID);
);

```

PS:
BTime 借书时间, 为了简化问题, 从0开始, 系统开启是第0天

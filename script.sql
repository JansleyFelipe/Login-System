Create Table USUARIOS (
email varchar(90) primary key not null,
nome varchar(50) not null,
senha varchar(15) not null
)

Select * From USUARIOS

Delete From USUARIOS Where email = 'teste@gmail.com'
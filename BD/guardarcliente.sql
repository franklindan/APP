CREATE DEFINER=`root`@`localhost` PROCEDURE `guardarcliente`(dni char(8), nombre varchar(25), apellido varchar(25))
begin
	insert into cliente(DniClie,NombClie,ApelClie) values(dni,nombre,apellido);
end
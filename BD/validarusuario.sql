delimiter //
use bdsispasajes//
create procedure validarusuario(dni char(8), clave varchar(200))
begin
	select dniUsuario, nombUsua, apelUsua,clavUsua, fotoUsua, tipoUsua from 
    usuario where estaUsua="habilitado"and dniUsua=dni and clavUsua=clave;
end//

delimiter //
use sispasajes;
create procedure mostrarcliente()
begin
	select DniClie, NomCLie, ApelClie from cliente;

end //
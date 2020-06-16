function muestra_oculta(id){
if (document.getElementById){ //se obtiene el id
var el = document.getElementById(id); //se define la variable "el" igual a nuestro div
el.style.display = (el.style.display === 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
}
}
window.onload = function(){/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
muestra_oculta('ingresoCli');/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
};

function muestra_oculta2(id){
	if (document.getElementById){ //se obtiene el id
	var el1 = document.getElementById(id); //se define la variable "el" igual a nuestro div
	el1.style.display = (el1.style.display === 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
	}
	}
	window.onload = function(){/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
	muestra_oculta2('ingresoBLs');/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
	};
	
	function muestra_oculta3(id){
		if (document.getElementById){ //se obtiene el id
		var el2 = document.getElementById(id); //se define la variable "el" igual a nuestro div
		el2.style.display = (el2.style.display === 'none') ? 'block' : 'none'; //damos un atributo display:none que oculta el div
		}
		}
		window.onload = function(){/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
		muestra_oculta3('ingresoProveedores');/* "contenido_a_mostrar" es el nombre que le dimos al DIV */
		};
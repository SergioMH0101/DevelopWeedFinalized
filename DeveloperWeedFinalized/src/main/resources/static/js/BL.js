function BLController(option){
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
	switch(option){
	
	case "list":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/list",
			success : function(res){
				$("#blTable").bootstrapTable('load',res);
				$("#blTable tbody").on('click','tr', function(){
					$("#Id_bl").val($(this).find("td:eq(0)").text());
					$("#Nombre_nave").val($(this).find("td:eq(1)").text());
					$("#Nombre_sello").val($(this).find("td:eq(2)").text());
					$("#Consignatario").val($(this).find("td:eq(3)").text());
					$("#Consignante").val($(this).find("td:eq(4)").text());
					$("#Peso").val($(this).find("td:eq(5)").text());
					$("#Vol_cubico").val($(this).find("td:eq(6)").text());
					$("#Mercaderia").val($(this).find("td:eq(7)").text());
					$("#Tipo_carga").val($(this).find("td:eq(8)").text());
					$("#Fecha_salida").val($(this).find("td:eq(9)").text());
					$("#Fecha_arribo").val($(this).find("td:eq(10)").text());
					$("#Unidades").val($(this).find("td:eq(11)").text());
					$("#Carga").val($(this).find("td:eq(12)").text());
					$("#Incoterms").val($(this).find("td:eq(13)").text());
					$("#Pais").val($(this).find("td:eq(14)").text());
					$("#Documentacion").val($(this).find("td:eq(15)").text());
					$("#myModal").click()
				});
				$("#myModal").modal({show:true})
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en la busqueda de BL");
			}
		});
		break;
		
	case "get":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/get",
			data: "Id_bl=" + $("#Id_bl").val(),
			success : function(res){
				if (res== null || res==""){
					$("#msg").show();
					$("#msg").html("Registro no encontrado")
				}else{
					$("#Id_bl").val(res.Id_bl);
					$("#Nombre_nave").val(res.Nombre_nave);
					$("#Num_sello").val(res.Num_sello);
					$("#Consignatario").val(res.Consignantario');
					$("#Consignante").val(res.Consignante);
					$("#Peso").val(res.Peso);
					$("#Vol_cubico").val(res.Vol_cubico);
					$("#Mercaderia").val(res.Mercaderia);
					$("#Tipo_carga").val(res.Tipo_carga);
					$("#Fecha_salida").val(res.Fecha_salida);
					$("#Fecha_arribo").val(res.Fecha_arribo);
					$("#Unidades").val(res.Unidades);
					$("#Carga").val(res.Carga);
					$("#Incoterms").val(res.Incoterms);
					$("#Pais").val(res.Pais);
					$("#Documentacion").val(res.Documentacion);
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en busqueda de BL");
			}
		});
		break;
	case "insert":
		var json = 
	{
			
			'Nombre_nave' : $("#Nombre_nave").val(),
			'Num_sello' : $("#Num_sello").val(),
			'Consignatario' : ($("#Consignatario").val(),
			'Consignante' : ($("#Consignante").val(),
			'Peso' : $("#Peso").val(),
			'Vol_cubico' : $("#Vol_cubico").val(),
			'Mercaderia' : ($("#Mercaderia").val(),
			'Tipo_carga' : ($("#Tipo_carga").val(),
			'Fecha_salida' : $("#Fecha_salida").val(),
			'Fecha_arribo' : $("#Fecha_arribo").val(),
			'Unidades' : ($("#Unidades").val(),
			'Carga' : ($("#Carga").val(),
			'Incoterms' : $("#Incoterms").val(),
			'Pais' : $("#Pais").val(),
			'Documentacion' : ($("#Documentacion").val()		
	}
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/insert",
			data: postData,
			contentType : "application/json; charset=utf-8",
			success : function(res){
				if (res== 1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro insertado correctamente")
				}else{
					$("#msg").show();
					$("#msg").html("Error al agregar registro")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al agregar registro");
			}
		});
		break;
		
	case "update":
		var json = 
	{
			'Nombre_nave' : $("#Nombre_nave").val(),
			'Num_sello' : $("#Num_sello").val(),
			'Consignatario' : ($("#Consignatario").val(),
			'Consignante' : ($("#Consignante").val(),
			'Peso' : $("#Peso").val(),
			'Vol_cubico' : $("#Vol_cubico").val(),
			'Mercaderia' : ($("#Mercaderia").val(),
			'Tipo_carga' : ($("#Tipo_carga").val(),
			'Fecha_salida' : $("#Fecha_salida").val(),
			'Fecha_arribo' : $("#Fecha_arribo").val(),
			'Unidades' : ($("#Unidades").val(),
			'Carga' : ($("#Carga").val(),
			'Incoterms' : $("#Incoterms").val(),
			'Pais' : $("#Pais").val(),
			'Documentacion' : ($("#Documentacion").val()
	
	}
	
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/update",
			data: postData,
			contentType : "application/json; charset=utf-8",
			success : function(res){
				if (res== 1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro actualizado correctamente")
				}else{
					$("#msg").show();
					$("#msg").html("Error al actualizar registro")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al actualizar registro");
			}
		});
		break;
		
	case "delete":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/delete",
			data: "Id_bl=" + $("#Id_bl").val(),
			success : function(res){
				if (res==1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro eliminado con exito")
				}else{
					$("#msg").show();
					$("#msg").html("Registro no se pudo eliminar ")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al eliminar");
			}
		});
		break;
		
	
		
	case "insertProv":
		var json = 
	{
			'rut_proveedor': $("#rut_proveedor").val(),
			'nombre_proveedor': $("#nombre_proveedor").val(),
			'giro': $("#giro").val(),
			'contacto': $("#contacto").val(),
			'email': $("#email").val(),
			'direccion': $("#direccion").val(),
			'comuna': $("#comuna").val(),
			'region': $("#region").val(),
			'pais': $("#pais").val(),
			'tipo_proveedor': $("#tipo_proveedor").val(),
	}
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/insert",
			data: postData,
			contentType : "application/json; charset=utf-8",
			success : function(res){
				if (res== 1){
					$("#msg").removeClass("alert-danger").addClass("alert-success")
					$("#msg").show();
					$("#msg").html("Registro insertado correctamente")
				}else{
					$("#msg").show();
					$("#msg").html("Error al agregar registro")
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error al agregar registro");
			}
		});
		break;
	
	default:
			$("#msg").show();
			$("#msg").html("Opcion no valida");
	}
}
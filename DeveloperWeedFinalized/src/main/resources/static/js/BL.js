function BLController(option){
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
	switch(option){
	
	case "list":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token},
		
			url : "/BL/list",
			success : function(res){
				$("#blTable").bootstrapTable('load',res);
				$("#blTable tbody").on('click','tr', function(){
					$("#id_bl").val($(this).find("td:eq(0)").text());
					$("#nombre_nave").val($(this).find("td:eq(1)").text());
					$("#nombre_sello").val($(this).find("td:eq(2)").text());
					$("#consignatario").val($(this).find("td:eq(3)").text());
					$("#consignante").val($(this).find("td:eq(4)").text());
					$("#peso").val($(this).find("td:eq(5)").text());
					$("#vol_cubico").val($(this).find("td:eq(6)").text());
					$("#mercaderia").val($(this).find("td:eq(7)").text());
					$("#tipo_carga").val($(this).find("td:eq(8)").text());
					$("#fecha_salida").val($(this).find("td:eq(9)").text());
					$("#fecha_arribo").val($(this).find("td:eq(10)").text());
					$("#unidades").val($(this).find("td:eq(11)").text());
					$("#carga").val($(this).find("td:eq(12)").text());
					$("#incoterms").val($(this).find("td:eq(13)").text());
					$("#pais").val($(this).find("td:eq(14)").text());
					$("#documentacion").val($(this).find("td:eq(15)").text());
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
					$("#id_bl").val(res.Id_bl);
					$("#nombre_nave").val(res.Nombre_nave);
					$("#num_sello").val(res.Num_sello);
					$("#consignatario").val(res.Consignatario);
					$("#consignante").val(res.Consignante);
					$("#peso").val(res.Peso);
					$("#vol_cubico").val(res.Vol_cubico);
					$("#mercaderia").val(res.Mercaderia);
					$("#tipo_carga").val(res.Tipo_carga);
					$("#fecha_salida").val(res.Fecha_salida);
					$("#fecha_arribo").val(res.Fecha_arribo);
					$("#unidades").val(res.Unidades);
					$("#carga").val(res.Carga);
					$("#incoterms").val(res.Incoterms);
					$("#pais").val(res.Pais);
					$("#documentacion").val(res.Documentacion);
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en busqueda de BL");
			}
		});
		break;
	case "insert":
		var bljson = 
	{
			'Id_bl' : $("#Id_bl").val(),
			'Nombre_nave' : $("#Nombre_nave").val(),
			'Num_sello' : $("#Num_sello").val(),
			'Consignatario' : $("#Consignatario").val(),
			'Consignante' : $("#Consignante").val(),
			'Peso' : $("#Peso").val(),
			'Vol_cubico' : $("#Vol_cubico").val(),
			'Mercaderia' : $("#Mercaderia").val(),
			'Tipo_carga' : $("#Tipo_carga").val(),
			'Fecha_salida' : $("#Fecha_salida").val(),
			'Fecha_arribo' : $("#Fecha_arribo").val(),
			'Unidades' : $("#Unidades").val(),
			'Carga' : $("#Carga").val(),
			'Incoterms' : $("#Incoterms").val(),
			'Pais' : $("#Pais").val(),
			'Documentacion' : $("#Documentacion").val()		
	}
		var postData= JSON.stringify(bljson);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/BL/insert",
			data: postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
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
		var bljson = 
	{
			'Id_bl' : $("#Id_bl").val(),
			'Nombre_nave' : $("#Nombre_nave").val(),
			'Num_sello' : $("#Num_sello").val(),
			'Consignatario' : $("#Consignatario").val(),
			'Consignante' : $("#Consignante").val(),
			'Peso' : $("#Peso").val(),
			'Vol_cubico' : $("#Vol_cubico").val(),
			'Mercaderia' : $("#Mercaderia").val(),
			'Tipo_carga' : $("#Tipo_carga").val(),
			'Fecha_salida' : $("#Fecha_salida").val(),
			'Fecha_arribo' : $("#Fecha_arribo").val(),
			'Unidades' : $("#Unidades").val(),
			'Carga' : $("#Carga").val(),
			'Incoterms' : $("#Incoterms").val(),
			'Pais' : $("#Pais").val(),
			'Documentacion' : $("#Documentacion").val()
	
	}
	
		var postData= JSON.stringify(bljson);
		
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
	default:
			$("#msg").show();
			$("#msg").html("Opcion no valida");
	}
}
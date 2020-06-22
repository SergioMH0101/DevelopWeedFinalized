function ProveedorController(option){
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
	switch(option){
	
	case "list":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/AA_PROVEEDOR/list",
			success : function(res){
				$("#proveedorTable").bootstrapTable('load',res);
				$("#proveedorTable tbody").on('click','tr', function(){
					$("#id_proveedor").val($(this).find("td:eq(0)").text());
					$("#nombre_proveedor").val($(this).find("td:eq(1)").text());
					$("#id_giro").val($(this).find("td:eq(2)").text());
					$("#contacto").val($(this).find("td:eq(3)").text());
					$("#email").val($(this).find("td:eq(4)").text());
					$("#direccion").val($(this).find("td:eq(5)").text());
					$("#id_comuna").val($(this).find("td:eq(6)").text());
					$("#id_reg").val($(this).find("td:eq(7)").text());
					$("#id_pais").val($(this).find("td:eq(8)").text());
					$("#id_tproveedor").val($(this).find("td:eq(9)").text());
					$("#myModal").click()
				});
				$("#myModal").modal({show:true})
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en la busqueda de Proveedor");
			}
		});
		break;
		
	case "get":
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/AA_PROVEEDOR/get",
			data: "id_proveedor=" + $("#id_proveedor").val(),
			success : function(res){
				if (res== null || res==""){
					$("#msg").show();
					$("#msg").html("Registro no encontrado")
				}else{
					$("#id_proveedor").val(res.id_proveedor);
					$("#nombre_proveedor").val(res.nombre_proveedor);
					$("#id_giro").val(res.id_giro);
					$("#contacto").val(res.contacto);
					$("#email").val(res.email);
					$("#direccion").val(res.direccion);
					$("#id_comuna").val(res.id_comuna);
					$("#id_reg").val(res.id_reg);
					$("#id_pais").val(res.id_pais);
					$("#id_tproveedor").val(res.id_tproveedor);
					
				}
			},
			error : function(){
				$("#msg").show();
				$("#msg").html("Error en busqueda de Proveedor");
			}
		});
		break;
	case "insert":
		var json = 
	{
			'id_proveedor' : $("#id_proveedor").val(),
			'nombre_proveedor' : $("#nombre_proveedor").val(),
			'id_giro' : $("#id_giro").val(),
			'contacto' : $("#contacto").val(),
			'email' : $("#email").val(),
			'direccion' : $("#direccion").val(),
			'id_comuna' : $("#id_comuna").val(),
			'id_reg' : $("#id_reg").val(),
			'id_pais' : $("#id_pais").val(),
			'id_tproveedor' : $("#id_tproveedor").val(),
					
	}
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/AA_PROVEEDOR/insert",
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
			'id_proveedor' : $("#id_proveedor").val(),
			'nombre_proveedor' : $("#nombre_proveedor").val(),
			'id_giro' : $("#id_giro").val(),
			'contacto' : $("#contacto").val(),
			'email' : $("#email").val(),
			'direccion' : $("#direccion").val(),
			'id_comuna' : $("#id_comuna").val(),
			'id_reg' : $("#id_reg").val(),
			'id_pais' : $("#id_pais").val(),
			'id_tproveedor' : $("#id_tproveedor").val(),
	
	}
	
		var postData= JSON.stringify(json);
		
		$.ajax({
			type : "post",
			headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/AA_PROVEEDOR/update",
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
			url : "/AA_PROVEEDOR/delete",
			data: "id_proveedor=" + $("#id_proveedor").val(),
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
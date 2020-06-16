function CLController(option){
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
	
	switch(option){
	
	case "insertCliente":
		var json = 
	{
			'rut_cliente': $("#rut_cliente").val(),
			'nombre_cliente': $("#nombre_cliente").val(),
			'giro': $("#giro").val(),
			'email': $("#email").val(),
			'telefono': $("#telefono").val(),
			'comuna': $("#comuna").val(),
			'direccion': $("#direccion").val(),
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
		
		
	}
}

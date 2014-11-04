$('#oldpassword').blur( function() {

	var input_data = {
		userid : $("#uid").val(),
		password : $("#oldpassword").val()
	}
	$.getJSON("auth/checkUserPasswordAciton", input_data, function(data) {
		if (data["isPasswordCorrect"]) {
			$('#submitDiv').removeClass("buttonDisabled").addClass("buttonActive");
			$('#submit').removeAttr("disabled");
		} else {
			alertMsg.warn('您输入的密码有误！');
			$('#submitDiv').removeClass("buttonActive").addClass("buttonDisabled");
			$('#submit').removeAttr("disabled").attr("disabled","disabled");
		}

	}

	);

});
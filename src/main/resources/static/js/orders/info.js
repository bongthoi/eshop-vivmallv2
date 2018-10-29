$(function () {
	$("#btn-approve").click(function(){
	
		$("#frm-orders").attr("action","admin/orders/approve").submit();
	});
	
	$("#btn-destroy").click(function(){
		$("#frm-orders").attr("action","admin/orders/destroy").submit();
	});
	$("#btn-export").click(function(){
		$("#frm-orders").attr("action","admin/orders/export").submit();
	});
	
});


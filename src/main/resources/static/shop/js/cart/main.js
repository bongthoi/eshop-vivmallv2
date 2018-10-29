$(function(){
	
	//add to cart
	$(".add-to-cart").click(function(){
		var id=$(this).data('id');
		var message_start=$("#toastr-message-start").data('messages');
		var message_end=$("#toastr-message-end").data('messages');
		var message_item=$("#toastr-message-item").data('messages');
		var number= $("#frm_product_detail").find('input[name="number"]').val();
		if(number==undefined){
			number=1;
		}
		$.ajax({
			url:"cart/add/" + id+"/"+number,
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-count-ontop").html(response.count);
				$("#frm_product_detail").find('input[name="number"]').val(1);
			}
		});
		
		// hiệu ứng giỏ hàng
		toastr.options = {
    			"closeButton" : true,
    			"positionClass" : "toast-top-left",
    			"onclick" : null,
    			"showDuration" : "0",
    			"hideDuration" : "0",
    			"timeOut" : "3000",
    			"showMethod" : "fadeIn"
    		};
		toastr.success(message_start+" <span style='color:yellow'><b>"+ number+" "+message_item+"</b></span> "+message_end);
	});
	
});


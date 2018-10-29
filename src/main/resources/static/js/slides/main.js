 $(function () {
	    
		$("#btnSaveslides").click(function(){
				//var pdata=$("#frm-about").serialize();
						$("#frm_slides_edit").submit();
				
		});
		
		$('#txtimage_slides').ajaxfileupload({
			'valid_extensions' : ['gif','png','jpg','jpeg'],
		    'action': "upload/publicimg/?folder=slide",
		    'onComplete': function(response) {	
		        if (response.status==false) {
		        	$.messager.alert('Error',response.message,'error');
		        	 //$("#strongmessage").html("<font color='red'>" + JSON.stringify(response.message) + " </font>");
		        }
		        if (response.status==true) {
		        	//$.messager.alert('Info',response.message,'info');
		            var pram = response.pram;
		            var url_img=baseurl+"upload/slide/"+pram;
		            top.$('.mce-btn.mce-open').parent().find('.mce-textbox').val(url_img);
		           // $("#id_uploadsuccess").val(pram);
		            //$("#branchimg_@index").attr('src','upload/branch/'+pram);
		           // $("#strongmessage").html("<font color='green'>" + JSON.stringify(response.message) + " </font>");
		            
		        }
		    },
		    'onStart': function() {
		    
		    }
		});
	   
	   
	   $("#feature_image_btn").click(function(){
		   $("#txtimage_slides_feature").click();
	   });
	
	   $("#txtimage_slides_feature").ajaxfileupload({
		   'action': "upload/publicimg/?folder=slide",
	        'valid_extensions' : ['jpg','png','gif'],
	        'onComplete': function(response) {   
	        
	        		 if (response.status==false) {
	                     alert(response.message);
	                 }
	                 if (response.status==true) {
	                     var pram = response.pram;
	                     var fullpath= baseurl+"/upload/slide/" +pram;
	                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
	                     $("#feature_image_input").val(pram);
	                     $("#feature_image_div").html(imgtag);
	                 }
	        },
	        'onStart': function() {
	        }
	    });
	   
 });	   
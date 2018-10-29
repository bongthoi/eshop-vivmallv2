 $(function () {
	 var objrules= {
			  invalidHandler: function(form, validator) {
				      var errors = validator.numberOfInvalids();
				      if (errors) {                    
				          validator.errorList[0].element.focus();
				      }
				} ,
						  rules : {
							  name: {required: true},
							  fee: {required: true,number: true}
						  },
						  messages: {
							  fee:{required:"This feilds is required!",number:  "This feilds is float!"},
							  name:{required:"This feilds is required!"}
						    }//end message
						};//end obj rules 
	
	 	var frm_add =   $('#frm_add');
	    frm_add.validate(objrules);
	    //validate form
	    $("#frm_add button[type='submit']").click(function(){
	    	frm_valib=frm_add.valid();
		});
	    
	 //Enable iCheck plugin for checkboxes
	    //iCheck for checkbox and radio inputs
	    $('.tb-delivery input[type="checkbox"]').iCheck({
	      checkboxClass: 'icheckbox_flat-blue',
	      radioClass: 'iradio_flat-blue'
	    });

	    //Enable check and uncheck all functionality
	   $(".checkbox-toggle66").click(function () {
	      var clicks = $(this).data('clicks');
	      if (clicks) {
	        //Uncheck all checkboxes
	        $(".tb-delivery input[type='checkbox']").iCheck("uncheck");
	        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
	      } else {
	        //Check all checkboxes
	        $(".tb-delivery input[type='checkbox']").iCheck("check");
	        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
	      }
	      $(this).data("clicks", !clicks);
	    });
	   
	

	   $("#do_active_delivery").click(function(){
		   var ids = [];
		     $.each($("#frm-table-delivery input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-delivery").attr('action',"admin/delivery/active");
		    	 $("#frm-table-delivery").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_disabled_delivery").click(function(){
		   var ids = [];
		     $.each($("#frm-table-delivery input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-delivery").attr('action',"admin/delivery/disabled");
		    	 $("#frm-table-delivery").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_delete_delivery").click(function(){
		   var ids = [];
		     $.each($("#frm-table-delivery input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-delivery").attr('action',"admin/delivery/delete");
		    	 $("#frm-table-delivery").submit();
		     }else{
		    	 return;
		     }
	   });
	   
		 
		 $("#feature_iconimage_btn").click(function(){
			 $("#txtimage_icondelivery_feature").click();
		});
	   
		 $("#txtimage_icondelivery_feature").ajaxfileupload({
			   'action': "upload/publicimg/?folder=delivery",
		        'valid_extensions' : ['jpg','png','gif'],
		        'onComplete': function(response) {   
		        
		        		 if (response.status==false) {
		                     alert(response.message);
		                 }
		                 if (response.status==true) {
		                     var pram = response.pram;
		                     var fullpath= baseurl+"/upload/delivery/" +pram;
		                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
		                     $("#feature_iconimage_input").val(pram);
		                     $("#feature_iconimage_div").html(imgtag);
		                 }
		        },
		        'onStart': function() {
		        }
		    });
	   
 });	   
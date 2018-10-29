 $(function () {
	 
	 var objrules= {
			  invalidHandler: function(form, validator) {
				      var errors = validator.numberOfInvalids();
				      if (errors) {                    
				          validator.errorList[0].element.focus();
				      }
				} ,
						rules : {
							  CategoryOrder: {required: true,number: true},
							  CategoryName: {required: true},
							  CategoryDes: {required: true}
						  },
						  messages: {
							  CategoryOrder:{required:"This feilds is required!",number:  "This feilds is integer!"},
							  CategoryName:{required:"This feilds is required!"},
							  CategoryDes:{required:"This feilds is required!"}
						    }///end message
						};//end obj rules 
	
	 	var frm_add =   $('#frm_add');
	    frm_add.validate(objrules);
	    //validate form
	    $("#frm_add button[type='submit']").click(function(){
	    	frm_valib=frm_add.valid();
		});
	 
	 
	    //Enable iCheck plugin for checkboxes
	    //iCheck for checkbox and radio inputs
	    $('.tb-category input[type="checkbox"]').iCheck({
	      checkboxClass: 'icheckbox_flat-blue',
	      radioClass: 'iradio_flat-blue'
	    });

	    //Enable check and uncheck all functionality
	   $(".checkbox-toggle77").click(function () {
	      var clicks = $(this).data('clicks');
	      if (clicks) {
	        //Uncheck all checkboxes
	        $(".tb-category input[type='checkbox']").iCheck("uncheck");
	        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
	      } else {
	        //Check all checkboxes
	        $(".tb-category input[type='checkbox']").iCheck("check");
	        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
	      }
	      $(this).data("clicks", !clicks);
	    });
	   
	

	   $("#do_active_category").click(function(){
		   var ids = [];
		     $.each($("#frm-table-category input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-category").attr('action',"admin/category/active");
		    	 $("#frm-table-category").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_disabled_category").click(function(){
		   var ids = [];
		     $.each($("#frm-table-category input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-category").attr('action',"admin/category/disabled");
		    	 $("#frm-table-category").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_delete_category").click(function(){
		   var ids = [];
		     $.each($("#frm-table-category input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-category").attr('action',"admin/category/delete");
		    	 $("#frm-table-category").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   $("#feature_image_btn").click(function(){
			 $("#txtimage_category_feature").click();
		});
	   
		 $("#txtimage_category_feature").ajaxfileupload({
			   'action': "upload/publicimg/?folder=category",
		        'valid_extensions' : ['jpg','png','gif'],
		        'onComplete': function(response) {   
		        
		        		 if (response.status==false) {
		                     alert(response.message);
		                 }
		                 if (response.status==true) {
		                     var pram = response.pram;
		                     var fullpath= baseurl+"/upload/category/" +pram;
		                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
		                     $("#feature_image_input").val(pram);
		                     $("#feature_image_div").html(imgtag);
		                 }
		        },
		        'onStart': function() {
		        }
		    });
	   
 });	   
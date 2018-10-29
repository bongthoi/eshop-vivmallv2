 $(function () {
	 
	 var objrules= {
			  invalidHandler: function(form, validator) {
				      var errors = validator.numberOfInvalids();
				      if (errors) {                    
				          validator.errorList[0].element.focus();
				      }
				} ,
						rules : {
							  ordered: {required: true,number: true},
							  name: {required: true},
							  description: {required: true}
						  },
						  messages: {
							  ordered:{required:"This feilds is required!",number:  "This feilds is integer!"},
							  name:{required:"This feilds is required!"},
							  description:{required:"This feilds is required!"}
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
	    $('.tb-newscategory input[type="checkbox"]').iCheck({
	      checkboxClass: 'icheckbox_flat-blue',
	      radioClass: 'iradio_flat-blue'
	    });

	    //Enable check and uncheck all functionality
	   $(".checkbox-toggle77").click(function () {
	      var clicks = $(this).data('clicks');
	      if (clicks) {
	        //Uncheck all checkboxes
	        $(".tb-newscategory input[type='checkbox']").iCheck("uncheck");
	        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
	      } else {
	        //Check all checkboxes
	        $(".tb-newscategory input[type='checkbox']").iCheck("check");
	        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
	      }
	      $(this).data("clicks", !clicks);
	    });
	   
	

	   $("#do_active_newscategory").click(function(){
		   var ids = [];
		     $.each($("#frm-table-newscategory input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-newscategory").attr('action',"admin/newscategories/active");
		    	 $("#frm-table-newscategory").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_disabled_newscategory").click(function(){
		   var ids = [];
		     $.each($("#frm-table-newscategory input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-newscategory").attr('action',"admin/newscategories/disabled");
		    	 $("#frm-table-newscategory").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_delete_newscategory").click(function(){
		   var ids = [];
		     $.each($("#frm-table-newscategory input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-newscategory").attr('action',"admin/newscategories/delete");
		    	 $("#frm-table-newscategory").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   $("#feature_image_btn").click(function(){
			 $("#txtimage_newscategory_feature").click();
		});
	   
		 $("#txtimage_newscategory_feature").ajaxfileupload({
			   'action': "upload/publicimg/?folder=newscategories",
		        'valid_extensions' : ['jpg','png','gif'],
		        'onComplete': function(response) {   
		        
		        		 if (response.status==false) {
		                     alert(response.message);
		                 }
		                 if (response.status==true) {
		                     var pram = response.pram;
		                     var fullpath= baseurl+"/upload/newscategories/" +pram;
		                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
		                     $("#feature_image_input").val(pram);
		                     $("#feature_image_div").html(imgtag);
		                 }
		        },
		        'onStart': function() {
		        }
		    });
	   
 });	   
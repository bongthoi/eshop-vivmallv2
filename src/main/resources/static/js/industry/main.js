 $(function () {
	 var objrules= {
			  invalidHandler: function(form, validator) {
				      var errors = validator.numberOfInvalids();
				      if (errors) {                    
				          validator.errorList[0].element.focus();
				      }
				} ,
						  rules : {
							  IndustryOrder: {required: true,number: true},
							  IndustryName: {required: true},
							  IndustryName: {required: true}
						  },
						  messages: {
							  IndustryOrder:{required:"This feilds is required!",number:  "This feilds is integer!"},
							  IndustryName:{required:"This feilds is required!"},
							  IndustryDes:{required:"This feilds is required!"}
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
	    $('.tb-industry input[type="checkbox"]').iCheck({
	      checkboxClass: 'icheckbox_flat-blue',
	      radioClass: 'iradio_flat-blue'
	    });

	    //Enable check and uncheck all functionality
	   $(".checkbox-toggle66").click(function () {
	      var clicks = $(this).data('clicks');
	      if (clicks) {
	        //Uncheck all checkboxes
	        $(".tb-industry input[type='checkbox']").iCheck("uncheck");
	        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
	      } else {
	        //Check all checkboxes
	        $(".tb-industry input[type='checkbox']").iCheck("check");
	        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
	      }
	      $(this).data("clicks", !clicks);
	    });
	   
	

	   $("#do_active_industry").click(function(){
		   var ids = [];
		     $.each($("#frm-table-industry input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-industry").attr('action',"admin/industry/active");
		    	 $("#frm-table-industry").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_disabled_industry").click(function(){
		   var ids = [];
		     $.each($("#frm-table-industry input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-industry").attr('action',"admin/industry/disabled");
		    	 $("#frm-table-industry").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_delete_industry").click(function(){
		   var ids = [];
		     $.each($("#frm-table-industry input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-industry").attr('action',"admin/industry/delete");
		    	 $("#frm-table-industry").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   $("#feature_image_btn").click(function(){
			 $("#txtimage_industry_feature").click();
		});
	   
		 $("#txtimage_industry_feature").ajaxfileupload({
			   'action': "upload/publicimg/?folder=industry",
		        'valid_extensions' : ['jpg','png','gif'],
		        'onComplete': function(response) {   
		        
		        		 if (response.status==false) {
		                     alert(response.message);
		                 }
		                 if (response.status==true) {
		                     var pram = response.pram;
		                     var fullpath= baseurl+"/upload/industry/" +pram;
		                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
		                     $("#feature_image_input").val(pram);
		                     $("#feature_image_div").html(imgtag);
		                 }
		        },
		        'onStart': function() {
		        }
		    });
		 
		 $("#feature_iconimage_btn").click(function(){
			 $("#txtimage_iconindustry_feature").click();
		});
	   
		 $("#txtimage_iconindustry_feature").ajaxfileupload({
			   'action': "upload/publicimg/?folder=industry",
		        'valid_extensions' : ['jpg','png','gif'],
		        'onComplete': function(response) {   
		        
		        		 if (response.status==false) {
		                     alert(response.message);
		                 }
		                 if (response.status==true) {
		                     var pram = response.pram;
		                     var fullpath= baseurl+"/upload/industry/" +pram;
		                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
		                     $("#feature_iconimage_input").val(pram);
		                     $("#feature_iconimage_div").html(imgtag);
		                 }
		        },
		        'onStart': function() {
		        }
		    });
	   
 });	   
 $(function () {
	 
	 var objrules= {
			  invalidHandler: function(form, validator) {
				      var errors = validator.numberOfInvalids();
				      if (errors) {                    
				          validator.errorList[0].element.focus();
				      }
				} ,
						rules : {
							  title: {required: true},
							  content: {required: true}
						  },
						  messages: {
							  title:{required:"This feilds is required!"},
							  content:{required:"This feilds is required!"}
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
	    $('.tb-news input[type="checkbox"]').iCheck({
	      checkboxClass: 'icheckbox_flat-blue',
	      radioClass: 'iradio_flat-blue'
	    });

	    //Enable check and uncheck all functionality
	   $(".checkbox-toggle77").click(function () {
	      var clicks = $(this).data('clicks');
	      if (clicks) {
	        //Uncheck all checkboxes
	        $(".tb-news input[type='checkbox']").iCheck("uncheck");
	        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
	      } else {
	        //Check all checkboxes
	        $(".tb-news input[type='checkbox']").iCheck("check");
	        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
	      }
	      $(this).data("clicks", !clicks);
	    });
	   
	   tinymce.init({
			  selector: '#content',
			  height: 300,
			  menubar: 'file edit insert view format table tools',
			 /* plugins: [
			    'advlist autolink lists link image charmap print preview anchor',
			    'searchreplace visualblocks code fullscreen',
			    'insertdatetime media table contextmenu paste code'
			  ],*/
			   plugins: ["image","link","textcolor","code","charmap","searchreplace","visualblocks","preview","fullscreen","table","lists"],
			  toolbar: 'undo redo | bold italic | fontselect fontsizeselect | forecolor backcolor |alignleft aligncenter alignright  alignjustify | bullist numlist indent outdent | link unlink image',
			  content_css: '//www.tinymce.com/css/codepen.min.css',
			  file_browser_callback_types: 'image',
			    file_browser_callback: function(field_name, url, type, win) {
			        if(type=='image'){
			        	$('#my_form_uploadnews input').click();
			        }
			    }
		});
		$("#btnsaveproduct").click(function(){
				//var pdata=$("#frm-about").serialize();
						var MCEeditor1=tinymce.get('content');
						var content1=MCEeditor1.getContent();		
						$("#content").val(content1);
						$("#frm_add").submit();
				
		});
		
		$('#txtimage_news').ajaxfileupload({
			'valid_extensions' : ['gif','png','jpg','jpeg'],
		    'action': "upload/publicimg/?folder=news",
		    'onComplete': function(response) {	
		        if (response.status==false) {
		        	$.messager.alert('Error',response.message,'error');
		        	 //$("#strongmessage").html("<font color='red'>" + JSON.stringify(response.message) + " </font>");
		        }
		        if (response.status==true) {
		        	//$.messager.alert('Info',response.message,'info');
		            var pram = response.pram;
		            var url_img=baseurl+"/upload/news/"+pram;
		            top.$('.mce-btn.mce-open').parent().find('.mce-textbox').val(url_img);
		           // $("#id_uploadsuccess").val(pram);
		            //$("#branchimg_@index").attr('src','upload/branch/'+pram);
		           // $("#strongmessage").html("<font color='green'>" + JSON.stringify(response.message) + " </font>");
		        }
		    },
		    'onStart': function() {
		    
		    }
		});
	   $("#do_active_news").click(function(){
		   var ids = [];
		     $.each($("#frm-table-news input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-news").attr('action',"admin/news/active");
		    	 $("#frm-table-news").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_disabled_news").click(function(){
		   var ids = [];
		     $.each($("#frm-table-news input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-news").attr('action',"admin/news/disabled");
		    	 $("#frm-table-news").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   
	   $("#do_delete_news").click(function(){
		   var ids = [];
		     $.each($("#frm-table-news input[type='checkbox']:checked"), function(){            
		    	 ids.push($(this).val());
		     });
		     if(ids.length>0){
		    	 $("#frm-table-news").attr('action',"admin/news/delete");
		    	 $("#frm-table-news").submit();
		     }else{
		    	 return;
		     }
	   });
	   
	   $("#feature_image_btn").click(function(){
			 $("#txtimage_news_feature").click();
		});
	   
		 $("#txtimage_news_feature").ajaxfileupload({
			   'action': "upload/publicimg/?folder=news",
		        'valid_extensions' : ['jpg','png','gif'],
		        'onComplete': function(response) {   
		        
		        		 if (response.status==false) {
		                     alert(response.message);
		                 }
		                 if (response.status==true) {
		                     var pram = response.pram;
		                     var fullpath= baseurl+"/upload/news/" +pram;
		                     var imgtag='<img alt="" src="'+fullpath+'" class="img img-responsive">';
		                     $("#feature_image_input").val(pram);
		                     $("#feature_image_div").html(imgtag);
		                 }
		        },
		        'onStart': function() {
		        }
		    });
	   
		 
		 
 });	   
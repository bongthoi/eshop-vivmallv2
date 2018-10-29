$(function () {	 
	tinymce.init({
		  selector: '#my_editor_guide',
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
		        	$('#my_form_uploadguide input').click();
		        }
		    }
	});
	$("#btnSaveGuide").click(function(){
			//var pdata=$("#frm-guide").serialize();
					var MCEeditor=tinymce.get('my_editor_guide');
					var content=MCEeditor.getContent();	
					//alert(content);
					$("#frm_guide_edit #my_editor_guide").val(content);
					//var pdata=$("#frm_about_edit").serialize();
					$("#frm_guide_edit").submit();
			
	});
	
	$('#txtimage_guide').ajaxfileupload({
		'valid_extensions' : ['gif','png','jpg','jpeg'],
	    'action': "upload/publicimg/?folder=guide",
	    'onComplete': function(response) {	
	        if (response.status==false) {
	        	$.messager.alert('Error',response.message,'error');
	        	 //$("#strongmessage").html("<font color='red'>" + JSON.stringify(response.message) + " </font>");
	        }
	        if (response.status==true) {
	        	//$.messager.alert('Info',response.message,'info');
	            var pram = response.pram;
	            var url_img=baseurl+"upload/guide/"+pram;
	            top.$('.mce-btn.mce-open').parent().find('.mce-textbox').val(url_img);
	           // $("#id_uploadsuccess").val(pram);
	            //$("#branchimg_@index").attr('src','upload/branch/'+pram);
	           // $("#strongmessage").html("<font color='green'>" + JSON.stringify(response.message) + " </font>");
	            
	        }
	    },
	    'onStart': function() {
	    
	    }
	});

});
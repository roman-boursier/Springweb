<div class="container">
	<jsp:include page="header.jsp" />
	<h3>Outil de recherche</h3>
	
	<div class="row">
    	<div class="col-sm">
			<div class="form-group">
				<label for="exampleFormControlSelect1"> Type :</label>
				 <select  class="form-control" id="Infotype">
				 	<option value="country">Country</option>
				 	<option value="regions">Region</option>
				 	<option value="city">City</option>
				 	<option value="street">Street</option>
				 	<option value="language">Langage</option>
				 </select>
			 </div>
  
			 <div class="form-group ui-widget">
				  <label for="libelle">Libellé</label>
				  <input class="form-control" id="libelle">
			 </div>
	 
	 		<input type="hidden" id="id" type="text" value=""/>
			<input type="hidden" id="type" type="text"/>	
			
			<input id="valider" class="btn btn-primary" type="submit" value="valider">
		</div>
	 
		<div class="col-sm">
			<div id="resultDiv" class="mt-md-4">
			</div>
		</div>
	</div>
</div>
</body>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function() {

		var info = "";
		
		//Form validated
		$("#valider").click(function(){
			let _id = $("#id").val();
			$.ajax({
	          	url:"/Springweb/autocomplete/" + info + "Single",
	          	method:"post",
	           	data:{id:_id},
	           	success:function(data){
	           		$("#resultDiv").html(data);
	           	},
	       	});
		});
		
		//Change type of info
	  	$("#Infotype").change(function(){
	       var selectedInfo = $(this).children("option:selected").val();
	       info = selectedInfo;
	   	});
		
	  	//Change type of info
	  	$('#libelle').on('autocompleteselect', function (e, ui) {
	       console.log(ui.item.id);
	       $("#id").val(ui.item.id);
	   	});
  		
	  	//Auto complete libelle
	    $('#libelle').autocomplete({
	       	source: function(request,response){
		       	$.ajax({
		          	url:"/Springweb/autocomplete/" + info,
		          	method:"post",
		           	data:{term:request.term},
		           	success:function(data){
		  				var ar = data.split(',');
		  				var json = [];
		  				for(i = 0; i<= ar.length; i++){
		  					if(ar[i]){
		  						let ar2 = ar[i].split('-');
		  						json.push({
		       					"label":ar2[1],
		       					"value":ar2[1],
		       					"id":ar2[0].replace(/\n|\r|(\n\r)/g,'')
		      					});
		  					}
		  				}
		              	response(json); 
		           	}
		       	});
	      	}
	   	});
	});
</script>
</html>
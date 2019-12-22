<div class="container">
	<jsp:include page="header.jsp" />
	
	<h1>Rechercher</h1>
	
	<div class="row mt-4">
    	<div class="col-sm">
			<div class="form-group">
				<label for="exampleFormControlSelect1"> Type :</label>
				 <select  class="form-control" id="Infotype">
				 	<option value="country">----</option>
				 	<option value="country">Country</option>
				 	<option value="regions">Region</option>
				 	<option value="city">City</option>
				 	<option value="street">Street</option>
				 	<option value="language">Langage</option>
				 </select>
			 </div>
  
			 <div class="form-group ui-widget">
				  <label for="libelle">Libelle</label>
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
	           	success:function(jsonResponse){
	           		const datas = JSON.parse(jsonResponse);
	           		console.log(datas);
	           		let result = '';
	           		switch(info) {
	           			case 'language':
	           				result = datas.idLanguage + "<hr>" +  datas.LanguageCode + "<hr>" + datas.LanguageName;
	           			break;
	           			case 'regions':
	           				result = datas.idArea + "<hr>" +  datas.areaLabel;
	           			break;
	           			case 'country':
	           				result = datas.idCountry + "<hr>" +  datas.codeIso;
	           			break;
	           			case 'city':
	           				result = datas.id + "<hr>" +  datas.cityName + "<hr>" +  datas.cityZipLabel;
	           			break;
	           			case 'street':
	           				result = datas.id + "<hr>" +  datas.street_name;
	           			break;
	           		}
	           		$("#resultDiv").html(result);
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
		           	success:function(jsonResponse){
		           		const datas = JSON.parse(jsonResponse);
		           		console.log(datas);
		           		let json = [];
		  				for(i=0; i<datas.length; i++){
		  					switch(info) {
			           			case 'language':
			           				json.push({
				       					"label":datas[i].LanguageName,
				       					"value":datas[i].LanguageName,
				       					"id":datas[i].idLanguage
				      					});
			           			break;
			           			case 'regions':
			           				json.push({
				       					"label":datas[i].areaLabel,
				       					"value":datas[i].areaLabel,
				       					"id":datas[i].idArea
				      					});
			           			break;
			           			case 'country':
			           				json.push({
				       					"label":datas[i].codeIso,
				       					"value":datas[i].codeIso,
				       					"id":datas[i].idCountry
				      					});
			           			break;
			           			case 'city':
			           				json.push({
				       					"label":datas[i].cityName,
				       					"value":datas[i].cityName,
				       					"id":datas[i].id
				      					});
			           			break;
			           			case 'street':
			           				json.push({
				       					"label":datas[i].street_name,
				       					"value":datas[i].street_name,
				       					"id":datas[i].id
				      					});
			           			break;
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
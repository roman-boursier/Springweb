<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd%22%3E
<html>
<head>       
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Autocomplete - Default functionality</title>
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
	

<body>
    <h3>Country</h3>
    
 <div class="ui-widget">
  <label for="country">Tags: </label>
  <input id="country">
</div>

    	<script>
 	 $( document ).ready(function() {
 		 {
 	            $('#country').autocomplete({
 	            	
 	            source:function(request,response){
 	            //Fetch data
 	            $.ajax({
 	                url:"getdata.jsp",
 	                method:"get",
 	                //dataType:'json',
 	                data:{term:request.term},
 	                success:function(data){
 	       				//console.log(data);
 	       				var ar = data.split(',');
 	       				var json = [];
 	       		
 	       				for(i = 0; i<= 0; i++){
 	       					console.log(ar[i]);
 	       					json.push({
	 	       					"label":ar[i],
	 	       					"value":ar[i]
 	       					});
 	       				}
 	       			console.log(json);
 	                    response(json);
 	                },
 	                error:function(data){
 	                	console.log(data);
 	                }
 	            });
 	            }
 	            });
 	     }
        
     });
 	</script>
   
</body>
</html>
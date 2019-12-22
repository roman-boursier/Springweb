<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp" />
<div class="container">
   	<h1>Villes</h1>

   	<form method="POST" action="pageVille/add">
   		<div class="row mt-4 mb-4">
			 <div class="col">
				  <input class="form-control" type="text" name="zipLabel" placeholder="Label">
			 </div>
			 <div class="col">
				  <input class="form-control" type="text" name="name" placeholder="name">
			 </div>
			 <div class="col">
			 	<input id="valider" class="form-control btn btn-primary" type="submit" value="Ajouter">
			 </div>
  		</div>
  	</form>

	
   <table class="table">
       <thead>
           <tr>
            <th>Id</th>
       		<th>Name</th>
       		<th>Zip label</th>
       		<th style="width:120px;">Actions</th>
           </tr>
       </thead>
       <tbody>
          <c:forEach items="${listCity}" var="city">
               <tr>
               	<td><c:out value="${city.id}"/></td>
               	 	<td><c:out value="${city.cityName}"/></td>
                   <td><c:out value="${city.cityZipLabel}"/></td>
                   <td>
                   		<a href="" class="btn btn-outline-primary editModalBtn" js-id="${city.id}" js-name="${city.cityName}" js-zip-label="${city.cityZipLabel}"><i class="fa fa-edit"></i></a>
                   		<a class="btn btn-outline-danger" href="pageVille/remove/?id=${city.id}"><i class="fa fa-trash"></i></a>
                   </td>
               </tr>
           </c:forEach>
       </tbody>
   </table>
       
    <!-- Modal -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
	    	<div class="modal-content">
				  <div class="modal-header">
				    <h5 class="modal-title" id="exampleModalLabel">Editer une langue</h5>
				    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				      <span aria-hidden="true">&times;</span>
				    </button>
				  </div>
				  <div class="modal-body">
				  	<form method="POST" action="pageVille/update">
					  	<div class="form-group">
					  		<label for="name">Name</label>
					  		 <input class="form-control" type="text" name="name">
					  	</div>
					  	<div class="form-group">
					  		<label for="zipLabel">Zip label</label>
					  		 <input class="form-control" type="text" name="zipLabel">
					  	</div>
					   	<input type="hidden" name="id">
					   	
						  <div class="modal-footer">
						    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
						    <button type="submit" class="btn btn-primary">Valider</button>
						  </div>
					</form>
				</div>
	  		</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	$('.editModalBtn').on( "click", function(e) {
		e.preventDefault();
		target = $(e.currentTarget);
		modalForm = $('#editModal');
		
		id = target.attr('js-id');
		zipLabel = target.attr('js-zip-label');
		name = target.attr('js-name');
		
		idInput = $(modalForm.find("input[name='id']"));
		zipInput = $(modalForm.find("input[name='zipLabel']"));
		nameInput = $(modalForm.find("input[name='name']"));
		
		idInput.val(id);
		nameInput.val(name);
		zipInput.val(zipLabel);
		
		
		modalForm.modal();	
	});
});
</script>

</body>
</html>
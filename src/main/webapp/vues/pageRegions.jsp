<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp" />
<div class="container">
   	<h1>Regions</h1>

   	<form method="POST" action="pageRegions/add">
   		<div class="row mt-4 mb-4">
			  <div class="col-4">
				  <input class="form-control" type="text" name="name" placeholder="Name">
			 </div>
			 <div class="col-3">
			 	<input id="valider" class="form-control btn btn-primary" type="submit" value="Ajouter">
			 </div>
  		</div>
  	</form>

	
   <table class="table">
       <thead>
           <tr>
            <th>Id</th>
       		<th>Name</th>
       		<th style="width:120px">Actions</th>
           </tr>
       </thead>
       <tbody>
           <c:forEach items="${listRegions}" var="region">
               <tr>
               	<td><c:out value="${region.idArea}"/></td>
                   <td><c:out value="${region.areaLabel}"/></td>
                   <td style="width:120px">
                   		<a href="" class="btn btn-outline-primary editModalBtn" js-id="${region.idArea}" js-name="${region.areaLabel}"><i class="fa fa-edit"></i></a>
                   		<a class="btn btn-outline-danger" href="pageRegions/remove/?id=${region.idArea}"><i class="fa fa-trash"></i></a>
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
				  	<form method="POST" action="pageRegions/update">
					  	<div class="form-group">
					  		<label for="name">Name</label>
					  		 <input class="form-control" type="text" name="name">
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
		name = target.attr('js-name');
		
		idInput = $(modalForm.find("input[name='id']"));
		nameInput = $(modalForm.find("input[name='name']"));
		
		idInput.val(id);
		nameInput.val(name);
		
		modalForm.modal();	
	});
});
</script>

</body>
</html>
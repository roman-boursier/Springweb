<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="header.jsp" />
<div class="container">
   	<h1>Pays</h1>

   	<form method="POST" action="pagePays/add">
   		<div class="row mt-4 mb-4">
   			<div class="col">
				  <input class="form-control" type="text" name="id" placeholder="id">
			 </div>
			 <div class="col">
				  <input class="form-control" type="text" name="code" maxlength="3" placeholder="Code">
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
       		<th>Code ISO</th>
       		<th style="width:120px;">Actions</th>
           </tr>
       </thead>
       <tbody>
           <c:forEach items="${listCountry}" var="country">
               <tr>
               	<td><c:out value="${country.idCountry}"/></td>
               	 	<td><c:out value="${country.codeIso}"/></td>
                   <td style="width:120px;">
                   		<a href="" class="btn btn-outline-primary editModalBtn" js-id="${country.idCountry}" js-code="${country.codeIso}"><i class="fa fa-edit"></i></a>
                   		<a class="btn btn-outline-danger" href="pagePays/remove/?id=${country.idCountry}"><i class="fa fa-trash"></i></a>
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
				    <h5 class="modal-title" id="exampleModalLabel">Editer un pays</h5>
				    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				      <span aria-hidden="true">&times;</span>
				    </button>
				  </div>
				  <div class="modal-body">
				  	<form method="POST" action="pagePays/update">
					  	<div class="form-group">
					  		<label for="code">Code</label>
					  		 <input class="form-control" type="text" maxlength="3" name="code">
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
		code = target.attr('js-code');
		
		idInput = $(modalForm.find("input[name='id']"));
		codeInput = $(modalForm.find("input[name='code']"));
		
		idInput.val(id);
		codeInput.val(code);
		
		modalForm.modal();	
	});
});
</script>

</body>
</html>
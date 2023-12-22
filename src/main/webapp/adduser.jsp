<jsp:include page="include/header.jsp"/>

<h1>Add User Page</h1>
<form  method="post">
<div style="background-color:aqua;border:1px solid red; padding:5px;">
	<div style="padding:5px;"> 
	Enter Your User Name: <input type="text" required="required" name="username">
	</div>	
	<div style="padding:5px;"> 
	Enter Your Email: <input type="email" required="required" name="email">
	</div>
   <div>
   <input type="hidden" name="form" value="adduseroperation">
   </div>
   <div>
   <input type="submit" style="background-color:blue; color:white" value="Add User"/>
   </div>

</div>
</form>

<jsp:include page="include/footer.jsp"/>
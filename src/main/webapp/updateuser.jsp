<jsp:include page="include/header.jsp"/>
<h1>Update Page</h1>

<form method="post"action="<%= request.getContextPath() %>/home">
    <div style="background-color:aqua;border:1px solid red; padding:5px;">
        <div style="padding:5px;"> 
            Your User Id: <input type="text" required="required" name="user_id" readonly value="<%= request.getParameter("user_id") %>">
        </div>	
        <div style="padding:5px;"> 
            Enter Your User Name: <input type="text" required="required" name="username" value="<%= request.getParameter("username") %>">
        </div>	
        <div style="padding:5px;"> 
            Enter Your Email: <input type="email" required="required" name="email" value="<%= request.getParameter("email") %>">
        </div>
        <div>
            <input type="hidden" name="form" value="updateuseroperation">
        </div>
        <div>
            <input type="submit" style="background-color:blue; color:white" value="Update User"/>
        </div>
    </div>
</form>

<jsp:include page="include/footer.jsp"/>

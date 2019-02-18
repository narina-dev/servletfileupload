

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File upload</title>
    </head>
    <body>
        <h1>File upload</h1>
        
        <hr>
        
        <form method="post" action="Uploader"  enctype="multipart/form-data" name="form1"> 
            Name:<input type="text" name="name" /><br>
            Address:<input type="text" name="address"/><br>
            Select your image:<input type="file" name="file" multiple="multiple"/><br>
            <input type="submit" value="start upload">
        </form>
    </body>
</html>

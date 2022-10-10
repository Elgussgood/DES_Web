<%-- 
    Document   : index
    Created on : Oct 8, 2022, 4:23:12 PM
    Author     : gussr
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Cifrado DES</title>
    <script src="js/Btn.js"></script>
    </head>
    <body>
        <div id="menu">
            <form action="Recibir" method="POST" enctype="multipart/form-data" name="formulario">
                <div id="titulo"><p>Cifrado DES</p></div>
                <p class="elementosform">Sube un archivo para poder aplicarle el cifrado DES</p>
                <label class="elementosform" for="clave">Introduce tu clave:</label>
                <input type="text" class="elementosform" id="clave" name="clave" placeholder="Clave">
                <button type="submit" id="btn_cifrar" name="btn_cifrar" onclick="MostrarEC();" value="Ci">Cifrar</button><br>
                <button type="submit" id="btn_decifrar" name="btn_decifrar" onclick="MostrarE();" value="De">Descifrar</button>
                <div id="subir_txt">
                    <p>Subir archivo a cifrar</p>
                    <input type="file" id="btn_subir" name="archivo" onclick="MostrarCD();" accept=".txt,.cifrado">
                </div>
                <%
                
              
                if(request.getAttribute("error") != null){
                    out.println("<div id='error'>"+(String)request.getAttribute("error")+"</div>");
                }
                %>
                <input type="submit" id="btn_enviar" value="Ejecutar">
            </form>
        </div>
    </body>
</html>

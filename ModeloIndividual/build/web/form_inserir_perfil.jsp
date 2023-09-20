<%--@page import="modelo.Perfil"--%>
<%@page import="java.util.ArrayList"%>
<%--@page import="modelo.PerfilDAO"--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript" >
            function validaForm(){
                formulario = document.form_perfil;
                if(formulario.perfil.value==""){
                    alert("O Campo perfil deve ser preenchido!!");
                    formulario.perfil.focus();
                    return false;
                }

                return true;
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <table width="760" border="1">
                <tr>
                    <td width="760" height="150">
                        <%@include file="banner.jsp" %>
                    </td>
                </tr>
                <tr>
                    <td width="760" height="20" valign="top">
                        <%--@include file="menu.jsp" --%>
                        <a href="form_inserir_usuario.jsp">Inserir Usuário</a> | <a href="form_inserir_menu.jsp">Inserir Menu</a> | <a href="form_inserir_perfil.jsp">Inserir Perfil</a> |  <a href="listar_usuario.jsp">Listar Usuário</a> |  <a href="listar_menu.jsp">Listar Menu</a> |  <a href="listar_perfil.jsp">Listar Perfil</a>
                    </td>
                </tr>
                <tr>
                    <td width="760" height="330">
                        <form name="form_perfil" action="inserir_perfil.do" method="post" onsubmit="return validaForm();">
                            <table width="500">
                                <tr>
                                    <td>Perfil:</td>
                                    <td><input type="text" name="perfil" size="30" /> </td>
                                </tr>

                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Salvar" /> </td>
                                </tr>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>

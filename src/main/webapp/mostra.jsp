<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Olá</title>
<script type="text/javascript">
	function callService(valor) {
		document.getElementById("tipoTraducao").setAttribute("value", valor);
		document.forms["form"].submit();
	}
</script>
<style type="text/css">
#textoPuro,#botoes,#textoBase64 {
	display: inline-block;
}

#botoes button {
	display: block;
}
</style>
</head>
<body>
	<section id="principal">
		<form action="http://127.0.0.1:8080/base64-test/" method="post"
			id="form">
			<input type="hidden" value="E" name="tipoTraducao" id="tipoTraducao">
			<textarea id="textoPuro" name="textoPuro" rows="5" cols="70"
				placeholder="Texto Puro">${textoPuro}</textarea>
			<div id="botoes">
				<button type="button" onclick="callService(this.value)" value="E">&gt;&gt;</button>
				<button type="button" onclick="callService(this.value)" value="D">&lt;&lt;</button>
			</div>
			<textarea id="textoBase64" name="textoBase64" rows="5" cols="70"
				placeholder="Texto na base 64">${textoBase64}</textarea>
		</form>
	</section>
</body>
</html>
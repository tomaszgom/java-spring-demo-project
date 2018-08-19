<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<h2>Select Languages:</h2>

<form ACTION="goodbye">
<input type="radio" name="id" value="Java"> Java<BR>
<input type="radio" name="id" value=".NET"> .NET<BR>
<input type="radio" name="id" value="PHP"> PHP<BR>
<input type="radio" name="id" value="C/C++"> C/C++<BR>
<input type="radio" name="id" value="PERL"> PERL <BR>
<input type="submit" value="Submit">
</form>
<%

String select[] = request.getParameterValues("id"); 
if (select != null && select.length != 0) {
out.println("You have selected: ");
for (int i = 0; i < select.length; i++) {
out.println(select[i]); 
}
}
%>
</html>

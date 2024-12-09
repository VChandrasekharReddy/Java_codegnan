<%
    session.removeAttribute("userdata");
    session.invalidate();
%>
<script>
    // Redirect and replace history
    sessionStorage.clear();
    window.location.href = "../../login.jsp";
    history.replaceState(null, null, "../../login.jsp");
</script>


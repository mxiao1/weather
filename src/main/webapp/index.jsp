<%@ page contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script  type="text/javascript" src="<%=request.getContextPath() %>/assets/js/jquery.js"></script>
</head>
<body>
<h1 style="align-content: center">今天天气</h1>
<input class="cc" value="xi">
<button id="button">Hello ${student.name}!</button>
    </a>
</input>
<script>
    $(document).ready(function(){
        $("#button").click(function(){
            $(".cc").val("肖");
        })

    })
</script>
</body>
</html>

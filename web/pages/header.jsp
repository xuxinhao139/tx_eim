<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin Header</title>
    <link href="/css/header.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" language="javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box', 'school', 'config', 'other');
        $(document).ready(function() {
            $('#nav').find("a").click(function() {
                var id = $(this).attr('id');
                $.each(oplist, function(i, n) {
                    $('#'+n).attr('class', 'inactive');
                });
                $(this).parents("li").attr('class', 'active');
            });
        });
    </script>
</head>

<body>
<div id="all">
    <div id="banner"><h1>信息管理系统&nbsp;&nbsp;&nbsp;</h1></div>
    <div id="nav">
        <ul>
            <li class="inactive" id="user"><a href="http://www.txjava.cn" target="_blank">拓薪教育</a></li>
        </ul>
    </div>
    <div id="main">
        <div id="welcome">
            欢迎您：${user.nickname}
            <%--<img src="/images/clock.gif" />--%>
        </div>
        <div id="adminop">
            <ul>
                <li><a href="/userExistServlet" target="_parent">用户退出</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>

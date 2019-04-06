<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
        <div class="navbar-header">
            <a class="navbar-brand" onclick="window.location.href='${pageContext.request.contextPath}/manage'">后台管理首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">用户管理</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div><!-- /.navbar-collapse -->
</nav>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>汽车调查问卷后台管理系统</title>
    <style type="text/css">
        body{
            background-color: #DDE5ED;
            text-align: center;
        }

        #container{
            text-align: left;
            margin: 0 auto;
            width: 35%;
        }

        #container div{
            clear:both;
            margin-top:50px;
        }

        #container div:first-child{
            margin-top: 25px;
        }

        .toolbox .btn {
            display: block;
            margin-bottom: 20px;
            width: 147px;
        }

        .toolbox{
            position: absolute;
            right: 15%;
            top: 100px;
        }

        .question{
            width: 100%;
            display: block;
        }

        .option{
            display: block;
            width: 100px;
        }

        input{
            border-style:none none solid none;
            background-color:transparent;
        }

        #container h4 input{
            float: left;
        }

        #container h4 input.option{
            width: 17.5%
        }

        h2{
            margin: 0;
        }
    </style>
</head>
<body>
<jsp:include page="head.jsp" />

<div class=".container">
    <h2>问卷题目:<input type="text" name="survey_name"></h2>
    <div id="container">
    </div>
    <div class="toolbox">
        <button type="button" class="btn btn-default btn-lg" onclick="addquestion()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加问题
        </button>
        <button type="button" class="btn btn-default btn-lg" onclick="addradio()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加单选框
        </button>
        <button type="button" class="btn btn-default btn-lg" onclick="addcheckbox()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加多选框
        </button>
        <button type="button" class="btn btn-default btn-lg" onclick="delquestion()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 删除问题
        </button>
        <button type="button" class="btn btn-default btn-lg" onclick="delradio()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 删除单选框
        </button>
        <button type="button" class="btn btn-default btn-lg" onclick="delcheckbox()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 删除多选框
        </button>
        <button type="button" class="btn btn-default btn-lg" onclick="senddata()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 保存问卷
        </button>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
        src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script type="text/javascript">
    var questionnum = 1;
    //逻辑上的问题id
    var questionid;
    function addquestion() {
        //鼠标点击需要增加问题的编号时
        if($("#container div:last").attr("id") != undefined && getnum(questionid) != getnum($("#container div:last").attr("id"))){
            //拿到鼠标选择的问题之后的问题数量
            var num = $("#" + questionid).nextAll().length;
            //style="clear:both;margin-top:50px;"
            $("#" + questionid).after('<div id="' + changeid("+") + '" onclick="getquestionid(this)"><h3>问题' + Number(getnum(questionid) + Number(1)) + ':</h3><input class="question" type="text"></div>');
            addsort(num);
        }else{
            //style="clear:both;margin-top:50px;"
            $("#container").append('<div id="question' + questionnum + '" onclick="getquestionid(this)"><h3>问题' + questionnum + ':</h3><input class="question" type="text"></div>');
            questionid = "question" + questionnum;
            questionnum++;
        }
        $("h3").hover(function(){
            $(this).css("color" , "grey");
        },function(){
            $(this).css("color" , "black");
        });
    }

    function addsort(element){
        for(var i = element;i > 0;i--){
            if(i == "1"){
                $("#container div:last h3").text("问题" + (getnum($("#container div:last").attr("id")) + 1));
                $("#container div:last").attr("id" , "question" + (getnum($("#container div:last").attr("id")) + 1));
            }else{
                $("#container div").eq("-" + i).children("h3").text("问题" + (getnum($("#container div").eq("-" + i).attr("id")) + 1));
                $("#container div").eq("-" + i).attr("id" , "question" + (getnum($("#container div:eq(-" + i + ")").attr("id")) + 1));
            }
        }
    }

    function addradio(){
        //之前已经添加过h4
        if($("#" + questionid + " h4 input:last").attr("class") != undefined){
            if($("#" + questionid + " h4 input").eq(-2).attr("type") == "checkbox"){
                alert("该问题是多选题，不能再添加单选框!");
            }else{
                var tempid = parseInt($("#" + questionid + " h4 input:last").attr("name"));
                if(tempid % 4 == 0){
                    $("#" + questionid + " h4").append('<br style="clear:both;"><br>');
                }
                ++tempid;
                $("#" + questionid + " h4").append('<input type="radio"><input name="' + tempid +'" class="option" type="text">');
            }
        }else{
            $("#" + questionid).append('<h4><input type="radio"><input name="1" class="option" type="text"></h4>');
        }
    }

    function addcheckbox(){
        if($("#" + questionid + " h4 input:last").attr("class") != undefined){
            if($("#" + questionid + " h4 input").eq(-2).attr("type") == "radio"){
                alert("该问题是单选题，不能再添加多选框!");
            }else{
                var tempid = parseInt($("#" + questionid + " h4 input:last").attr("name"));
                if(tempid % 4 == 0){
                    $("#" + questionid + " h4").append('<br style="clear:both;"><br>');
                }
                ++tempid;
                $("#" + questionid + " h4").append('<input type="checkbox"><input name="' + tempid +'" class="option" type="text">');
            }
        }else{
            $("#" + questionid).append('<h4><input type="checkbox"><input name="1" class="option" type="text"></h4>');
        }
    }

    function delquestion(){
        if(getnum(questionid) == 0){
            alert("已经无问卷可以删除!");
            return ;
        }
        //鼠标点击需要删除问题的编号时
        if(getnum(questionid) != getnum($("#container div:last").attr("id"))){
            //得到被鼠标点击问题后剩余问题数量
            var num = $("#" + questionid).nextAll().length;
            $("#" + questionid).remove();
            questionnum--;
            delsort(num);
        }else{
            $("#" + questionid).remove();
            changeid("-");
            questionnum--;
        }
    }

    function delsort(element){
        for(var i = element;i > 0;i--){
            if(i == "1"){
                $("#container div:last h3").text("问题" + (getnum($("#container div:last").attr("id")) - 1));
                $("#container div:last").attr("id" , "question" + (getnum($("#container div:last").attr("id")) - 1));
            }else{
                $("#container div").eq("-" + i).children("h3").text("问题" + (getnum($("#container div").eq("-" + i).attr("id")) - 1));
                $("#container div").eq("-" + i).attr("id" , "question" + (getnum($("#container div:eq(-" + i + ")").attr("id")) - 1));
            }
        }
    }

    //添加选中删除功能
    function delradio(){
        if($("#" + questionid + " h4 input:last").attr("class") == undefined){
            alert("已经无单选框可以删除!");
            return ;
        }
        if($("#" + questionid + " h4 input").eq(-2).attr("type") == "checkbox"){
            alert("该问题是单选题，不能删除多选框!");
            return ;
        }else{
            $("#" + questionid + " h4 input:last").remove();
            $("#" + questionid + " h4 input:last").remove();
            if($("#" + questionid + " h4 input:last").attr("name") != undefined){
                var tempid = parseInt($("#" + questionid + " h4 input:last").attr("name").replace(/[^0-9]/g, ""));
                if(tempid % 4 == 0){
                    $("#" + questionid + " h4 br:last").remove();
                    $("#" + questionid + " h4 br:last").remove();
                }
            }
        }

    }

    function delcheckbox(){
        if($("#" + questionid + " h4 input:last").attr("class") == undefined){
            alert("已经无多选框可以删除!");
            return ;
        }
        if($("#" + questionid + " h4 input").eq(-2).attr("type") == "radio"){
            alert("该问题是多选题，不能删除单选框!");
        }else{
            $("#" + questionid + " h4 input:last").remove();
            $("#" + questionid + " h4 input:last").remove();
            if($("#" + questionid + " h4 input:last").attr("name") != undefined){
                var tempid = parseInt($("#" + questionid + " h4 input:last").attr("name").replace(/[^0-9]/g, ""));
                if(tempid % 4 == 0){
                    $("#" + questionid + " h4 br:last").remove();
                    $("#" + questionid + " h4 br:last").remove();
                }
            }
        }
    }

    //获取字符中的数字
    function getnum(element){
        return parseInt(element.replace(/[^0-9]/g, ""));
    }

    //获取鼠标点击的问题的id
    function getquestionid(element){
        questionid = element.id;
    }

    //根据传递的值对questionid进行改变
    function changeid(element){
        element == "+" ? questionid = "question" + (getnum(questionid) + 1) : questionid = "question" + (getnum(questionid) - 1);
    }

    function senddata(){
        $(this).attr("disabled" , "disabled");
        var content = {};
        var key = "survey_name";
        var value = $("input[name='survey_name']").val();
        content[key] = value;
        key = "";
        value = "";
        $("#container input.question").each(function(){
            //r是单选，c是多选
            key = $(this).next().next().attr("type") == "radio" ? "r" : "c";
            key += $(this).val().trim().replace(/\s/g,"");
            $(this).next().children("input.option").each(function(){
                value += $(this).val() + "*#";
            });
            content[key] = value;
        });
        content = {"content" : content}
        $.ajax({
            type: "POST",
            url: "resolve",
            data: JSON.stringify(content),
            // dataType: "json",
            contentType: "application/json",
            success: function(data){
                alert("问卷提交完成!");
                window.location.href="${pageContext.request.contextPath}/manage";
            }
        });
    }
</script>
</body>
</html>
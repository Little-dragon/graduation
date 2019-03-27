<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="zh-CN">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <style type="text/css">
        body {
            color: grey;
            background-color: #F7F8FA;
        }

        .subtag_spacing input {
            margin-left: 30px;
            margin-bottom: 50px;
        }
    </style>
    <script type="text/javascript">
        var result = [];
        var check_val = [];
        var i = 1;
        function commit() {
            $("#button").attr("disabled",true);
            while(true){
                option = document.getElementsByName("q" + i);
                //如果取不到option跳出循环
                if(option[0] == undefined)
                    break;
                for(j in option){
                    if(option[j].checked){
                        check_val.push(option[j].value);
                    }
                    //*为问题之间的分隔符
                }
                check_val.push(" ");
                result.push(check_val);
                i++;
                //置为空，否则下次循环含有上次的值
                check_val = [];
            }
            var res = {"result" : JSON.stringify(result)};
            $.ajax({
                // Post 方式，data参数不能为空""，
                type: "POST",
                //如果不传参数，也要写成"{}"，否则contentType将不能附加在Request Headers中。JSON.parse()
                url: "/xaau/survey",
                // data sent is json application/x-www-form-urlencoded; charset=UTF-8
                contentType: "application/json",
                // data in response will expected json
                dataType: "json",

                data: JSON.stringify(res) , //result.toString()
                anysc: false,
                success: function () {
                    alert("问卷提交完成,请勿重新提交，谢谢!");
                },
                error: function () {
                    //处理问题没有回答的情况stringify
                    alert("服务器出现了一点问题，莫慌哦。");
                }
            });
        }
    </script>
    <title>高中学习情况调查问卷</title>
</head>
<body>
<div class=".container" style="margin: 0 auto; width: 80%">
    <h1 class="text-center" style="color: black; margin: 30px 0">高中生学习情况调查</h1>
    <h4 color="#8B7070">各位同学好！本调查目的是了解同学的学习情况，为学校、教师改进工作提供参考，不会对同学产生任何不良影响，请如实填写！感谢配合！</h4>
    <hr>
    <div class="question-content">
        <div class="question-title">
            <h5>Q1：您认为对学习兴趣有影响的因素有哪些？（多选)</h5>
        </div>
        <div class="subtag_spacing">
            <input id="q1_1" type="radio" name="q1" value="很有兴趣" /><label
                for="q1_1">很有兴趣</label> <input id="q1_2" type="radio" name="q1"
                                               value="有兴趣" /><label for="q1_2">有兴趣</label> <input id="q1_3"
                                                                                                  type="radio" name="q1" value="没兴趣" /><label for="q1_3">没兴趣</label>
            <input id="q1_4" type="radio" name="q1" value="曾有兴趣" /><label
                for="q1_4">曾有兴趣</label>
        </div>
    </div>
    <div class="question-content">
        <div class="question-title">
            <h5>Q2：你喜欢什么科目?</h5>
        </div>
        <div class="subtag_spacing">
            <input id="q2_1" type="radio" name="q2" value="语文" /><label
                for="q2_1">语文</label> <input id="q2_2" type="radio" name="q2"
                                             value="数学" /><label for="q2_2">数学</label> <input id="q2_3"
                                                                                              type="radio" name="q2" value="英语" /><label for="q2_3">英语</label>
        </div>
    </div>
    <input id="button" type="button" onclick="commit()" value="提交" />
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
        src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
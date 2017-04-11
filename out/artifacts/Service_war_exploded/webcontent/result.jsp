<%--
  Created by IntelliJ IDEA.
  User: Sin
  Date: 2017/4/11
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>J2EE实验题目 - 欧瀚阳/卢洪利</title>

    <link rel="stylesheet" type="text/css" href="../webcontent/style/semantic.css">


    <script src="../webcontent/js/jquery.min.js"></script>
    <script src="../webcontent/js/semantic.js"></script>

    <script>
        $(document)
            .ready(function() {

                // fix main menu to page on passing
                $('.main.menu').visibility({
                    type: 'fixed'
                });
                $('.overlay').visibility({
                    type: 'fixed',
                    offset: 80
                });

                // lazy load images
                $('.image').visibility({
                    type: 'image',
                    transition: 'vertical flip in',
                    duration: 500
                });

                // show dropdown on hover
                $('.main.menu  .ui.dropdown').dropdown({
                    on: 'hover'
                });
            })
        ;
    </script>
    <script>
        $('select.dropdown')
            .dropdown()
        ;
    </script>

    <style type="text/css">

        body {
            background-color: #FFFFFF;
        }
        .main.container {
            margin-top: 2em;
        }

        .main.menu {
            margin-top: 4em;
            border-radius: 0;
            border: none;
            box-shadow: none;
            transition:
                    box-shadow 0.5s ease,
                    padding 0.5s ease
        ;
        }
        .main.menu .item img.logo {
            margin-right: 1.5em;
        }

        .overlay {
            float: left;
            margin: 0em 3em 1em 0em;
        }
        .overlay .menu {
            position: relative;
            left: 0;
            transition: left 0.5s ease;
        }

        .main.menu.fixed {
            background-color: #FFFFFF;
            border: 1px solid #DDD;
            box-shadow: 0px 3px 5px rgba(0, 0, 0, 0.2);
        }
        .overlay.fixed .menu {
            left: 800px;
        }

        .text.container .left.floated.image {
            margin: 2em 2em 2em -4em;
        }
        .text.container .right.floated.image {
            margin: 2em -4em 2em 2em;
        }

        .ui.footer.segment {
            margin: 5em 0em 0em;
            padding: 5em 0em;
        }
    </style>

</head>
<body>
<script type="text/javascript" color="102,185,255" zindex="-10" opacity="50" count="99" src="../webcontent/js/canvas-nest.min.js"></script>
<canvas id="c_n13" width="1366" height="559" style="position: fixed; top: 0px; left: 0px; z-index: -10; opacity: 50;"></canvas>

<div class="ui main text container">
    <h1 class="ui header">J2EE</h1>
    <p>J2EE的实验示例。作者：欧瀚阳&卢洪利</p>
</div>


<div class="ui borderless main menu">
    <div class="ui text container">
        <div id="item" class="item">
            <img class="logo" src="../webcontent/style/logo.png">
            首页
        </div>
        <script>
            document.getElementById("item").addEventListener("click", function() {
                window.location.href = "../webcontent/index.html"
            }, false)
        </script>
        <a href="#" class="header item">结果</a>
        <a href="#" class="item">帮助</a>
        <a href="#" class="item">关于</a>
        <a href="#" class="ui right floated dropdown item">
            其他 <i class="dropdown icon"></i>
            <div class="menu">
                <div class="item">源码</div>
                <div class="item">截图</div>
                <div class="divider"></div>
                <div class="header">Header Item</div>
                <div class="item">
                    <i class="dropdown icon"></i>
                    Sub Menu
                    <div class="menu">
                        <div class="item">Link Item</div>
                        <div class="item">Link Item</div>
                    </div>
                </div>
                <div class="item">Link Item</div>
            </div>
        </a>
    </div>
</div>

<div class="ui text container">

    <div class="ui attached message">
        <div class="header">
            运行结果
        </div>
    </div>
    <div class="field ui form attached fluid segment">
        <label>结果</label>
        <textarea readonly="readonly"><% String str = (String)request.getAttribute("result"); out.println(str);%></textarea>
    </div>
    <div class="ui bottom attached warning message">
        <i class="icon help"></i>
        遇到问题？ 查看<a href="#">帮助</a>.
    </div>

</div>

<div class="ui inverted vertical footer segment">
    <div class="ui center aligned container">
        <div class="ui stackable inverted divided grid">
            <div class="three wide column">
                <h4 class="ui inverted header">Group 1</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Link One</a>
                    <a href="#" class="item">Link Two</a>
                    <a href="#" class="item">Link Three</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Group 2</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Link One</a>
                    <a href="#" class="item">Link Two</a>
                    <a href="#" class="item">Link Three</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Group 3</h4>
                <div class="ui inverted link list">
                    <a href="#" class="item">Link One</a>
                    <a href="#" class="item">Link Two</a>
                    <a href="#" class="item">Link Three</a>
                </div>
            </div>
            <div class="seven wide column">
                <h4 class="ui inverted header">版权说明</h4>
                <p>本页使用Semantic UI提供的前端库</p>
            </div>
        </div>
        <div class="ui inverted section divider"></div>
        <img src="../webcontent/style/black_logo.png" class="ui centered mini image">
        <div class="ui horizontal inverted small divided link list">
            <a class="item" href="#">联系我们</a>
            <a class="item" href="#">关于本站</a>
            <a class="item" href="#">使用条款</a>
        </div>
    </div>
</div>
</body>

</html>


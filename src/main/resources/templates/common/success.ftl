<html>
<head>
    <meta charset="utf-8">
    <title>成功提示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    成功!
                </h4> <strong>${msg!""}</strong><a href="${url}" class="alert-link"><span id="second">3</span>s后自动跳转</a>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    <#--setTimeout('location.href="${url}"', 3000);-->

    var second = document.getElementById("second");
    var num = 3;
    setInterval(function () {
        num--;
        second.innerHTML = num + "";
        if (num <=0) {
            location.href="${url}";
        }
    },1000)
</script>

</html>
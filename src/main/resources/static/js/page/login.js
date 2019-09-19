$(function () {
    getCodeImg();
});

/**
 * 登录·提交表单
 */
function loginChange() {
    var data = {
        userName: $("#username").val(),
        userPwd: $("#password").val(),
        code: $("#code").val()
    };
    console.log(data);
    http(loginUrl, "post", true, data, "json", function (res) {
        console.log(res);
        if (res.type == "success") {
            window.localStorage.setItem("tokenId", res.data.token.tokenId);
            window.localStorage.setItem("uid", res.data.token.uid);
            window.localStorage.setItem("avatar", res.data.token.avatar);
            $('form').fadeOut(500);
            $("#accountTitle").text("Welcome");
            $('.wrapper').addClass('form-success');
            setTimeout(function () {
                window.location = "home";
            }, 1500);
        } else {
            alert(res.msg);
        }
    }, function (res) {
        alert("error");
    });
}

/**
 * 验证码刷新
 */
function refresh() {
    // 提示框隐藏
    $("#id-msg").hide();
    getCodeImg();
}

/**
 * 获取验证码图片
 */
function getCodeImg() {
    var data = {};
    http(codeImgUrl, "post", true, data, "json", function (res) {
        $("#captchaImg").attr("src", "data:image/jpg;base64," + res.codeImg);
    }, function () {
        alert("验证码请求错误！");
    });
}
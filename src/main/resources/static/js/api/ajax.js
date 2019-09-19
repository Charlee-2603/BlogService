var path = "http://localhost:8080/api";
// 获取验证码
var codeImgUrl = "/sys/code";
// 用户登录
var loginUrl ="/sys/login";
// 判断用户登录状态
var uType = "/sys/uType";
// 前端数据展示
var frontUrl = "/front/setHtml";

var postArticleURL = "/sys/article/post";
var getArticleLabelURL = "/sys/article/label";
var myCenterNav = "/sys/front/myCenter";
var getUserInfoURL = "/sys/user/getUserInfo";
var getArticleByUserIdURL = "/sys/user/getArticleByUserId";

function http(url, type, async, data, dataType, successFunction, errorFunction) {
    // data["selfToken"] = window.localStorage.token;
    $.ajax({
        type: type || "get",
        url: path + url,
        async: async,
        data: JSON.stringify(data),
        dataType: dataType || "json",
        contentType: "application/json",
        success: function (res) {
            successFunction(res);
        },
        error: errorFunction
    });
}
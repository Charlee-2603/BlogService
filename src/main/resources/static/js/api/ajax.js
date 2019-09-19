/**
 * ajax请求
 * 依赖jQuery
 */
var path = "localhost:8080";

function http(url, type, async, data, dataType, successFunction, errorFunction) {
    data["selfToken"] = window.localStorage.token;
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
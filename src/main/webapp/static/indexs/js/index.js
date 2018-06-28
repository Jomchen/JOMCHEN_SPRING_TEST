// var Socket = new WebSocket(url, [protocol] );
/*var socket = new WebSocket("ws://127.0.0.1:8080/getMyTextHandler");  // 这里应该填写地址
socket.onopen = function() {
    var state = checkState(socket.readyState);
    console.log(state);
    socket.send("webSocket client 的连接打开信息。。");
    console.log("webSocket connected !!");
};
socket.onmessage = function(message) {
    var result = message.data;
    var state = checkState(socket.readyState);
    console.log(state);
    console.log("webSocket client 的接收消息：" + result);
};
socket.onclose = function() {
    var state = checkState(socket.readyState);
    console.log(state);
    console.log("webSocket client 连接断开。。")
};
socket.onerrror = function() {
    var state = checkState(socket.readyState);
    console.log(state);
    console.log("webSocket client 错误 ！！");
};
window.onbeforeunload = function() {
  socket.close();
};

function checkState(state) {
    var result;
    switch(state) {
        case WebSocket.CONNECTING:
            result = "webSocket 正在连接";
            break;
        case WebSocket.OPEN:
            result = "webSocket 连接成功";
            break;
        case WebSocket.CLOSING:
            result = "webSocket 关闭中";
            break;
        case WebSocket.CLOSED:
            result = "webSocket 已经关闭";
            break;
        default:
            result = "webSocket 状态未知";
            break;
    }
    return result;
}


$(function() {
    $(".submit").click(function () {
        var data = prompt("请输入您要上传的字符串？", "Linux");
        socket.send(data);
    });
});*/

/ * ----------------------------------------------------------------------------------------------------------------- */

var sockjs = new SockJS("http://127.0.0.1:8080/getMyTextHandler");
sockjs.onopen = function() {
    console.log("sockJs 打开连接了。。。");
};
sockjs.onmessage = function(message) {
    console.log("sockJs 接收到的消息为：" + message.data);
};
sockjs.onclose = function() {
    console.log("sockJs 连接断开了。。。");
};

$(function() {
    $(".submit").click(function () {
        var data = prompt("请输入您要上传的字符串？", "Linux");
        sockjs.send(data);
    });
});

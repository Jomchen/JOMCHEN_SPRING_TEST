// var Socket = new WebSocket(url, [protocol] );
var socket = new WebSocket("ws://127.0.0.1:8080/getMyTextHandler");  // 这里应该填写地址
socket.onopen = function() {
    var r = checkState(socket.readyState);
    console.log(r);
    socket.send("webSocket client 的连接打开信息。。");
    console.log("webSocket connected !!");
};
socket.onmessage = function(message) {
    var result = message.data;
    var r = checkState(socket.readyState);
    console.log(r);
    console.log("webSocket client 的接收消息：" + result);
};
socket.onclose = function() {
    var r = checkState(socket.readyState);
    console.log(r);
    console.log("webSocket client disconnected !!")
};
socket.onerrror = function() {
    var r = checkState(socket.readyState);
    console.log(r);
    console.log("webSocket client error");
};
window.onbeforeunload = function() {
  socket.close();
};

function checkState(state) {
    var result;
    switch(state) {
        case WebSocket.CONNECTING:
            result = "正在连接";
            break;
        case WebSocket.OPEN:
            result = "连接成功";
            break;
        case WebSocket.CLOSING:
            result = "关闭中";
            break;
        case WebSocket.CLOSED:
            result = "已经关闭";
            break;
        default:
            result = "未知状态";
            break;
    }
}


$(function() {
    $(".submit").click(function () {
        var data = prompt("请输入您要上传的字符串？", "Linux");
        socket.send(data);
    });
});
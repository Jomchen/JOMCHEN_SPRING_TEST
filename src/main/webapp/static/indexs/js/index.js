// var Socket = new WebSocket(url, [protocol] );
/* ---------------------------- 对于普通的 webSocket ------------------- */
/*var socket = new WebSocket("ws://127.0.0.1:8080/getMyTextHandler");
socket.onopen = function() {
    var state = checkState(socket.readyState);
    console.log(state);
    socket.send("webSocket client 的连接打开信息。。");
    console.log("webSocket 连接了。。。");
};
socket.onmessage = function(message) {
    var result = message.data;
    var state = checkState(socket.readyState);
    console.log(state);
    console.log("webSocket 接收消息：" + result);
};
socket.onclose = function() {
    var state = checkState(socket.readyState);
    console.log(state);
    console.log("webSocket 连接断开。。")
};
socket.onerrror = function() {
    var state = checkState(socket.readyState);
    console.log(state);
    console.log("webSocket 错误 ！！");
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


/* -------------------------------- 对于 SockJs ---------------------------- */
/*var sockjs = new SockJS("http://127.0.0.1:8080/getMyTextHandler");
sockjs.onopen = function() {
    console.log("sockJs 打开连接了。。。");
};
sockjs.onmessage = function(message) {
    $(".some_message").append("<p>" + message.data + "</p>");
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
});*/

/* --------------------------------- 对于 STOMP --------------------------- */
var sockjs = new SockJS("/my_stomp_socket");
sockjs.onopen = function() {
    console.log("stompClient 打开了链接。。。")
};
sockjs.onmessage = function(message) {
    console.log("stompClient 接收到了消息为：" + message.data);
};
sockjs.onclose = function() {
    console.log("stompClient 连接关闭了。。。");
};

var stompClient = Stomp.over(sockjs);
stompClient.connect(
    {},
    function(frame) {
        console.log("stompClient 打开了链接。。。" + frame);
        stompClient.subscribe("/topic/subscript00", function(data) {
            $(".some_message").append("<p>订阅00消息：" + data.body + "</p>");
        });
        stompClient.subscribe("/topic/subscript01", function(data) {
            $(".some_message").append("<p>订阅01消息：" + data.body + "</p>");
        });
    },
    function(frame) {
        console.log("stompClient 链接断开了。。。" + frame)
    }
);

$(function() {
    // STOMP 只能传字符串
    $(".submit").click(function() {
        var data = prompt("请输入您要上传的字符串？", "Linux");
        stompClient.send("/app/stomp/handle00", {}, data);
    });
});

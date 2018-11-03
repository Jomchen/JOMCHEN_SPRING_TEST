var stompClient;
var hearders = {"name": "websocket00", "password": "websocket00"};

$(function () {
    $(".connect_websocket").click(function() {
        var sockJsClient = new SockJS("/my_stomp_socket");
        stompClient = Stomp.over(sockJsClient);
        stompClient.connect(
            hearders,
            function(frame) {
                console.log("websocket00 连接打开了。。。" + frame);
                stompClient.subscribe("/topic/subscript00", function(data) {
                    $(".text_content").append("<p>/topic/subscript00 接到信息为：" + data.body + "</p>");
                });
                stompClient.subscribe("/user/queue/notifications", function(data) {
                    $(".text_content").append("<p>websocket00 /user/queue/notifications 接到信息为：" + data.body + "</p>");
                });
                stompClient.subscribe("/app/jomchen", function(data) {
                    $(".text_content").append("<p>/app/jomchen 接到信息为：" + data.body + "</p>");
                });
            },
            function(frame) {
                console.log("websocket00 连接断开了。。。" + frame);
            }
        );
    });
    $(".close_websocket").click(function() {
        if (null != stompClient) {
            stompClient.disconnect();
        }
    });
    $(".websocket_anniu").click(function() {
        var data = prompt("您要传的信息为：", "websocket00");
        var sendData = {"cname": data};
        stompClient.send("/app/stomp/handle00", {}, JSON.stringify(sendData));
    });

    $(".handleRequest00ToItself").click(function() {
        var data = prompt("您要对自己发送的信息为：", "zhidingMessage");
        var sendData = {"cname": data};
        stompClient.send("/app/stomp/handleRequest00ToItself", {}, JSON.stringify(sendData));
    });
    $(".handleRequest00ToUser").click(function() {
        var data = prompt("您要对指定用户发送的用户：", "zhidingMessage");
        var sendData = {"cname": data, "address": "这是指的信息"};
        stompClient.send("/app/stomp/handleRequest00ToUser", {}, JSON.stringify(sendData));
    });

    $(".ajax_anniu").click(function() {
        var data = prompt("您要上传的 ajax 信息为：", "有梦的人");
        $.ajax({
            url: "/WebSocketController/ajax/websocket/test00",
            type: "POST",
            dataType: "json",
            data: { "name": data },
            success: function(data) {
                alert("在 websocket00 方 ajax 请求成功，返回完整数据为：\n" + JSON.stringify(data));
            },
            error: function(error) {
                alert("在 websocekt00 方 ajax 请求错误，错误数据为：" + JSON.stringify(error));
            }
        });
    });
});

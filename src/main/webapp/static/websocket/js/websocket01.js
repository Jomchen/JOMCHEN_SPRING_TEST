var stompClient;
var hearders = {"name": "websocket01", "password": "websocket01"};

$(function () {
    $(".connect_websocket").click(function() {
        var sockJsClient = new SockJS("/my_stomp_socket");
        stompClient = Stomp.over(sockJsClient);
        stompClient.connect(
            hearders,
            function(frame) {
                console.log("websocket01 连接打开了。。。" + frame);
                stompClient.subscribe("/topic/subscript01", function(data) {
                    $(".text_content").append("<p>/topic/subscript01 接到信息为：" + data.body + "</p>");
                });
                stompClient.subscribe("/user/queue/notifications", function(data) {
                    $(".text_content").append("<p>websocket01 /user/queue/notifications 接到信息为：" + data.body + "</p>");
                });
                stompClient.subscribe("/app/jomchen", function(data) {
                    $(".text_content").append("<p>/app/jomchen 接到信息为：" + data.body + "</p>");
                });
            },
            function(frame) {
                console.log("websocket01 连接断开了。。。" + frame);
            }
        );
    });
    $(".close_websocket").click(function() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
    });
    $(".websocket_anniu").click(function() {
        var data = prompt("您要传的信息为：", "websocket01");
        var sendData = {"cname": data};
        stompClient.send("/app/stomp/handle01", {}, JSON.stringify(sendData));
    });

    $(".ajax_anniu").click(function() {
        var data = prompt("您要上传的 ajax 信息为：", "谢晓峰");
        $.ajax({
            url: "/WebSocketController/ajax/websocket/test01",
            type: "POST",
            dataType: "json",
            data: {"name": data},
            success: function(result) {
                alert("在 websocket01 方 ajax 请求成功，返回完整数据为：\n" + JSON.stringify(result));
            },
            error: function(error) {
                alert("在websocket01 方的 ajax 请求失败信息为：" + error);
            }
        });
    });
});

var sockJsClient = new SockJS("/my_stomp_socket");
var stompClient = Stomp.over(sockJsClient);
stompClient.connect(
    {},
    function(frame) {
        console.log("websocket01 连接打开了。。。" + frame);
        stompClient.subscribe("/topic/subscript01", function(data) {
            $(".text_content").append("<p>/topic/subscript01 接到信息为：" + data.body + "</p>");
        });
    },
    function(frame) {
        console.log("websocket01 连接断开了。。。" + frame);
    }
);

$(function () {
    $(".websocket_anniu").click(function() {
        var data = prompt("您要传的信息为：", "websocket01");
        var sendData = {"cname": data};
        stompClient.send("/app/stomp/handle01", {}, JSON.stringify(sendData));
    });
});
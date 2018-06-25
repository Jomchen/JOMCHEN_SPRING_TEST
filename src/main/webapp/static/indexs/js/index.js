// var Socket = new WebSocket(url, [protocol] );
var socket = new WebSocket("/getMyTextHandler");  // 这里应该填写地址
socket.onopen = function() {
    socket.send("This is web socket sended messages at connect ..");
    console.log("web socket connected!!");
};
socket.onmessage = function(message) {
    var result = message.data;
    console.log("received message: " + result);
};
socket.onclose = function() {
    console.log("web socket disconnected!!")
};
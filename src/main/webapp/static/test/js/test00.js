
window.onload = function() {
    var nameUnd;
    var nameStr = "我是字符串"
    var nameNum = 3;
    var nameBoo = true;
    var nameObj = {"name": "李寻欢"};
    var nameFun = function() {};
    
    /*
    alert(typeof(nameUnd));
    alert(typeof(nameStr));
    alert(typeof(nameNum));
    alert(typeof(nameBoo));
    alert(typeof(nameObj));
    alert(typeof(nameFun));
    alert(nameFun);
    */
    
    var tops = document.getElementById("top");
    var anniu00 = document.getElementById("anniu00");
    var anniu01 = document.getElementById("anniu01");

    anniu00.onclick=function() {
      var username = document.getElementById("username");
      var zhi = username.value;
      sessionStorage.setItem("username", zhi);
    };
    anniu01.onclick=function () {
        // /TestController/test00Ajax
        var data = {
            "cid": 2,
            "age": 22,
            "cname": "独孤求败",
            "address": "南宋"
        };
        var remote = new XMLHttpRequest();
        remote.open("get", "/TestController/test00Ajax", true);
        remote.send(JSON.stringify("name=李刚"));
        var status = remote.status;
        alert("状态码为：" + status);
        var responseBody = remote.response.body;
        var responseText = remote.responseText;
        alert("responseBody：" + responseBody);
        alert("responseText：" + responseText);
    };
};



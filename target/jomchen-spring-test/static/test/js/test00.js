
window.onload = function() {
    var nameUnd;
    var nameStr = "我是字符串";
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
    
    var top = document.getElementById("top");
    var anniu00 = document.getElementById("anniu00");
    var anniu01 = document.getElementById("anniu01");
    var div00 = document.getElementById("div00");
    document.documentElement.style.overflow="auto";

    div00.onmousedown = function(e) {
        var event = e || window.event;
        var _this = this;
        var x = event.clientX - _this.offsetLeft;
        var y = event.clientY - _this.offsetTop;
        var offsetWidth = _this.offsetWidth;
        var offsetHeight = _this.offsetHeight;
        document.onmousemove = function(e) {

            e = e || window.event;
            var left = e.clientX - x;
            var top  = e.clientY - y;
            if (left < 0) {
                left = 0;
            } else if(left > (document.documentElement.clientWidth - _this.offsetWidth)) {
                left = document.documentElement.clientWidth - _this.offsetWidth;
            }
            if (top < 0) {
                top = 0;
            } else if (top > (document.documentElement.clientHeight - _this.offsetHeight)) {
                top = document.documentElement.clientHeight - _this.offsetHeight;
            }
            _this.style.left =left + 'px';
            _this.style.top = top + 'px';
            console.log("左: " + left);
            console.log("上: " + top);
        };
        document.onmouseup = function() {
            document.onmouseup = null;
            document.onmousemove = null;
        };
    };

    /*div00.onmousedown=function(e) {
        var event = e || window.event;
        var _this = e.target;
        var clientX = event.clientX;
        var clientY = event.clientY;
        var offsetTop = this.offsetTop;
        var offsetLeft = this.offsetLeft;
        var x = clientX - offsetLeft;
        var y = clientY - offsetTop;
        document.onmousemove=function(e) {
            _this.clientX = e.clientX - x + 'px';
            _this.clientY = e.clientY - y + 'px';
        };
        document.onmouseup=function() {
            document.onmouseup=null;
            document.onmousemove=null;
        }

    };*/


    anniu00.onclick=function() {
    };
    anniu01.onclick=function () {
    };
};



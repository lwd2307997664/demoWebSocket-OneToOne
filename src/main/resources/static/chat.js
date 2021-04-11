var stompClient=null;

/**
 * 连接事件
 */
function connect() {
    var socket=new SockJS("/endpointChat");
    stompClient=Stomp.over(socket);
    stompClient.connect({},function connectCallback(frame) {
        console.log('连接上');
        /**
         * /user前缀是因为SimpMessagingTemplate类汇总自动添加了路径前缀
         */
        stompClient.subscribe('/user/queue/chat',function (chat) {
            showGreeting(JSON.parse(chat.body));
        });
    });
}


function sendNMSG() {
    stompClient.send("/app/chat",{},JSON.stringify({'context':$("#context").val(),'to':$("#to").val()}));
}

function showGreeting(message) {
    $("#chatsConent").append("<div>"+message.from+":"+message.context+"</div>");
}

$(function () {
    connect();
    $("#send").click(function() {sendNMSG();});

});

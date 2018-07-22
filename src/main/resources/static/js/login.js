function login() {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8080/login?" + new Date() ,
        data: $('.login-form').serialize(),
        success: function (result) {
            console.log(result);
        },
        error : function() {
            alert("异常！");
        }
    });
}
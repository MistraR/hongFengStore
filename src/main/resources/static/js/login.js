function login() {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/login",
        data: $('.login-form').serialize(),
        success: function (result) {
            console.log(result);
        },
        error : function() {
            alert("异常！");
        }
    });
}
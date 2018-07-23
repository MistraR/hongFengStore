/*
$(function () {
    $("#submit").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/login",
            data: {"username":$("#username").val(),"password":$("#password").val()},
            success: function (result) {
                $("body").html(result);
                console.log(result);
                location.href="";
            },
            error : function() {
                alert("异常！");
            }
        });
    });
})
*/

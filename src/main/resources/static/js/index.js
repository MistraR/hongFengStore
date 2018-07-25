$(function () {
    $("#searchButton").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/goods/listSelect",
            data: {
                "name": $("#goodsName").val(),
                "number": $("#number").val(),
                "pageNum": 0,
                "pageSize": 10,
                "order": "createTime",
                "orderBy": "ASC"
            },
            success: function (result) {
                renderGoodsList(result);
            }
        });
    });
})

function page(value) {
    var pageNumber = $("#pageNumber").val();
    if (value == 1) {
        pageNumber = pageNumber - 2;
    }
    $.ajax({
        type: "POST",
        url: "/goods/listSelect",
        data: {
            "name": $("#goodsName").val(),
            "number": $("#number").val(),
            "pageNum": pageNumber,
            "pageSize": 10,
            "order": "createTime",
            "orderBy": "ASC"
        },
        success: function (result) {
            renderGoodsList(result);
        }
    });
}

function renderGoodsList(data) {
    $("#goodsListTable tbody").html("");
    console.log(data)
    $("#pageNumber").val(data.pageNum + 1);
    for (var i = 0; i < data.content.length; i++) {
        var good = data.content[i];
        var tr = "<tr><td>" + good.name + "</td><td>" +
            good.number + "</td><td>" +
            good.category + "</td><td>" +
            good.purchasePrice + "</td><td>" +
            good.retailPrice + "</td><td>" +
            good.wholesalePrice +"</td><td>" +
            good.standard + "</td><td>" + good.inventorySituation + "</td><td>" +good.createTime + "</td><td>"+
            "<button type='button' class=\"btn btn-sm btn-danger btn-block\" onclick='' >编辑</button>"
        $("#goodsListTable tbody").append(tr);
    }
}
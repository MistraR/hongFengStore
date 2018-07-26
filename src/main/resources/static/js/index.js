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
            good.purchasePrice + "</td><td>" +
            good.retailPrice + "</td><td>" +
            good.wholesalePrice +"</td><td>" +
            good.standard + "</td><td>" + good.inventorySituation + "</td><td>" +good.createTime + "</td><td>"+
            "<button type='button' class='btn btn-md btn-danger btn-block' type='button' id='editButton' data-toggle='modal' data-target='#myEditModal'>编辑</button>"
        $("#goodsListTable tbody").append(tr);
    }
}


function save() {
    $.ajax({
        type: "POST",
        url: "/goods/add",
        data: {
            "name": $("#addGoodsName").val(),
            "number": $("#addGoodsNumber").val(),
            "purchasePrice": $("#addGoodsPurchasePrice").val(),
            "wholesalePrice": $("#addGoodsWholesalePrice").val(),
            "retailPrice": $("#addGoodsRetailPrice").val(),
            "standard": $("#addGoodsStandard").val(),
            "inventorySituation":$("#addGoodsInventorySituation").val()
        },
        success: function (result) {
            $("#addForm")[0].reset();
            $('#myModal').modal('hide')
        }
    });
}
function toEdit() {
    $.ajax({
        type: "GET",
        url: "/goods/get",
        data: {
            "id": $(this).data.val()
        },
        success: function (result) {
            $('#myModal').modal('show')
            var good = result.content;
            $("#dataId").val(good.id);
            $("#editGoodsName").val(good.name);
            $("#editGoodsNumber").val(good.number);
            $("#editGoodsPurchasePrice").val(good.purchasePrice);
            $("#editGoodsWholesalePrice").val(good.wholesalePrice);
            $("#editGoodsRetailPrice").val(good.retailPrice);
            $("#editGoodsStandard").val(good.standard);
            $("#editGoodsInventorySituation").val(good.inventorySituation);
        }
    });
}
function edit() {
    $.ajax({
        type: "POST",
        url: "/goods/update",
        data: {
            "id":$("#dataId").val(),
            "name": $("#editGoodsName").val(),
            "number": $("#editGoodsNumber").val(),
            "purchasePrice": $("#editGoodsPurchasePrice").val(),
            "wholesalePrice": $("#editGoodsWholesalePrice").val(),
            "retailPrice": $("#editGoodsRetailPrice").val(),
            "standard": $("#editGoodsStandard").val(),
            "inventorySituation":$("#editGoodsInventorySituation").val()
        },
        success: function (result) {
            $("#editForm")[0].reset();
            $('#myEditModal').modal('hide')
        }
    });
}

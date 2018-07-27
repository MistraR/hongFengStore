$(function () {
    $("#searchButton").click(function (e) {
        e.preventDefault();
        flush();
    });

})

function flush() {
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
}

function page(value) {
    var pageNumber = $("#pageNumber").text() - 1;
    var totalPages = $("#totalPages").text();
    if (value == 1) {
        pageNumber = pageNumber - 1;
    } else {
        pageNumber = pageNumber + 1;
    }
    if (pageNumber < 0) {
        pageNumber = 0;
    }
    if (pageNumber > totalPages - 1) {
        pageNumber = totalPages - 1;
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
            $("#pageNumber").text(result.pageNumber + 1);
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
            good.purchasePrice + "</td><td class='retailPriceColor'>" +
            good.retailPrice + "</td><td>" +
            good.wholesalePrice + "</td><td>" +
            good.standard + "</td><td>" + good.inventorySituation + "</td><td>" + good.createTime + "</td><td>" +
            "<button type='button' class='btn btn-sm btn-danger btn-block editButton' type='button'  onclick='toEdit(this)' data-toggle='modal' data='" + good.id + "'>编辑</button></td>"
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
            "inventorySituation": $("#addGoodsInventorySituation").val()
        },
        success: function (result) {
            $("#addForm")[0].reset();
            $('#myModal').modal('hide')
            flush();
        }
    });
}

function toEdit(_this) {
    var dataid = $(_this).attr("data");
    $.ajax({
        type: "GET",
        url: "/goods/get",
        data: {
            "id": dataid
        },
        success: function (result) {
            console.log(result);
            $('#myEditModal').modal('show')
            var good = result;
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
            "id": $("#dataId").val(),
            "name": $("#editGoodsName").val(),
            "number": $("#editGoodsNumber").val(),
            "purchasePrice": $("#editGoodsPurchasePrice").val(),
            "wholesalePrice": $("#editGoodsWholesalePrice").val(),
            "retailPrice": $("#editGoodsRetailPrice").val(),
            "standard": $("#editGoodsStandard").val(),
            "inventorySituation": $("#editGoodsInventorySituation").val()
        },
        success: function (result) {
            $("#editForm")[0].reset();
            $('#myEditModal').modal('hide')
            flush();
        }
    });
}

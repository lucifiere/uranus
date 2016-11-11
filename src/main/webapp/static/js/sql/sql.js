/**
 *  Created by XD.Wang on 2016/11/3.
 */

var i = 0;

function getCol() {
    var table = document.getElementById("tableList"); //定位id
    var index = table.selectedIndex; // 选中索引
    var value = table.options[index].text; // 选中值
    
    $.ajax({
        type:"get",
        url:"/tool/getCol",
        cache:false,
        async:false,
        dataType:"json",
        data:{"table": value},
        success:function(data){
            var select = document.getElementById("colList");
            var select1 = document.getElementById("colList1");
            for(var one in data){
                var objOption = document.createElement("OPTION");
                objOption.text=data[one];
                objOption.value=data[one];
                select.options.add(objOption);
            }
            for(var one in data){
                var objOption = document.createElement("OPTION");
                objOption.text=data[one];
                objOption.value=data[one];
                select1.options.add(objOption);
            }
        },
        error:function(){
            alert("错误！");
        }
    });
}

function addV() {
    if(!checkTableSelected()) return;
    var colList = document.getElementById('set');
    var colListNew = colList.cloneNode(true);
    colListNew.id = "set" + new Date().getMilliseconds();
    document.body.appendChild(colListNew);
}

function addQ() {
    if(!checkTableSelected()) return;
    var colList = document.getElementById('where');
    var colListNew = colList.cloneNode(true);
    colListNew.id = "where" + new Date().getMilliseconds();
    document.body.appendChild(colListNew);
}

function checkTableSelected() {
    if($("#tableList").find("option:selected").text() == "请选择"){
        alert("选择表！");
        return false;
    }
    return true;
}

function submit() {

}

function getDataVo() {
    if(!checkTableSelected()) return;
    var dataVo = {};
    dataVo.select = [];
    dataVo.table = $("#tableList").find("option:selected").text();
    dataVo.condition = $("#typeList").find("option:selected").val();
}
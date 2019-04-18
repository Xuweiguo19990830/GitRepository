$('select').select();
//表头属性
var head = [{
    label:'员工编号',
    width: 200,
    name:'cguid'
},{
    label:'员工姓名',
    width: 180,
    name:'crealname'
},{
    label: '员工账号',
    width: 200,
    name:'cname'
},{
    label:'市州服务部',
    width:280,
    name:'org_name'
}];

/* 这是什么意思？？？ */
$('.grid').Grid('addLoading');

/*    */
$('.grid').Grid({
    /*表头*/
    thead: head,
    tbody: null,
    height : 320,
    /*复选框*/
    checkbox: {
        single:true
    },
    operator: {
        type : "normal",
        width : 100
    },
    /* 这是定义了一个函数？？？ */
    sortCallBack : function(name,index,type){
        var sort = null;
        switch (index){
            case 1:
                sort = 'id';
                break;
            case 2:
                sort = 'create_time';
                break;
            case 3:
                sort = 'update_time';
                break;
            default:
                sort = 'id';
                break;
        }
        advanceSearch("sort:"+sort+" "+type+";");
    }

});

var ids = [];
/* 设置数据的方法 时间格式怎么设置 */
function setData(jsonArray) {
    //加载表格
    $('.grid').Grid('addLoading');
    //数据内容
    var tbody = [];
    //记录首个字段
    ids = [];
    //数据初始化
    for(var i=0;i<jsonArray.length;i++){
        str = [];
        var item = jsonArray[i];
        var regexStr = $("#allSearchInfo").val();
        for(var j=0;j<head.length;j++) {
            if(head[j].name.indexOf('Time')>-1){
                str.push(formatDate(item[head[j].name]));
            }else{
                //识别关键字并转换颜色
                var toReplace = item[head[j].name]+'';
                if(regexStr != null && regexStr != '' && toReplace!=null && toReplace.indexOf(regexStr)>-1){
                    toReplace = toReplace.replace(regexStr,'<span style="color:red">'+regexStr+'</span>');
                }
                str.push(toReplace);
            }
        }
        ids.push(item[head[0].name]);
        tbody.push(str);
    }
    /*//操作栏
 if(jsonArray.length>=1){
 var oper1 = [{label:'查看',onclick: function(){
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[0]);
 }},{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[0]);
 }}];
 tbody[0].push(oper1);
 }
 if(jsonArray.length>=2) {
 var oper2 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[1]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[1]);
 }}];
 tbody[1].push(oper2);
 };
 if(jsonArray.length>=3) {
 var oper3 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[2]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[2]);
 }}];
 tbody[2].push(oper3);
 }
 if(jsonArray.length>=4) {
 var oper4 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[3]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[3]);
 }}];
 tbody[3].push(oper4);
 }
 if(jsonArray.length>=5) {
 var oper5 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[4]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[4]);
 }}];
 tbody[4].push(oper5);
 }
 if(jsonArray.length>=6) {
 var oper6 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[5]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[5]);
 }}];
 tbody[5].push(oper6);
 }
 if(jsonArray.length>=7) {
 var oper7 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[6]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[6]);
 }}];
 tbody[6].push(oper7);
 }
 if(jsonArray.length>=8) {
 var oper8 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[7]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[7]);
 }}];
 tbody[7].push(oper8);
 }
 if(jsonArray.length>=9) {
 var oper9 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[8]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[8]);
 }}];
 tbody[8].push(oper9);
 }
 if(jsonArray.length>=10) {
 var oper10 = [{
 label: '查看', onclick: function () {
 openDialog('800px','600px','详细信息',commonPath+'/backstage/employee/showDetail?id='+ids[9]);
 }
 },{label:'编辑',onclick:function(){
 openDialog('600px','400px','编辑信息',commonPath+'/backstage/employee/employeeEditCrm?id='+ids[9]);
 }}];
 tbody[9].push(oper10);
 }*/
 $('.grid').Grid('setData',tbody);
}


/*   分页查询？？？  */
function getData(no,condition) {
    $.post(commonPath+"/backstage/employee/getList?id="+$("#searchLevel").val(),{"pageNo":no,"condition":condition},function (data) {
        if(data==null){
            $('.grid').Grid('setData',null);
        }else{
            setData(data);
        }
    },"json");
}

/*  查询总记录数  */
function getTotal(condition){
    condition += condition.concat("index:"+$("#searchLevel").val()+";");
    var total;
    $.post(commonPath+"/backstage/employee/getTotal",{"condition":condition},function (data) {
        total = parseInt(data);
        if(total==0){
            $('.pagination').pagination(null);
        }else{
            $('.pagination').pagination(total,{
                callback: function(page){
                    getData(page,condition);
                    $("#pageNo").val(page);
                },
                display_msg: false
            });
        }
    });
}

$(function () {
    $('.grid').Grid('addLoading');
    getData(0,null);
    getTotal($("#searchLevel").val());
});

//搜索  点击搜索时调用该方法
function advanceSearch(sort) {
    var conditionStr = '';
    //模糊查询条件
    var nameC = $("#allSearchInfo").val();
    if(nameC!=null &&''!=nameC){
        conditionStr += 'allSearchInfo:'+nameC+';' + "index:" +$("#searchLevel").val()+";";
    }
    conditionStr += sort;
    getData(0,conditionStr);
    getTotal(conditionStr);
    $("#refresh_condition").val(conditionStr);
}

$("#searchButton").click(function () {
    advanceSearch("sort:id asc;");
});

$("#fix").click(function(){
    var indexs = $('.grid').Grid('getCheckedIndex');
    if(indexs.length <= 0){
        top.layer.msg("请选择修改积分的用户");
        return;
    }
    var fixStr = [];
    for(var i = 0;i<indexs.length;i++){
        fixStr.push(ids[indexs[i]]);
    }
    var openUrl = commonPath+'/backstage/score/transefer?ids='+fixStr+"&&type=2";//弹出窗口的url
    var iWidth=600; //弹出窗口的宽度;
    var iHeight=400; //弹出窗口的高度;
    openDialog(iWidth,iHeight,'积分配置',openUrl)
})
function refreshTable() {
    getData($("#pageNo").val(),$("#refresh_condition").val());
    getTotal($("#refresh_condition").val());
}


function uptime(value) {
    $("#upTimeSearch").val(value);
}

function getDeletes(){
    var indexs = $('.grid').Grid('getCheckedIndex');
    if(indexs.length>0){
        var deleteStr = [];
        for(var i =0;i<indexs.length;i++){
            deleteStr.push(ids[indexs[i]]);
        }
        $.post(commonPath+"/backstage/employee/deleteEmployee",{"delete":deleteStr.join('-')},function (data) {
            top.layer.msg(data.message);
            refreshTable();
        },"json");
    }
}

function setRoles() {
    var indexs = $('.grid').Grid('getCheckedIndex');
    if(indexs.length==1){
        openDialog('650px','350px','设置员工的角色',commonPath+'/backstage/userrole/setRole?cguid='+ids[indexs[0]]);
    }else if(indexs.length==0){
        top.layer.msg('请选择一个员工');
        return;
    }else{
        top.layer.msg('不能同时选中多个员工');
        return;
    }
}

//自定义日期框弹出
$('.search-box input[type=radio]').click(function(e) {
    if($(this).prop('checked')){
        if($(this).attr('data-define') === 'define'){
            $('.define-input').show();
        }else{
            $('.define-input').hide();
        }
    }
});
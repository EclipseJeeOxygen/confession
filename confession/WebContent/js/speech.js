$(function(){
	post();
});
function post(){
	var base=$("#base").val();
	$.ajax({
		url:base+'/message/checkAdmin.htm',
		type:'post',
		dataType:'json',
		success:function(data){
			/*console.log(data);*/
			show(data);
		}
	});
}
function show(data){
	$("#table_server").bootstrapTable({
		data:data,
		striped: true,
        undefinedText: "-",
        pagination: true, 
        paginationLoop:true,
        showToggle: true,
        pageNumber: 1,
        showPaginationSwitch:true, 
        pageSize: 20,
        search: true, 
        idField: "id",
        columns:[
        	{
        		title:'昵称',
        		field:'name',
        		align:'center'
        	},
        	{
        		title:'学号',
        		field:'userNameOne',
        		align:'center'
        	},
        	{
        		title:'内容',
        		field:'leaveMessage',
        		align:'center'
        	},
        	{
        		title:'日期',
        		field:'time',
        		align:'center'
        	},
        	{
        		title:'操作',
        		field:'id',
        		align:'center',
        		formatter:function(value){
        			var base=$("#base").val()+'/message/deleteMessage.htm?id='+ value;
        			var rtnValue="<a class='btn btn-primary btn-xs' href='" + base + "'>删除</a>"
        			/*console.log(rtnValue);*/
        			return rtnValue;
        		}
        	}
        ]
	});
}
 
/*function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        
        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
    }
}*/


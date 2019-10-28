<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + 
		":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>My BootStrap Home</title>
<link rel="stylesheet" href="static/bootstrap-4.1.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="static/bootstrap-table-master/dist/bootstrap-table.min.css">
<script type="text/javascript" src="static/bootstrap-4.1.3-dist/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
<script type="text/javascript" src="static/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
	<div style="width: 80%;">
		<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title text-center">Bootstrap-table样例演示</h3>
		</div>
		<div class="panel-body">
 
			<!-- <div id="toolbar" class="btn-group">
				<button id="btn_edit" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				</button>
				<button id="btn_delete" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div> -->
 
			<table data-toggle="table" id="table" data-height="400"
				data-classes="table table-hover" data-striped="true"
				data-pagination="true" data-side-pagination="server"
				data-search="true" data-show-refresh="true" data-show-toggle="true"
				data-show-columns="true" data-toolbar="#toolbar">
				<thead>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	
	</div>
	<table id="mytab" class="table table-hover">
	</table>
	
	<script type="text/javascript">
	$("#table")
	.bootstrapTable({
		url : "product/findAll.do",    //数据请求路径
		clickToSelect : true,  //点击表格项即可选择
		dataType : "json",   //后端数据传递类型
		striped: true,           //是否显示行间隔色 
		sidePagination: "client",      //分页方式：client客户端分页，server服务端分页（*）
		pageNumber:1,            //初始化加载第一页，默认第一页
		pageSize : 5,
		pageList : [ 5, 10, 20 ],
		//contentType: "application/x-www-form-urlencoded", //解决POST提交问题
		method : 'get',      //请求类型
		dataField : function(res){
			return res;
		},  //很重要，这是后端返回的实体数据！					
		//是否显示详细视图和列表视图的切换按钮
		queryParams : function(params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的  
			return {//这里的params是table提供的  
				offset : params.offset,//从数据库第几条记录开始  
				limit : params.limit
			//找多少条  
			};
		},
		responseHandler : function(res) {
			//在ajax获取到数据，渲染表格之前，修改数据源
			return res;
		},
		columns : [
				{
					 checkbox: true,
					 field : 'state',
				},
				{
					 field: 'prodSerialno',
		             title: '产品流水号',
					 align : 'center'
				},
				{
					 field: 'prodCode',
		             title: '产品代码',
					 align : 'center'
				},
				{
					 field: 'prodName',
		             title: '产品名称',
					 align : 'center'
				},
				{
					field : 'prodManager',
					title : '产品经理',
					align : 'center'
				},
				{
					title : '操作',
					field : 'prodSerialno',
					align : 'center',
					formatter : function(value, row, index) {
						var e = '<a href="javascript:void(0);" mce_href="#" onclick="edit(\''
								+ row.prodSerialno + '\')">编辑</a> ';
						var d = '<a href="javascript:void(0);" mce_href="#" onclick="del(\''
								+ row.prodSerialno + '\')">删除</a> ';
						return e + d;
					}

				} ]
		});
	
	function edit(id){
		alert(id);
	}
	function del(id){
		alert(id);
	}
	</script>
</body>
</html>
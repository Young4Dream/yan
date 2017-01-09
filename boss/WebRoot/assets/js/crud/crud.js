function ajaxCRUD(url, params, isAlert) {
	var resData;
	$.ajax({
				url : url,
				data : params,
				type : 'post',
				dataType : 'json',
				async : false, // 同步false
				error : function(data) {
					bootbox.alert({
								locale : "zh_CN",
								size : 'small',
								title : "提示",
								message : "error"
							});
				},
				success : function(data) {
					if (isAlert) {
						bootbox.alert({
									locale : "zh_CN",
									size : 'small',
									title : "提示",
									message : data.res
								});
					}
					resData = data;
				}
			});

	return resData;
}

// 是否有子节点
// 返回值 >0 有子节点
function hasChild(menuId, menuList) {
	var t = 0;
	for (var i = 0; i < menuList.length; i++) {
		var menu = menuList[i];
		if (menuId == menu.parentId) {
			t += 1;
		}
	}
	return t;
}

function bbAlert(msg) {
	bootbox.alert({
		locale : "zh_CN",
		size : 'small',
		title : "提示",
		message : msg
	});
}

function loadRef(tableName, ctrlId, allowEmpty) {
	var res = ajaxCRUD("ref!findAll.do", { "tableName": tableName }, false);
	var lst = res.lst;
	var html = "";
	if (allowEmpty == true) {
		html = "<option role='option' value='' selected='selected'>--请选择--</option>";
	} else if (allowEmpty != undefined) {
		html = "<option role='option' value='' selected='selected'>" + allowEmpty + "</option>";
	}
	$(lst).each(function(index) {
		var item = lst[index];
		if (html == "") {
			html += "<option role='option' value='" + item.id + "' selected='selected'>" + item.name + "</option>";
		} else {
			html += "<option role='option' value='" + item.id + "'>" + item.name + "</option>";
		}
	});
	$("#" + ctrlId).empty();
	$("#" + ctrlId).append(html);
}

// 查询数据并装载
function loadInfo(url, parm, elementClass) {
	var res = ajaxCRUD(url, parm, false);
	var obj = res.obj;
	loadObjInfo(obj, elementClass);
}

function loadObjInfo(obj, elementClass) {
	if (obj == undefined) return;
	$(elementClass).each(function() {
		var name = $(this).attr("name");
		var value = obj[name];
		if (value != undefined && value != null) {
			$(this).text(value);
		} else {
			$(this).text("");
		}
	});
}

function checkDate(date){
    return (new Date(date).getDate()==date.substring(date.length-2));
}

	

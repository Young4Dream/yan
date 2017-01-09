		
		var zTreeObj = null;
		
		function initAccountItemTree(){
			if (zTreeObj != null) return;
			zTreeObj = $.fn.zTree.init($("#treeAccountItem"), { callback: { onClick: nodeOnClick }}, []);																	
			var res = ajaxCRUD("sysAccountItem!findAll.do", {}, false);
			var lst = res.lst;
			$(lst).each(function(index) {
				var item = lst[index];
				var newNode = {
					id: item.id, 
					name: item.itemName, 
					code: item.itemCode, 
					parentId: item.parentId,
					remark: item.remark,
					parentCode: '',
					children: [],
					open: false
				};
        		if (newNode.parentId == undefined || newNode.parentId == null || newNode.parentId == "") {
        			// 添加根节点
        			var nodes = [];
        			nodes.push(newNode);
        			zTreeObj.addNodes(null, nodes);
        		} else {
        			var parent = zTreeObj.getNodeByParam("id", newNode.parentId);
        			if (parent == null) {
						bootbox.alert({
							locale : "zh_CN",
							size : 'small',
							title : "提示",
							message : "未知错误： 无法找到上级节点"
						});
        			} else {
        				// 直接添加下级节点
        				newNode.parentCode = parent.itemCode;
        				var nodes = [];
        				nodes.push(newNode);
        				zTreeObj.addNodes(parent, nodes, true);
        			}
        		}
			});
		}
		
		function nodeOnClick(event, treeId, treeNode) {
			$("#accountItemId").val(treeNode.id);
			$("#accountItemName").val(treeNode.name);
		}
		
		var zTreeObj1 = null;
		
		function initAttachItemTree(){
			if (zTreeObj1 != null) return;
			zTreeObj1 = $.fn.zTree.init($("#treeAttachItem"), { callback: { onClick: nodeOnClick1 }}, []);																	
			var res = ajaxCRUD("sysAccountItem!findAll.do", {}, false);
			var lst = res.lst;
			$(lst).each(function(index) {
				var item = lst[index];
				var newNode = {
					id: item.id, 
					name: item.itemName, 
					code: item.itemCode, 
					parentId: item.parentId,
					remark: item.remark,
					parentCode: '',
					children: [],
					open: false
				};
        		if (newNode.parentId == undefined || newNode.parentId == null || newNode.parentId == "") {
        			// 添加根节点
        			var nodes = [];
        			nodes.push(newNode);
        			zTreeObj1.addNodes(null, nodes);
        		} else {
        			var parent = zTreeObj1.getNodeByParam("id", newNode.parentId);
        			if (parent == null) {
						bootbox.alert({
							locale : "zh_CN",
							size : 'small',
							title : "提示",
							message : "未知错误： 无法找到上级节点"
						});
        			} else {
        				// 直接添加下级节点
        				newNode.parentCode = parent.itemCode;
        				var nodes = [];
        				nodes.push(newNode);
        				zTreeObj1.addNodes(parent, nodes, true);
        			}
        		}
			});
		}
		
		function nodeOnClick1(event, treeId, treeNode) {
			$("#attachItemId").val(treeNode.id);
			$("#attachItemName").val(treeNode.name);
		}
		
		
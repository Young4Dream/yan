		// 初始化部门树
		
		var zTreeResDept;
		var cbDeptId;
		var cbDeptName;
		
		function initResDeptTree(){
			var res = ajaxCRUD("resDept!findAll2Tree4Choosed.do", {}, false);
			var setting = {
				data: {
					simpleData: { 
						enable: true 
					}
				}
			};
			zTreeResDept = $.fn.zTree.init($("#treeResDept"), setting, res.ztree);
		}
		
		function getSelectedNode() {
			var nodes = zTreeResDept.getSelectedNodes();
			if (nodes == undefined || nodes.length == 0) {
				bootbox.alert({
					locale : "zh_CN",
					size : 'small',
					title : "提示",
					message : "请选择节点"
				});
				return undefined;
			} else {
				return nodes[0];
			}
		}
		
		
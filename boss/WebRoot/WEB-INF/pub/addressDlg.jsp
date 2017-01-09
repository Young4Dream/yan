<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	</head>

	<body>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="dlgAddress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						地址输入
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
					<input type="hidden" id="vlanChoosed" />
					<input type="hidden" id="accPrefixChoosed" />
					<input type="hidden" id="businessAreaChoosed" />
					<input type="hidden" id="userAreaChoosed" />
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding">
							地址前缀：
						</label>
						<div class="col-xs-10">
							<input type="text" id="addressPrefix" class="form-control" placeholder="点击选择地址前缀" readonly/>
						</div>
					</div>
					<div class="form-group" id="divAddress" style="display:none;">
						<label class="col-xs-2 control-label no-padding">
						</label>
						<div class="col-xs-10">
							<ul id="treeAddress" class="ztree" style="overflow:auto;" onmouseleave="hideDivAddress()"></ul>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 control-label no-padding">
							地址后缀：
						</label>
						<div class="col-xs-10">
							<input type="text" id="addressSuffix" class="form-control" placeholder="请输入地址后缀"/>
						</div>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnChooseAddress">
						确认
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>	
	<script type="text/javascript">
		var zAddressTreeObject;
		$(document).ready(function(){
			var res = ajaxCRUD("resAddress!findAll2Tree.do", {}, false);
			var setting = {
				callback: {
					onClick: addressNodeClicked
				},
				data: {
					simpleData: { 
						enable: true 
					}
				}
			};
			zAddressTreeObject = $.fn.zTree.init($("#treeAddress"), setting, res.ztree);
		});
		
    	$("#addressPrefix").focus(function() {
    		$("#divAddress").css("display", "block");
    	});

		function hideDivAddress() {
			$("#divAddress").css("display", "none");
		}
		
		function addressNodeClicked(event, treeId, treeNode) {
			$("#vlanChoosed").val(treeNode.vlan);
			$("#accPrefixChoosed").val(treeNode.accPrefix);
			$("#businessAreaChoosed").val(treeNode.businessArea);
			$("#userAreaChoosed").val(treeNode.userArea);
			var addressPrefix = treeNode.name;
			var pId = treeNode.pId;
			while (pId != undefined || pId != null || pId != "") {
				var node = zAddressTreeObject.getNodeByParam("id", pId, null);
				if (node == null) break;
				addressPrefix = node.name +  addressPrefix;
				pId = node.pId;
			}
			$("#addressPrefix").val(addressPrefix);
		}
		
		$("#btnChooseAddress").click(function() {
			fnAddressChoosed($("#addressPrefix").val() + $("#addressSuffix").val(), 
				$("#vlanChoosed").val(), 
				$("#accPrefixChoosed").val(),
				$("#businessAreaChoosed").val(),
				$("#userAreaChoosed").val());
			$("#dlgAddress").modal("hide");
		});
	</script>
	</body>
</html>

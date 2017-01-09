<%@ page language="java" pageEncoding="UTF-8"%>  
<%@taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<!-- page specific plugin styles -->
		<!-- fonts -->
		<link rel="stylesheet" href="assets/font/fonts.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<!-- 
		<link rel="stylesheet" href="assets/css/datepicker/bootstrap-datetimepicker.min.css">
		 -->
		<link rel="stylesheet" href="assets/css/datepicker/datetimepicker.css">
		<!-- inline styles related to this page -->

		<script src="assets/js/ace-extra.min.js">
		</script>	
		<!-- inline styles related to this page -->
	</head>

	<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home home-icon"></i>
					<a href="#">业务受理</a>
				</li>
				<li class="active">录音查询</li>
			</ul><!-- .breadcrumb -->
		</div>
		
		<div class="page-content">
			<div class="col-sm-12">
				<div class="table-responsive">
					<div class="table-search">
                        <div class="col-sm-12" style="padding-bottom:5px;">
                            <div class='col-sm-4'>
                                <label class="control-label no-padding" >坐席工号:</label>
                                <input type="text" class="input-small" name="" id="empl_no" style="margin-left: 14px;width:220px;">
                            </div>								
                            
                            <div class='col-sm-4'>
                                <label class="control-label no-padding-right" for="form-field-1" style="margin-left: 12px;">坐席姓名:</label>
                                <input type="text" class="input-small" name="" id="empl_name" style="margin-left: 2px;width:220px;">
                            </div>
                                                         
                            <div class='col-sm-4'>
                                <label class="control-label no-padding-right" for="form-field-1">来电号码:</label>
                                <input type="text" class="input-small" name="" id="customer_tel" style="margin-left: 14px;width:220px;">
                            </div>
                            
                        </div>
                        
								
								
				
						<div class="col-sm-12" style="padding-bottom: 5px;">
							<div class="col-sm-4">
								<div class="form-group no-padding col-sm-12">
								<label class="control-label no-padding col-sm-3 " style="margin-top: 2px;">
									开始时间:
								</label>
								
								<div class="input-group date form_datetime col-sm-9 no-padding-left" data-date="2016-03-01 05:25:07Z"  data-link-field="startTime">
                    				<input class="form-control" size="16" type="text" value="" readonly>
                   					<span class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</span>
               					 </div>
								<input type="hidden" id="start_time" value="" /><br/>
								</div>
							</div>

							<div class="col-sm-4">
								<div class="form-group no-padding col-sm-12">
								<label class="control-label no-padding-right col-sm-3 " style="margin-top: 2px;">
									结束时间:
								</label>
								
								<div class="input-group date form_datetime col-sm-9 no-padding-left" data-date="2016-03-01 05:25:07Z"  data-link-field="endTime">
                    				<input class="form-control" size="16" type="text" value="" readonly>
                   					<span class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</span>
               					 </div>
								<input type="hidden" id="end_time" value="" /><br/>
								</div>
								
								
								<!-- 
								<div class="input-group date form_datetime" id="aaaa">
    								<input class="form-control" type="text" value="" readonly>
    								<span class="input-group-addon"><i class="icon-th"></i></span>
								</div>
								 -->
								
								
							</div>
						</div>	
               
                        </div>
                        
                        <div class="col-sm-12" style="padding-bottom: 5px;">
                            <div class="col-sm-6">
                                <button type="submit" id="query"
                                    class="btn btn-sm btn-primary pull-right">
                                        查询
                                </button>
                            </div>
                        </div>
					</div>
					<br>
					
					<table id="sample-table-2" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>来电号码</th>
								<th>来电时间</th>
								<th>坐席工号</th>
								<th>坐席姓名</th>
								<th>操作</th>
							</tr>	
						</thead>
						<tbody></tbody>
					</table>					
                </div><!-- /.table-responsive -->
			</div>									
        

		<!-- 模态框（Modal） -->
		<div class="modal fade" id="listenModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<!-- 
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							&times;
						</button>
						 -->
						<h4 class="modal-title" id="myModalLabel">
							试听
						</h4>
					</div>
						<input type="hidden" id="modleuserId" >
						<input type="hidden" id="flag">
						<div class="modal-body">
							<!-- 
							<audio id="myAudio" controls></audio>
						 	-->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-sm btn-default"
								data-dismiss="modal" id="closeRecord">
								关闭
							</button>
						</div>

				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>








		<!-- basic scripts -->
		<script src="assets/js/handlebars-v3.0.1.js"></script>
		<script type="text/javascript" src="assets/js/crud/crud.js"></script>
		
		<script src='assets/js/jquery-2.0.3.min.js'></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.dataTables.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="assets/js/crud/crud.js"></script>
		<script src="assets/js/datepicker/bootstrap-datetimepicker.js"></script>
		<script src="assets/js/datepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		
		
		
		
		<script id="tpl" type="text/x-handlebars-template">
        <div class="action-buttons">
    	{{#each func}}
    	<a class="{{this.color}}" href="javascript:{{this.fn}}"><i class="icon-{{this.icon}} bigger-130"></i></a>
    	{{/each}}
		</div>
		</script>

		
		<script type="text/javascript"> 
            var userName="${sessionScope.userInfo.userName}";//session
            var oTable1;
			var param;
			
       

			jQuery(function($) {
				var tpl = $("#tpl").html();
		        //预编译模板
		        var template = Handlebars.compile(tpl);
				oTable1 = $('#sample-table-2').dataTable({
					"serverSide": true,//服务器模式，分页用
					"ajax":{
		            	"type": "post",
		            	"url": "record!selectRecordList.do",
		            	"data":param,
		            	"dataSrc": "recordList"
		            },
		            "aoColumns": [ 
		            	{"mDataProp":"customer_tel"},
		    			{"mDataProp":"creat_time"},
		    			{"mDataProp":"empl_no"},
		    			{"mDataProp":"empl_name"},
		    			{"mDataProp":""}
		    		],
		    		columnDefs: [
		                         {
		                             targets: 4,
		                             render: function (a, b, c, d) {
		 	                            var context =
		 	                            {
		 	                                func: [
		 										{"fn": "downLoad('" + c.file_path + "')", "color": "blue","icon": "download"},
		 										{"fn": "listen('" + c.file_path+ "')", "color": "red","icon": "play-circle"}
		 										
		 				                    ]
		 				                };
		 				                var html = template(context);
		 				                return html;
		                             }
		                         }			
		                     ],
					"bLengthChange": false,//
					"iDisplayLength" :10,
					"searching":false,//关闭dataTable自带搜索
					"bPaginate": true,//开启分页功能
					"bSort" : false,//关闭排序
					"language": {//国际化
						"url": "assets/js/Chinese.json"
					}
				});			
	        });
	        
            
            $("#query").click(function(){
            	var customer_tel = $("#customer_tel").val();
				var empl_no = $("#empl_no").val();
				var empl_name = $("#empl_name").val();
				var startTime = $("#start_time").val();
				var endTime = $("#end_time").val();
	        	param = {
	            	"recordHistroy.customerTel":customer_tel,
	            	"recordHistroy.emplNo":empl_no,
	            	"recordHistroy.emplName":empl_name,
	            	"startTime":startTime,
	            	"endTime":endTime
				};
	        	oTable1.fnSettings().ajax.data=param;
				oTable1.api().ajax.reload();
            }); 
            
            
            $("#closeRecord").click(function(){
            	document.getElementById("myAudio").pause(); 
            	document.getElementById("myAudio").currentTime = 0.0;
            	$(".modal-body").html("");
            }); 
            
            
			function downLoad(file_path){
				var url = "download!downLoad.do";
				
				var form = $("<form>");   //定义一个form表单
	            form.attr('style', 'display:none');   //在form表单中添加查询参数
	            form.attr('target', '');
	            form.attr('method', 'post');
	            form.attr('action', url);

	            var input1 = $('<input>');
	            input1.attr('type', 'hidden');
	            input1.attr('name', 'filePath');
	            input1.attr('value', file_path);
	            $('body').append(form);  //将表单放置在web中 
	            form.append(input1);   //将查询参数控件提交到表单上
	            form.submit();
            }
            
            
            function listen(file_path){
            	//var file = "/record/"+( file_path.split("/")[5] ).split(".")[0]; 
            	//$("#myAudio").iWish({audioSource: file, autoPlay: true});
            	var file = "/record/"+file_path.split("/")[5]; 
            	var markup = "";   
        			markup +="<audio controls preload='auto' src='" + file + "' id='myAudio'>";
        			markup +="</audio>";
        		$(".modal-body").append(markup);
            	
            	$("#listenModal").modal("show");
            }

            /**
            $(".form_datetime").datetimepicker({
    			language:  'zh-CN',
    			weekStart: 1,
    			todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				forceParse: 0,
    			showMeridian: 1
			});
           */
            
           
            $(".form_datetime").datetimepicker({
            	forceParse: 0,
            	startView: 2,
            	todayBtn:  1,
            	todayHighlight: 1,
				autoclose: 1,
            	language:"zh-CN",
                format: "yyyy-mm-dd hh:ii:ss"
            });
			
           
            (function ($) {
            	$.fn.iWish = function (options) {
            		// Declare variables (and create a audio element in the DOM for reference below when checking if the browser supports the HTML5 <audio>-tag)
            		var audioSource = options.audioSource, myAudio = document.createElement("audio"), fileExt, i = true;
            		// Check if the browser supports the HTML5 <audio>-tag
            		if (myAudio.canPlayType) {
            			// Set the variable fileExt to whatever file format supported by the browser
            			//fileExt = (!!myAudio.canPlayType && "" != myAudio.canPlayType('audio/mpeg') ? "mp3" : (!!myAudio.canPlayType && "" != myAudio.canPlayType('audio/wav') ? "wav" : (!!myAudio.canPlayType && "" != myAudio.canPlayType('audio/ogg; codecs="vorbis"') ? "ogg" : false)));
            			fileExt = "mp3";
            			// Loop through all the <audio>-tags in the document
            			$(this).each(function () {
            				// If the <audio>-tag lacks a src attribute and <source>-tag
            				if (typeof $(this).attr("src") === "undefined" && $(this).children("source").size() < 1) {
            					// Append a <source>-tag to the <audio>-tag with the file and correct file format
            					$(this).append('<source src="' + audioSource + '.' + fileExt + '">');
            					if (options.autoPlay && i) { // If we set autoplay to true when calling the function...
            						$(this).attr("autoplay", true); // ...add autoplay="true" to the first of all <audio>-tags
            						i = false;
            					}
            				}
            			});
            		} else { // If the browser doesnt support the <audio>-tag we let the user know that and remove the element
            			$(this).each(function () {
            				$(this).after('<p class="no-support">Your browser does not support the audio-tag.</p>');
            				$(this).hide();
            			});
            		}
            	}
            })(jQuery);

            $(document).ready(function () {
            	// Call the function with the filename skee-lo_i-wish and autoPlay to either true or false
            	
            });
            
            
            
          
		</script>
    </body>
</html>
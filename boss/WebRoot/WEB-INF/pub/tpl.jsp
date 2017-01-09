
<script id="tpl" type="text/x-handlebars-template">
	<div class="action-buttons">
		{{#each func}}
		<a class="{{this.color}}" 
			data-toggle="tooltip" 
			data-placement="bottom" 
			title="{{this.tooltip}}" 
			href="javascript:{{this.fn}}">
			<i class="icon-{{this.icon}} bigger-130"></i>
		</a>
		{{/each}}
	</div>
</script>


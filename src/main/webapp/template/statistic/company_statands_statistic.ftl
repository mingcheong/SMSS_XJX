<@fkMacros.pageHeader />
<div align="center" class="data_content">
	<div id="fillDiv" style=""></div>
	<div name="checkboxFrom" style="padding-left:5px;">
		<table width="100%" border="1" cellpadding="0" cellspacing="0" class="table_list_01" id="heightLightTable">
			  <tr>
			    <th width="100%" id="th_title" colspan="${areas?size+3}" class="print_title_th print_title">滁州市安全生产标准化达标企业统计表</th>
			  </tr>
			  <tr>
				<th colspan=2 style="width:15%;height: 30px;" >行业与等级</th>
			    <#list areas?if_exists as item>
					<th class="operator" >
						${item[1]}
					</th>
			    </#list>
			    <th style="width:5%;">合计</th>		
			    <tr style="height:30px;">
			  	<#assign rowTotal=0>
			 	<#assign columnName="">
			  	<#list statisticDatas?if_exists as s>
				    <#if s_index%areas?size==0><#if s_index!=0></tr><tr style="height:30px;"><#assign rowTotal=0></#if>
				    <#if columnName != s[3]><#assign columnName=s[3]><td rowSpan=5 class="font">${s[4]}</td></#if>
				    <td class="font">${s[6]}</td></#if>
				    <td id="td_${s[1]}" ><#if s[0]!=0><a href="javascript:void(0)">${s[0]}</a><#else>${s[0]}</#if><#assign rowTotal=rowTotal+s[0]></td>
				    <#if areas?size gt 1>	
				    <#if (s_index+1)%areas?size==0><#if s_index!=0><td id="td_t"><#if rowTotal!=0><a href="javascript:void(0)" >${rowTotal}</a><#else>${rowTotal}</#if></td></#if></#if>
				    <#else>
				   	<td id="td_t"><#if rowTotal!=0><a href="javascript:void(0)">${rowTotal}</a><#else>${rowTotal}</#if></td>
				    </#if>
			    </#list>
			  </tr>	    
  		</table>
	</div>
</div>
<@fkMacros.pageFooter />
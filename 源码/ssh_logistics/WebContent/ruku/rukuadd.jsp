<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<div class="pageContent">
<form method="post" name=form1 action="cangchumethod!rukuadd2" class="pageForm" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent nowrap" layoutH="80">
	
						<dl>
							<dt >
							商品名
							</dt>
							<dd >
								<input class="required " type="text" name="shangpingming" size="20" maxlength="20" />
							</dd>
						</dl>
						
						<dl>
							<dt >
							价格
							</dt>
							<dd >
								<input class="required " type="text" name="jiage" size="20" maxlength="20" />
							
							</dd>
						</dl>
						<dl>
							<dt >
							数量
							</dt>
							<dd >
								<input class="required " type="text" name="shuliang" size="20" maxlength="20" />
							
							</dd>
						</dl>
						<dl>
							<dt >
							占用面积
							</dt>
							<dd >
								<input class="required " type="text" name="zhanyongmianji" size="20" maxlength="20" />
							
							</dd>
						</dl>
					
					
				
						
	</div>
<div class="formBar">
      <ul>
            <li>
                 <div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div>
            </li>
            <li>
                  <div class="button"><div class="buttonContent"><button type="Button" class="close">取消</button></div></div>
            </li>
      </ul>
</div>
</form>
</div>


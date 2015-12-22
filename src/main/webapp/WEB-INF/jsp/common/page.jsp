<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="taglibs.jsp"%>

    共有${pager.totalCount}记录
    <a href="${uri}?${pager.fullUrl}&pageNo=1" class="ajax" refreshId='${refreshId}' >首页</a>
    <c:if test="${pager.isHasPre()}">
        <a href="${uri}?${pager.fullUrl}&pageNo=${pager.pageNo-1}" class="ajax" refreshId='${refreshId}' >上一页</a>
    </c:if>
    <c:if test="${!pager.isHasPre()}">
            <a href="javascript:;">上一页</a>
    </c:if>
    <c:if test="${pager.isHasNext()}">
        <a href="${uri}?${pager.fullUrl}&pageNo=${pager.pageNo+1}"  class="ajax" refreshId='${refreshId}'  >下一页</a>
    </c:if>
    <c:if test="${!pager.isHasNext()}">
        <a href="javascript:;">下一页</a>
    </c:if>
    <a href="${uri}?${pager.fullUrl}&pageNo=${pager.totalPages}" class="ajax" refreshId='${refreshId}' >末页</a>
    <a href="${uri}?${pager.fullUrl}&pageNo=${pager.pageNo}" class="ajax refresh" refreshId='${refreshId}' >刷新</a>

    第<input id="pageGo" type="text"  value="${pager.pageNo}" />/${pager.totalPages}页
    <input  type="button"  value="跳转" onclick="pagination()"   />
<script>
    function pagination(){
            var maxPage = '${pager.totalPages}';
            var regex = /^(\d)+$/;
            var cPage = document.getElementById("pageGo").value;
            if(!regex.exec(cPage)){
                alert('请输入数字！');
                return false;
            }
            if(maxPage==null || maxPage == ''){
                maxPage = 1;
            }
            if (parseInt(cPage) > parseInt(maxPage)) {
                cPage = maxPage;
            }
            window.location.href='${uri}?${pager.fullUrl}&pageNo='+cPage;
}
</script>

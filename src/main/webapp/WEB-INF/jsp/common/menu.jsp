<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script type="text/javascript" src="../static/j/jquery-1.11.1.min.js">
    <!--
    //导航树的配置
    $(function ($) {
        var setting = {
            callback: {
                onClick: zTreeOnClick,
                onExpand: zTreeOnExpand,
                onCollapse: zTreeOnCollapse
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: 0
                }
            },

            view: {
                showLine: true
            }
        }
        $(function () {
            var treeNodes;
            var navTree;
            $.ajax({
                type: 'GET',
                dataType: "json",
                url: "http://localhost:8090/menu/menuList.j",//请求的action路径
                success: function (result) {
                    if (result && result.success == "Y") {
                        treeNodes = result.data;
                        alert(treeNodes);
                        navTree= $.fn.zTree.init($("#navTree"), setting, treeNodes);
                        alert(navTree);
                    } else if (result && result.success == "N") {
                    }
                }
            });
            navTree = $.fn.zTree.init($("#navTree"), setting, treeNodes);
        });
    });
    //-->
</script>

<div id="leftBar">
    kkkkk
    ${treeNodes}
    <ul id="navTree" class="ztree"></ul>
</div>


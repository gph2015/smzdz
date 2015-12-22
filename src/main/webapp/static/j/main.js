/* 
 * @Author: lushijie
 * @Email lushijie1218@126.com
 * @Date:   2015-03-22 15:33:59
 */

$(function ($) {


    //时间选择框中文支持
    $.datepicker.regional['zh-CN'] = {
        clearText: '清除',
        clearStatus: '清除已选日期',
        closeText: '关闭',
        closeStatus: '不改变当前选择',
        prevText: '上月',
        prevStatus: '显示上月',
        prevBigText: '<<',
        prevBigStatus: '显示上一年',
        nextText: '下月',
        nextStatus: '显示下月',
        nextBigText: '>>',
        nextBigStatus: '显示下一年',
        currentText: '今天',
        currentStatus: '显示本月',
        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        monthNamesShort: ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一', '十二'],
        monthStatus: '选择月份',
        yearStatus: '选择年份',
        weekHeader: '周',
        weekStatus: '年内周次',
        dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
        dayStatus: '设置 DD 为一周起始',
        dateStatus: '选择 m月 d日, DD',
        dateFormat: 'yy-mm-dd',
        firstDay: 1,
        initStatus: '请选择日期',
        isRTL: false
    };
    $.datepicker.setDefaults($.datepicker.regional['zh-CN']);

    //时间格式化扩展
    //Demo: var time1 = new Date().Format("yyyy-MM-dd");
    //Demo: var time2 = new Date().Format("yyyy-MM-dd   HH:mm:ss");
    Date.prototype.Format = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) {
            fmt =
                fmt.replace(RegExp.$1,
                    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt =
                    fmt.replace(RegExp.$1,
                        (RegExp.$1.length == 1) ? (o[k])
                            : (("00" + o[k]).substr((""
                        + o[k]).length)));
            }
        }
        return fmt;
    }

    $(".datepickerStart,.datepickerEnd").datepicker({
        regional: ["zh-CN"],
        dateFormat: "yy-mm-dd",
        showOn: "both",	//点击按钮和input都可以弹出时间选择窗,showOn: "button"只是图片可以点击
        changeMonth: true,
        changeYear: true,
        buttonImage: "../static/i/calendar.gif",
        buttonImageOnly: true,
        buttonText: "Select date"
    });

    //$("#transactionList .datepickerStart,#transactionList .datepickerEnd").each(function () {
    //    $(this).val(new Date().Format("yyyy-MM-dd"));
    //});
    var zTreeNodes =
        [
            {
                "id": 13, name: "运营系统", open: "true",
                "children": [
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "产品管理",
                                "sort": 1,
                                "open": "true",
                                "url": "/app/getAppList.j",
                                "target": "_self"
                            },
                            {
                                "id": 10,
                                "name": "用户管理",
                                "sort": 3,
                                "open": "true",
                                "url": "/user/query.j",
                                "target": "_self"
                            }
                        ], "id": 2, "name": "权限管理", "sort": 1, "open": "true", "url": "", "target": "_self"
                    },
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "手续费配置管理",
                                "sort": 1,
                                "open": "true",
                                "url": "/payfee/query.j",
                                "target": "_self"
                            },
                            {
                                "id": 1,
                                "name": "渠道适配管理",
                                "sort": 2,
                                "open": "true",
                                "url": "/adapt/getAdaptList.j",
                                "target": "_self"
                            },
                            {
                                "id": 10,
                                "name": "机构路由管理",
                                "sort": 3,
                                "open": "true",
                                "url": "/router/routerList.j",
                                "target": "_self"
                            },
                            {
                                "id": 10,
                                "name": "支付机构管理",
                                "sort": 3,
                                "open": "true",
                                "url": "/agency/query.j",
                                "target": "_self"
                            },
                            {
                                "id": 10,
                                "name": "银行别名管理",
                                "sort": 3,
                                "open": "true",
                                "url": "/bankAlias/query.j",
                                "target": "_self"
                            },
                            {
                                "id": 10,
                                "name": "支付机构商户管理",
                                "sort": 3,
                                "open": "true",
                                "url": "/merchant/query.j",
                                "target": "_self"
                            },
                            {
                                "id": 10,
                                "name": "支付渠道管理",
                                "sort": 3,
                                "open": "true",
                                "url": "/channelInfo/query.j",
                                "target": "_self"
                            }
                        ],
                        "id": 3, "name": "配置管理", "sort": 2, "open": "true", "url": "", "target": "_self"
                    },
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "交易列表",
                                "sort": 1,
                                "open": "true",
                                "url": "/trans/transList.j",
                                "target": "_self"
                            }
                        ], "id": 4, "name": "交易管理", "sort": 3, "open": "true", "url": "", "target": "_self"
                    },
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "付款单审批",
                                "sort": 1,
                                "open": "true",
                                "url": "/transferBatch/transferBatchList.j",
                                "target": "_self"
                            },
                            {
                                "id": 9,
                                "name": "付款历史查询",
                                "sort": 1,
                                "open": "true",
                                "url": "/transfer/transferList.j",
                                "target": "_self"
                            }
                        ], "id": 4, "name": "代付管理", "sort": 3, "open": "true", "url": "", "target": "_self"
                    },
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "对账列表",
                                "sort": 1,
                                "open": "true",
                                "url": "/paycheck/payCheck.j",
                                "target": "_self"
                            },
                            {
                                "id": 9,
                                "name": "手续费对账列表",
                                "sort": 2,
                                "open": "true",
                                "url": "/paycheck/payCheckFee.j",
                                "target": "_self"
                            }
                        ], "id": 6, "name": "对账管理", "sort": 4, "open": "true", "url": "", "target": "_self"
                    },
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "收支报表",
                                "sort": 1,
                                "open": "true",
                                "url": "/report/reportList.j",
                                "target": "_self"
                            }
                        ],
                        "id": 7, "name": "报表管理", "sort": 5, "open": "true", "url": "", "target": "_self"
                    },
                    {
                        "children": [
                            {
                                "id": 9,
                                "name": "财务报表",
                                "sort": 1,
                                "open": "true",
                                "url": "/appReport/reportList.j",
                                "target": "_self"
                            },
                            {
                                "id": 9,
                                "name": "统计报表",
                                "sort": 2,
                                "open": "true",
                                "url": "/statis/report.j",
                                "target": "_self"
                            }
                        ],
                        "id": 8, "name": "业务自助查询", "sort": 6, "open": "true", "url": "", "target": "_self"
                    }
                ]
            }
        ];

    var otherzTreeNodes =
        [
            {
                "children": [
                    {
                        "id": 9,
                        "name": "交易列表",
                        "sort": 1,
                        "open": "true",
                        "url": "/trans/transList.j",
                        "target": "_self"
                    },
                    {
                        "id": 9,
                        "name": "财务报表",
                        "sort": 1,
                        "open": "true",
                        "url": "/appReport/reportList.j",
                        "target": "_self"
                    }

                ],
                "id": 8, "name": "业务自助查询", "sort": 6, "open": "true", "url": "", "target": "_self"
            }
        ];

    var transferzTreeNodes =
        [
            {
                "children": [
                    {
                        "id": 9,
                        "name": "付款单审批",
                        "sort": 1,
                        "open": "true",
                        "url": "/transferBatch/transferBatchList.j",
                        "target": "_self"
                    },
                    {
                        "id": 9,
                        "name": "付款历史查询",
                        "sort": 1,
                        "open": "true",
                        "url": "/transfer/transferList.j",
                        "target": "_self"
                    }
                ],
                "id": 4, "name": "代付管理", "sort": 3, "open": "true", "url": "", "target": "_self"
            }
        ];
    var transferAtranszTreeNodes =
        [
            {
                "children": [
                    {
                        "id": 9,
                        "name": "交易列表",
                        "sort": 1,
                        "open": "true",
                        "url": "/trans/transList.j",
                        "target": "_self"
                    },
                    {
                        "id": 9,
                        "name": "财务报表",
                        "sort": 1,
                        "open": "true",
                        "url": "/appReport/reportList.j",
                        "target": "_self"
                    }
                ],
                "id": 8, "name": "业务自助查询", "sort": 6, "open": "true", "url": "", "target": "_self"
            }, {
            "children": [
                {
                    "id": 9,
                    "name": "付款单审批",
                    "sort": 1,
                    "open": "true",
                    "url": "/transferBatch/transferBatchList.j",
                    "target": "_self"
                },
                {
                    "id": 9,
                    "name": "付款历史查询",
                    "sort": 1,
                    "open": "true",
                    "url": "/transfer/transferList.j",
                    "target": "_self"
                }
            ],
            "id": 4, "name": "代付管理", "sort": 3, "open": "true", "url": "", "target": "_self"
        }
        ];

    //导航树的配置
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
    var navTree = $.fn.zTree.init($("#navTree"), setting, zTreeNodes);
    var othernavTree = $.fn.zTree.init($("#othernavTree"), setting, otherzTreeNodes);
    var transfernavTree = $.fn.zTree.init($("#transfernavTree"), setting, transferzTreeNodes);
    var transferAtransnavTree = $.fn.zTree.init($("#transferAtransnavTree"), setting, transferAtranszTreeNodes);
    var pagesObj = {
        "13": "home",
        "1301": "productList",
        "1302": "productDetail",
        "1303": "transactionList",
        "1304": "transactionDetail",
        "1305": "addNewProduct",
        "1306": "addNewUser",
        "1307": "userList"
    }

    //function showOne(name,pagesObj){
    //	for(var property in pagesObj){
    //		if(pagesObj.hasOwnProperty(property)){
    //			$("#"+pagesObj[property]).css("display",'none');
    //		}
    //	}
    //	$("#"+name).css("display",'block');
    //}
    //导航树的点击
    function zTreeOnClick(event, treeId, treeNode) {
        //var location=[];
        //showOne(pagesObj[treeNode.id],pagesObj);
        //location.push(treeNode.name);
        //$(".pageTitle").html(treeNode.name);
        //while(treeNode.getParentNode()){
        //	var treeNode=treeNode.getParentNode();
        //	location.push(treeNode.name);
        //}
        //$(".pageLocation").html(location.reverse().join(">"));
    };
    //树开启记录开启的树id
    function zTreeOnExpand(event, treeId, treeNode) {
        console.log(treeNode);
    };
    //树关闭记录关闭的树id
    function zTreeOnCollapse(event, treeId, treeNode) {
        console.log(treeNode)
    };

    var selectStr1 = '<option value=""></option><option value="12">12</option><option value="13">13</option><option value="14">14</option>';
    var selectStr2 = '<option value="1">启用</option><option value="0">禁用</option>';
    //Chosen 插件 配置下拉框
    var config = {
        '.chosen_select110': {
            no_results_text: "None!",
            disable_search_threshold: 10,
            width: "110px"
        },
        '.chosen_select150': {
            no_results_text: "None!",
            disable_search_threshold: 10,
            width: "150px"
        }
    }
    //$(".chosen-select").chosen({no_results_text: "None!"});
    //$(".chosen-select").chosen({disable_search_threshold: 12});

    //Chosen 插件 配置下拉框
    for (var selector in config) {
        $(selector).chosen(config[selector]);
    }

    $("#chosen_productList_status").html(selectStr2).trigger("chosen:updated");
    $("#chosen_transactionList_product").html(selectStr1).trigger("chosen:updated");
    $("#chosen_transactionList_status").html(selectStr2).trigger("chosen:updated");
    $("#chosen_transactionList_platform").html(selectStr1).trigger("chosen:updated");
    $("#chosen_addNewProduct_company").html(selectStr1).trigger("chosen:updated");
    $("#chosen_addNewProduct_weixin").html(selectStr1).trigger("chosen:updated");
    $("#chosen_addNewUser_department").html(selectStr1).trigger("chosen:updated");

    $(".chosen-select").chosen().change(function (event) {
        console.log("ID:" + $(this).attr("id") + ";Value:" + $(this).val());
    });

    //renderpage(selector,currentPage,totalPage,leriPage);
    renderpage(".productListPager", 1, 20, 2);
    renderpage(".userListPager", 1, 20, 2);

    renderpage(".transactionListPager", 1, 20, 2);

    // 新增提交验证
    // $("#userSave").click(function(){
    // 	if($("#addNewUser .userText").val()=="" || $("#chosen_addNewUser_department").val()=="0"){
    // 		alert("请填写必填项");

    // 	}else{
    // 		alert("提交成功");
    // 		//location.reload();

    // 	}
    // });

    // $("#productSave").click(function(){

    // 	if($("#addNewProduct .userText").val()=="" ||  $("#chosen_addNewProduct_company").val()=="0" || $("#chosen_addNewProduct_weixin").val()=="0"){
    // 		alert("请填写必填项");

    // 	}else{
    // 		alert("提交成功");

    // 		//location.reload();
    // 	}
    // });

    function check() {
        alert('AAA');
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#aaa").find(".userText").each(function () {
            if ($(this).val() == "") {
                $(this).siblings(".point").css("display", "inline-block");
                emptyArr.push($(this));
            }
            else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        $('#aaa').find('.chosen_select150').each(function () {
            if (!$(this).find('option:selected').not($(this).find('option').eq(0)).length) {
                errorInfo = $(this).siblings(".point").css("display", "inline-block");
                ;
                emptyArr.push($(this));
            } else {
                $(this).siblings(".point").css("display", "none");
            }
        });

        flag = !emptyArr.length ? 1 : 0;

        return false;

        if (flag) {
            alert("提交成功");
        }

    }

    $("#userSave1").click(function () {
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#aaa").find(".userText").each(function () {
            if ($(this).val() == "") {
                $(this).siblings(".point").css("display", "inline-block");
                emptyArr.push($(this));
            }
            else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        $('#aaa').find('.chosen_select150').each(function () {
            if (!$(this).find('option:selected').not($(this).find('option').eq(0)).length) {
                errorInfo = $(this).siblings(".point").css("display", "inline-block");
                ;
                emptyArr.push($(this));
            } else {
                $(this).siblings(".point").css("display", "none");
            }
        });

        $('#aaa').submit = false;
        flag = !emptyArr.length ? 1 : 0;
        if (flag) {
            alert("提交成功");
        }
    });
    $("#productSave").click(function () {
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#addNewProduct").find(".userText").each(function () {
            if ($(this).val() == "") {
                $(this).siblings(".point").css("display", "inline-block");
                emptyArr.push($(this));
            }
            else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        $('#addNewProduct').find(".chosen_select150").each(function () {
            if (!$(this).find('option:selected').not($(this).find('option').eq(0)).length) {
                errorInfo = $(this).siblings(".point").css("display", "inline-block");
                ;
                emptyArr.push($(this));
            } else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        flag = !emptyArr.length ? 1 : 0;
        if (flag) {
            alert("提交成功");
        }
    });

});

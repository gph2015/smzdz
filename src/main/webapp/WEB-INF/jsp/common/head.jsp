<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/taglibs.jsp" %>


<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    搜狗支付运营中心
                </small>
            </a><!-- /.brand -->
        </div>
        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="grey">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-tasks"></i>
                        <span class="badge badge-grey">4</span>
                    </a>

                    <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="icon-ok"></i>
                            4 Tasks to complete
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
                                    <span class="pull-left">Software Update</span>
                                    <span class="pull-right">65%</span>
                                </div>

                                <div class="progress progress-mini ">
                                    <div style="width:65%" class="progress-bar "></div>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
                                    <span class="pull-left">Hardware Upgrade</span>
                                    <span class="pull-right">35%</span>
                                </div>

                                <div class="progress progress-mini ">
                                    <div style="width:35%" class="progress-bar progress-bar-danger"></div>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
                                    <span class="pull-left">Unit Testing</span>
                                    <span class="pull-right">15%</span>
                                </div>

                                <div class="progress progress-mini ">
                                    <div style="width:15%" class="progress-bar progress-bar-warning"></div>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
                                    <span class="pull-left">Bug Fixes</span>
                                    <span class="pull-right">90%</span>
                                </div>

                                <div class="progress progress-mini progress-striped active">
                                    <div style="width:90%" class="progress-bar progress-bar-success"></div>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                See tasks with details
                                <i class="icon-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="purple">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-bell-alt icon-animated-bell"></i>
                        <span class="badge badge-important">8</span>
                    </a>

                    <ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="icon-warning-sign"></i>
                            8 Notifications
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												New Comments
											</span>
                                    <span class="pull-right badge badge-info">+12</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="btn btn-xs btn-primary icon-user"></i>
                                Bob just signed up as an editor ...
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
												New Orders
											</span>
                                    <span class="pull-right badge badge-success">+8</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info icon-twitter"></i>
												Followers
											</span>
                                    <span class="pull-right badge badge-info">+11</span>
                                </div>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                See all notifications
                                <i class="icon-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="green">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="icon-envelope icon-animated-vertical"></i>
                        <span class="badge badge-success">5</span>
                    </a>

                    <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="icon-envelope-alt"></i>
                            5 Messages
                        </li>

                        <li>
                            <a href="#">
                                <img src="../assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar"/>
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Alex:</span>
												Ciao sociis natoque penatibus et auctor ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>a moment ago</span>
											</span>
										</span>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <img src="../assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar"/>
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Susan:</span>
												Vestibulum id ligula porta felis euismod ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>20 minutes ago</span>
											</span>
										</span>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <img src="../assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar"/>
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Bob:</span>
												Nullam quis risus eget urna mollis ornare ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>3:15 pm</span>
											</span>
										</span>
                            </a>
                        </li>

                        <li>
                            <a href="inbox.html">
                                See all messages
                                <i class="icon-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo"/>
								<span class="user-info">
									<small>欢迎,</small>
									${user.name}
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="${ctx}/system/loginOut.j">
                                <i class="icon-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- /.ace-nav -->
        </div>
        <!-- /.navbar-header -->
    </div>
    <!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {
                }
            </script>

            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-signal"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="icon-pencil"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="icon-group"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="icon-cogs"></i>
                    </button>
                </div>

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div>
            <!-- #sidebar-shortcuts -->

            <ul class="nav nav-list">
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text">  权限管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="/app/getAppList.j">
                                <i class="icon-double-angle-right"></i>
                                产品管理
                            </a>
                        </li>

                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                用户管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-group"></i>
                        <span class="menu-text"> 配置管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                手续费管理
                            </a>
                        </li>

                        <li>
                            <a href="jqgrid.html">
                                <i class="icon-double-angle-right"></i>
                                渠道适配
                            </a>
                        </li>
                        <li>
                            <a href="/router/routerList.j">
                                <i class="icon-double-angle-right"></i>
                                机构路由管理
                            </a>
                        </li>
                        <li>
                            <a href="jqgrid.html">
                                <i class="icon-double-angle-right"></i>
                                支付机构管理
                            </a>
                        </li>

                        <li>
                            <a href="jqgrid.html">
                                <i class="icon-double-angle-right"></i>
                                银行别名管理
                            </a>
                        </li>
                        <li>
                            <a href="jqgrid.html">
                                <i class="icon-double-angle-right"></i>
                                支付机构商户管理
                            </a>
                        </li>
                        <li>
                            <a href="jqgrid.html">
                                <i class="icon-double-angle-right"></i>
                                支付渠道管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text">交易管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                交易列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-coffee"></i>
                        <span class="menu-text">代付管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                付款单审批列表
                            </a>
                        </li>
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                付款单历史查询列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-exchange"></i>
                        <span class="menu-text">对账管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                对账列表
                            </a>
                        </li>
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                手续费对账列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-bar-chart"></i>
                        <span class="menu-text">报表管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                收支报表
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-book"></i>
                        <span class="menu-text">业务自助查询 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu" style="display: block;">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                财务报表
                            </a>
                        </li>
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i>
                                统计报表
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
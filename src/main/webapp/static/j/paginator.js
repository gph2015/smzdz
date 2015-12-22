/* 
* @Author: lushijie
* @Email lushijie1218@126.com
* @Date:   2015-03-23 16:03:25
*/
//总页数
//var totalPage=20;
//当前页前后显示页数
//var leriPage=3;
//总共要显示的页数

function  renderpage(selector,url,currentPage,totalPage,leriPage){
    console.log("currentPage:"+currentPage);
    //console.log("totalPage:"+totalPage);
    var i=0;
    var leriPage=(typeof (leriPage)=='undefined')?2:leriPage;
    var posnum=leriPage*2+5;//除去pre和next有的空位
    var pagearr=[];
    //页数不足
    if(totalPage<=posnum){
         for(i=1;i<=totalPage;i++){
             pagearr.push(i);
         }
         //console.log("页数不足")
    }
    //...在后面
    else if(currentPage<=(1+leriPage*2+1)){
        for(i=1;i<=posnum-2;i++){
            pagearr.push(i);
        }
        pagearr.push('...');
        pagearr.push(totalPage);
        //console.log("...在后面");
    }
    //...在前面
    else if(currentPage>=(totalPage-2*leriPage-1)){
        pagearr.push(1);
        pagearr.push('...');
        for(i=totalPage-(posnum-3);i<=totalPage;i++){
            pagearr.push(i);
        }
        //console.log("...在前面")
    }
    //...前后面都存在
    else if(pagearr.length==0){
        pagearr.push(1);
        pagearr.push('...');
        for(i=currentPage-leriPage;i<=currentPage+leriPage;i++){
            pagearr.push(i);
        }
        pagearr.push('...');
        pagearr.push(totalPage);
        //console.log("...在前后面")
    }

    var pageInnerHtml=[];
    // if (currentPage!=1) {
    //      pageInnerHtml.push('<ul><li class="pre"><</li>');
    // };
    //pageInnerHtml.push('<ul><li class="pre"><</li>');
    var preNo = currentPage-1;
    pageInnerHtml.push('<ul><li class="pre"><a href ="'+url+'&pageNo='+preNo+'">上一页</a></li>');



    for(i=0;i<pagearr.length;i++){
        var insertHtml='';
        if(currentPage==pagearr[i]){
            insertHtml='<li class="current">'+pagearr[i]+'</li>';
        }
        else{
            if(pagearr[i]=='...'){
                insertHtml='<li class="ellipsis">'+pagearr[i]+'</li>';
            }else{
                insertHtml='<li class="general"><a href="'+url+'&pageNo='+pagearr[i]+'">'+pagearr[i]+'</a></li>';
                //insertHtml='<li class="general">'+pagearr[i]+'</li>';
            }
        }
        pageInnerHtml.push(insertHtml);
    }


    // if(currentPage!=totalPage){
    //      pageInnerHtml.push('<li class="next">></li></ul>');
    // }
    var nextNo = currentPage+1;
    pageInnerHtml.push('<li class="next"><a href ="'+url+'&pageNo='+nextNo+'">下一页</a></li></ul>');

   
    $(selector).html(pageInnerHtml.join(""));

    if (currentPage==1) {
        $(selector+" .pre").css({"visibility":"hidden"});
    }

    if(currentPage==totalPage){
        $(selector+" .next").css({"visibility":"hidden"});
        
    }

    if(totalPage==0){
        $(selector+" .pre").css({"visibility":"hidden"});
        $(selector+" .next").css({"visibility":"hidden"});
    }

    $(function(){
        //$(selector+" .general").click(function(event){
        //    currentPage=parseInt(event.target.innerText);
        //    renderpage(selector,currentPage,totalPage,leriPage);
        //});
        //
        //$(selector+" .pre").click(function(event){
        //   if(currentPage>1){
        //       currentPage=currentPage-1;
        //       renderpage(selector,currentPage,totalPage,leriPage);
        //   }
        //});
        //$(selector+" .next").click(function(){
        //    if(currentPage<totalPage){
        //        currentPage=currentPage+1;
        //        renderpage(selector,currentPage,totalPage,leriPage);
        //    }
        //});
    });

}

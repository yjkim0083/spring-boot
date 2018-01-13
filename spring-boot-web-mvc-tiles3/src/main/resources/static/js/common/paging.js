'use strict';

var paging = {
    totalCount : 0,         // 전체 로우 갯수
    totalPageCount : 0,     // 전체 페이지 갯수
    pagePerView : 10,       // 화면당 표시되는 전체 페이지 갯수
    currentPageNumber : 1,  // 현재 페이지 번호
    rowsPerPage : 50,       // 페이지당 표시되는 리스트 로우 개수
    startRow : 0,           // 페이지의 첫번째 로우 번호
    endRow : 0,             // 페이지의 마지막 로우 번호,
    orderby : ''            // 정렬조건
};

function pagingReset(args) {
    paging.totalCount = 0;
    paging.totalPageCount = 0;
    paging.pagePerView = 10;
    paging.currentPageNumber = 1;
    paging.startRow = 0;
    paging.endRow = 0;
    paging.rowsPerPage = (typeof(args) != 'undefined' && typeof(args.rowsPerPage) != 'undefined' ? args.rowsPerPage : 5);
    //paging.orderby = '';
}

function pagingMake() {

    var str = '';
    var division_1 = 0;
    var division_2 = 0;

    if(paging.currentPageNumber === 1) {
        str += '<button  id="pg_first" type="button" disabled="disabled" onclick="pagingClick(this)"><span>처음</span></button>';
        str += '<button  id="pg_prev" type="button" disabled="disabled" onclick="pagingClick(this)"><span>이전</span></button>';
    } else {
        str += '<button  id="pg_first" type="button" onclick="pagingClick(this)"><span>처음</span></button>';
        str += '<button  id="pg_prev" type="button" onclick="pagingClick(this)"><span>이전</span></button>';
    }

    if(paging.totalCount === 0) {
        $('.pagination').html('');
        return;
    } else {
        paging.totalCount = parseInt(paging.totalCount);
        division_1 = parseInt(paging.totalCount / paging.rowsPerPage);
        division_2 = parseInt(paging.totalCount % paging.rowsPerPage);
    }

    paging.totalPageCount = division_1;
    if(division_2 > 0) paging.totalPageCount = paging.totalPageCount + 1;

    var pageRange_1 = parseInt(paging.currentPageNumber / paging.pagePerView);
    var pageRange_2 = parseInt(paging.currentPageNumber % paging.pagePerView);
    var pageRange = 0;

    if(pageRange_2 == 0) {
        pageRange = (pageRange_1 - 1) * 10;
    }
    else {
        pageRange = pageRange_1 * 10;
    }

    var cnt = 0;
    str += '<ul>';
    for(var i=1; i <= paging.totalPageCount; i++) {
        if(i+pageRange === paging.currentPageNumber) {
            str += '<li class="active"><a href="#" id='+ (i+pageRange) +' onclick="javascript:pagingClick(this)">' + (i+pageRange) + '</a></li>';
            if(i+pageRange === paging.totalPageCount) {
                break;
            }
        }
        else if(i+pageRange === paging.totalPageCount) {
            str += '<li><a href="#" id='+ (i+pageRange) +' onclick="javascript:pagingClick(this)">' + (i+pageRange) + '</a></li>';
            break;
        }
        else {
            str += '<li><a href="#" id='+ (i+pageRange) +' onclick="javascript:pagingClick(this)">' + (i+pageRange) + '</a></li>';
        }

        cnt++;
        if(cnt === paging.pagePerView) break;
    }
    str += '</ul>';

    if(paging.currentPageNumber === paging.totalPageCount) {
        str += '<button id="pg_next" type="button" disabled="disabled" onclick="pagingClick(this)"><span>다음</span></button>';
        str += '<button id="pg_last" type="button" disabled="disabled" onclick="pagingClick(this)"><span>마지막</span></button>';
    } else {
        str += '<button id="pg_next" type="button" onclick="pagingClick(this)"><span>다음</span></button>';
        str += '<button id="pg_last" type="button" onclick="pagingClick(this)"><span>마지막</span></button>';
    }

    $(".pagination").html(str);
}

function pagingClick(obj) {

    var clickedId = obj.id;

    // 맨처음
    if(clickedId === 'pg_first') {
        if(paging.currentPageNumber > 1) {
            paging.currentPageNumber = 1;
        }
        else {
            Common.Notice.show('첫번째 페이지 입니다.');
            return;
        }
    }
    // 이전
    else if(clickedId === 'pg_prev') {
        if(paging.currentPageNumber > 1)
            paging.currentPageNumber = paging.currentPageNumber - 1;
        else {
            Common.Notice.show('첫번째 페이지 입니다.');
            return;
        }
    }
    // 다음
    else if(clickedId === 'pg_next') {
        if(paging.currentPageNumber < paging.totalPageCount)
            paging.currentPageNumber = paging.currentPageNumber + 1;
        else {
            Common.Notice.show('마지막 페이지 입니다.');
            return;
        }
    }
    // 마지막
    else if(clickedId === 'pg_last') {
        if(paging.currentPageNumber === paging.totalPageCount) {
            Common.Notice.show('마지막 페이지 입니다.');
            return;
        }
        else
            paging.currentPageNumber = paging.totalPageCount;
    }
    // 페이지 번호
    else {
        paging.currentPageNumber = parseInt(clickedId);
    }

    search();
}

/**
 * 테이블 헤더의 컬럼을 클릭하여 정렬한다.
 * @param order : 정렬 TH
 * @param obj : 각 페이지별 obj
 */
function orderbyAppend(order) {
    var _id = order.id;
    var _class = $(order).attr("class");

    // 전체 th의 class 삭제
    $('th').each(function(){
        if($(this).hasClass('none'))
            return true;
        $(this).removeClass('up');
        $(this).removeClass('down');
        $(this).addClass('');
    });

    // 화살표 윗쪽
    if( _class === 'up') {
        $(order).attr("class",'');
        paging.orderby = '';
    }
    // 화살표 아랫쪽
    else if( _class === 'down') {
        $(order).attr("class","up");
        paging.orderby = _id.replace("TH_",'');
    }
    // 화살표 위아래
    else {
        $(order).attr("class","down");
        paging.orderby = _id.replace("TH_",'') + " desc";
    }

    search({ action : 'order'});
}

function orderbyAppend2(order) {
    var _id = order.id;
    var _class = $(order).attr("class");

    // 전체 th의 class 삭제
    $('th').each(function(){
        if($(this).hasClass('none'))
            return true;
        $(this).removeClass('up');
        $(this).removeClass('down');
        $(this).addClass('');
    });

    // 화살표 윗쪽
    if( _class === 'up') {
        $(order).attr("class",'');
        paging.orderby = '';
    }
    // 화살표 아랫쪽
    else if( _class === 'down') {
        $(order).attr("class","up");
        paging.orderby = _id.replace("TH_",'') + 'A';
    }
    // 화살표 위아래
    else {
        $(order).attr("class","down");
        paging.orderby = _id.replace("TH_",'') + "D";
    }

    search({ action : 'order'});
}

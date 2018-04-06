<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 分页导航 -->
	

	 <hr>
	<c:set var="page" value="${requestScope.page}"/>
	<c:set var="startpage" value="${page.currentPage-5>1? page.currentPage-5:1}"/>
	<c:set var="endpage" value="${page.currentPage+5<page.pageCount? page.currentPage+5:page.pageCount}"/>
	<c:set var="url" value="${page.url }"/>
	<c:if test="${page.groupList!=null and page.groupList.size()>0}">
    <div class="text-center">
        <nav>
            <ul class="pagination">
                <li><a href="<c:url value='${url }/1${page.param }'/> ">首页</a></li>
                <li><a href="<c:url value='${url }/${page.currentPage-1>1?page-1:1}${page.param }'/>">&laquo;</a></li>

                <c:forEach items="${page.groupList }" var="item">
                    <c:set var="active" value="${item==page.currentPage? 'active':''}"/>
                    <li class="${active}">
                    	<a href="<c:url value="${url }/${item}${page.param }"/>">${item}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="<c:url value="${url }/${page.currentPage+1<page.pageCount?page+1:page.pageCount}${page.param }"/>">&raquo;</a>
                </li>
                <li><a href="<c:url value="${url }/${page.pageCount}${page.param }"/>">尾页</a></li>
            </ul>
        </nav>
    </div>
    </c:if>
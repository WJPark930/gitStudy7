<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    

movieList.jsp<br>

<style>
	th{
		background-color: navy;
		color : white;
	}
</style>

<script type="text/javascript">
	function insert(){
		location.href="insert.mv";
	}
</script>

<h1 align="center">영화 리스트 화면(${pageInfo.totalCount })</h1>
	    <form action="list.mv" align="center">
			<select name="whatColumn">
				<option value="all">전체 검색
				<option value="genre">장르
				<option value="grade">등급
				<option value="actor">출연배우
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
    <table border="1" align="center">
    	<tr>
    		<td colspan="9" align="right">
    			<input type="button" value="추가하기" onClick="insert()">
    		</td>
    	</tr>
    	<tr>
    		<th>번호</th>
    		<th>제목</th>
    		<th>대륙</th>
    		<th>국가</th>
    		<th>장르</th>
    		<th>관람등급</th>
    		<th>배우</th>
    		<th>수정</th>
    		<th>삭제</th>
    	</tr>
    	
    	<c:forEach var="mb" items="${movieList}">
    		
    		<tr>
    			<td>${mb.num}</td>
    			<td><a href="detail.mv?num=${mb.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn}&keyword=${param.keyword}">${mb.title}</a></td>
    			<td>${mb.continent}</td>
    			<td>${mb.nation}</td>
    			<td>${mb.genre}</td>
    			<td>${mb.grade}</td>
    			<td>${mb.actor}</td>
    			<td><a href="update.mv?num=${mb.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn}&keyword=${param.keyword}">수정</a></td>
    			<td><a href="delete.mv?num=${mb.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn}&keyword=${param.keyword}">삭제</a></td>
    		</tr>
    		
    	</c:forEach>
    	
    </table>
    <br><br>
    <center>
    ${pageInfo.pagingHtml }
    </center>
    
    
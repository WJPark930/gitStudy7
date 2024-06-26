<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../common/common.jsp" %>
  
  <style>
  	th{
  		background-color: olive;
  	}
  </style>
  
  	<center>
    <h3>영화 상세 화면</h3>
    </center>
    <table border="1" align="center">
    	<tr>
    		<th>번호</th>
    		<td>${movie.num}</td>
    	</tr>
    	<tr>
    		<th>영화제목</th>
    		<td>${movie.title}</td>
    	</tr>
    	<tr>
    		<th>제작국가</th>
    		<td>${movie.nation}</td>
    	</tr>
    	<tr>
    		<th>장르</th>
    		<td>${movie.genre}</td>
    	</tr>
    	<tr>
    		<th>등급</th>
    		<td>${movie.grade}</td>
    	</tr>
    	<tr>
    		<th>배우</th>
    		<td>${movie.actor}</td>
    	</tr>
    	<tr>
    		<td colspan ="2">
 			<a href="list.mv?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn}&keyword=${param.keyword}">영화 리스트 화면으로 돌아감</a>
 			<!-- 페이지번호를 param으로 받을 수 있다. -->
 			</td>
    	</tr>
    </table>
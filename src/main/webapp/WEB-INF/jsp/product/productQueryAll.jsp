<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="stylesheet" href="/css/ordersystem.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   var indexPage = 1;
   $(document).ready(function(){
       load(indexPage);
   });

   function change(page){
	   indexPage = page;
	   load(indexPage);
   }

   function load(indexPage){
      $.ajax({
         type:'post',
         url:'/product/queryByPage/' + indexPage,
         dataType:'JSON',
         contentType:'application/json',
         success: function(data){
            var json = JSON.stringify(data,null,4);
            console.log("Success:" + json);

            var jsonArray = JSON.parse(json);
            $("#showproduct").empty("");

            if(json==null){
            	$("#showproduct").prepend("<tr><td colspan='2'>暫無資料</td></tr>");
            	return;
            }

            var table = $("#showproduct");
            table.append("<tr id='ptitle'><th>ID</th><th>Product Name</th><th>Product Price</th><th>Date</th><th>Note</th></tr>");

            $.each(jsonArray, function(i,n){
            	var tr = "<tr align='center'>" + "<td>" + n.id + "</td>" +
            	         "<td>" + n.pname + "</td>" + "<td>" + n.price + "</td>" +
            	         "<td>" + n.pdate + "</td>" + "<td>" + n.note + "</td>" +
            	         "</tr>";
            	table.append(tr); 
            });
         }
      });
   }
</script>
</head>
<body>
	<div id="productListTitle">ProductQuery</div>
	<table id="showproduct" border="1"></table>
	<table id="showpage">
		<tr>
			<td>Total Page:${totalPages} Total Records:${totalElements}</td>
			<td colspan="3" align="right">Previous <c:forEach var="i"
					begin="1" end="${totalPages}" step="1">
					<button id="myPage" value="${i}" onclick="change(${i})">${i}</button>
				</c:forEach>Next
			</td>
		</tr>
	</table>
</body>
</html>
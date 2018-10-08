<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
window.addEventListener('load',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/boardInfo');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				var html = '';
				for(var bi of res){
					html += '<tr>';
					html += '<td>' + bi.binum + '</td>';
					html += '<td><input type="text" name="bititle'+ bi.binum +'" value="' + bi.bititle + '"></td>';
					html += '<td><input type="text" name="bitext'+ bi.binum +'" value="' + bi.bitext +'"></td>';
					html += '<td><input type="text" name="bifile" value="' + bi.bifile + '"></td>';
					html += '<td><input type="text" name="bicredat" value="' + bi.bicredat + '"></td>';
					html += '<td><input type="text" name="bimoddat" value="' + bi.bimoddat + '"></td>';
					html += '<td><input type="text" name="bicnt" value="' + bi.bicnt + '"></td>';
					html += '<td><input type="text" name="biactive" value="' + bi.biactive + '"></td>';
					html += '<td><input type="text" name="uinum" value="' + bi.uinum + '"></td>';
					html += '<td><button>수정</button> <button>삭제</button></td>';
					html += '</tr>';
				}
				
				document.querySelector('#biBody').insertAdjacentHTML('beforeend',html);
			}else{
				
			}
		}
	}
	xhr.send();
});
</script>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>파일</th>
				<th>생성일자</th>
				<th>수정일자</th>
				<th>조회수</th>
				<th>???</th>
				<th>uinum</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody id="biBody">
		</tbody>
	</table>
	<script>
	function boardInfoUpdate(binum){
		var bititle = document.querySelector('input[name=bititle' + binum + ']').value;
		var bitext = document.querySelector('input[name=bitext' + binum + ']').value;
		
		var param = {binum:binum,bititle:bititle,bitext:bitext};
		var xhr = new XMLHttpRequest();
		var url = "/bi";
		xhr.open('PUT',url);
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.responseText=='1'){
					alert('수정성공!');
					location.href='/uri/boardInfo/BoardInfoList';
				}else{
					alert('수정실패');
				}
			}
		}
		alert(JSON.stringify(param));
		xhr.send(JSON.stringify(param));
	}
	</script>
</body>
</html>
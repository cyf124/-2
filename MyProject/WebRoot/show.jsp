<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.nancai.service.IKUtil"%>
<%
	String sid = request.getParameter("id");
	String type = request.getParameter("type");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>show.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<script type="text/javascript" src="d3.min.js"></script>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
    
    // 2.这边从url参数中取出id和type，并保存到全局变量中
    sid = '<%=sid%>';
    type = '<%=type%>';
	function init(data){
		var width = 960,
			height = 700;
		//var nodes = d3.range(dataset.length).map(function(i) { return {radius: Math.random() * 12 + 4}; }),
		var nodes = data;
		var root = nodes[0];
		var	color = d3.scale.category10();//用10种颜色构建一个ordinal变换。 （序数变换）
		root.radius = 0; //半径
		root.fixed = true;
		var force = d3.layout.force()  //力学 ，节点（node）基于物理模拟的位置连接。
		    .gravity(0.05) //获取或设置节点的引力强度.
		    .charge(function(d, i) { return i ? 0 : -2000; }) //获取或设置节点的电荷数.(电荷数决定结点是互相排斥还是吸引)
		    .nodes(nodes) //获得或设置布局中的节点（node）阵列组。
		    .size([width, height]); //获取或设置布局的 宽 和 高 的大小.
		    
		force.start(); //开启或恢复结点间的位置影响.
		
		var svg = d3.select("div").append("svg")
		    .attr("width", width)
		    .attr("height", height)
		    
		    
		svg.selectAll("circle")
		    .data(nodes.slice(1))
		  .enter().append("circle")
		    .attr("r", function(d) { return d.radius; })
		    .style("fill", function(d, i) { return color(i % 3); }); 
		    
		svg.selectAll("text")
			.data(nodes)
			.enter()
			.append("text")
			.text(function(d) { return d.word+" "+d.num;})
			.attr("font-family", "sans-serif")
			.attr("font-size", "11px")
			.attr("fill", "black");     //force.tick 让布局运行到下一步.
		force.on("tick", function(e) {  //监听布局位置的变化。(仅支持"start","step","end"三种事件)
		  var q = d3.geom.quadtree(nodes),  //构造一个四叉树的点的数组。		
		      i = 0,
		      n = nodes.length;
		  while (++i < n) q.visit(collide(nodes[i]));//q.visit--递归地遍历四叉树节点。
		
		  svg.selectAll("circle")
		      .attr("cx", function(d) { return d.x; })
		      .attr("cy", function(d) { return d.y; });
		      
		  svg.selectAll("text")
		      .attr("x", function(d) { return d.x-20; })
		      .attr("y", function(d) { return d.y; });
		});
		svg.on("mousemove", function() {
		  var p1 = d3.mouse(this); //获取鼠标的相对当前元素的坐标。
		  root.px = p1[0];
		  root.py = p1[1];
		  force.resume(); //设置冷却系数为0.1,并重新调用start()函数.
		});
		function collide(node) { //此函数的作用是模拟碰撞事件
		  var r = node.radius + 16,
		      nx1 = node.x - r,
		      nx2 = node.x + r,
		      ny1 = node.y - r,
		      ny2 = node.y + r;
		  return function(quad, x1, y1, x2, y2) {
		    if (quad.point && (quad.point !== node)) {
		      var x = node.x - quad.point.x,
		          y = node.y - quad.point.y,
		          l = Math.sqrt(x * x + y * y),
		          r = node.radius + quad.point.radius;
		      if (l < r) {
		        l = (l - r) / l * .5;
		        node.x -= x *= l;
		        node.y -= y *= l;
		        quad.point.x += x;
		        quad.point.y += y;
		      }
		    }
		    return x1 > nx2 || x2 < nx1 || y1 > ny2 || y2 < ny1;
		  };
		}
	}
	//获取数据	
	function getData(){
		//4.从DataControl中取回数据并显示
		$.ajax({
			  type: "POST",
			  url: "/MyProject/servlet/DataControl",
			  data: {
			  	"type" : type,
				"id" : sid,
			//	"map": map
			  },
			  success: function(data){
			  if(data!=null){
			  	$("svg").remove();
				 init(data);
			  }
	   		}
		});
	}

    </script>
</head>
<body onload="getData()"><!-- 3.加载页面时立即执行getData -->
<div
		style="position:absolute; left: 0;top: 0;height: 100%;width:100%;background: url('img/show1.jpg');background-size: 100% 100%">
		
	

	<table    border="1"  bordercolorlight="#ffffff" cellspacing="0" cellpadding="0"  style="text-align:center;position:absolute;right:100px;top:30px;display:inline">
		<tr>
			<td width = "80" ><font color=blue>序号</font></td>
			<td width = "120"><font color=blue>单词</font></td>
			<td width = "80" ><font color=blue>次数</font></td>
		</tr>
		<%
			Map<String, Integer> map = IKUtil.getIKMap(sid, type);
			if (map != null) {
				int size = map.size();
				int i = 0;
				for (Map.Entry entry : map.entrySet()) {
	
					i = i + 1;
		%>

		<tr>
			<td><font color=purple><%=i%></font></td>
			<td><font color=purple><%=entry.getKey()%></font></td>
			<td><font color=purple><%=entry.getValue()%></font></td>
		</tr>
		<%
				}
			}
		%>
	</table>
		<div style="position:absolute;left:400px;top:40px;display:inline"></div>

</div>

</body>
</html>

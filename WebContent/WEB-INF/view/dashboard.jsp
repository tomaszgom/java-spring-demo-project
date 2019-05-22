<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Purchase Orders</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mainActions.js" ></script>
	<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/dashboard.css" />	
	
	<%-- Chart.js Diagrams --%>		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>		
			
</head>

<body>

<!-- Navigation Panel -->
<input type="submit" value=">>>"  onclick="showNavi()" class="showNavi"/>
<div id="naviPanelId" class="naviPanel">
  <a href="javascript:void(0)" class="hideButton" onclick="hideNavi()">&times;</a>
	<table class="naviTable" id="naviTable">
	<tbody>						
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/app/dashboard" onclick="showPleaseWait()">Dashboard</a></td></tr>				
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/client/list" onclick="showPleaseWait()">Clients List</a></td></tr>
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/purchaseOrder/list" onclick="showPleaseWait()">Orders List</a></td></tr>
		<tr class="naviItem" ><td><a href="${pageContext.request.contextPath}/app/goodbye" onclick="showPleaseWait()">Log out</a></td></tr>															
  	</tbody>
  	</table>
</div>
<div id="pleaseWaitId" class="pleaseWait">
	<div class="pleaseWaitText">Please wait...</div>
</div>
<!-- Navigation Panel End -->

<!-- Main Content Page  -->
<div id="mainContentId">

<div>
<div>
	<div id="wrapper">
		<div id="header0"><p>Purchase Orders Management  -  Java Spring Demo Project by Tomasz Gomoradzki</p></div>
		<div id="header1"><h2>Dashboard</h2></div>
		<div id="header"><h2></h2></div>
	</div>	
	<div id="container">
		<div id="content">			
			<table class="dashboardTable">
				<tr id="trdashboard">				
					<th>
						<input type="button" value="Review Clients"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/client/list'; return false;"
							class="dashboardButton"
						/>			
					</th>					
					<th>
						<input type="button" value="Add Client"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/client/formAddClient'; return false;"
							class="dashboardButton"
						/>
					</th>
					<th>
						<input type="button" value="Show Statistics"
							onclick="showStats(); return false;"
							class="dashboardButton"
						/>
					</th>
				</tr>
				<tr>				
					<th>
						<input type="button" value="Review Orders"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/purchaseOrder/list'; return false;"
							class="dashboardButton"
						/>			
					</th>					
					<th>
						<input type="button" value="Add Order"
							onclick="showPleaseWait();window.location.href='${pageContext.request.contextPath}/purchaseOrder/purchaseOrderAddSelectClient'; return false;"
							class="dashboardButton"
						/>
					</th>
					<th>
						<input type="button" value="Log Out"
							onclick="showPleaseWait();window.location.href='goodbye'; return false;"
							class="dashboardButton"
						/>
					</th>
				</tr>			
		</table>	
	</div>				
	</div>
	</div>
	<div><h2></h2></div>
														
		<table class="statsTable" id="statsTable" style="display:none;">				
				<tr class="stats" >				
					<th>Total Number of Clients</th>
					<th>${stats['totalClients']}</th>	
				</tr>			
				<tr class="stats" >
					<th>Total Number of Orders</th>
					<th>${stats['totalPurchaseOrders']}</th>									
				</tr>		
				<tr class="stats" >
					<th>Avg Order Value</th>
					<th>${stats['avgOrderValue']}</th>							
				</tr>	
				<tr class="stats" >
					<th>Max Client Points</th>
					<th>${stats['maxClientsPoints']}</th>							
				</tr>								
		</table>	
		
</div>	
</div>	
	
<div><h2></h2></div>

	<div class="chart-container">	
		<canvas id="dashBoardChart"></canvas>
	</div>
	
	
  <script>
    let myChart = document.getElementById('dashBoardChart').getContext('2d');
   // myChart.dashBoardChart.width = 300;
   // myChart.dashBoardChart.height = 300;

    // Global Options
   // Chart.defaults.global.defaultFontFamily = 'Lato';
   // Chart.defaults.global.defaultFontSize = 18;
   // Chart.defaults.global.defaultFontColor = '#777';

    let ordersChart = new Chart(dashBoardChart, {
      type:'bar', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
      data:{
        labels:['Product 10', 'Product 20', 'Product 30', 'Product 50', 'Product 90'],
        datasets:[{
          label:'Vol.',
          // backgroundColor: "rgba(255,99,132,0.2)",
          //backgroundColor:'green',
          backgroundColor:[
            'rgba(54, 162, 235, 0.6)',	// blue
            'rgba(255, 159, 64, 0.6)', //orange
            'rgba(255, 99, 132, 0.6)', //red
            'rgba(75, 192, 192, 0.6)',	//green
            'rgba(153, 102, 255, 0.6)'	//violet
         // 'rgba(255, 206, 86, 0.6)', //yellow
          ], 
         // borderColor: "rgba(255,99,132,1)",
          borderColor:'#777',
          borderWidth: 1,
       //   hoverBackgroundColor: "rgba(54, 162, 235, 0.6)",
       //   hoverBorderColor: "rgba(54, 162, 235, 0.6)",
       //   hoverBorderWidth:3,
       //   hoverBorderColor:'#000'
       
          data:[9,10,7,2,5]
        //,

        }]
      }
     ,
       options:{
        title:{
          display:true,
          text:'Purchase Orders by Product',
          fontSize:25
        },
        legend:{
          display:false,
          position:'right',
          labels:{
            fontColor:'#000'
          }
        },
        layout:{
          padding:{left:20, right:0, bottom:0, top:0}
        },
        tooltips:{enabled:true},
        
        /////
            maintainAspectRatio: false,
    		  scales: {
    		    yAxes: [{
    		      stacked: true,
    		      gridLines: {
    		        display: true,
    		        	color:'rgba(54, 162, 235, 0.6)'
    		      }
    		    }],
    		    xAxes: [{
    		      gridLines: {
    		        display: false
    		      }
    		    }]
    		  } 
        /////
      }
      
    });
  
/*     var options = {
    		  maintainAspectRatio: false,
    		  scales: {
    		    yAxes: [{
    		      stacked: true,
    		      gridLines: {
    		        display: true,
    		        color: "rgba(255,99,132,0.2)"
    		      }
    		    }],
    		    xAxes: [{
    		      gridLines: {
    		        display: false
    		      }
    		    }]
    		  }
    		}; */
    
       
/*     Chart.Bar('dashBoardChart', {
    	  options: options,
    	  data: data
    	}); */
  </script>
		
</body>
</html>










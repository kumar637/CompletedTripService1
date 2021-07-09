

var xhrMyRequest = new XMLHttpRequest();

window.onload = getMyRequest;

document.getElementById("myRequest").addEventListener('click', getMyRequest());
var id=101;
function getMyRequest() {

	xhrMyRequest.open("GET", "http://localhost:5053/user/myrequest/employeedetails/" + 2038, true);
   // xhrMyRequest.open("GET", "http://localhost:5050/user/myrequest/employeedetails/" +id, true);

	xhrMyRequest.onreadystatechange = processResponse;
	xhrMyRequest.send(null);
}


var rowCounter;
var arr;
var timeSplit;
var time;
var hours
var dateFormat;
var dateTravel;
var tripCabId;
var bookingId;
function processResponse() {
	if (xhrMyRequest.readyState == 4 && xhrMyRequest.status == 200) {
		// $("#tableBody").empty();
		 arr = JSON.parse(xhrMyRequest.responseText);
		console.log(arr);
		rowCounter = 0;

		for (var i = 0; i < arr.length; i++) {



			// creating row and data  

			var trow = document.createElement('tr');
			trow.className = "row-bg-style";             // display-shadow       // addingStyle class
			trow.id = "tr" + rowCounter++;



			var divObj = document.createElement('td');
			divObj.className = "spacing";
			// divObj.id = "tdmodel" + i;

			var divObj1 = document.createElement('td');
			divObj1.className = "spacing";
			
         var date = arr[i].dateOfTravel;

          var dateTravel = date.split("\-");
                 dateFormat = dateTravel[2] + "-" + dateTravel[1] + "-"+ dateTravel[0];
divObj1.innerText=dateFormat;
       dateOfTravel = dateFormat;
          alert(dateOfTravel);


			var divObj2 = document.createElement('td');
			divObj2.className = "spacing";
			var timeSplit = arr[i].details.timeSlot.split(":");
			//var timeSplit = time.split(":");
			var hours = timeSplit[0];


			if (hours < 12) {
				if (hours == 00) {
					divObj2.innerHTML = "12" + ":" + timeSplit[1] + " AM";
				} else {
					divObj2.innerHTML = hours + ":" + timeSplit[1] + " AM";
				}
			} 
			else
			{
				hours = hours - 12;
				if (hours < 10) {
					divObj2.innerHTML = "0" + hours + ":" + timeSplit[1] + " PM";
				} if (hours == 0) {
					divObj2.innerHTML = "12" + ":" + timeSplit[1] + " PM";
				}
				else {
					divObj2.innerHTML = hours + ":" + timeSplit[1] + " PM";
				}
			}




			//divObj2.className="spacing";
			//divObj2.id = "tdseats" + i;

			var divObj3 = document.createElement('td');
			divObj3.className = "spacing";
			//divObj3.id = "tdinsnum" + i;

			var divObj4 = document.createElement('td');
			divObj4.className = "spacing";
			//divObj4.id = "tdaction" + i;
		
			
			var divObj5 = document.createElement('td');
			divObj5.className = "spacing";
			//document.getElementById("element").style.display="none";
		 var divObj5 = document.getElementById('elements');
       divObj5.style.display = 'none';
    
			
			var divObj6 =document.createElement('td');
			divObj6.className ="spacing";
			 var divObj6 = document.getElementById('elements1');
       divObj6.style.display = 'none';
    



			divObj.innerText = i + 1;
	   	   // divObj1.innerText = arr.dateOfTravel;
			//divObj2.innerText = arr.details[i].timeSlot;
			divObj3.innerText = arr[i].details.status;
			if(divObj3.innerText=="reached")
			{
				divObj4.innerHTML = "<a class='view-icon' href='cab-app-completedtrip.html'><img src='images/view.png' class='viewicon' alt='viewicon'</a>";
		
		}
			else{
			divObj4.innerHTML = "<a class='view-icon'><img src='images/view.png' class='viewicon' alt='viewicon'</a>";
	
			}
	
					
			
		//document.getElementById("tdaction0").disabled = "true"; 
            
			tripCabId = arr[i].details.tripCabId;
			divObj5.innerHTML = tripCabId;

			bookingId =arr[i].details.bookingId;
			divObj6.innerHTML =bookingId;


			trow.appendChild(divObj);
			trow.appendChild(divObj1);
			trow.appendChild(divObj2);
			trow.appendChild(divObj3);
			trow.appendChild(divObj4);
			trow.appendChild(divObj5);
			trow.appendChild(divObj6);



			document.getElementById("tableBody").appendChild(trow);
          //document.getElementById("tdaction").disabled = "true"; 
        
		}
		
    var count = document.createElement('div');
count.class = "header-left py-md-3";
document.getElementById("totalrecord").innerText ='Total record  '+ rowCounter+" out of " +rowCounter;

	}
}




/*var MyRequest;

function processResponse() {
	alert(xhr.readyState);
	if (xhr.readyState == 4 && xhr.status == 200) {
		alert("10");
		MyRequest = JSON.parse(xhr.responseText);

		var length = MyRequest.length;
		alert(length);

		var tbody = document.getElementById("tableBody");
		for (i = 0; i < length; i++) {
			var trow = document.createElement('tr');
			trow.className = "row-bg-style";

			var td0 = document.createElement('td');
			td0.className = "spacing";
			td0.innerHTML = i + 1;
			trow.appendChild(td0);

			var td1 = document.createElement('td');
			td1.className = "spacing";
			td1.innerHTML = MyRequest[i].dateOfTravel;
			trow.appendChild(td1);

			var td2 = document.createElement('td');
			td2.className = "spacing";
			td2.innerHTML = MyRequest.details[i].timeSlot;
			trow.appendChild(td2);

			var td3 = document.createElement('td');
			td3.className = "spacing";
			td3.innerHTML = MyRequest.details[i].status;
			trow.appendChild(td3);

			var td4 = document.createElement('td');
			td4.className = "spacing";
			//td4.innerHTML = MyRequest[i].action;
			td4.innerHTML = "<img src='images/view.png' class='viewicon' alt='viewicon'>";
			//	window.location.href="cab-app-completedtrip.html";
			trow.appendChild(td4);
			tbody.appendChild(trow);

		}

	}

}*/


// Completed Trip Js
	
	 var querystr = window.location.search;
	// alert(querystr);
	 var id = querystr.split("=")[1];
	window.onload = getCompletedTrip;
	var xhr = new XMLHttpRequest();
	function getCompletedTrip() {
		xhr.open("GET", "http://localhost:4040/api/v1/completedTrip/" + id,
			true);
		xhr.onreadystatechange = processResponse;
		xhr.send(null);

	}
	var completedTrip;
	var dateFormat;
	function processResponse() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			completedTrip = JSON.parse(this.responseText);

			document.getElementById('cabNumber').innerText = completedTrip.cabNumber;
			document.getElementById('driverName').innerText = completedTrip.driverName;
			document.getElementById('driverContact').innerText = completedTrip.driverNumber;
			document.getElementById('destination').innerText = completedTrip.destination;
			var date = completedTrip.dateOfTravel;
			var dateOfTravel = date.split("\-");
			dateFormat = dateOfTravel[2] + "-" + dateOfTravel[1] + "-"+ dateOfTravel[0];
			document.getElementById("date").innerHTML = dateFormat;
			
			// TimeSlot Format 
			 var  timeSlotOption = document.getElementById('timeSlot');
			var slot = completedTrip.timeSlot;
			var slotSplitted = slot.split(":");
			slotHour = slotSplitted[0];
			if(slotHour < 12){
				if(slotHour == 00 ){
					timeSlotOption.innerHTML ="12" + ":" + slotSplitted[1] +  " AM";
				}else{
					timeSlotOption.innerHTML =slotHour + ":" + slotSplitted[1] +  " AM";
				}
				
			}else{
				slotHour = slotHour - 12 ;
				if(slotHour < 10){
					timeSlotOption.innerHTML = "0" + slotHour + ":" + slotSplitted[1] + " PM";
					
				}if(slotHour == 0 ){
					timeSlotOption.innerHTML = "12"+ ":" + slotSplitted[1] + " PM";
				}
				else{
					timeSlotOption.innerHTML =   slotHour + ":" + slotSplitted[1] +" PM";
				}
			}
			
			document.getElementById('reachedTime').innerText = completedTrip.reachedTime;
			var length = completedTrip.tripList.length;
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
				td1.innerHTML = completedTrip.tripList[i].employeeId;
				trow.appendChild(td1);

				var td2 = document.createElement('td');
				td2.className = "spacing";
				td2.innerHTML = completedTrip.tripList[i].emlpoyeeName;
				trow.appendChild(td2);

				var td3 = document.createElement('td');
				td3.className = "spacing";
				td3.innerHTML = completedTrip.tripList[i].dropPoint;
				trow.appendChild(td3);
				tbody.appendChild(trow);
			}
			//var len = length - 1;
			document.getElementById("passenger").innerText = "No.Of Passengers : "+ length;
		}
	}

	// When Raise A Complaint button clicks
	var raiseBtn = document.getElementById("raiseBtn");
	raiseBtn.addEventListener("click", popUpDetails)
		// popUp details
	function popUpDetails() {
		document.getElementById("PopupDate").innerHTML = "Date: " + dateFormat;
		document.getElementById("PopupTimeslot").innerHTML = "Time Slot: " + completedTrip.timeSlot;
		document.getElementById("PopupCabNo.").innerHTML = "Cab Number: " + completedTrip.cabNumber;
		document.getElementById("PopDriverName").innerHTML = "Driver Name: " + completedTrip.driverName;
		document.getElementById("PopupDriverNo").innerHTML = "Driver Number: " + completedTrip.driverNumber;
		document.getElementById("PopupDestination").innerHTML = "Destination: " + completedTrip.destination;

		getDropdown();

	}
		// get Complaints in dropDown
	var xhw = new XMLHttpRequest();

	function getDropdown() {
		xhw.open("GET", "http://localhost:4040/api/v1/complaints", true);
		xhw.onreadystatechange = getComplaints;
		xhw.send(null);
	}

	function getComplaints() {
		if (xhw.readyState == 4 && xhw.status == 200) {
			var complaintsList = JSON.parse(this.responseText);
			var reasonSel = document.getElementById("dropdown");
			var len = complaintsList.length;

			var optLength = reasonSel.options.length;
			for (i = optLength - 1; i > 0; i--) {
					reasonSel.options[i] = null;
			}
			for (var i = 0; i < len; i++) {
				var list = complaintsList[i];
				var ele = document.createElement("option");
				ele.innerHTML = list.complaintDescription;
				reasonSel.appendChild(ele);
			}

		}

	}

		// Post the Complaint in the DB
	var xhrComplaints = new XMLHttpRequest();
	//var xhy = new XMLHttpRequest();
	var popup = document.getElementById("raiseComPopUp");
	popup.onclick = validateComplaints;
	function validateComplaints() {
		var reasonSelec = document.getElementById("dropdown");
		var value = reasonSelec.options[reasonSelec.selectedIndex].value;

		if (value == 0) {
			alert("Invalid Complaint");
			return false;
		}
		Popraisebtn();
	}

	function Popraisebtn() {

		var reasonSelec = document.getElementById("dropdown");
		var value = reasonSelec.options[reasonSelec.selectedIndex].value;
		xhrComplaints.open("PUT", "http://localhost:4040/api/v1/updateComplaints/" + 123 + "/" + value, true);
		xhrComplaints.onreadystatechange = updateComplaint;
		
		
		function updateComplaint() {
			if(xhrComplaints.readyState == 4 && xhrComplaints.status == 201){
				var obj = JSON.parse(xhrComplaints.responseText);
				console.log(obj);
				alert("Complaints registered Successfully!");

			}
			if (xhrComplaints.readyState == 4 && xhrComplaints.status == 400) {
				alert("Complaints Already registerd !");


			}
		}

		xhrComplaints.send();

	}


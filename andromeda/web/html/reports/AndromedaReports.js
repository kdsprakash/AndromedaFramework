var AndromedaReports = {

	showReportPage: function(path) {
		if(!path)
		{
			return false;
		}
		
		alert("showReportPage: " + path);
		//setSessionValue("backUrl");

		var jqxhr = jQuery.post(path, function(data) {
			AndromedaReports.showReport(data);
		});
	},
	
	showReport: function(data) {
		var reportDataString = "";
		
		if (data)
		{
			if (data.reportHeaders)
			{
				var headerString = AndromedaReports.getReportHeaders(data.reportHeaders);
				reportDataString += headerString;
			}
	
			if (data.bigNumbers)
			{
				var bigNumbersString = AndromedaReports.getBigNumbers(data.bigNumbers);
				reportDataString += bigNumbersString;
			}
		
			reportDataString += "<table class=\"amdReportTable\">";
			if (data.columnHeaders)
			{
			
				var columnHeaderString = AndromedaReports.getColumnHeaders(data.columnHeaders);
				reportDataString += columnHeaderString;
			}
			
			if ((data.columnHeaders) && (data.data))
			{
				var dataString = AndromedaReports.getReportData(data.config, data.columnHeaders, data.data);
				reportDataString += dataString;
			}
	
			reportDataString += "</table><br/>";
		}

		jQuery("#amdContentDiv").html("<center>" + reportDataString + "</center>");
	},
	
	getReportHeaders: function(reportHeaders) {
		var headerString;
		
		headerString = "<div class=\"amdReportHeading\">" + reportHeaders[0].value + "</div><br/>";
		headerString += "<div class=\"amdReportSubHeading\">" + reportHeaders[1].value + "</div><br/>";
		headerString += "<div class=\"amdReportSubHeading\">" + reportHeaders[2].value + "</div><br/>";
		
		return headerString;
	},
	
	getBigNumbers: function(bigNumbers) {
		var bigNumbersString = "<div class=\"row\">";
		for(var i=0; i<bigNumbers.length; i++) {
			if(bigNumbers[i].active)
			{
				bigNumbersString += "<div class=\"col-md-2 amd-bignumber-active\">";
			}
			else
			{
				bigNumbersString += "<div class=\"col-md-2 amd-bignumber\">";
			}
			bigNumbersString += "<table border=\"0\" width=\"100%\"><tr><td><div class=\"amd-bignumber-value\">" + bigNumbers[i].value + "</div></td></tr>";
			bigNumbersString += "<tr><td><div class=\"amd-bignumber-name\">" + bigNumbers[i].name + "</div></td></tr></table>";
			bigNumbersString += "</div>";
		}
	
		bigNumbersString += "</div>";
		
		return bigNumbersString;
	},
	
	getColumnHeaders: function(columnHeaders) {
		var columnHeaderString = "";
		columnHeaderString += "<tr><td align=\"right\" style=\"border: 0px\" colspan=\""+columnHeaders.length+"\"><button class=\"btn btn-primary btn-xs\" type=\"button\" onClick=\"Andromeda.showEmployeePage();\">Add</button></td></tr>";
		columnHeaderString += "<tr>";
		
		for(var i=0; i<columnHeaders.length; i++) {
			columnHeaderString += "<th>" + columnHeaders[i].value + "</th>";
		}
		//columnHeaderString += "<th><img class=\"amd-action-icon\" src=\"images/settings.png\" /></th>";
		columnHeaderString += "</tr>";
		
		return columnHeaderString;
	},
	
	getReportData: function(config, columnHeaders, data) {
		var dataString = "";
		
		for(var i=0; i<data.length; i++) {
			if(data[i]) {
				dataString += "<tr>";
				for(var j=0; j<data[i].length; j++) {
					var align = "";
					if(columnHeaders[j].type == "INTEGER")
					{
						align = " align=\"right\"";
					}

					var value = "-";
					if((data[i][j]) && (data[i][j].value))
					{
						if(data[i][j].url)
						{
							value = "<div class=\"reportUrl\" onClick=\"AndromedaReports.showReportPage('"+ data[i][j].url +"');\">" + data[i][j].value + "</div>";
						}
						else
						{
							value = data[i][j].value;
						}
					}
					dataString += "<td" + align + ">" + value + "</td>";
				}
				//dataString += "<td><img class=\"amd-action-icon\" src=\"images/trash.png\" /></td>";
				dataString += "</tr>";
			}
		}
		
		return dataString;
	}
};
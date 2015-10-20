var AndromedaReports = {

	showReportPage: function(path, reportTemplate) {
		if(!path)
		{
			return false;
		}
		
		if(!reportTemplate)
		{
			reportTemplate = "/andromeda/html/reports/report.html";
		}
		
		//setSessionValue("backUrl");
		
		Andromeda.showPage(reportTemplate, "amdContentDiv");

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
				AndromedaReports.showReportHeaders(data.reportHeaders);
			}
	
			if (data.bigNumbers)
			{
				var bigNumbersString = AndromedaReports.getBigNumbers(data.bigNumbers);
				reportDataString += bigNumbersString;
			}
			
			if(data.reportLinks)
			{
				AndromedaReports.showReportLinks(data.reportLinks);
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

		jQuery("#reportTableDiv").html(reportDataString);
	},
	
	showReportHeaders: function(reportHeaders) {
		jQuery("#amdReportHeadingDiv").html(reportHeaders[0].value);
		jQuery("#amdReportSubHeadingDiv1").html(reportHeaders[1].value);
		jQuery("#amdReportSubHeadingDiv2").html(reportHeaders[2].value);
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
	
	showReportLinks: function(reportLinks) {
		var reportLinksString = "";
		for(var i=0; i<reportLinks.length; i++) {
			reportLinksString += "&nbsp;<button class=\"btn btn-primary btn-xs\" type=\"button\" ";
			reportLinksString += "onClick=\"" + reportLinks[i].url + "\">"+ reportLinks[i].text +"</button>";
		}
		
		jQuery("#reportLinksDiv").html(reportLinksString);
	},
	
	getColumnHeaders: function(columnHeaders) {
		var columnHeaderString = "";
		if (columnHeaders)
		{
			columnHeaderString += "<tr>";
			
			for(var i=0; i<columnHeaders.length; i++) {
				columnHeaderString += "<th>" + columnHeaders[i].value + "</th>";
			}
			//columnHeaderString += "<th><img class=\"amd-action-icon\" src=\"images/settings.png\" /></th>";
			columnHeaderString += "</tr>";
		}
		
		return columnHeaderString;
	},
	
	getReportData: function(config, columnHeaders, data) 
	{
		var dataString = "";
		
		if ((columnHeaders) && (data) && (data.length > 0))
		{
			for(var i=0; i<data.length; i++) 
			{
				if(data[i]) 
				{
					dataString += "<tr>";
					for(var j=0; j<data[i].length; j++) 
					{
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
								value = "<div class=\"amdLink\" onClick=\"AndromedaReports.showReportPage('"+ data[i][j].url +"');\">" + data[i][j].value + "</div>";
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
		}
		else
		{
			if((columnHeaders) && (columnHeaders.length > 0))
			{
				dataString = "<td align=\"left\" colspan=\"" + columnHeaders.length + "\">No data</td>";
			}
		}
		
		return dataString;
	}
};
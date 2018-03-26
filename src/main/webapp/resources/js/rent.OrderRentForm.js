$(document).ready(function() 
{
	$(document).on('click', '#btnStartGodzinaMinus', Start_OdejmijCzas);
	$(document).on('click', '#btnStartGodzinaPlus', Start_DodajCzas);
	$(document).on('click', '#btnStartDataMinus', Start_OdejmijDzien);
	$(document).on('click', '#btnStartDataPlus', Start_DodajDzien);
	
	$(document).on('click', '#btnEndGodzinaMinus', End_OdejmijCzas);
	$(document).on('click', '#btnEndGodzinaPlus', End_DodajCzas);
	$(document).on('click', '#btnEndDataMinus', End_OdejmijDzien);
	$(document).on('click', '#btnEndDataPlus', End_DodajDzien);
})

function Start_OdejmijCzas()
{
	var currentHours = 0;
	var currentMinutes = 0;
	var temp;
	var tempNumeric = 0;

	tempNumeric = $('#startHours').text();
	currentHours = parseInt(tempNumeric);
	tempNumeric = $('#startMinutes').text();
	currentMinutes = parseInt(tempNumeric);

	currentMinutes -= 30;
	
	if(currentMinutes < 0)
	{
		currentHours -= 1;
		currentMinutes += 60;
		
		if(currentHours == -1)
		{
			currentHours = 23;
		}
	}

	temp = $('#startHours');
	if(currentHours < 10)
	{
		temp.text("0" + currentHours);
	}
	else
	{
		temp.text(currentHours);
	}
	
	temp = $('#startMinutes');
	if(currentMinutes < 10)
	{
		temp.text("0" + currentMinutes);
	}
	else
	{
		temp.text(currentMinutes);
	}
}
function Start_DodajCzas()
{
	var currentHours = 0;
	var currentMinutes = 0;
	var temp;
	var tempNumeric = 0;

	tempNumeric = $('#startHours').text();
	currentHours = parseInt(tempNumeric);
	tempNumeric = $('#startMinutes').text();
	currentMinutes = parseInt(tempNumeric);
	
	currentMinutes += 30;
	
	if(currentMinutes >= 60)
	{
		currentHours += 1;
		currentMinutes -= 60;
		
		if(currentHours == 24)
		{
			currentHours = 0;
		}
	}
	
	temp = $('#startHours');
	if(currentHours < 10)
	{
		temp.text("0" + currentHours);
	}
	else
	{
		temp.text(currentHours);
	}
	
	temp = $('#startMinutes');
	if(currentMinutes < 10)
	{
		temp.text("0" + currentMinutes);
	}
	else
	{
		temp.text(currentMinutes);
	}
}

function Start_OdejmijDzien()
{
	var temp;
	var split = $('#startDate').text().split("/");
	var dateString = split[1] + "/" + split[0] + "/" + split[2];

	var d = new Date(dateString);
	d.setDate(d.getDate() - 1);
	var dd = d.getDate();
	var mm = d.getMonth() + 1;
	var yy = d.getFullYear();
	temp = $('#startDate');
	mm.toString();
	dd.toString();
	if(mm < 10)
	{
		mm = '0' + mm;
	}
	if(dd < 10)
	{
		dd = '0' + dd;
	}
	temp.text(dd + "/" + mm + "/" + yy);
}
function Start_DodajDzien()
{
	var temp;
	var split = $('#startDate').text().split("/");
	var dateString = split[1] + "/" + split[0] + "/" + split[2];

	var d = new Date(dateString);
	d.setDate(d.getDate() + 1);
	var dd = d.getDate();
	var mm = d.getMonth() + 1;
	var yy = d.getFullYear();
	temp = $('#startDate');
	mm.toString();
	dd.toString();
	if(mm < 10)
	{
		mm = '0' + mm;
	}
	if(dd < 10)
	{
		dd = '0' + dd;
	}
	temp.text(dd + "/" + mm + "/" + yy);
}

function End_OdejmijCzas()
{
	var currentHours = 0;
	var currentMinutes = 0;
	var temp;
	var tempNumeric = 0;

	tempNumeric = $('#endHours').text();
	currentHours = parseInt(tempNumeric);
	tempNumeric = $('#endMinutes').text();
	currentMinutes = parseInt(tempNumeric);

	currentMinutes -= 30;
	
	if(currentMinutes < 0)
	{
		currentHours -= 1;
		currentMinutes += 60;
		
		if(currentHours == -1)
		{
			currentHours = 23;
		}
	}

	temp = $('#endHours');
	if(currentHours < 10)
	{
		temp.text("0" + currentHours);
	}
	else
	{
		temp.text(currentHours);
	}
	
	temp = $('#endMinutes');
	if(currentMinutes < 10)
	{
		temp.text("0" + currentMinutes);
	}
	else
	{
		temp.text(currentMinutes);
	}
}
function End_DodajCzas()
{
	var currentHours = 0;
	var currentMinutes = 0;
	var temp;
	var tempNumeric = 0;

	tempNumeric = $('#endHours').text();
	currentHours = parseInt(tempNumeric);
	tempNumeric = $('#endMinutes').text();
	currentMinutes = parseInt(tempNumeric);
	
	currentMinutes += 30;
	
	if(currentMinutes >= 60)
	{
		currentHours += 1;
		currentMinutes -= 60;
		
		if(currentHours == 24)
		{
			currentHours = 0;
		}
	}
	
	temp = $('#endHours');
	if(currentHours < 10)
	{
		temp.text("0" + currentHours);
	}
	else
	{
		temp.text(currentHours);
	}
	
	temp = $('#endMinutes');
	if(currentMinutes < 10)
	{
		temp.text("0" + currentMinutes);
	}
	else
	{
		temp.text(currentMinutes);
	}
}

function End_OdejmijDzien()
{
	var temp;
	var split = $('#endDate').text().split("/");
	var dateString = split[1] + "/" + split[0] + "/" + split[2];

	var d = new Date(dateString);
	d.setDate(d.getDate() - 1);
	var dd = d.getDate();
	var mm = d.getMonth() + 1;
	var yy = d.getFullYear();
	temp = $('#endDate');
	mm.toString();
	dd.toString();
	if(mm < 10)
	{
		mm = '0' + mm;
	}
	if(dd < 10)
	{
		dd = '0' + dd;
	}
	temp.text(dd + "/" + mm + "/" + yy);
}
function End_DodajDzien()
{
	var temp;
	var split = $('#endDate').text().split("/");
	var dateString = split[1] + "/" + split[0] + "/" + split[2];

	var d = new Date(dateString);
	d.setDate(d.getDate() + 1);
	var dd = d.getDate();
	var mm = d.getMonth() + 1;
	var yy = d.getFullYear();
	temp = $('#endDate');
	mm.toString();
	dd.toString();
	if(mm < 10)
	{
		mm = '0' + mm;
	}
	if(dd < 10)
	{
		dd = '0' + dd;
	}
	temp.text(dd + "/" + mm + "/" + yy);
}
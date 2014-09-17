function injetaHTML(){
	var x = document.getElementById("list");
	var y = document.getElementById("buy");
	var option = document.createElement("option");
	option.text = x.value;
    y.add(option);	
}

function remove(){
	var x = document.getElementById("buy");
	x.remove(x.selectedIndex);
}

function getPais(){
	var connection = new ActiveXObject("ADODB.Connection") ;
	var connectionstring="C:/hefesto.mdb";

	connection.Open(connectionstring);
	var rs = new ActiveXObject("ADODB.Recordset");

	rs.Open("SELECT * FROM tb_code_pais", connection);
	rs.MoveFirst
	while(!rs.eof)
	{
		document.write(rs.fields(1));
		rs.movenext;
	}

		rs.close;
		connection.close;
}


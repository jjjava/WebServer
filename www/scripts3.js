
function gravarCliente(){
	
	var nome = document.getElementById("nome").innerHTML;

	document.getElementById("mail").innerHTML = nome;
	localStorage.setItem("pro", nome);
}

function lerCliente(){
	var cliente = localStorage.getItem("pro");
	
	document.getElementById("nome").innerHTML=cliente;
	document.getElementById("sobrenome").innerHTML=cliente;

}

function Cliente(){
	this.name     = null;
	this.lastname = null;
	this.tel      = null;S
	this.mail     = null;
  
	this.constructor = construtor();
	function constructor(n,l,t,e){
		this.name     = n;
		this.lastname = l;
		this.tel      = t;
		this.e        = e;
	}
}

function getClienteID(){
	return localStorage.getItem("idCliente");
}

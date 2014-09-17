function injetaHTML(){
	document.getElementById("demo").innerHTML="My First JavaScript Function";
}

function escreveHTML(){
	var texto ="<h1>This is a heading hold on variable</h1>";
	document.write(texto);
}
function escreveHTML2(texto){
	document.write(texto);
}

function alertaHTML(texto){
	alert(texto);
}

function funcaoComRetorno(a,b){
	return a*b/a+b;
}

function person(firstName,lastName,age,eyeColor)
{
	this.firstName=firstName;
	this.lastName=lastName;
	this.age=age;
	this.eyeColor=eyeColor;
 
	this.changeName=changeName;
	function changeName(name)
	{
		this.fristName=name;
	}
}

function car(){
	this.name = null;
	this.year = null;
	this.constructor = constructor;
	function constructor(n,y){
		this.name = n;
		this.year = y;
	}
	this.setName = setName;
	function setName(n){
		this.name = n;
	}
	this.getName = getName;
	function getName(){
		return this.name;
	}
}
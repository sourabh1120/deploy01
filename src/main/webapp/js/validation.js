/*validation.js with arrow syntax for the function */
let validation=(frm)=>{
	alert("1");
	
	let output=(id)=>document.getElementById(id);
	
	//empty the existing element error message
	output('enameError').innerHTML="";
	output('ejobError').innerHTML="";
	output('esalaryError').innerHTML="";
	output('deptnoError').innerHTML="";
	
	//read the form data
	let name=frm.ename.value;
	let job=frm.ejob.value;
	let sal=frm.esalary.value
	let dno=frm.deptno.value;
	
	//write the client form validation logic
	let vflag=true;
	
	if(name=="" || name.length==0){
			output('enameError').innerHTML="Employee name is mandatory(cs)";
		vflag=false;
	}else if(name.length<5 || name.length>15){
			output('enameError').innerHTML="Employee name must have min 5 char and max 15 char(cs)";
		vflag=false;
	}
	
	if(job=="" || job.length==0){
		output('ejobError').innerHTML="Employee job is mandatory(cs)";
		vflag=false;
	}else if(job.length<4 || job.length>10){
		output('ejobError').innerHTML="Employee job must have min 4 char and max 10 char(cs)";
		vflag=false;
	}
	
	if(sal==""|| sal.length==0){
		output('esalaryError').innerHTML="Employee salary is mandatory(cs)";
		vflag=false;
	}else if(isNaN(sal)){
		output('esalaryError').innerHTML="Employee salary must  be numeric(cs)";
	}else if(sal<10000 || sal>200000){
		output('esalaryError').innerHTML="Employee salary range between 10000 and 200000 (cs)";
		vflag=false;
	}
	
	if(dno==""|| dno.length==0){
		output('deptnoError').innerHTML="Employee deptno is mandatory(cs)";
		vflag=false;
	}
	//change the hidden box form validatimng value to indicate that the client side form validation  are done
	frm.vflag1.value="yes";
	
	
	return vflag;
	
}





/*
function validation(frm){
	alert("1");
	
	//empty the existing element error message
	document.getElementById("enameError").innerHTML="";
	document.getElementById("ejobError").innerHTML="";
	document.getElementById("esalaryError").innerHTML="";
	document.getElementById("deptnoError").innerHTML="";
	
	//read the form data
	let name=frm.ename.value;
	let job=frm.ejob.value;
	let sal=frm.esalary.value
	let dno=frm.deptno.value;
	
	//write the client form validation logic
	let vflag=true;
	
	if(name=="" || name.length==0){
		document.getElementById("enameError").innerHTML="Employee name is mandatory(cs)";
		vflag=false;
	}else if(name.length<5 || name.length>15){
		document.getElementById("enameError").innerHTML="Employee name must have min 5 char and max 15 char(cs)";
		vflag=false;
	}
	
	if(job=="" || job.length==0){
		document.getElementById("ejobError").innerHTML="Employee job is mandatory(cs)";
		vflag=false;
	}else if(job.length<4 || job.length>10){
		document.getElementById("ejobError").innerHTML="Employee job must have min 4 char and max 10 char(cs)";
		vflag=false;
	}
	
	if(sal==""|| sal.length==0){
		document.getElementById("esalaryError").innerHTML="Employee salary is mandatory(cs)";
		vflag=false;
	}else if(isNaN(sal)){
		document.getElementById("esalaryError").innerHTML="Employee salary must  be numeric(cs)";
	}else if(sal<10000 || sal>200000){
		document.getElementById("esalaryError").innerHTML="Employee salary range between 10000 and 200000 (cs)";
		vflag=false;
	}
	
	if(dno==""|| dno.length==0){
		document.getElementById("deptnoError").innerHTML="Employee deptno is mandatory(cs)";
		vflag=false;
	}
	return vflag;
	
}*/

	

window.app = {
	show(msg){
		alert("Show: " + msg);		
	}
}



let btn = document.createElement("button");

btn.innerText = "Javascript to Java";

btn.addEventListener("click", () => {
	const el = document.querySelector("#our-div");
	el.$server.javaProcess(123, 456);
});

document.body.append(btn);	

// Call the dataTables jQuery plugin
$(document).ready(function() {


});

async function loginUser() {

    let data = {};

    data.email = document.getElementById('txtLoginEmail').value;
    data.pass = document.getElementById('txtLoginPass').value;


      // aqui hacemos la solicitud de tipo GET
      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      const response = await request.text();

      if (response == "OK") {
        window.location.href = 'users.html'
      } else {
        alert("Las credenciales son incorrectas")
      }





}

function info() {
    alert("Prueba de concepto");
}
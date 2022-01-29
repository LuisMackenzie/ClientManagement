// Call the dataTables jQuery plugin
$(document).ready(function() {

    /*document.getElementById ("btnReg").addEventListener ("click", registerNewUser(), false);*/
});

async function registerNewUser() {

    let data = {};

    data.name = document.getElementById('txtName').value;
    data.last = document.getElementById('txtLast').value;
    data.email = document.getElementById('txtEmail').value;
    data.phone = document.getElementById('txtPhone').value;
    data.pass = document.getElementById('txtPass').value;
    let repeatedPass = document.getElementById('txtRepPass').value;

    if (repeatedPass != data.pass) {
        alert('Passwords do not match');
        return;
    }

      // aqui hacemos la solicitud de tipo GET
      const request = await fetch('api/users', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      // const newUser = await request.json();



}

function info() {
    alert("Prueba de concepto");
}
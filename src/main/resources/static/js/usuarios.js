// Call the dataTables jQuery plugin
$(document).ready(function() {
    getAllUsers();
  $('#users').DataTable();
});
async function getAllUsers() {

      // aqui hacemos la solicitud de tipo GET
      const request = await fetch('api/users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const allUsers = await request.json();

      let btnDelete = '<a href="#" onclick="deleteUser()" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
      let btnInfo = '<a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>'

      let listHtml = '';
      for (let user of allUsers) {

        let btnDelete = '<a href="#" onclick="deleteUser('+user.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
        let btnInfo = '<a href="#" onclick="infoUser('+user.id+')" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>'

        let phoneText = user.phone == null ? '-' : user.phone
        phoneText = user.phone == "" ? '-' : user.phone
        let userHtml = '<tr><td>' + user.id + '</td><td>' + user.name + ' ' + user.last + '</td><td>'
        + user.email + '</td><td>' + phoneText +
        '</td><td>' + btnInfo + btnDelete + '</td><td>$320,800</td></tr>'
        listHtml += userHtml;
      }

      console.log(allUsers);



      document.querySelector('#usuarios tbody').outerHTML = listHtml;

}

async function deleteUser(id) {

    if (!confirm('¿Desea eliminar este Usuario?')) {
      return;
    }

    // aqui hacemos la solicitud de tipo GET
          const request = await fetch('api/users/' + id, {
            method: 'DELETE',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });
          location.reload()
}

function infoUser(id) {
    alert(id);
}

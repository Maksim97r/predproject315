const host = "http://localhost:8080";

function deleteUser(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    let json = JSON.stringify(Object.fromEntries(formData.entries()));

    fetch(host + '/users/' + json.userId, {
        method: 'DELETE'
    }).then(response => {
        if (response.ok) {
            deleteUserRowById(json.userId)
        }
    }).catch(error => console.log(error))
}

function deleteUserRowById(userId) {

}

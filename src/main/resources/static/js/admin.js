function deleteUser(event) {
    event.preventDefault();

    const formData = new FormData(event.target);

    let entries = Object.fromEntries(formData.entries());
    entries.roles = formData.getAll('delete-roles');
    let json = JSON.stringify(entries);
    console.log(json);
    formData.forEach(data => console.log(data))
}

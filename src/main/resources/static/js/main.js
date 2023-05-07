const host = "http://localhost:8080";

const formEdit = document.getElementById('edit-user');
const formDelete = document.getElementById('delete-user');
const formAddUser = document.getElementById('add-new-user');


async function getAllUsers() {
    let page = await fetch(host + "/admin/users");

    if (!page.ok) {
        alert(`Error ${page.status}`);
        return;
    }
}

async function getCurUser() {
    let user = await fetch(host + "/users");
    let jsonUser = await user.json();
    replaceUserRoles(jsonUser);
    return jsonUser;
}

function replaceUserRoles(user) {
    user.roles.forEach(role => {
        role.roleName = role.roleName.replace("ROLE_", "")
    })
}

function getUserRoleNames(user) {
    return user.roles.map(role => role.roleName);
}

function isAdmin(user) {
    return getUserRoleNames(user).includes("ADMIN")
}

function isAdmin(user) {
    return getUserRoleNames(user).includes("USER")
}




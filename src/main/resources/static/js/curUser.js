"use script"

function showCurUser() {
    $.get(`/users`, function (data) {

        let usersBody =
            "<td>" + data.id + "</td>" +
            "<td>" + data.firstName + "</td>" +
            "<td>" + data.lastName + "</td>" +
            "<td>" + data.age + "</td>" +
            "<td>" + data.email + "</td>" +
            "<td>" + replaceUserRoles(data) + "</td>"

        $("#user").html(usersBody);
    })
}

function curEmail() {
    $.get(`/users`, function (data) {

        let authUserEmail = data.email;
        $("#authUserEmail").html(authUserEmail);
    })
}

function curRoles() {
    $.get(`/users`, function (data) {
        let authUserRole = replaceUserRoles(data);
        $("#authUserRoles").html(authUserRole);
    })
}

function replaceUserRoles(user) {
    let role = user.roles.map(role => role.roleName.replace("ROLE_", ""));
    return role;
}

$(document).ready(function () {
    showCurUser();
    curEmail();
    curRoles();
})
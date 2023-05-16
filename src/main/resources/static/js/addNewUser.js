'use strict';


let formAddNewUser = document.getElementById('addUserForm');

function createNewUser() {
    let options = formAddNewUser.getElementsByTagName('select')[0].children
    formAddNewUser.addEventListener("submit", ev => {
        ev.preventDefault();
        let roles = [];
        for (let i = 0; i < options.length; i++) {
            if (options[i].selected) roles.push({
                id: options[i].value,
                roleName: "ROLE_" + options[i].text
            });
        }

        fetch("http://localhost:8080/admin/users", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: formAddNewUser.querySelector('input#addFirstName').value,
                lastName: formAddNewUser.querySelector('input#addLastName').value,
                age: formAddNewUser.querySelector('input#addAge').value,
                email: formAddNewUser.querySelector('input#addEmail').value,
                password: formAddNewUser.querySelector('input#addPassword').value,
                roles: roles
            })
        }).then(() => {
            formAddNewUser.reset();
            $('#home-tab').click();
            getUserTable()
        });
    });
}
//
// const tabs = document.querySelectorAll('.taba');
// const tabsContent = document.querySelectorAll('.tabaContent');
//
// tabs.forEach((clickedTab) => {
//     clickedTab.addEventListener('click', async () => {
//         tabs.forEach((tab) => {
//             tab.classList.remove('active');
//         });
//         clickedTab.classList.add('active');
//         let tabaId = clickedTab.getAttribute('id');
//         await activeTabContent(tabaId);
//     });
// });
//
// async function activeTabContent(tabaId) {
//     tabsContent.forEach((clickedTabContent) => {
//         clickedTabContent.classList.contains(tabaId) ?
//             clickedTabContent.classList.add('active') :
//             clickedTabContent.classList.remove('active');
//     })
// }
//
// const form_new = document.getElementById('formForNewUser');
//
// async function newUser() {
//     form_new.addEventListener('submit', addNewUser);




// let form = document.forms["create"];
//
// function createNewUser() {
//     form.addEventListener("submit", newUser => {
//         newUser.preventDefault();
//         let roles = [];
//         for (let i = 0; i , form.roles.options.length; i++) {
//             if (form.roles.options[i].selected) roles.push({
//                 id: form.roles.options[i].value,
//                 role: "ROLE_" + form.roles.options[i].text
//             });
//         }
//
//         fetch("http://localhost:8080/admin/users", {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify({
//                 firstName: form.firstName.value,
//                 lastName: form.lastName.value,
//                 age: form.age.value,
//                 email: form.email.value,
//                 password: form.password.value,
//                 roles: roles,
//
//             })
//         }).then(() => {
//             form.reset();
//             $('#userTable').click();
//             getTableUser()
//         });
//     });
// }
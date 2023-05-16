const tbody = $("#user_table");
getUserTable();

function getUserTable() {
    getAllUsers()
        .then(js => {
            tbody.empty();
            js.forEach(user => {
                const users = `$(
                                  <tr>
                                    <td id="userId">${user.id}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.age}</td>
                                    <td>${user.email}</td>
                                    <td>${user.roles.map(role => role.roleName.replace("ROLE_", ""))}</td>

                                               <!--Кнопка редактирования Edit-->
                                    <td>
                                        <button type="button" class="btn btn-info" data-toggle="modal" 
                                        data-target="#editModal" onclick="fillEditModalTable(${user.id})">Edit
                                        </button>

                                    </td>

                                                            <!--Кнопка удаления Delete-->
                                    <td>
                                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal"
                                        onclick="fillDeleteModalTable(${user.id})">Delete
                                        </button>
                                    </td>
                                </tr>
                                
                )`;
                tbody.append(users)
            })
        })
}
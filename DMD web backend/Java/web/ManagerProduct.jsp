<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                            <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal" onclick="deleteListProduct()"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>												
                        </div>
                    </div>
                </div>
                <jsp:useBean id="ProductDAO" scope="page" class="dao.ProductDAO" />
                <jsp:setProperty name="ProductDAO" property="*" />
                <c:set var="LIST_PRODUCT" value="${ProductDAO.getList()}"/>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll" onclick="selectAll(this)" >
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${LIST_PRODUCT}" var="item">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="${item.pId}">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${item.pId}</td>
                                <td>${item.name}</td>
                                <td>
                                    <img src="${item.img}">
                                </td>
                                <td>${item.price}</td>
                                <td>
                                    <a href="#editEmployeeModal"  class="edit" data-toggle="modal" data-id="${item.pId}" onclick="loadProduct(this)"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254</i></a>
                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal" data-id="${item.pId}" onClick="deleteProduct(this)"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="Home.jsp"><button type="button" class="btn btn-primary">Back to home</button></a>
        </div>
        <!-- Add Modal HTML -->
        <jsp:useBean id="CategoryDAO" scope="page" class="dao.CategoryDAO" />
        <jsp:setProperty name="CategoryDAO" property="*" />
        <c:set var="LIST_CATEGORY" value="${CategoryDAO.getList()}"/>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="AddProduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input name="id" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${LIST_CATEGORY}" var="crr">
                                        <option value="${crr.cId}">${crr.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="DeleteProduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Delete Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete these Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <button name="id" class="btn btn-danger deleteBtn" >Delete</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </a>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="js/manager.js" type="text/javascript"></script>
    <script>
                                        function deleteProduct(t) {
                                            var id = $(t).data('id');
                                            $('#deleteEmployeeModal .deleteBtn').val(id);
                                        }

                                        function deleteListProduct() {
                                            const allP = document.querySelectorAll('#checkbox1');
                                            var listId = "";
                                            for (const p of allP) {
                                                if (p.checked) {
                                                    listId += p.value + "&";
                                                }
                                            }
                                            $('#deleteEmployeeModal .deleteBtn').val(listId);
                                        }
                                        
                                        function loadProduct(t) {
                                            const id = $(t).data("id");
                                            $.ajax({
                                                url: "/AmericanOrder/LoadProduct?id=" + id,
                                                type: "GET",
                                                success: function (response) {
                                                    document.getElementById("editEmployeeModal").innerHTML = response;
                                                }
                                            });
                                        }
    </script>
</body>
</html>
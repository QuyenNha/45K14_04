

import db from '../models/index'
import CRUDService from "../services/CRUDService"
let getHomePage = async (req, res) => {
    try {
        let data = await db.Users.findAll();
        console.log('-------------')
        console.log(data)
        console.log('-------------')
        return res.render('homepage.ejs', {
            data: JSON.stringify(data)
        });
    } catch (e) {
        console.log(e)
    }
}
let getCRUD = (req, res) => {
    return res.render('crud.ejs');
}

let postCRUD = async (req, res) => {
    let message = await CRUDService.createNewUser(req.body);
    console.log(message)
    return res.send('post crud from server')
}
let displayGetCRUD = async (req, res) => {
    let data = await CRUDService.getALLuser();

    return res.render('displayCRUD.ejs', {
        dataTable: data
    })
}
let displayEditCRUD = async (req, res) => {
    let userId = req.query.id;
    console.log(userId)
    if (userId) {
        let userData = await CRUDService.getUserInfoById(userId);
        //check user data not found
        return res.render('editCRUD.ejs', {
            user: userData
        });

        //let user data
        console.log('-------------------')
        console.log(userData)
        console.log('-------------------')
        // let userData
        return res.send('Found a user!');
    }
    else {
        return res.send('Users not found!');
    }
}
let displayPutCRUD = async (req, res) => {
    let data = req.body;
    let allUsers = await CRUDService.UpdateUserData(data);
    return res.render('displayCRUD.ejs', {
        dataTable: allUsers
    })
}

let deleteCRUD = async (req, res) => {
    let id = req.query.id;
    if (id) {
        await CRUDService.deleteUserById(id);
        return res.send('Delete user succeed!!')
    }
    else {
        return res.send('User not found!!')
    }
}


module.exports = {
    getHomePage: getHomePage,
    getCRUD: getCRUD,
    postCRUD: postCRUD,
    displayGetCRUD: displayGetCRUD,
    displayEditCRUD: displayEditCRUD,
    displayPutCRUD: displayPutCRUD,
    deleteCRUD: deleteCRUD
}
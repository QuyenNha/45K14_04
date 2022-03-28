
import db from '../models/index'

import bcrypt from 'bcryptjs';

import res from 'express/lib/response';
const salt = bcrypt.genSaltSync(10);

let createNewUser = async (data) => {
    return new Promise(async (resolve, reject) => {
        try {
            let hashMatKhauFromBrypt = await hashUserMatKhau(data.MatKhau);
            await db.Users.create({
                email: data.email,
                Password: hashMatKhauFromBrypt,
                Ho: data.Ho,
                Ten: data.Ten,
                DiaChi: data.DiaChi,
                DienThoai: data.DienThoai,
                GioiTinh: data.GioiTinh == '1' ? true : false,
                RoleId: data.RoleId,
            })

            resolve('Create user succesful!!!')

        } catch (e) {
            reject(e);
        }
    })
}
let hashUserMatKhau = (MatKhau) => {
    return new Promise(async (resolve, reject) => {
        try {
            let hashMatKhau = await bcrypt.hashSync(MatKhau, salt);
            resolve(hashMatKhau);
        } catch (e) {
            reject(e);
        }
    })
}

let getALLuser = () => {
    return new Promise(async (resolve, reject) => {
        try {
            let users = db.Users.findAll({
                raw: true,
            });
            resolve(users)
        } catch (e) {
            reject(e)
        }
    })
}

let getUserInfoById = (userId) => {
    return new Promise(async (resolve, reject) => {
        try {
            let user = await db.Users.findOne({
                where: { id: userId }
            })
            if (user) {
                resolve(user)
            }
            else {
                resolve({})
            }
        } catch (e) {
            reject(e);
        }
    })
}


let UpdateUserData = (data) => {
    return new Promise(async (resolve, reject) => {
        try {
            let user = await db.Users.findOne({
                where: { id: data.id }
            })
            if (user) {
                user.Ho = data.Ho;
                user.Ten = data.Ten;
                user.DiaChi = data.DiaChi;

                await user.save();
                let allUsers = await db.Users.findAll();



                resolve(allUsers);
            } else {
                resolve();
            }
            await db.Users.update()

        } catch (e) {
            console.log(e);
        }
    })
}
let deleteUserById = (userId) => {
    return new Promise(async (resolve, reject) => {
        try {
            let user = await db.Users.findOne({
                where: { id: userId }
            })

            if (user) {
                await user.destroy();
            }

            resolve();
        } catch (e) {
            reject(e);
        }
    })
}
module.exports = {
    createNewUser: createNewUser,
    getALLuser: getALLuser,
    getUserInfoById: getUserInfoById,
    UpdateUserData: UpdateUserData,
    deleteUserById: deleteUserById,
}
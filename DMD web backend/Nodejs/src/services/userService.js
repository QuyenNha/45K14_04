
import db from "../models/index"
import bcrypt from 'bcryptjs';
import { reject } from "bcrypt/promises";

const salt = bcrypt.genSaltSync(10);

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

let handleUserLogin = (email, Password) => {
    return new Promise(async (resolve, reject) => {
        try {
            let userData = {};
            let isExist = await checkUserEmail(email);
            if (isExist) {
                //user already exist
                //compare Password
                let user = await db.Users.findOne({
                    attributes: ['email', 'roleId', 'Password'],
                    where: { email: email },
                    raw: true

                });
                if (user) {
                    //compare Password
                    let check = await bcrypt.compareSync(Password, user.Password); //false
                    if (check) {
                        userData.errCode = 0;
                        userData.errMessage = 'Ok',
                            delete user.Password;
                        userData.user = user;
                    } else {
                        userData.errCode = 3;
                        userData.errMessage = 'Wrong Password';

                    }
                } else {
                    userData.errCode = 2;
                    userData.errMessage = `User's not found`

                }
            } else {
                //retunr error
                userData.errCode = 1;
                userData.errMessage = `Your's Email isn't exist in you  r system. Plz try other email! `

            }
            resolve(userData)
        } catch (e) {
            reject(e)
        }
    })
}
let checkUserEmail = (userEmail) => {
    return new Promise(async (resolve, reject) => {
        try {
            let user = await db.Users.findOne({
                where: { email: userEmail }
            })
            if (user) {
                resolve(true)
            } else {
                resolve(false)
            }
        } catch (e) {
            reject(e);
        }
    })
}
let getAllUsers = (userId) => {
    return new Promise(async (resolve, reject) => {
        try {
            let users = '';
            if (userId === 'ALL') {
                users = await db.Users.findAll({
                    attributes: {
                        exclude: ['Password']
                    }
                })
            }
            if (userId && userId !== 'ALL') {
                users = await db.Users.findOne({
                    where: { id: userId }
                })
            }
            resolve(users)
        } catch (e) {
            reject(e);
        }
    })

}

let createNewUser = (data) => {
    return new Promise(async (resolve, reject) => {
        try {
            //check email is exist ???
            let check = await checkUserEmail(data.email);
            if (check === true) {
                resolve({
                    errCode: 1,
                    errMessage: 'Your email is ready is used, Plz try another email!'
                })
            } else {
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

                resolve({
                    errCode: 0,
                    message: 'OK'
                })
            }
        } catch (e) {
            reject(e)
        }
    })
}

let deleteUser = (userId) => {
    return new Promise(async (resolve, reject) => {
        let foundUser = await db.Users.findOne({
            where: { id: userId }
        })
        if (!foundUser) {
            resolve({
                errCode: 2,
                errMessage: `The user isn't exist`
            })
        }
        if (foundUser) {
            await foundUser.destroy();
        }

        resolve({
            errCode: 0,
            message: `The user is delete`
        })
    })
}
let UpdateUserData = (data) => {
    return new Promise(async (resolve, reject) => {
        try {
            if (!data.id) {
                resolve({
                    errCode: 2,
                    errMessage: 'Missing required parameters'
                })
            }
            let user = await db.Users.findOne({
                where: { id: data.id },
                raw: false
            })
            if (user) {
                user.Ho = data.Ho;
                user.Ten = data.Ten;
                user.DiaChi = data.DiaChi;

                await user.save();

                resolve({
                    errCode: 0,
                    message: 'Update the user succeeds!'
                })
            } else {
                resolve({
                    errCode: 1,
                    errMessage: `User's not found!`
                });
            }
        } catch (e) {
            reject(e);
        }
    })
}

module.exports = {
    handleUserLogin: handleUserLogin,
    getAllUsers: getAllUsers,
    createNewUser: createNewUser,
    deleteUser: deleteUser,
    UpdateUserData: UpdateUserData,
}
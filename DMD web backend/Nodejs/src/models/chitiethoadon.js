'use strict';
const {
    Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
    class Chitiethoadon extends Model {
        /**
         * Helper method for defining associations.
         * This method is not a part of Sequelize lifecycle.
         * The `models/index` file will call this method automatically.
         */
        static associate(models) {
            // define association here
        }
    };
    Chitiethoadon.init({
        MaHD: DataTypes.STRING,
        MaSP: DataTypes.STRING,
        SoLuong: DataTypes.INTEGER,
    }, {
        sequelize,
        modelName: 'Chitiethoadon',
    });
    return Chitiethoadon;
};
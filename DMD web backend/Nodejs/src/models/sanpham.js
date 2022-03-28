'use strict';
const {
    Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
    class Sanpham extends Model {
        /**
         * Helper method for defining associations.
         * This method is not a part of Sequelize lifecycle.
         * The `models/index` file will call this method automatically.
         */
        static associate(models) {
            // define association here
        }
    };
    Sanpham.init({
        MaSP: DataTypes.STRING,
        TenSP: DataTypes.STRING,
        DonViTinh: DataTypes.INTEGER,
        DonGia: DataTypes.INTEGER,
        HinhAnh: DataTypes.STRING,
        MoTa: DataTypes.TEXT,
    }, {
        sequelize,
        modelName: 'Sanpham',
    });
    return Sanpham;
};
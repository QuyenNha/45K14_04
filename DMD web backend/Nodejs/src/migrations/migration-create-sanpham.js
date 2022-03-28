'use strict';
module.exports = {
    up: async (queryInterface, Sequelize) => {
        // MaSP: DataTypes.STRING,
        // TenSP: DataTypes.STRING,
        // DonViTinh: DataTypes.INTEGER,
        // DonGia: DataTypes.INTEGER,
        await queryInterface.createTable('sanpham', {
            id: {
                allowNull: false,
                autoIncrement: true,
                primaryKey: true,
                type: Sequelize.INTEGER
            },
            MaSP: {
                type: Sequelize.STRING
            },
            TenSP: {
                type: Sequelize.STRING
            },
            DonViTinh: {
                type: Sequelize.INTEGER
            },
            DonGia: {
                type: Sequelize.INTEGER
            },
            HinhAnh: {
                type: Sequelize.STRING
            },
            MoTa: {
                type: Sequelize.TEXT
            },


            createdAt: {
                allowNull: false,
                type: Sequelize.DATE
            },
            updatedAt: {
                allowNull: false,
                type: Sequelize.DATE
            }
        });
    },
    down: async (queryInterface, Sequelize) => {
        await queryInterface.dropTable('sanpham');
    }
};
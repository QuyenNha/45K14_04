'use strict';
module.exports = {
    up: async (queryInterface, Sequelize) => {
        // MaHD: DataTypes.STRING,
        // MaKH: DataTypes.STRING,
        // MaNV: DataTypes.STRING,
        // NgayLapHD: DataTypes.DATE,
        // NgayNhanHang: DataTypes.DATE,
        // TrangThai: DataTypes.STRING,
        await queryInterface.createTable('hoadon', {
            id: {
                allowNull: false,
                autoIncrement: true,
                primaryKey: true,
                type: Sequelize.INTEGER
            },
            MaHD: {
                type: Sequelize.STRING
            },
            MaKH: {
                type: Sequelize.STRING
            },
            MaNV: {
                type: Sequelize.STRING
            },
            NgayLapHD: {
                type: Sequelize.DATE
            },
            NgayNhanHang: {
                type: Sequelize.DATE
            },
            TrangThai: {
                type: Sequelize.STRING
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
        await queryInterface.dropTable('hoadon');
    }
};
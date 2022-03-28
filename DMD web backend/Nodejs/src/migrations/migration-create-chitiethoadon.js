'use strict';
module.exports = {
    up: async (queryInterface, Sequelize) => {
        // MaHD: DataTypes.STRING,
        // MaSP: DataTypes.STRING,
        // SoLuong: DataTypes.INTEGER,
        await queryInterface.createTable('Chitiethoadon', {
            id: {
                allowNull: false,
                autoIncrement: true,
                primaryKey: true,
                type: Sequelize.INTEGER
            },
            MaHD: {
                type: Sequelize.STRING
            },
            MaSP: {
                type: Sequelize.STRING
            },
            SoLuong: {
                type: Sequelize.INTEGER
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
        await queryInterface.dropTable('Chitiethoadon');
    }
};
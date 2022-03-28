'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    return queryInterface.bulkInsert('Users', [{
      email: 'admin@gmail.com',
      Password: '123456',
      Ho: 'Tran Do',
      Ten: 'Hoa',
      DiaChi: 'Da Nang',
      GioiTinh: 1,
      DienThoai: '0762548324',
      RoleId: '1',

      createdAt: new Date(),
      updatedAt: new Date(),

    }]);
  },

  down: async (queryInterface, Sequelize) => {
    /**
     * Add commands to revert seed here.
     *
     * Example:
     * await queryInterface.bulkDelete('People', null, {});
     */
  }
};

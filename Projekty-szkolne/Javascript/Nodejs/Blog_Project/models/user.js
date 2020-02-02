module.exports = (sequelize, type) => {
    return sequelize.define(`user`, {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        name: type.STRING,
        password: type.STRING,
        permission_id: type.INTEGER,

    }, {
        freezeTableName: true,
        timestamps: false
    });
}
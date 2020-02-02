module.exports = (sequelize, type) => {
    return sequelize.define(`permission`, {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        permission: type.STRING,
        
    }, {
        freezeTableName: true,
        timestamps: false
    });
}
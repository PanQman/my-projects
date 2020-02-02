const Sequelize = require(`sequelize`);
const userModel = require(`./models/user`);
const postModel = require(`./models/post`);
const permissionModel = require(`./models/permission`);

const sequelize = new Sequelize(`blogdb`, `root`, ``, {
//const sequelize = new Sequelize(
    host: `localhost`,
    dialect: `mysql`,
    logging: false,
    pool: {
        max: 10,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
});

const User = userModel(sequelize, Sequelize);
const user_post = sequelize.define(`user_post`, {});
const user_permission = sequelize.define(`user_permission`, {});
const Post = postModel(sequelize, Sequelize);
const Permission = permissionModel(sequelize, Sequelize);


Permission.belongsToMany(User, { through: user_permission, unique: false});
User.belongsToMany(Permission, { through: user_permission, unique: false});
User.belongsToMany(Post, { through: user_post, unique: false});
Post.belongsToMany(User, { through: user_post, unique: false});

try {
    sequelize.authenticate();
    console.log('Connection has been established successfully.');
  } catch (error) {
    console.error('Unable to connect to the database:', error);
  }


module.exports = {
    User,
    Post,
    Permission
};
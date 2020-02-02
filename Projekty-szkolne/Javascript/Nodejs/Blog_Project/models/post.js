module.exports = (sequelize, type) => {
    return sequelize.define(`post`, {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        post: type.STRING,
        title: type.STRING,
        user_id: type.INTEGER,
        
    }, {
        freezeTableName: true,
        timestamps: false
    });
}

















/*
const postModel = (sequelize, Sequelize) => {
    const {INTEGER, STRING, FLOAT, BOOLEAN, DATE} = Sequelize;
    const Post = sequelize.define(`Post`, {
        id: {type: INTEGER, primaryKey: true, autoIncrement: true},
        post: {type: STRING, primaryKey: true, allowNull: false},
        title: {type: STRING, primaryKey: true, allowNull: false}
    });
    return Post;
}


const fs = require('fs');

module.exports = {
    addPostPage: (req, res) => {
        res.render('add-post.html', {
            title: `This is my Blog`,
            message: ``
        });
    },
    addPost: (req, res) => {
        if (!req.files) {
            return res.status(400).send(`No files were uploaded.`);
        }

        let message = ``;
        let postContent = ``;
        let postTitle = ``;
        let username = req.body.username; //!!! Tu może być błąd !

        let usernameQuery = 'Select * from `user` where name = "' + username + '"';

        db.query(usernameQuery, (err, result) => {
            if (err){
                return res.status(500).send(err);
            }
            if (result.length > 0){
                message = `Username already exists`;
                res.render('')
            }
        })
}*/

